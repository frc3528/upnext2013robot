/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.commands.TiltTableWithJoystick;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class Table extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Gyro gyro;
    private DigitalInput lowLimitSwitch;
    private DigitalInput highLimitSwitch;
    private Talon leadScrewMotor; 
    //private double angle;
   
    public Table()
    {
        super();
        
        lowLimitSwitch = new DigitalInput(RobotMap.TABLE_LOW_LIMIT_CHANNEL);
        highLimitSwitch = new DigitalInput(RobotMap.TABLE_HIGH_LIMIT_CHANNEL);
        
        gyro = new Gyro(RobotMap.TABLE_GYRO_CHANNEL);
        gyro.setSensitivity(RobotMap.TABLE_GYRO_SENSITIVITY);
        gyro.reset();
        
        //angle = gyro.getAngle();
        
        leadScrewMotor = new Talon(RobotMap.LEAD_SCREW_PWM_CHANNEL);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TiltTableWithJoystick());
    }
    
    public boolean getLowLimitSwitch() {
        return lowLimitSwitch.get();
    }
    
    public boolean getHighLimitSwitch() {
        return highLimitSwitch.get();
    }
    
    public void moveUp()
    {        
        //System.out.println("moving up");
        
        if(highLimitSwitch.get()) {
            zeroGyro();
            stop();
        } else {
            leadScrewMotor.set(1);
            //angle = gyro.getAngle();
        }
    }
    
    public void moveDown()
    {
        //System.out.println("moving down");
        
        if(lowLimitSwitch.get()) {
            stop();
        } else {
            leadScrewMotor.set(-1);
            //angle = gyro.getAngle();
        }
    }
    
    public void stop()
    {
        leadScrewMotor.set(0);
    }
    
    public double getAngle() {
        //return angle;
        return gyro.getAngle();
    }
    
    public void zeroGyro() {
        gyro.reset();
    }

    public boolean isUp() {
        return highLimitSwitch.get();
    }
    
    public boolean isDown() {
        return lowLimitSwitch.get();
    }
}
