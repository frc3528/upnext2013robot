/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.Utils;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    //speed controller
    private CANJaguar shootingMotor;
    private DriverStationLCD lcd;
    private double power = 0;
    
    public Shooter() throws CANTimeoutException
    {
        super();
        
        shootingMotor = new CANJaguar(RobotMap.SHOOTER_CAN);
        shootingMotor.setSafetyEnabled(false);
        shootingMotor.setExpiration(RobotMap.DEFAULT_MOTOR_SAFETY_EXPIRATION);
        //lcd = DriverStationLCD.getInstance();
        //printLCD("STOPPED");
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setPower(double power) throws CANTimeoutException
    {
        this.power = power;
        shootingMotor.setX(power);
        
        //System.out.println("Power set to " + power);
        //printLCD("" + power);
    }
    
    public double getPower()
    {
        return power;
    }
    
    public double getCurrent() throws CANTimeoutException {
        return shootingMotor.getOutputCurrent();
    }
    
    public double getOutputVoltage() throws CANTimeoutException {
        return shootingMotor.getOutputVoltage();
    }
    
    public double getBusVoltage() throws CANTimeoutException {
        return shootingMotor.getBusVoltage();
    }    
    
    public void increasePower() throws CANTimeoutException {
        if (power >= 1.0) {
            return;
        }

        setPower(Utils.roundstrip(power + 0.1));
    }

    public void decreasePower() throws CANTimeoutException {      
        if(power <= -1.0) {
            return;
        }
        
        setPower(Utils.roundstrip(power - 0.1));
    }

    public void stop() throws CANTimeoutException {
        setPower(0);
    }
       
    /*private void printLCD(String s) {
        clearLCD();
        lcd.println(DriverStationLCD.Line.kUser1, 1, s);
        lcd.updateLCD();
    }
    
    private void printLCD(String s, DriverStationLCD.Line line)
    {
        lcd.println(line, 1, s);
    }
    
    private void clearLCD() {
        lcd.println(DriverStationLCD.Line.kUser1, 1, "                              ");
        lcd.updateLCD();
    }*/
}
