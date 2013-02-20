/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

/**
 *
 * @author Team Up Next
 */
public class TiltTableToTop extends CommandBase {
    
    public TiltTableToTop() {
        // Use requires() here to declare subsystem dependencies
        super("TiltTableToTop");
        requires(table);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        table.moveUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return table.isUp();
    }

    // Called once after isFinished returns true
    protected void end() {
        table.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
