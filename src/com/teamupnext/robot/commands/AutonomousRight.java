/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author TeamUpNextControls
 */
public class AutonomousRight extends CommandGroup implements IAutonomousCommand {
    
    public String getName() {
        return "right";
    }
    
    public boolean accepts(String name) {
        return name.equalsIgnoreCase(getName());    
    }
    
    public AutonomousRight() {
        addSequential(new SetShooterSetpoint(50));
        addSequential(new Fire());
        addSequential(new Fire());
        addSequential(new Fire());
    }
}
