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
public class TableTilter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    //Mechanical thingies
    
    private Gyro gyro;
    private DigitalInput lowLimitSwitch;
    private DigitalInput highLimitSwitch;
    private Relay leadScrewMotor; 
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
        
        leadScrewMotor = new Relay(RobotMap.LEAD_SCREW_RELAY_CHANNEL);
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
        //System.out.println("high limit: " + highLimitSwitch.get());
        
        if(highLimitSwitch.get()) {
            stop();
        } else {
            leadScrewMotor.set(Relay.Value.kForward);
        }
    }
    
    public void moveDown()
    {
        //System.out.println("low limit: " + lowLimitSwitch.get());
        
        if(lowLimitSwitch.get()) {
            stop();
        } else {
            leadScrewMotor.set(Relay.Value.kReverse);
        }
    }
    
    public void stop()
    {
        leadScrewMotor.set(Relay.Value.kOff);
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
