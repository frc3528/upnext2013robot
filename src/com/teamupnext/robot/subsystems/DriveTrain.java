/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.Utils;
import com.teamupnext.robot.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class DriveTrain extends Subsystem {
    
    private RobotDrive drive;
    
    private SpeedController leftMotor1;
    private SpeedController leftMotor2;
    private SpeedController rightMotor1;
    private SpeedController rightMotor2;
    
    //4 encoders
    private Encoder leftMotor1Encoder;
    private Encoder leftMotor2Encoder;
    private Encoder rightMotor1Encoder;
    private Encoder rightMotor2Encoder;
    
    //1 dual sulenoid
    private DoubleSolenoid shiftSolenoid;
    
    public DriveTrain()
    {
        leftMotor1 = new Jaguar(RobotMap.LEFT_MOTOR1_RELAY_CHANNEL);
        leftMotor2 = new Jaguar(RobotMap.LEFT_MOTOR2_RELAY_CHANNEL);
        rightMotor1 = new Jaguar(RobotMap.RIGHT_MOTOR1_RELAY_CHANNEL);
        rightMotor2 = new Jaguar(RobotMap.RIGHT_MOTOR2_RELAY_CHANNEL);

        shiftSolenoid = new DoubleSolenoid(RobotMap.SHIFT_UP_SOLENOID_CHANNEL, RobotMap.SHIFT_DOWN_SOLENOID_CHANNEL);
        
        drive = new RobotDrive(leftMotor1, leftMotor2, rightMotor1, rightMotor2);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public void drive(double left, double right){
        drive.tankDrive(Utils.rampSpeed(left), Utils.rampSpeed(right));
    }
    
    public void shiftUp()
    {
        
    }
    
    public void shiftDown()
    {
        
    }
}
