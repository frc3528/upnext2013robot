/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.Utils;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
/**
 *
 * @author jousley
 */
public class PrintCurrent extends CommandBase {
    
    public PrintCurrent() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        //requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            Utils.printToDriverStation("" + shooter.getCurrent(), DriverStationLCD.Line.kUser2);   
            System.out.println("" + shooter.getCurrent());
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
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
