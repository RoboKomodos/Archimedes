package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class launchSubsystem extends Subsystem {
  //motor controllers
  private Victor motor1;
  private Victor motor2;
  //bool for starting/stopping loop
  public boolean runLoop = false;
  
  //init motor controllers
  public launchSubsystem(){
    motor1 = new Victor(RobotMap.launchMotor1);
    motor2 = new Victor(RobotMap.launchMotor2);
  }
  //set motor speed
  public void startMotors(double speed){
    motor1.set(speed);
    motor2.set(speed);
  }
  //stops motors
  public void stopMotors(){
    motor1.set(0.0);
    motor2.set(0.0);
  }
  //returns t/f based on motor speed
  public boolean areMotorsRunning(){
    return motor1.getSpeed() == 0.0 ? false : true;
  }
  
    @Override
    public void initDefaultCommand() {

    }
}
