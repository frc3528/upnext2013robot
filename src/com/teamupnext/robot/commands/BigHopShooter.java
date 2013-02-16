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
public class BigHopShooter extends CommandBase {
    
    public BigHopShooter() {
        //requires(shooter);
    }
    
    protected void initialize() {       
       shooter.setPower(RobotMap.SHOOTER_HOP_SPEED);
       setTimeout(RobotMap.SHOOTER_FROM_STOP_TIMEOUT);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        shooter.setPower(RobotMap.SHOOTING_POWER_DEFAULT);
    }

    protected void interrupted() {
    }
}
