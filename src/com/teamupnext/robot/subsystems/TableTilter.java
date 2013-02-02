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
public class TableTilter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    //Mechanical thingies
    
    private Gyro gyro;
    private DigitalInput lowLimitSwitch;
    private DigitalInput highLimitSwitch;
    private Talon leadScrewMotor; 
    private double angle;
   
    public TableTilter()
    {
        super();
        
        lowLimitSwitch = new DigitalInput(RobotMap.TABLE_LOW_LIMIT_CHANNEL);
        highLimitSwitch = new DigitalInput(RobotMap.TABLE_HIGH_LIMIT_CHANNEL);
        
        gyro = new Gyro(RobotMap.TABLE_GYRO_CHANNEL);
        gyro.setSensitivity(RobotMap.TABLE_GYRO_SENSITIVITY);
        gyro.reset();
        
        angle = gyro.getAngle();
        
        leadScrewMotor = new Talon(RobotMap.LEAD_SCREW_PWM);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TiltTableWithJoystick());
    }
    
    public void move(double destination) {
        if(destination == angle) {
            return;
        }
        
        double toMove = destination - angle;
        
        gyro.reset();
        
        if(toMove > 0) {
            moveUp(toMove);
        }
        else {
            moveDown(toMove);
        }

        angle += gyro.getAngle();
    }
    
    public void moveUp()
    {
        if(highLimitSwitch.get()) {
            leadScrewMotor.set(0);
        } else {
            leadScrewMotor.set(RobotMap.TABLE_TALON_SPEED);
        }
    }
    
    public void moveDown()
    {
        if(lowLimitSwitch.get()) {
            leadScrewMotor.set(0);
        } else {
            leadScrewMotor.set(-RobotMap.TABLE_TALON_SPEED);
        }
    }
    
    public void stop()
    {
        leadScrewMotor.set(0);
    }
    
    private void moveUp(double angleToMove) {       
        while(gyro.getAngle() < angleToMove) {
            moveUp();
        }
    }
    
    private void moveDown(double angleToMove) {
        while(gyro.getAngle() > angleToMove) {
            moveDown();
        }
    }
    
    public double getAngle() {
        return angle;
    }
    
    public void zeroGyro() {
        gyro.reset();
    }
}
