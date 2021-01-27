// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.AnalogButton;
import frc.robot.Constants;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  XboxController xbox;
  Drivetrain m_drive;
  Launch m_launch;
  Actuator m_actuator;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    xbox = new XboxController(Constants.xboxport);
    m_drive = new Drivetrain();
    m_launch = new Launch();
    m_actuator = new Actuator();


    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    m_drive.setDefaultCommand(new RunCommand(() -> m_drive.setJoystickPosition(getX(), getY()), m_drive));
    new JoystickButton(xbox, Button.kY.value).whenPressed(new InstantCommand(m_launch::toggle, m_launch));
    new JoystickButton(xbox, Button.kBumperRight.value).whenPressed(new SequentialCommandGroup(
      new RunCommand(m_actuator::runMotor, m_actuator).withTimeout(Constants.actuatorForward),
      new RunCommand(m_actuator::reverseMotor, m_actuator).withTimeout(Constants.actuatorBack),
      new InstantCommand(m_actuator::stopMotor, m_actuator)));
    new AnalogButton(xbox, 3).whenPressed( new InstantCommand(m_drive::toggleSpeed, m_drive)).whenReleased(new InstantCommand(m_drive::toggleSpeed, m_drive));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

    /**
   * @return x
   */
  public double getX(){
    // If |joystick X position|>deadzone, retun 0
    return -(Math.abs(xbox.getX(Hand.kLeft)) < Constants.deadzone ? 0 : xbox.getX(Hand.kLeft));
  }
  /**
   * Y position on the joystick is the opposite of what is intuitive (forward=negative).
   * @return y
   */
  public double getY(){
    // If |joystick Y position|>deadzone, retun 0
    return Math.abs(xbox.getY(Hand.kLeft)) < Constants.deadzone ? 0 : xbox.getY(Hand.kLeft);
  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
