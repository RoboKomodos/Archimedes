package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import frc.robot.RobotMap;
import frc.robot.commands.startMotors;


public class launchSubsystem extends Subsystem {
  //reserve motor object names
  private Victor motor1;
  private Victor motor2;


public launchSubsystem(){
  //init motor objects
  motor1 = new Victor(RobotMap.launchMotor1);
  motor2 = new Victor(RobotMap.launchMotor2);
  
}
//start running the motors
public void runMotors(){
  motor1.set(1.0);
  motor2.set(1.0);
}
//stop running the motors
public void stopMotors(){
  motor1.set(0.0);
  motor2.set(0.0);
}


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
