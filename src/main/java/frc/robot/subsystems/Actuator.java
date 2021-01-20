// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Victor;
import frc.robot.Constants;

public class Actuator extends SubsystemBase {
  /** Creates a new Actuator. */
  Victor motor;
  public Actuator() {
    motor = new Victor(Constants.actuatorPort);
  }

  //.5 for .7 and -.5 for 1.2 sec
  public void runMotor(){
    motor.set(.5);
}

public void reverseMotor(){
    motor.set(-0.5);
}

public void stopMotor(){
    motor.set(0.0);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
