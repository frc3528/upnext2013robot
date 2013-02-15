/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.teamupnext.robot;


import com.teamupnext.robot.commands.Autonomous;
import com.teamupnext.robot.commands.CommandBase;
import com.teamupnext.robot.commands.PrintInfo;
import com.teamupnext.robot.commands.SetRobotToDefault;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        
        // tell 'em where we are folks!
        System.out.println("===> UpNext2013Robot <===");       
        
        // instantiate the command used for the autonomous period
        autonomousCommand = new Autonomous();

        // Initialize all subsystems
        CommandBase.init();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        new SetRobotToDefault().start();
        autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
        new SetRobotToDefault().start();
        //new PrintInfo().start();
        //new TestCommand().start();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        new PrintInfo().start();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void disabledInit() {
        new SetRobotToDefault().start();
    }
    
    public void disabledPeriodic() {
        //new PrintInfo().start();
    }
}
