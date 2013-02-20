/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.commands.TiltTableWithJoystick;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Relay;
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
    private Relay leadScrewMotor; 
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
        
        leadScrewMotor = new Relay(RobotMap.LEAD_SCREW_RELAY_CHANNEL);
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
    
    /*public void move(double destination) {
        double angle = gyro.getAngle();
        
        if(destination == angle) {
            return;
        }
        
        //double toMove = destination - angle;
        
        //zeroGyro();
        
        if(destination > angle) {
            moveUp(destination);
        }
        else {
            moveDown(destination);
        }

        //angle += gyro.getAngle();
    }*/
    
    public void moveUp()
    {        
        //System.out.println("moving up");
        
        if(highLimitSwitch.get()) {
            zeroGyro();
            stop();
        } else {
            leadScrewMotor.set(Relay.Value.kForward);
            //angle = gyro.getAngle();
        }
    }
    
    public void moveDown()
    {
        //System.out.println("moving down");
        
        if(lowLimitSwitch.get()) {
            stop();
        } else {
            leadScrewMotor.set(Relay.Value.kReverse);
            //angle = gyro.getAngle();
        }
    }
    
    public void stop()
    {
        leadScrewMotor.set(Relay.Value.kOff);
    }
    
    /*private void moveUp(double destinationAngle) {       
        while(gyro.getAngle() < destinationAngle && !highLimitSwitch.get()) {
            moveUp();
        }
    }
    
    private void moveDown(double destinationAngle) {
        while(gyro.getAngle() > destinationAngle && !lowLimitSwitch.get()) {
            moveDown();
            //System.out.println("dest: " + destinationAngle + "current: " + gyro.getAngle());
        }
    }*/
    
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
