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
import frc.robot.commands.Drive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Victor leftMotor;
  private Victor rightMotor;
  public Drivetrain(){
    leftMotor=new Victor(RobotMap.leftDrive);
    rightMotor=new Victor(RobotMap.rightDrive);
  }

  public void setSpeed(double left, double right){
    leftMotor.set(left);
    rightMotor.set(-right);
  }

  /** 
  *  Joystick to Drivetrain formula
  *  Accepts values from -1 to 1
  *  See http://home.kendra.com/mauser/joystick.html for ideas
  */
  public void setJoystickPosition(double dx, double dy){
    //Turning is backwards
    if(dy>0){
      setSpeed(dx+dy,dy-dx);
    }else{
      setSpeed(dy-dx,dx+dy);
    }
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }
}