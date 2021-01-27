// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Victor;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new drivetrain. */
  private Victor leftMotor;
  private Victor rightMotor;
  
  private double speed = 1.0;
  private boolean toggle = false;

  public Drivetrain(){
    leftMotor=new Victor(Constants.leftDrive);
    rightMotor=new Victor(Constants.rightDrive);
  }
  /**
   * @param left value from -1 to 1 (left motor is flipped)
   * @param right value from -1 to 1
   */
  public void setMotors(double left, double right){
    leftMotor.set(left*speed);
    rightMotor.set(-right*speed);
  }
  /**
   * Set the motor speeds based off of joystick position
   * @param dx value from -1 to 1
   * @param dy value from -1 to 1
   */
  public void setJoystickPosition(double dx, double dy){
    setMotors(dx+dy,dy-dx);
  }

  public void toggleSpeed(){
    if(toggle == false){
      speed = Constants.mikhail;
      toggle = true;
    }
    else{
      speed = 1.0;
      toggle = false;
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
