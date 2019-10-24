/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.actuator.actuatorBackwards;
import frc.robot.commands.actuator.actuatorForward;

public class actuatorGroup extends CommandGroup {
  /**
   * Add your docs here.
   */
  public actuatorGroup() {
    requires(Robot.m_actuator);
    addSequential(new actuatorForward(0.7));
    addSequential(new actuatorBackwards(0.9));
  }
}
