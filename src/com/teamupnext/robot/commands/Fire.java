/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author jousley
 */
public class Fire extends CommandGroup {
    
    public Fire() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        //addSequential(new SpinUpShooter());
        addSequential(new Feed());
        //addSequential(new SpinUpShooter());
        
    }
}
