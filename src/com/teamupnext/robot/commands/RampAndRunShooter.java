/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Team Up Next
 */
public class RampAndRunShooter extends CommandGroup {
    
    public RampAndRunShooter() {
        addParallel(new RunShooter());
        addSequential(new BigHopShooter());
    }
}
