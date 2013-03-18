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
public class RaiseArm extends CommandBase {
    
    StopSweeper stopSweeper = new StopSweeper();
    
    public RaiseArm() {
        // Use requires() here to declare subsystem dependencies
        requires(pickerUpper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(RobotMap.ARM_UP_TIMEOUT);
        //stopSweeper.start();
        pickerUpper.setOn(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        pickerUpper.moveUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        pickerUpper.zeroSolenoids();
        //stopSweeper.cancel();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
