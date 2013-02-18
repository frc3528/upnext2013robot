/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

/**
 *
 * @author Team Up Next
 */
public class ReverseDriveTrainByTime extends CommandBase {
    
    private double time;
    
    public ReverseDriveTrainByTime(double time) {
        // Use requires() here to declare subsystem dependencies
        requires(driveTrain);
        this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrain.drive(0.6, 0.6);       
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.stopDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
