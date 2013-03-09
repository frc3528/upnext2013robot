
package com.teamupnext.robot;

import com.teamupnext.robot.commands.DecreaseSensitivity;
import com.teamupnext.robot.commands.DecreaseShooter;
import com.teamupnext.robot.commands.Feed;
import com.teamupnext.robot.commands.Fire;
import com.teamupnext.robot.commands.IncreaseSensitivity;
import com.teamupnext.robot.commands.IncreaseShooter;
import com.teamupnext.robot.commands.LowerArm;
import com.teamupnext.robot.commands.PIDShooterEncoderFailToggle;
import com.teamupnext.robot.commands.RaiseArm;
import com.teamupnext.robot.commands.RapidFire;
import com.teamupnext.robot.commands.ShiftDown;
import com.teamupnext.robot.commands.ShiftUp;
import com.teamupnext.robot.commands.TogglePIDShooter;
import com.teamupnext.robot.commands.ToggleSweeper;
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
    private JoystickButton rapidFire;
    private JoystickButton autoShoot;
    private JoystickButton raiseArm;
    private JoystickButton lowerArm;
    private JoystickButton suckFrisbee;
    private JoystickButton increaseSensitivity;
    private JoystickButton decreaseSensitivity;
    private JoystickButton toggleShooter;
    private JoystickButton shooterIncrease;
    private JoystickButton shooterDecrease;
    private JoystickButton toggleFailMode;
    
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
                
        //Raise Arm
        raiseArm = new JoystickButton(drivingStick, RobotMap.Y_BUTTON);
        raiseArm.whenPressed(new RaiseArm());
        
        //Lower Arm
        lowerArm = new JoystickButton(drivingStick, RobotMap.X_BUTTON);
        lowerArm.whenPressed(new LowerArm());
        
        //Release Holder
        //JoystickButton releaseHolder = new JoystickButton(drivingStick, RobotMap.B_BUTTON);
        //releaseHolder.whenPressed(new PullHolder());
        
        //Hold
        //JoystickButton hold = new JoystickButton(drivingStick, RobotMap.A_BUTTON);
        //hold.whenPressed(new PushHolder());
        
        //Sweep
        JoystickButton sweeper = new JoystickButton(drivingStick, RobotMap.Y_BUTTON);
        sweeper.whenPressed(new ToggleSweeper());
        
        //Sensitivity
        increaseSensitivity = new JoystickButton(drivingStick, RobotMap.START_BUTTON);
        increaseSensitivity.whenPressed(new IncreaseSensitivity());
        decreaseSensitivity = new JoystickButton(drivingStick, RobotMap.BACK_BUTTON);
        decreaseSensitivity.whenPressed(new DecreaseSensitivity());
        
        //Un Clamp
        //autoShoot = new JoystickButton(controlsStick, RobotMap.A_BUTTON);
        //autoShoot.whenPressed(new UnClamp());
        
        //Clamp
        //suckFrisbee = new JoystickButton(controlsStick, RobotMap.Y_BUTTON);
        //suckFrisbee.whenPressed(new Clamp());
        
        //Fire
        fire = new JoystickButton(controlsStick, RobotMap.X_BUTTON);
        fire.whenPressed(new Fire());
        
        //Rapid Fire
        rapidFire = new JoystickButton(controlsStick, RobotMap.Y_BUTTON);
        rapidFire.whenPressed(new RapidFire());
        
        //Toggle Shooter
        toggleShooter = new JoystickButton(controlsStick, RobotMap.B_BUTTON);
        toggleShooter.whenPressed(new TogglePIDShooter());
        
        //Toggle Shooter Fail Mode
        toggleFailMode = new JoystickButton(controlsStick, RobotMap.A_BUTTON);
        toggleFailMode.whenPressed(new PIDShooterEncoderFailToggle());
        
        //Change shooter speed
        shooterIncrease = new JoystickButton(controlsStick, RobotMap.START_BUTTON);
        shooterIncrease.whenPressed(new IncreaseShooter());
        shooterDecrease = new JoystickButton(controlsStick, RobotMap.BACK_BUTTON);
        shooterDecrease.whenPressed(new DecreaseShooter());
        
        
        //test
        testingStick = new Joystick(RobotMap.TESTING_JOYSTICK_PORT);
        
        testShiftUp = new JoystickButton(testingStick, RobotMap.RIGHT_BUMPER);
        testShiftUp.whenPressed(new ShiftUp());
        
        testShiftDown = new JoystickButton(testingStick, RobotMap.LEFT_BUMPER); 
        testShiftDown.whenPressed(new ShiftDown());
        
        testFeed = new JoystickButton(testingStick, RobotMap.A_BUTTON);
        testFeed.whenPressed(new Feed());
        
        testShooterIncrease = new JoystickButton(testingStick, RobotMap.B_BUTTON);
        testShooterIncrease.whenPressed(new IncreaseShooter());
        
        testShooterDecrease = new JoystickButton(testingStick, RobotMap.X_BUTTON);
        testShooterDecrease.whenPressed(new DecreaseShooter());   
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

