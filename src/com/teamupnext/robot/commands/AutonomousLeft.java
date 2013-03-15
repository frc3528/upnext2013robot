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
public class AutonomousLeft extends CommandGroup implements IAutonomousCommand {
    
    public String getName() {
        return "left";
    }
    
    public boolean accepts(String name) {
        return name.equalsIgnoreCase(getName());    
    }
    
    public AutonomousLeft() {
        addSequential(new Fire());
        addSequential(new Fire());
        addSequential(new Fire());
    }
}
