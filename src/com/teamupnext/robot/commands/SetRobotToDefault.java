
package com.teamupnext.robot.commands;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Team Up Next
 */
public class SetRobotToDefault extends CommandBase {
    
    public SetRobotToDefault() {
        //requires(shooter);
        //requires(driveTrain);
        //requires(feeder);
        //requires(pickerUpper);
        //requires(tableTilter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            new SetPneumaticDevicesToDefault().start();
            //setPneumaticDevicesToDefault();
            
            new TurnOffShooter().start();
            
            tableTilter.zeroGyro();
            driveTrain.zeroEncoders();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Finished setting robot to default");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

    private void setPneumaticDevicesToDefault() {
        new RaiseArm().start();
        new PullFeeder().start();
        new PushHolder().start();
        new ShiftDown().start();
    }
}
