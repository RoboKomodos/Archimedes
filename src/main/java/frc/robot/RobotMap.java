/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //The left and right wheel ports
  public static int leftDrive =0;
  public static int rightDrive = 1;
  //The two launch motors
  private static int launchMotor1 = 3;
  private static int launchMotor2 = 4;
  //The actuator used to push the frisbee into the wheels 
  private static int actuator = 2;
}
