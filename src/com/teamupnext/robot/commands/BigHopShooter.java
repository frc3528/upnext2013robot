/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import com.teamupnext.robot.RobotMap;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author jousley
 */
public class BigHopShooter extends CommandBase {
    
    public BigHopShooter() {
        //requires(shooter);
    }
    
    protected void initialize() {       
       shooter.setPower(1);
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
    
    //public BigHopShooter() {
    //    addSequential(new SpinShooter(1, RobotMap.SHOOTER_FROM_STOP_TIMEOUT));
    //    addSequential(new RunShooter(RobotMap.SHOOTING_POWER_DEFAULT));
    //}
}
