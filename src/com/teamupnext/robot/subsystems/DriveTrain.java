/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.Utils;
import com.teamupnext.robot.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class DriveTrain extends Subsystem {
    
    private RobotDrive drive;
    private SpeedController leftMotor;
    private SpeedController rightMotor;
    
    public DriveTrain()
    {
        leftMotor = new Jaguar(RobotMap.LEFT_MOTOR_CHANNEL);
        rightMotor = new Jaguar(RobotMap.RIGHT_MOTOR_CHANNEL);

        drive = new RobotDrive(leftMotor, rightMotor);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public void drive(double left, double right){
        drive.tankDrive(Utils.rampSpeed(left), Utils.rampSpeed(right));
    }
    
}
