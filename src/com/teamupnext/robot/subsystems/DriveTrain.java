/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.Utils;
import com.teamupnext.robot.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class DriveTrain extends Subsystem {
    
    private RobotDrive drive;
    
    private SpeedController rightBack;
    private SpeedController rightFront;
    private SpeedController leftBack;
    private SpeedController leftFront;
    
    //1 dual sulenoid
    //private Solenoid shiftUpSolenoid;
    private Solenoid shiftDownSolenoid;
    private Solenoid shiftUpSolenoid;
    private Boolean isShiftedUp = null;
    
    public DriveTrain() throws CANTimeoutException
    {
        rightBack = new CANJaguar(RobotMap.DRIVE_RIGHT_BACK_CAN);
        rightFront = new CANJaguar(RobotMap.DRIVE_RIGHT_FRONT_CAN);
        leftBack = new CANJaguar(RobotMap.DRIVE_LEFT_BACK_CAN);
        leftFront = new CANJaguar(RobotMap.DRIVE_LEFT_FRONT_CAN);
        
        drive = new RobotDrive(leftFront, leftBack, rightFront, rightBack);
        //drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        //drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        
        shiftDownSolenoid = new Solenoid(RobotMap.SHIFT_DOWN_SOLENOID_CHANNEL);
        shiftUpSolenoid = new Solenoid(RobotMap.SHIFT_UP_SOLENOID_CHANNEL);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public void drive(double left, double right){
        drive.tankDrive(Utils.rampSpeed(left), Utils.rampSpeed(right));
    }
    
    public void shiftUp()
    {
        if(isShiftedUp != null) {
            if(isShiftedUp == Boolean.TRUE) {
                return;
            }
        }
           
        shiftUpSolenoid.set(true);
        shiftDownSolenoid.set(false);
        isShiftedUp = Boolean.TRUE;
    }
    
    public void shiftDown()
    {
        if(isShiftedUp != null) {
            if(isShiftedUp == Boolean.FALSE) {
                return;
            }
        }
                
        shiftDownSolenoid.set(true);
        shiftUpSolenoid.set(false);
        isShiftedUp = Boolean.FALSE;
    }
    
    public void resetSolenoids()
    {
        shiftDownSolenoid.set(false);
        shiftUpSolenoid.set(false);
    }
    
    public Boolean isShiftedUp()
    {
        return isShiftedUp;
    }
}
