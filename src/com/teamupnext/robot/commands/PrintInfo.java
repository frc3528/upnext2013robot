/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import com.teamupnext.robot.Utils;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author jousley
 */
public class PrintInfo extends CommandBase {
    
    public PrintInfo() {
        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            //Utils.printToDriverStation("i, o: " + shooter.getBusVoltage() + ", " + shooter.getOutputVoltage(), DriverStationLCD.Line.kUser1);
            Utils.printToDriverStation("shooting power: " + shooter.getPower(), DriverStationLCD.Line.kUser1);
            Utils.printToDriverStation("leftEncoder: " + driveTrain.getLeftEncoder(), DriverStationLCD.Line.kUser2);
            Utils.printToDriverStation("rightEncoder: " + driveTrain.getRightEncoder(), DriverStationLCD.Line.kUser3);
            //Utils.printToDriverStation("Shooter current: " + shooter.getCurrent(), DriverStationLCD.Line.kUser4);
        } catch (CANTimeoutException ex) {
            System.out.println(ex.getMessage());
        }
        
        Utils.printToDriverStation( "Gyro: " + table.getAngle(), DriverStationLCD.Line.kUser6);
        Utils.printToDriverStation( "Sensitivity: " + driveTrain.getSensitivity(), DriverStationLCD.Line.kUser5);
        
        SmartDashboard.putBoolean("TableLowLimit", table.getLowLimitSwitch());
        SmartDashboard.putBoolean("TableHighLimit", table.getHighLimitSwitch());
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
