package com.teamupnext.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    //Joystick Constants
    public static final int DRIVING_JOYSTICK_PORT = 1;
    public static final int CONTROLS_JOYSTICK_PORT = 2;
    public static final int A_BUTTON = 1;
    public static final int B_BUTTON = 2;
    public static final int X_BUTTON = 3;
    public static final int Y_BUTTON = 4;
    public static final int LEFT_BUMPER = 5;
    public static final int RIGHT_BUMPER = 6;
    public static final int LEFT_X_AXIS_INDEX = 1;
    public static final int LEFT_Y_AXIS_INDEX = 2;
    public static final int TRIGGERS = 3; //Triggers (Each trigger = 0 to 1, axis value = right - left)
    public static final int RIGHT_X_AXIS_INDEX = 4;
    public static final int RIGHT_Y_AXIS_INDEX = 5;
    public static final int DPAD = 6; //DPad Left/Right
    //End Joystick Constants
    
    //Drive Train Constants
    public static final int LEFT_MOTOR_CHANNEL = 1;
    public static final int RIGHT_MOTOR_CHANNEL = 2;
    //End Drive Train Constants
    
    //Camera Constants
    public static final int CAMERA_BRIGHTNESS = 50;
    //End Camera Constants
}
