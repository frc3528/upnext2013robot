/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

/**
 *
 * @author TeamUpNextControls
 */
public class StopSweeper extends CommandBase {
    
    public StopSweeper() {
        // Use requires() here to declare subsystem dependencies
        requires(pickerUpper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pickerUpper.setForward(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
