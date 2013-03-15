package com.teamupnext.robot.commands;

/**
 *
 * @author Team Up Next
 */
public class SetRobotToDefault extends CommandBase {
    
    public SetRobotToDefault() {
        requires(shooter);
        requires(driveTrain);
        requires(feeder);
        requires(pickerUpper);
        requires(table);
        //setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        try {
            new SetTableToDefault().start();
            setPneumaticDevicesToDefault();
            shooter.setToDefault();
            table.zeroGyro();
            driveTrain.zeroEncoders();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
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
        //pickerUpper.setToDefaultPosition();
        //feeder.setToDefaultPosition();
        //shifters.setToDefaultPosition();
        new RaiseArm().start();
        new PullFeeder().start();
        new ShiftDown().start();
    }
}
