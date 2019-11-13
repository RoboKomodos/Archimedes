/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commandgroups.LaunchActuator;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick logitech = new Joystick(RobotMap.joystickNumber);
  Double deadzone = 0.05;
  int actuatorButtonNumber=0;
  Button actuatorButton = new JoystickButton(logitech,actuatorButtonNumber);
  public OI(){
    actuatorButton.whenPressed(new LaunchActuator());
  }
  /**
   * @return x
   */
  public double getX(){
    // If |joystick X position|>deadzone, retun 0
    return Math.abs(logitech.getX())<deadzone?0:logitech.getX();
  }
  /**
   * Y position on the joystick is the opposite of what is intuitive (forward=negative).
   * @return y
   */
  public double getY(){
    // If |joystick Y position|>deadzone, retun 0
    return Math.abs(logitech.getY())<deadzone?0:-logitech.getY();
  }
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
}
