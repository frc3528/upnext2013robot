/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.helperPackage.PneumaticDevice;
import com.teamupnext.helperPackage.PneumaticHelper;
import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.Utils;
import com.teamupnext.robot.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class DriveTrain extends Subsystem implements PneumaticDevice {
    
    private RobotDrive drive;
    
    private CANJaguar rightBack;
    private CANJaguar rightFront;
    private CANJaguar leftBack;
    private CANJaguar leftFront;
    
    private PneumaticHelper shifter;
    
    private int sensitivity = RobotMap.DEFAULT_JOYSTICK_SENSITIVITY;
    
    public DriveTrain() throws CANTimeoutException
    {
        rightBack = new CANJaguar(RobotMap.DRIVE_RIGHT_BACK_CAN);
        rightFront = new CANJaguar(RobotMap.DRIVE_RIGHT_FRONT_CAN);
        leftBack = new CANJaguar(RobotMap.DRIVE_LEFT_BACK_CAN);
        leftFront = new CANJaguar(RobotMap.DRIVE_LEFT_FRONT_CAN);
        
        initializeJag(rightBack);
        initializeJag(rightFront);
        initializeJag(leftBack);
        initializeJag(leftFront);
        
        drive = new RobotDrive(leftFront, leftBack, rightFront, rightBack);
        
        shifter = new PneumaticHelper(RobotMap.SHIFT_DOWN_SOLENOID_CHANNEL, 
                RobotMap.SHIFT_UP_SOLENOID_CHANNEL, 
                RobotMap.SHIFT_UP_SOLENOID_CHANNEL);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public void drive(double left, double right){
        double leftPower = Utils.rampSpeed(left, sensitivity/10);
        double rightPower = Utils.rampSpeed(right, sensitivity/10);
        drive.tankDrive( leftPower , rightPower);
    }
    
    public int getSensitivity() {
        return sensitivity;
    }
    
    public void shiftUp()
    {
        shifter.pull();
    }
    
    public void shiftDown()
    {
        shifter.push();
    }
    
    public boolean isShiftedUp()
    {
        return !shifter.isPushed().booleanValue();
    }
    
    public void setToDefaultPosition() {
        shifter.setToDefault();
    }
    
    public void zeroSolenoids() {
        shifter.reset();
    }
    
    public double getLeftEncoder() throws CANTimeoutException {
        return leftBack.getPosition();
    }
    
    public double getRightEncoder() throws CANTimeoutException {
        return rightBack.getPosition();
    }
    
    public void decreaseSensitivity() {
        if(sensitivity > 0) {
            sensitivity -= 1;
        }
    }
    
    public void increaseSensitivity() {
        if(sensitivity < 10) {
            sensitivity += 1;
        }
    }
    
    private void initializeJag(CANJaguar jag) {
        try
        {
            jag.enableControl();
            jag.configEncoderCodesPerRev(360);
            jag.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
            jag.setExpiration(RobotMap.DEFAULT_MOTOR_SAFETY_EXPIRATION);
            jag.setSafetyEnabled(false);
        }
        catch(Exception e)
        {
            System.out.println("Error enabling closed control on Jag " + e.getMessage());
        }
    }
}
