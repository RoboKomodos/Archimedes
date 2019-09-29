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
 * Add your docs here.
 */
public class LaunchMotors extends Subsystem {
  private Victor leftMotor;
  private Victor rightMotor;
  private double speed=0.2;
  public LaunchMotors(){
    leftMotor = new Victor(RobotMap.launchMotor1);
    rightMotor = new Victor(RobotMap.launchMotor2);
  }

  public void start(){
    leftMotor.set(speed);
    rightMotor.set(speed);
  }

  public void stop(){
    leftMotor.set(0);
    rightMotor.set(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
