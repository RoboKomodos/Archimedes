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
public class LaunchServo extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private boolean extended = false;
  private Victor servo;
  private static double extendedPosition = 0.2;
  public LaunchServo(){
    servo = new Victor(RobotMap.actuator);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void Extend(){
    if(!extended){
      servo.setPosition(extendedPosition);
    }
  }

  public void Retract(){
    servo.setPosition(0);
  }
}
