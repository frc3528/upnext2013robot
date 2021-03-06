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
public class LowerArm extends CommandBase {
    
    public LowerArm() {
        // Use requires() here to declare subsystem dependencies
        requires(pickerUpper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(RobotMap.ARM_DOWN_TIMEOUT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        pickerUpper.moveDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        pickerUpper.zeroSolenoids();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
