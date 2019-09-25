package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.launchSubsystem;;

/**
 * An example command.  You can replace me with your own command.
 */
public class startMotors extends Command {
  public boolean running = false;
  public startMotors() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_launch);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    toggle();
  }

  // Called repeatedly when this Command is scheduled to run
  public void toggle(){
    if(running == false){
      running = true;
    }
    else{
      running = false;
    }
  }
  @Override
  protected void execute() {

    Robot.m_launch.runMotors();
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    boolean done = false;
    if(running == false){
      done =true;
    }
    return done;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_launch.stopMotors();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
