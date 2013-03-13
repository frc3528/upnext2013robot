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
public class Autonomous extends CommandGroup implements IAutonomousCommand {
    
    public String getName() {
        return "7disc";
    }
    
    public boolean accepts(String name) {
        return name.equalsIgnoreCase(getName());    
    }
    
    public Autonomous() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        
        //addSequential(new TiltTableToTop());
        
        //addParallel(new TiltTableDown(-7.9));//addSequential(new TiltTable(-7.9));
        addParallel(new DriveByTime(RobotMap.AUTO_DRIVE_POWER, RobotMap.AUTO_DRIVE_POWER, RobotMap.AUTO_REVERSE_TIME));//addSequential(new ReverseDriveTrainByTime(5));
        //addSequential(new BigHopShooter());
        addSequential(new SetShooterSetpoint(55));
        addSequential(new Fire());
        addSequential(new Fire());
        addSequential(new Fire());
        
        addParallel(new LowerArm());
        addSequential(new TiltTableToBottom());
        
        //addSequential(new Wait(5));
        addParallel(new ToggleSweeper());
        addSequential(new DriveByTime(-RobotMap.AUTO_DRIVE_POWER, -RobotMap.AUTO_DRIVE_POWER, RobotMap.AUTO_FORWARD_TIME));
        
        addParallel(new ToggleSweeper());
        addParallel(new TiltTableToTop());
        addSequential(new RaiseArm());
        
        addSequential(new ToggleSweeper());
        addSequential(new Wait(3));
        addSequential(new ToggleSweeper());
        addSequential(new Fire());
        addSequential(new Fire());        
    }
}
