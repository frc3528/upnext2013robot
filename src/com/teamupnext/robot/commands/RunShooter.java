/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author Team Up Next
 */
public class RunShooter extends CommandBase {
    
    private double power = 0;
    
    public RunShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        if(shooter.getPower() == power) {
            return;
        }
        
        try {
            shooter.runShooter();
            power = shooter.getPower();
        } catch (CANTimeoutException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
