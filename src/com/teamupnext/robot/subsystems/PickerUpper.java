/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.helperPackage.PneumaticHelper;
import com.teamupnext.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class PickerUpper extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private PneumaticHelper armPiston;
    
    private Talon sweeper;
   
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        armPiston = new PneumaticHelper(RobotMap.ARM_UP_SOLENOID_CHANNEL, 
                RobotMap.ARM_DOWN_SOLENOID_CHANNEL, 
                RobotMap.ARM_UP_SOLENOID_CHANNEL);
        
        sweeper = new Talon(RobotMap.SWEEPER_PWM_CHANNEL);
    }
    
    public void moveUp() {
        armPiston.push();
    }
    
    public void moveDown() {
        armPiston.pull();
    }
    
    public void reset() {
        armPiston.reset();
    }
}
