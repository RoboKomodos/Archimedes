package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Victor;

public class actuatorSubsystem extends Subsystem {
    private Victor actuatorMotor;

    public actuatorSubsystem(){
        actuatorMotor = new Victor(RobotMap.actuator);
    }
    public void runMotor(){
        actuatorMotor.set(.1);
        
    }
    @Override
    public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    }
}
