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
        //addSequential(new TiltShooter(7.5));
        addSequential(new ReverseDriveTrainByTime(RobotMap.AUTO_REVERSE_TIME));
        addSequential(new PreBigHopShooter());
        addSequential(new BigHopShooter());
        addSequential(new LowerArm());
        addSequential(new TiltShooter(-7.1));
        addSequential(new Fire());
        addSequential(new Fire());
        addSequential(new Fire());
        
    }
}
