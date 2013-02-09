/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import com.teamupnext.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author jousley
 */
public class SpinUpShooter extends CommandGroup {
    
    public SpinUpShooter() {
        addSequential(new SpinShooter(RobotMap.SHOOTING_POWER, RobotMap.SHOOTER_SPIN_UP_TIMEOUT));
        addSequential(new RunShooter());
    }
    
    /*public SpinUpShooter() {
        // Use requires() here to declare subsystem dependencies
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(RobotMap.SHOOTER_SPIN_UP_TIMEOUT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            shooter.setPower(1.0);
        } catch(CANTimeoutException ex) {
            System.out.println("---Trouble executing SpinUpShooter");
            System.out.println(ex.getMessage());
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        new RunShooter().start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }*/
}
