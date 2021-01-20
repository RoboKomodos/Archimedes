// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Victor;

public class Launch extends SubsystemBase {
  /** Creates a new Launch. */
  Victor motor1;
  Victor motor2;

  public Launch() {
  motor1 = new Victor(Constants.launch1);
  motor2 = new Victor(Constants.launch2);
  }

  public void startMotors(){
    motor1.set(Constants.launchSpeed);
    motor2.set(Constants.launchSpeed);
  }

  public void stopMotors(){
    motor1.set(0.0);
    motor2.set(0.0);
  }

  public void toggle(){
    if(motor1.getSpeed() == 0.0){
      startMotors();
    }
    else{
      stopMotors();
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
