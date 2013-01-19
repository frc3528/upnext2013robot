/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class PickerUpper extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    //1 dual sulenoid valve
    private DoubleSolenoid armSolenoid;
    
    //1 spike
    private Relay sweeper;
   
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        armSolenoid = new DoubleSolenoid(RobotMap.ARM_UP_SOLENOID_CHANNEL, RobotMap.ARM_DOWN_SOLENOID_CHANNEL);
        sweeper = new Relay(RobotMap.SWEEPER_RELAY_CHANNEL);
    }
}
