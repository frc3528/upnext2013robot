/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.helperPackage.PneumaticDevice;
import com.teamupnext.helperPackage.PneumaticHelper;
import com.teamupnext.robot.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class PickerUpper extends Subsystem implements PneumaticDevice {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private PneumaticHelper armPiston;
    
    private Relay sweeper;
   
    public PickerUpper() {
        armPiston = new PneumaticHelper(RobotMap.ARM_DOWN_SOLENOID_CHANNEL, 
                RobotMap.ARM_UP_SOLENOID_CHANNEL, 
                RobotMap.ARM_UP_SOLENOID_CHANNEL);
        
        sweeper = new Relay(RobotMap.SWEEPER_RELAY_CHANNEL);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());    
    }
    
    public void moveUp() {
        armPiston.pull();
    }
    
    public void moveDown() {
        armPiston.push();
    }
    
    public void setForward(boolean forward) {
        if(forward) {
            sweeper.set(Relay.Value.kForward);
        } else {
            sweeper.set(Relay.Value.kOff);
        }
    }
    
    public void setReverse(boolean reverse) {
        if(reverse) {
            sweeper.set(Relay.Value.kReverse);
        } else {
            sweeper.set(Relay.Value.kOff);
        }
    }
    
    /*public void runPickerUpper(double power) {
        System.out.println("setting sweeper to " + power);
        sweeper.set(power);
    }
    
    public void stopPickerUpper() {
        runPickerUpper(0);
    }*/
    
    public void zeroSolenoids() {
        armPiston.reset();
    }

    public void setToDefaultPosition() {
        //System.out.println("setting arm to default");
        armPiston.setToDefault();
    }
}
