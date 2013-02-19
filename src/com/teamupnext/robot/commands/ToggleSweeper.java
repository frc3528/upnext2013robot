/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import com.teamupnext.robot.RobotMap;

/**
 *
 * @author Team Up Next
 */
public class ToggleSweeper extends CommandBase {
    
    private static boolean isOn = false;
    
    public ToggleSweeper() {
        requires(pickerUpper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(isOn) {
            isOn = false;
            new TurnSweeperOff().start();
        } else {
            isOn = true;
            new TurnSweeperOn().start();
        }
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