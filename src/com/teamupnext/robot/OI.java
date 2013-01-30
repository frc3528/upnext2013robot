
package com.teamupnext.robot;

import com.teamupnext.robot.commands.Feed;
import com.teamupnext.robot.commands.PowerDownShooter;
import com.teamupnext.robot.commands.PowerUpShooter;
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
    private JoystickButton feed;
    
    //Testing
    private Joystick testingStick;
    private JoystickButton testShiftUp;
    private JoystickButton testShiftDown;
    private JoystickButton testFeed;
    private JoystickButton testShooterIncrease;
    private JoystickButton testShooterDecrease;
    
    public OI()
    {
        drivingStick = new Joystick(RobotMap.DRIVING_JOYSTICK_PORT);
        
         //Shifters
        shiftUp = new JoystickButton(drivingStick, RobotMap.RIGHT_BUMPER);
        shiftDown = new JoystickButton(drivingStick, RobotMap.LEFT_BUMPER);
        
        shiftUp.whenPressed(new ShiftUp());
        shiftDown.whenPressed(new ShiftDown());
        
        //Feed
        feed = new JoystickButton(drivingStick, RobotMap.A_BUTTON);
        feed.whenPressed(new Feed());
        
        
        //test
        testingStick = new Joystick(RobotMap.TESTING_JOYSTICK_PORT);
        
        testShiftUp = new JoystickButton(testingStick, RobotMap.RIGHT_BUMPER);
        testShiftUp.whenPressed(new ShiftUp());
        
        testShiftDown = new JoystickButton(testingStick, RobotMap.LEFT_BUMPER); 
        testShiftDown.whenPressed(new ShiftDown());
        
        testFeed = new JoystickButton(testingStick, RobotMap.A_BUTTON);
        testFeed.whenPressed(new Feed());
        
        testShooterIncrease = new JoystickButton(testingStick, RobotMap.B_BUTTON);
        testShooterIncrease.whenPressed(new PowerUpShooter());
        
        testShooterDecrease = new JoystickButton(testingStick, RobotMap.X_BUTTON);
        testShooterDecrease.whenPressed(new PowerDownShooter());
        
    }
    
    public Joystick getDrivingJoystick()
    {
        return drivingStick;
    }
    
    public Joystick getTestingJoystick()
    {
        return testingStick;
    }
    
}

