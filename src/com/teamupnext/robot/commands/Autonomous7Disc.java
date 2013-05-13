/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import com.teamupnext.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author TeamUpNextControls
 */
public class Autonomous7Disc extends CommandGroup implements  IAutonomousCommand {
         
    public String getName() {
        return "7Disc";
    }

    public boolean accepts(String name) {
        return name.equalsIgnoreCase(getName());    
    }

    public Autonomous7Disc() {
        //Shoot pre-loaded discs
        addParallel(new LowerArm());
        addSequential(new SetShooterSetpoint(50));
        addSequential(new Fire());
        addSequential(new Fire());
        addSequential(new Fire());
        
        //Pick-up discs
        addParallel(new StartSweeper());
        addSequential(new DriveByTime(-.95, -.95, .68));//RobotMap.AUTO_FORWARD_TIME));
        
        //put 2 discs in hopper
        //addParallel(new TiltTableDown(1));
        addSequential(new RaiseArm());
        addParallel(new StartSweeper());
        addSequential(new Wait(1));
        addSequential(new TiltTableToBottom());
            
        //drive towards the next two discs
        addSequential(new LowerArm());
        addSequential(new DriveByTime(-.97, -1, 2.2));
        addSequential(new StopSweeper());
        //Pick up last two;
        //addSequential(new TiltTableUp(9));
        addParallel(new TiltTableUp(6));
        addSequential(new RaiseArm());
        //addSequential(new Wait(1.5));
        
        //back up to front of pyramid        
        //Shoot all
        addParallel(new StartSweeper());
        addSequential(new Wait(.7));
        addParallel(new TiltTableToTop());
        addSequential(new DriveByTime(.97, 1, 1.3));
        addSequential(new Fire());
        addSequential(new Fire()); 
        addSequential(new Fire());
        addSequential(new Fire());           
    }
}
