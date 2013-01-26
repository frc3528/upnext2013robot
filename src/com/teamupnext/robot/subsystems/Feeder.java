/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class Feeder extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    
   private Solenoid feederPush;
   private Solenoid feederPull;
   
   public Feeder() {
       feederPush = new Solenoid(RobotMap.FEEDER_FORWARD_SOLENOID_CHANNEL);
       feederPull = new Solenoid(RobotMap.FEEDER_REVERSE_SOLENOID_CHANNEL);
   }
   
   public void push() {
       feederPull.set(false);
       feederPush.set(true);
   }
   
   
   public void pull() {
       feederPush.set(false);
       feederPull.set(true);
   }
   
   
   public void reset() {
       feederPush.set(false);
       feederPull.set(false);
   }
   

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
