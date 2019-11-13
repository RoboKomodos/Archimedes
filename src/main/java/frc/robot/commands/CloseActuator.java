/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class CloseActuator extends TimedCommand {
  /**
   * Add your docs here.
   */
  public CloseActuator(double timeout) {
    super(timeout);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_actuator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_actuator.close();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Called once after timeout
  @Override
  protected void end() {
    Robot.m_actuator.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
