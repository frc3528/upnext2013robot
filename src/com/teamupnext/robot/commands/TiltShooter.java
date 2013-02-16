/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

/**
 *
 * @author Team Up Next
 */
public class TiltShooter extends CommandBase {
    
    private double angle;
    
    public TiltShooter(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(tableTilter);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        tableTilter.zeroGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        tableTilter.move(angle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        tableTilter.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
