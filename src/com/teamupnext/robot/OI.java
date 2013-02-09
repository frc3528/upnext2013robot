
package com.teamupnext.robot;

import com.teamupnext.robot.commands.AutoShoot;
import com.teamupnext.robot.commands.DecreaseSensitivity;
import com.teamupnext.robot.commands.Feed;
import com.teamupnext.robot.commands.Fire;
import com.teamupnext.robot.commands.IncreaseSensitivity;
import com.teamupnext.robot.commands.LowerArm;
import com.teamupnext.robot.commands.PowerDownShooter;
import com.teamupnext.robot.commands.PowerUpShooter;
import com.teamupnext.robot.commands.RaiseArm;
import com.teamupnext.robot.commands.ShiftDown;
import com.teamupnext.robot.commands.ShiftUp;
import com.teamupnext.robot.commands.SpinUpShooter;
import com.teamupnext.robot.commands.SuckFrisbee;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    private Joystick drivingStick;
    private Joystick controlsStick;
    private JoystickButton shiftUp;
    private JoystickButton shiftDown;
    private JoystickButton fire;
    private JoystickButton autoShoot;
    private JoystickButton raiseArm;
    private JoystickButton lowerArm;
    private JoystickButton suckFrisbee;
    private JoystickButton increaseSensitivity;
    private JoystickButton decreaseSensitivity;
    private JoystickButton spinUpShooter;
    
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
        controlsStick = new Joystick(RobotMap.CONTROLS_JOYSTICK_PORT);
        
         //Shifters
        shiftUp = new JoystickButton(drivingStick, RobotMap.RIGHT_BUMPER);
        shiftDown = new JoystickButton(drivingStick, RobotMap.LEFT_BUMPER);
        
        shiftUp.whenPressed(new ShiftUp());
        shiftDown.whenPressed(new ShiftDown());
        
        //Fire
        fire = new JoystickButton(controlsStick, RobotMap.X_BUTTON);
        fire.whenPressed(new Fire());
        
        //Auto Shoot
        autoShoot = new JoystickButton(controlsStick, RobotMap.A_BUTTON);
        autoShoot.whenPressed(new AutoShoot());
        
        //Raise Arm
        raiseArm = new JoystickButton(controlsStick, RobotMap.RIGHT_BUMPER);
        raiseArm.whenPressed(new RaiseArm());
        
        //Lower Arm
        lowerArm = new JoystickButton(controlsStick, RobotMap.LEFT_BUMPER);
        lowerArm.whenPressed(new LowerArm());
        
        //Suck Frisbee
        suckFrisbee = new JoystickButton(controlsStick, RobotMap.Y_BUTTON);
        suckFrisbee.whenPressed(new SuckFrisbee());
        
        //Spin up Shooter
        spinUpShooter = new JoystickButton(controlsStick, RobotMap.B_BUTTON);
        spinUpShooter.whenPressed(new SpinUpShooter());
        
        //Sensitivity
        increaseSensitivity = new JoystickButton(drivingStick, RobotMap.START_BUTTON);
        increaseSensitivity.whenPressed(new IncreaseSensitivity());
        decreaseSensitivity = new JoystickButton(drivingStick, RobotMap.BACK_BUTTON);
        decreaseSensitivity.whenPressed(new DecreaseSensitivity());
        
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
    
    public Joystick getControlsJoystick()
    {
        return controlsStick;
    }
    
    public Joystick getTestingJoystick()
    {
        return testingStick;
    }
    
}

