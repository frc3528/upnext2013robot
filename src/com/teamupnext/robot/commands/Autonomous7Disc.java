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
        addSequential(new SetShooterSetpoint(50));
        addSequential(new Fire());
        addSequential(new Fire());
        addSequential(new Fire());
        
        //Pick-up first discs
        addParallel(new StartSweeper());
        addSequential(new LowerArm());
        addSequential(new DriveByTime(-RobotMap.AUTO_DRIVE_POWER, -RobotMap.AUTO_DRIVE_POWER, 1));//RobotMap.AUTO_FORWARD_TIME));
        
        addParallel(new RaiseArm());
        
        addSequential(new StartSweeper());
        addSequential(new Wait(1)); 
        
        //drive towards the next two discs
        addParallel(new LowerArm());
        addSequential(new TiltTableToBottom());
        addSequential(new DriveByTime(-RobotMap.AUTO_DRIVE_POWER, -RobotMap.AUTO_DRIVE_POWER, 3.2));
        
        //Pick up last two;
        addParallel(new RaiseArm());
        addSequential(new TiltTableUp(9));
        addSequential(new StartSweeper());
        addSequential(new Wait(2.5));
        addSequential(new StopSweeper());
        
        //back up to front of pyramid
        addParallel(new DriveByTime(RobotMap.AUTO_DRIVE_POWER, RobotMap.AUTO_DRIVE_POWER, 1.5));
        
        //Shoot all
        addSequential(new TiltTableDown(3));
        
        addSequential(new Fire());
        addSequential(new Fire()); 
        addSequential(new Fire());
        addSequential(new Fire());           
    }
}
