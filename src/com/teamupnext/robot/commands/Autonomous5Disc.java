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
public class Autonomous5Disc extends CommandGroup implements IAutonomousCommand {
    
    public String getName() {
        return "5disc";
    }
    
    public boolean accepts(String name) {
        return name.equalsIgnoreCase(getName());    
    }
    
    public Autonomous5Disc() {
        
        //addParallel(new TiltTableDown(-7.9));//addSequential(new TiltTable(-7.9));
        //addParallel(new DriveByTime(RobotMap.AUTO_DRIVE_POWER, RobotMap.AUTO_DRIVE_POWER, RobotMap.AUTO_REVERSE_TIME));//addSequential(new ReverseDriveTrainByTime(5));
        
        //Shoot pre-loaded discs
        addSequential(new SetShooterSetpoint(50));
        addSequential(new Fire());
        addSequential(new Fire());
        addSequential(new Fire());
        
        //Pick-up discs
        addParallel(new LowerArm());
        addSequential(new TiltTableToBottom());
        
        //addSequential(new Wait(5));
        addParallel(new StartSweeper());
        addSequential(new DriveByTime(-RobotMap.AUTO_DRIVE_POWER, -RobotMap.AUTO_DRIVE_POWER, 1));//RobotMap.AUTO_FORWARD_TIME));
        
        //Drive Toward the 2 discs
        //addSequential(new StopSweeper());
        //addParallel(new TiltTableToTop());
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
        
        //prepare for tele-op
        addParallel(new LowerArm());
        addSequential(new TiltTableToBottom());
    }
}
