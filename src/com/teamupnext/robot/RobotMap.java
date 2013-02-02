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
    public static final int TESTING_JOYSTICK_PORT = 4;
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
    public static final int DRIVE_LEFT_FRONT_CAN = 4;
    public static final int DRIVE_LEFT_BACK_CAN = 5;
    public static final int DRIVE_RIGHT_FRONT_CAN = 2;
    public static final int DRIVE_RIGHT_BACK_CAN = 3;
    public static final int SHIFT_DOWN_SOLENOID_CHANNEL = 1;
    public static final int SHIFT_UP_SOLENOID_CHANNEL = 2;
    public static double SHIFT_TIMEOUT_TIME = 1;
    //End Drive Train Constants
    
    //Camera Constants
    public static final int CAMERA_BRIGHTNESS = 50;
    public static final String TARGETING_CAMERA_ADDRESS = "10.35.28.11";
    public static final String DISC_CAMERA_ADDRESS = "10.35.28.12";
    //End Camera Constants
    
    //Feeder Constants
    public static final int FEEDER_FORWARD_SOLENOID_CHANNEL = 4;
    public static final int FEEDER_REVERSE_SOLENOID_CHANNEL = 3;
    public static final double FEEDER_PUSH_TIMEOUT = .25;
    public static final double FEEDER_PULL_TIMEOUT = .25;
    //End Feeder Constants
    
    //PickerUpper Constants
    public static final int ARM_UP_SOLENOID_CHANNEL = 5;
    public static final int ARM_DOWN_SOLENOID_CHANNEL = 6;
    public static final int SWEEPER_PWM_CHANNEL = 2;
    //End PickerUpper Constants
    
    //Shooter Constants
    public static final int SHOOTER_CAN = 6;
    public static final double SHOOTING_POWER = .7;
    //End Shooter Constants
    
    //Compressor Constants
    public static final int COMPRESSOR_RELAY_CHANNEL = 1;
    public static final int PRESSURE_SWITCH_DIO_CHANNEL = 1;
    //End Compressor Constants
    
    //TableTilter Constants
    public static final int TABLE_GYRO_CHANNEL = 1;
    public static final int LEAD_SCREW_PWM = 3;
    public static final int TABLE_LOW_LIMIT_CHANNEL = 3;
    public static final int TABLE_HIGH_LIMIT_CHANNEL = 4;
    public static final double TABLE_GYRO_SENSITIVITY = .007;
    public static double TABLE_TALON_SPEED = .5;
    //End TableTilter Constants    
}
