/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import com.teamupnext.robot.RobotMap;

/**
 *
 * @author jousley
 */
public class ShiftDown extends CommandBase {
    
    public ShiftDown() {
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(RobotMap.SHIFT_TIMEOUT_TIME);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrain.shiftDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
