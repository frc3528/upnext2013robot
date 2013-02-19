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
public class Autonomous extends CommandGroup {
    
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
        
        
        addParallel(new BigHopShooter());
        addSequential(new TiltShooter(-7.9));
        addSequential(new DriveByTime(RobotMap.AUTO_DRIVE_POWER, RobotMap.AUTO_DRIVE_POWER, RobotMap.AUTO_REVERSE_TIME));//addSequential(new ReverseDriveTrainByTime(5));
        addSequential(new Fire());
        //addSequential(new Fire());
        //addSequential(new Fire());
        //addSequential(new LowerArm());
        //addSequential(new TurnSweeperOn());
        //addSequential(new DriveByTime(-RobotMap.AUTO_DRIVE_POWER, -RobotMap.AUTO_DRIVE_POWER, RobotMap.AUTO_FORWARD_TIME));
        //addParallel(new TurnSweeperOff());
        //addSequential(new RaiseArm());
        //addSequential(new TurnSweeperOn());
        //addSequential(new Wait(.5));
        //addSequential(new TurnSweeperOff());
        
    }
}
