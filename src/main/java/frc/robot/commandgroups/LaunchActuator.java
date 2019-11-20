/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.CloseActuator;
import frc.robot.commands.OpenActuator;

public class LaunchActuator extends CommandGroup {
  private static double closeTime = 0.9;
  private static double openTime = 0.7;
  /**
   * Automatically launches a single frisbee
   */
  public LaunchActuator() {
    addSequential(new OpenActuator(openTime));
    addSequential(new CloseActuator(closeTime));
  }

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }

