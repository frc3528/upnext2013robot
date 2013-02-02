package com.teamupnext.robot.subsystems;

import com.teamupnext.robot.RobotMap;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;

/**
 *
 * @author jousley
 */
public class Targeter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private AxisCamera targetingCamera;
    private AxisCamera discCamera;

    public Targeter() {
        
        System.out.println("Initialize");
        
        targetingCamera = AxisCamera.getInstance(RobotMap.TARGETING_CAMERA_ADDRESS);
        targetingCamera.writeBrightness(RobotMap.TARGETING_CAMERA_BRIGHTNESS);
        targetingCamera.writeCompression(RobotMap.TARGETING_CAMERA_COMPRESSION);
        targetingCamera.writeColorLevel(RobotMap.TARGETING_CAMERA_COLOR_LEVEL);
        
        discCamera = AxisCamera.getInstance(RobotMap.DISC_CAMERA_ADDRESS);
        discCamera.writeCompression(RobotMap.DISC_CAMERA_COMPRESSION);
        discCamera.writeColorLevel(RobotMap.DISC_CAMERA_COLOR_LEVEL);
        discCamera.writeBrightness(RobotMap.DISC_CAMERA_BRIGHTNESS);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    //return a ColorImage from the Axis Camera.  May return null if there was an error getting the image.
    public ColorImage getTargetingImage() throws AxisCameraException, NIVisionException {  
        return targetingCamera.getImage();
    }
}