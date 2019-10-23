package frc.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

//controls launch motors
public class controlActuator extends TimedCommand {
  private boolean done = false;
  public controlActuator() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_actuator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  
}

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(done == true){
        return true;
    }
    else{
        return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}