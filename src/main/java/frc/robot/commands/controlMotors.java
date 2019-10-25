package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.launchSubsystem;

//controls launch motors
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
    areMotorsOn = Robot.m_launch.areMotorsRunning();
    if(areMotorsOn == true){
      Robot.m_launch.runLoop = false;
      Robot.m_launch.stopMotors();
      done = true;
    }
    else{
      Robot.m_launch.runLoop = true;
      Robot.m_launch.motorLoop();
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
    return done;
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