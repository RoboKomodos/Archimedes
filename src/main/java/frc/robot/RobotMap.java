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
  public static int leftDrive =0;//victor motor controller
  public static int rightDrive = 1;//victor motor controller
  //The two launch motors
  public static int launchMotor1 = 3;//victor motor controller
  public static int launchMotor2 = 4;//victor motor controller
  //The actuator used to push the frisbee into the wheels 
  public static int actuator = 2;// victor motor controller
}
