package com.teamupnext.robot.commands;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.teamupnext.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author jousley
 */
public class Autonomous5DiscPlus extends CommandGroup implements IAutonomousCommand {
    
    public String getName() {
        return "5DiscPlus";
    }
    
    public boolean accepts(String name) {
        return name.equalsIgnoreCase(getName());    
    }
    
    public Autonomous5DiscPlus() {
             
        //Shoot pre-loaded discs
        addSequential(new SetShooterSetpoint(50));
        addSequential(new Fire());
        addSequential(new Fire());
        addSequential(new Fire());
        
        //Pick-up discs
        addParallel(new LowerArm());
        addSequential(new TiltTableToBottom());
        
        addParallel(new StartSweeper());
        addSequential(new DriveByTime(-RobotMap.AUTO_DRIVE_POWER, -RobotMap.AUTO_DRIVE_POWER, 1));
        
        //Drive Toward the 2 discs
        addSequential(new RaiseArm());
        addSequential(new TiltTableUp(9));
        
        addSequential(new StartSweeper());
        addSequential(new Wait(2.5));
        addSequential(new StopSweeper());
        addSequential(new Fire());
        addSequential(new Fire());   
        
        //safety shots
        addSequential(new Wait(1));
        addSequential(new Fire());
        addSequential(new Fire());
        
        //Pick up last two
        addParallel(new LowerArm());
        addSequential(new TiltTableToBottom());
        addSequential(new DriveByTime(-RobotMap.AUTO_DRIVE_POWER, -RobotMap.AUTO_DRIVE_POWER, 3));
        
        addParallel(new RaiseArm());
        addSequential(new TiltTableUp(9));
        addSequential(new StartSweeper());
        addSequential(new Wait(2.5));
        addSequential(new StopSweeper());
        
        //prepare for tele-op
        addParallel(new LowerArm());
        addSequential(new TiltTableToBottom());
    }
}
