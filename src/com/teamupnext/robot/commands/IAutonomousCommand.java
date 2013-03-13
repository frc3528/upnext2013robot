package com.teamupnext.robot.commands;

/**
 *
 * @author TeamUpNextControls
 */
public interface IAutonomousCommand {
    String getName();
    boolean accepts(String name);
    void start();
    void cancel();
}
