package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Victor;

public class actuatorSubsystem extends Subsystem {
    //init motor controller
    private Victor actuatorMotor;
    public actuatorSubsystem(){
        actuatorMotor = new Victor(RobotMap.actuator);
    }
    //sets motor forward    
    public void runMotor(){
        actuatorMotor.set(.5);
    }
    //sets motor reverse
    public void reverseMotor(){
        actuatorMotor.set(-0.5);
    }
    //sets motor to zero
    public void stopMotor(){
        actuatorMotor.set(0.0);
    }
    
    @Override
    public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    }
}
