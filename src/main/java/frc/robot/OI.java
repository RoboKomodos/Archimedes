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
import frc.robot.commands.controlMotors;
import edu.wpi.first.wpilibj.command.Command;

public class OI {

  //init joystick
  public final Joystick logitech = new Joystick(RobotMap.logitech);
  public static final double logitechDeadzone = 0.1;
  //init buttons
  public final Button launchButton = new JoystickButton(logitech, RobotMap.launchButton);
  public final Button actuatorButton = new JoystickButton(logitech, RobotMap.actuatorButton);
  
  
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


  public OI(){
    launchButton.whenPressed(new controlMotors());
  }
}


  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

