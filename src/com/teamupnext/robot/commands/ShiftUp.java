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
public class ShiftUp extends CommandBase {
    
    public ShiftUp() {
        requires(shifters);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(RobotMap.SHIFT_TIMEOUT_TIME);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {  
        shifters.shiftUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        shifters.zeroSolenoids();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

