package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class launchSubsystem extends Subsystem {
  private Victor motor1;
  private Victor motor2;
  public boolean runLoop = false;

  public launchSubsystem(){
    motor1 = new Victor(RobotMap.launchMotor1);
    motor2 = new Victor(RobotMap.launchMotor2);
  }

  public void motorLoop(){
    while(runLoop == true){
      startMotors(Robot.m_oi.getSpeedDial());
    }
  }
  public void startMotors(double speed){
    motor1.set(speed);
    motor2.set(speed);
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
