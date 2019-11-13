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
import frc.robot.commandgroups.LaunchActuator;

/**
 * Add your docs here.
 */
public class Actuator extends Subsystem {
  private Victor actuator;
  private double closeSpeed = -0.5;
  private double openSpeed = 0.5;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Actuator(){
    actuator = new Victor(RobotMap.actuator);
  }
  public void open(){
    actuator.setSpeed(openSpeed);
  }
  public void close(){
    actuator.setSpeed(closeSpeed);
  }
  public void stop(){
    actuator.setSpeed(0);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here
  }
}
