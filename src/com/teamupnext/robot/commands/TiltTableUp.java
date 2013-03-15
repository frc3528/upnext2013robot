/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

/**
 *
 * @author TeamUpNextControls
 */
public class TiltTableUp extends CommandBase {
    
    private double angle;
    
    public TiltTableUp(double angle) {
        // Use requires() here to declare subsystem dependencies
        super("TiltTableUp");
        requires(table);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        table.zeroGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        table.moveUp();
        System.out.println("table angle: " + table.getAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (table.getAngle() >= angle) || table.isUp();
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
