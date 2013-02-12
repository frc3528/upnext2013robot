/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import com.teamupnext.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author jousley
 */
public class SpinUpShooter extends CommandGroup {
    
    public SpinUpShooter() {
        addSequential(new SpinShooter(RobotMap.SHOOTING_POWER, RobotMap.SHOOTER_SPIN_UP_TIMEOUT));
        addSequential(new RunShooter());
    }
}
