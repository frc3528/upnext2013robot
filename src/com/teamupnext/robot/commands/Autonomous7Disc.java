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
        addSequential(new DriveByTime(-1, -1, .65));//RobotMap.AUTO_FORWARD_TIME));
        
        //Drive Toward the 2 discs
        addSequential(new RaiseArm());
        addParallel(new StartSweeper());
        addSequential(new Wait(.4));
        addSequential(new TiltTableToBottom());
            
        //drive towards the next two discs
        addSequential(new LowerArm());
        addSequential(new DriveByTime(-1, -1, 1.8));
        addSequential(new StopSweeper());
        //Pick up last two;
        //addSequential(new TiltTableUp(9));
        addParallel(new TiltTableUp(6));
        addSequential(new RaiseArm());
        addParallel(new StartSweeper());
        //addSequential(new Wait(1.5));
        
        //back up to front of pyramid
        addParallel(new DriveByTime(1, 1, 1.4));
        
        //Shoot all
        addSequential(new TiltTableToTop());
        
        addSequential(new Fire());
        addSequential(new Fire()); 
        addSequential(new Fire());
        addSequential(new Fire());           
    }
}
