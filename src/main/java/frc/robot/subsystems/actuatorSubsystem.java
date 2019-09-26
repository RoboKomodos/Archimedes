package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Victor;


/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class actuatorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Victor actuator;

  public actuatorSubsystem(){
    actuator = new Victor(RobotMap.actuator);
  }

  public void runActuator(){
    actuator.setPosition(0.3);
    actuator.setPosition(0.0);
  }
  @Override
  public void initDefaultCommand(){

  }
}
