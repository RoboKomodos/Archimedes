/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Victor;

public class Drivetrain extends SubsystemBase {
  private Victor leftMotor;
  private Victor rightMotor;
  private double m_speed;
  public Drivetrain(){
    leftMotor=new Victor(Constants.drivetrainLeft);
    rightMotor=new Victor(Constants.drivetrainRight);
    m_speed = 1.0;
  }
  
  /**
   * 
   * @param speed speed multiplier for mikhail mode
   */
  public void setSpeed(double speed){
    m_speed = speed;
  }
  
  /**
   * @param left value from -1 to 1 (left motor is flipped)
   * @param right value from -1 to 1
   */
  public void setMotors(double left, double right){
    leftMotor.set(-left*m_speed);
    rightMotor.set(right*m_speed);
  }

  /**
   * Set the motor speeds based off of joystick position
   * @param dx value from -1 to 1
   * @param dy value from -1 to 1
   */
  public void setJoystickPosition(double dx, double dy){
    setMotors(dx+dy,dy-dx);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
