/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author jousley
 */
public class TiltTableWithJoystick extends CommandBase {
    
    private Joystick stick;
    
    public TiltTableWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(tableTilter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        stick = oi.getControlsJoystick();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {       
        double value = stick.getZ();
        
        if(value < 0){
            tableTilter.moveUp();
        } else if(value > 0){
            tableTilter.moveDown();
        } else {
            tableTilter.stop();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
