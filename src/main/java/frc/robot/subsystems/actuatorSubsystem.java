package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Victor;

public class actuatorSubsystem extends Subsystem {
    private Victor actuatorMotor;

    public actuatorSubsystem(){
        actuatorMotor = new Victor(RobotMap.actuator);
    }
//.5 for .7 and -.5 for 1.2 sec
    public void runMotor(){
        actuatorMotor.set(.5);
    }

    public void reverseMotor(){
        actuatorMotor.set(-0.5);
    }

    public void stopMotor(){
        actuatorMotor.set(0.0);
    }
    
    @Override
    public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    }
}
