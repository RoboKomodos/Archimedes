package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.driveRobot;


public class driveSubsystem extends Subsystem {
    //set motors as Victor
    private Victor leftMotor;
    private Victor rightMotor;

    public driveSubsystem(){
        //init motors
        leftMotor = new Victor(RobotMap.leftDrive);
        rightMotor = new Victor(RobotMap.rightDrive);
    }

    //set motor controller values
    public void setSpeeds(double leftValue, double rightValue){
        leftMotor.set(leftValue);
        rightMotor.set(rightValue);
    }

    @Override
    protected void initDefaultCommand(){
        setDefaultCommand(new driveRobot());
    }
}