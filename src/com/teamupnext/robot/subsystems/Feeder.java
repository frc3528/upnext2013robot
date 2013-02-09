/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.helperPackage.PneumaticHelper;
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
    
    
   /*private Solenoid feederPush;
   private Solenoid feederPull;
   
   private boolean feederIsPushed;
   
   private Solenoid holderPush;
   private Solenoid holderPull;
   
   private boolean holderIsPushed;*/
   
   private PneumaticHelper feeder;
   private PneumaticHelper holder;
   
   public Feeder() {
       /*feederPush = new Solenoid(RobotMap.FEEDER_FORWARD_SOLENOID_CHANNEL);
       feederPull = new Solenoid(RobotMap.FEEDER_REVERSE_SOLENOID_CHANNEL);
       
       holderPush = new Solenoid(RobotMap.HOLDER_PUSH_SOLENOID_CHANNEL);
       holderPull = new Solenoid(RobotMap.HOLDER_PULL_SOLENOID_CHANNEL);*/
       
       feeder = new PneumaticHelper(RobotMap.FEEDER_PUSH_SOLENOID_CHANNEL, 
               RobotMap.FEEDER_PULL_SOLENOID_CHANNEL, 
               RobotMap.FEEDER_PUSH_SOLENOID_CHANNEL);
       
       holder = new PneumaticHelper(RobotMap.HOLDER_PUSH_SOLENOID_CHANNEL, 
               RobotMap.HOLDER_PULL_SOLENOID_CHANNEL, 
               RobotMap.HOLDER_PULL_SOLENOID_CHANNEL);
       
   }
   
   public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
   
   public void pushFeeder() {
       //feederPull.set(false);
       //feederPush.set(true);
       
       feeder.push();
   } 
   
   public void pullFeeder() {
       //feederPush.set(false);
       //feederPull.set(true);
       
       feeder.pull();
   }
   
   public void pushHolder() {
       //holderPull.set(false);
       //holderPush.set(true);
       
       holder.push();
   }
   
   public void pullHolder() {
       //holderPush.set(false);
       //holderPull.set(true);
       
       holder.pull();
   }
   
   public void reset() {
       //feederPush.set(false);
       //feederPull.set(false);
       
       feeder.reset();
       holder.reset();
   }
}
