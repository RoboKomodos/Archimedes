/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;
import frc.robot.commands.*;

public class OI {

  //init joystick
  public final Joystick logitech = new Joystick(RobotMap.logitech);
  public static final double logitechDeadzone = 0.1;
  //init buttons
  public final Button launchButton = new JoystickButton(logitech, RobotMap.launchButton);
  public final Button actuatorButton = new JoystickButton(logitech, RobotMap.actuatorButton);
  public final Button speedButton  = new JoystickButton(logitech, RobotMap.speedButton);
  

  //get x pos
  public double getJoyX(){
    double xAxis = logitech.getX();
    //returns 0.0 if pos is smaller than deadzone, else returns pos
    return Math.abs(xAxis) < logitechDeadzone ? 0.0 : xAxis;
  }
  //get y pos
  public double getJoyY(){
    double yAxis = logitech.getY();
    return Math.abs(yAxis) < logitechDeadzone ? 0.0 : yAxis;
  }
  //get dial position
  public double getRawSpeedDial(){
    return logitech.getRawAxis(RobotMap.speedDial);
  }
  

  //listens for button presses
  public OI(){
    launchButton.whenPressed(new controlMotors());
    actuatorButton.whenPressed(new actuatorGroup());
    speedButton.whenPressed(new updateSpeed());
  }
}

