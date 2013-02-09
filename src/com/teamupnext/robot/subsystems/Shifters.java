/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.helperPackage.PneumaticDevice;
import com.teamupnext.helperPackage.PneumaticHelper;
import com.teamupnext.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Team Up Next
 */
public class Shifters extends Subsystem implements PneumaticDevice {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private PneumaticHelper shifter;
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        shifter = new PneumaticHelper(RobotMap.SHIFT_DOWN_SOLENOID_CHANNEL, 
                RobotMap.SHIFT_UP_SOLENOID_CHANNEL, 
                RobotMap.SHIFT_UP_SOLENOID_CHANNEL);
    }
    
    public void shiftUp()
    {
        shifter.pull();
    }
    
    public void shiftDown()
    {
        shifter.push();
    }
    
    public boolean isShiftedUp()
    {
        return !shifter.isPushed().booleanValue();
    }
    
    public void setToDefaultPosition() {
        shifter.setToDefault();
    }
    
    public void zeroSolenoids() {
        shifter.reset();
    }
}
