/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  Drivetrain m_drive;

  XboxController xbox = new XboxController(Constants.controller);

  public RobotContainer() {
    m_drive = new Drivetrain();
    // Configure the button bindings
    configureButtonBindings();
  }
  
  /**
   * @return x
   */
  public double getX(){
    // If |joystick X position|>deadzone, retun 0
    return Math.abs(xbox.getX(Hand.kLeft))<Constants.driveDeadzone?0:xbox.getX(Hand.kLeft);
  }
  /**
   * Y position on the joystick is the opposite of what is intuitive (forward=negative).
   * @return y
   */
  public double getY(){
    // If |joystick Y position|>deadzone, retun 0
    return Math.abs(xbox.getY(Hand.kLeft))<Constants.driveDeadzone?0:-xbox.getY(Hand.kLeft);
  }
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_drive.setDefaultCommand(new RunCommand(()->m_drive.setJoystickPosition(getX(), getY()), m_drive));
    new AnalogButton(xbox, 3).whenPressed(new InstantCommand(()->m_drive.setSpeed(Constants.mikhail), m_drive)).whenReleased(new InstantCommand(()->m_drive.setSpeed(1.0), m_drive));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
