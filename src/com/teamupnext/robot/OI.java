
package com.teamupnext.robot;

import com.teamupnext.robot.commands.ShiftDown;
import com.teamupnext.robot.commands.ShiftUp;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    private Joystick drivingStick;
    private JoystickButton shiftUp;
    private JoystickButton shiftDown;
    
    public OI()
    {
        drivingStick = new Joystick(RobotMap.DRIVING_JOYSTICK_PORT);
        
         //Shifters
        shiftUp = new JoystickButton(drivingStick, RobotMap.RIGHT_BUMPER);
        shiftDown = new JoystickButton(drivingStick, RobotMap.LEFT_BUMPER);
        
        shiftUp.whenPressed(new ShiftUp());
        shiftDown.whenPressed(new ShiftDown());
        
    }
    
    public Joystick getDrivingJoystick()
    {
        return drivingStick;
    }
    
}

