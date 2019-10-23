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
        long starttime = System.nanoTime();
        actuatorMotor.set(.05);
        while(true){
            if((System.nanoTime() - starttime) > 30){
                actuatorMotor.set(0.0);
                break;
            }
        }
        
    }

    public void stopMotor(){
        long starttime = System.nanoTime();
        actuatorMotor.set(-.05);
        while(true){
            if((System.nanoTime() - starttime) > 30){
                actuatorMotor.set(0.0);
                break;
            }
        }
    }
    @Override
    public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    }
}
