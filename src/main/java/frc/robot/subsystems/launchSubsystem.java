package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class launchSubsystem extends Subsystem {
  private Victor motor1;
  private Victor motor2;

  public launchSubsystem(){
    motor1 = new Victor(RobotMap.launchMotor1);
    motor2 = new Victor(RobotMap.launchMotor2);
  }

  public void startMotors(){
    motor1.set(0.4);
    motor2.set(0.4);
  }

  public void stopMotors(){
    motor1.set(0.0);
    motor2.set(0.0);
  }

  public boolean areMotorsRunning(){
    return motor1.getSpeed() == 0.0 ? false : true;
  }
  
    @Override
    public void initDefaultCommand() {

    }
}