/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.teamupnext.robot;


import com.teamupnext.robot.commands.Autonomous5Disc;
import com.teamupnext.robot.commands.AutonomousSelector;
import com.teamupnext.robot.commands.CommandBase;
import com.teamupnext.robot.commands.IAutonomousCommand;
import com.teamupnext.robot.commands.PrintInfo;
import com.teamupnext.robot.commands.RaiseArm;
import com.teamupnext.robot.commands.SetMotorSafetyOff;
import com.teamupnext.robot.commands.SetMotorSafetyOn;
import com.teamupnext.robot.commands.SetRobotToDefault;
import com.teamupnext.robot.commands.SetTableToDefault;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    private SendableChooser autoChooser;
    private AutonomousSelector selector;
    private IAutonomousCommand autonomousCommand;
    private PrintInfo printInfo = new PrintInfo();


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public Robot() {   
    }
    
    public void robotInit() {
        
        // Initialize all subsystems
        CommandBase.init();
        
        // tell 'em where we are folks!\
        
        
        System.out.println("===> UpNext2013Robot <===");  
        selector = new AutonomousSelector(new Autonomous5Disc());
        autonomousCommand = new Autonomous5Disc();
        
        // instantiate the command used for the autonomous period
        //autonomousCommand = new Autonomous5Disc();
    }
    
    public void autonomousInit() {
        // schedule the autonomous command (example)
        new SetRobotToDefault().start();
        new SetMotorSafetyOff().start();
        
        String name = SmartDashboard.getString("Autonomous Mode", "5disc");   
        System.out.println("Auto name: " + name);
        autonomousCommand = selector.select(name);
        
        printInfo.start();
        //System.out.println(SmartDashboard.getString("Autonomous5Disc Mode"));
        autonomousCommand.start();
    }
    
    private String GetAutonomousName() {
        //NetworkTable operation = NetworkTable.getTable("Operation");
        
        //System.out.println(SmartDashboard.getString("Autonomous5Disc Mode"));
        
        //System.out.println(SmartDashboard.getBoolean("Checkbox 1"));
        
        //System.out.println("TestBool1: " + SmartDashboard.getBoolean("TestBool 1"));
        
        //String name = String.valueOf(SmartDashboard.getNumber("Autonomous5Disc", -1));
        //System.out.println("autoString: " + name);
        //System.out.println("autoDouble: " + SmartDashboard.getNumber("Autonomous5Disc", -1));
        
        String name = SmartDashboard.getString("Autonomous Mode", "5disc");
        
        return name;//SmartDashboard.getString("Autonomous5Disc", "none");
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        //new PrintInfo().start();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
        new SetMotorSafetyOn().start();
        new SetRobotToDefault().start();
        
        printInfo.start();
        
        //new PrintInfo().start();
        //new TestCommand().start();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //new PrintInfo().start();
    }
    
    public void testInit() {
        new SetRobotToDefault().start();
        new SetTableToDefault().start();
        new RaiseArm().start();
        System.out.println("test init finished");
    }
    
    public void testPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void disabledInit() {
        new SetRobotToDefault().start();
        printInfo.cancel();
    }
    
    public void disabledPeriodic() {
        
    }
}
