/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * This is the class that controls the launch of the disk
 */
public class Actuator extends Subsystem {
  private Victor actuator;
  private double closeSpeed = -0.5;
  private double openSpeed = 0.5;
  public Actuator(){
    actuator = new Victor(RobotMap.actuator);
  }
  /**
   * Sets actuator to opening phase
   * Do NOT run for more than set time (0.7 seconds)
   */
  public void open(){
    actuator.setSpeed(openSpeed);
  }
  /**
   * Sets actuator to closing phase
   * Do NOT run for more than set time (0.9 seconds)
   */
  public void close(){
    actuator.setSpeed(closeSpeed);
  }
  /**
   * To be run after the actuator is back in its starting position.
   */
  public void stop(){
    actuator.setSpeed(0);
  }
  /**
   * Do not use this, it runs when no command is being run.
   */
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here
  }
}
