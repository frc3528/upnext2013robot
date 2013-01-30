/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class TableTilter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    //Mechanical thingies
    
    private Gyro gyro;
    private DigitalInput lowLimitSwitch;
    private DigitalInput highLimitSwitch;
    private Talon leadScrewMotor; 
   
    public TableTilter()
    {
        lowLimitSwitch = new DigitalInput(RobotMap.TABLE_LOW_LIMIT_CHANNEL);
        highLimitSwitch = new DigitalInput(RobotMap.TABLE_HIGH_LIMIT_CHANNEL);
        gyro = new Gyro(RobotMap.TABLE_GYRO_CHANNEL);
        leadScrewMotor = new Talon(RobotMap.LEAD_SCREW_PWM);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
