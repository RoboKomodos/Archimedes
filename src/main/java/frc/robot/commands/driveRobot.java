package frc.robot.commands;

import edu.wpi.first.wpilibj.command.*;
import frc.robot.Robot;

public class driveRobot extends Command {
  //init values
  double leftValue, rightValue;

  public driveRobot() {
    //Declares drive subsystem needed
    requires(Robot.m_drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //get motor values from joystick position
    leftValue = Robot.m_drive.findLeftSpeed(Robot.m_oi.getJoyX(), Robot.m_oi.getJoyY());
    rightValue = Robot.m_drive.findRightSpeed(Robot.m_oi.getJoyX(), Robot.m_oi.getJoyY());
    //sets motor values
    Robot.m_drive.setSpeeds(leftValue, rightValue);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
