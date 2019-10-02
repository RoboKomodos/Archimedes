package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class controlMotors extends Command {
  private boolean areMotorsOn;
  private boolean done = false;
  public controlMotors() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_launch);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("got to init in controlmotors");
    areMotorsOn = Robot.m_launch.areMotorsRunning();
    if(areMotorsOn == false){
      Robot.m_launch.startMotors();
      done = true;
  }
  else{
      Robot.m_launch.stopMotors();
      done = true;
  }
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