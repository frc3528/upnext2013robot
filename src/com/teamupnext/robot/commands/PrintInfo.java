/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import com.teamupnext.robot.Utils;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author jousley
 */
public class PrintInfo extends CommandBase {
    
    int count = 0;
    
    public PrintInfo() {
        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        if(count++ % 3 == 0) {
    
            //Utils.printToDriverStation("i, o: " + shooter.getBusVoltage() + ", " + shooter.getOutputVoltage(), DriverStationLCD.Line.kUser1);
            
            //Utils.printToDriverStation("leftEncoder: " + driveTrain.getLeftEncoder(), DriverStationLCD.Line.kUser2);
            //Utils.printToDriverStation("rightEncoder: " + driveTrain.getRightEncoder(), DriverStationLCD.Line.kUser3);
            //Utils.printToDriverStation("Shooter current: " + shooter.getCurrent(), DriverStationLCD.Line.kUser4);
            //Utils.printToDriverStation("Shooter Count: " + shooter.getShooterEncoderCount(), DriverStationLCD.Line.kUser3);

            
            
            int setpoint = shooter.getPIDSetpoint();
            double rps = shooter.getRPS();
            Utils.printToDriverStation("Sensitivity: " + driveTrain.getSensitivity(), DriverStationLCD.Line.kUser1);
            Utils.printToDriverStation("shooting power: " + shooter.getOutputPower(), DriverStationLCD.Line.kUser2);
            Utils.printToDriverStation("Setpoint: " + setpoint, DriverStationLCD.Line.kUser3);
            Utils.printToDriverStation("ENCODER FAIL: " + shooter.getEncoderFailMode(), DriverStationLCD.Line.kUser4);
            Utils.printToDriverStation("Current RPS: " + rps, DriverStationLCD.Line.kUser5);
            Utils.printToDriverStation("Dif: " + (rps - setpoint), DriverStationLCD.Line.kUser6);

            SmartDashboard.putBoolean("TableLowLimit", table.getLowLimitSwitch());
            SmartDashboard.putBoolean("TableHighLimit", table.getHighLimitSwitch());
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
