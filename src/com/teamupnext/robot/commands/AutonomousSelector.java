package com.teamupnext.robot.commands;

/**
 *
 * @author TeamUpNextControls
 */
public class AutonomousSelector {
    
    private IAutonomousCommand[] commands = new IAutonomousCommand[] 
        { 
            new Autonomous(),
            new DoNothing()
        };
    
    private IAutonomousCommand defaultCommand;
    
    public AutonomousSelector(IAutonomousCommand defaultCommand) {
        this.defaultCommand = defaultCommand;
    }       
    
    public IAutonomousCommand select(String name) {       
        int count = commands.length;        
        for(int i=0; i < count; i++) {
            if(commands[i].accepts(name)) {
                return commands[i];
            }
        }
        
        return defaultCommand;
    }
    
    public IAutonomousCommand[] getCommands() {
        return commands;
    }
}
