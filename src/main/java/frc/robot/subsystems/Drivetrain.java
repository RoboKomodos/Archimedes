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
import frc.robot.commands.Drive;

/**
 * This is the class that controls the drivetrain, it acts as the legs of the robot.
 */
public class Drivetrain extends Subsystem {
  private Victor leftMotor;
  private Victor rightMotor;
  public Drivetrain(){
    leftMotor=new Victor(RobotMap.leftDrive);
    rightMotor=new Victor(RobotMap.rightDrive);
  }
  /**
   * @param left value from -1 to 1 (left motor is flipped)
   * @param right value from -1 to 1
   */
  public void setSpeed(double left, double right){
    leftMotor.set(-left);
    rightMotor.set(right);
  }
  /**
   * Set the motor speeds based off of joystick position
   * @param dx value from -1 to 1
   * @param dy value from -1 to 1
   */
  public void setJoystickPosition(double dx, double dy){
    setSpeed(dx+dy,dy-dx);
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }
}