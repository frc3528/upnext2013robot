/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author developer
 */
class ZeroTableGyro extends CommandBase {

    public ZeroTableGyro() {
        
    }

    protected void initialize() {
        table.zeroGyro();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    
    
}
