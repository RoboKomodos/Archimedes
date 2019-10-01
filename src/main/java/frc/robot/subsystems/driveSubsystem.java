package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.driveRobot;


public class driveSubsystem extends Subsystem {
    //reserve motor object names
    private Victor leftMotor;
    private Victor rightMotor;

    public driveSubsystem(){
        //init motor objects
        leftMotor = new Victor(RobotMap.leftDrive);
        rightMotor = new Victor(RobotMap.rightDrive);
    }

    //set motor controller values
    public void setSpeeds(double leftValue, double rightValue){
        leftMotor.set(leftValue);
        rightMotor.set(rightValue);
    }
    //gets left speed from joystick position
    public double findLeftSpeed(double x_pos, double y_pos){
        double leftValue=0.0;
        //double rightValue=0.0;
        if(x_pos == 0.0){
            leftValue = y_pos;
            //rightValue = y_pos;
        }
        if(x_pos < 0.0){
            if(y_pos == 0.0){
                leftValue = -x_pos;
                //rightValue = x_pos;
            }
            else{
                leftValue = y_pos - Math.abs(x_pos);
                //rightValue = y_pos;
            }
        }
        if(x_pos > 0.0){
            if(y_pos == 0.0){
                leftValue = x_pos;
                //rightValue = -x_pos;
            }
            else{
                leftValue = y_pos;
                //rightValue = y_pos - Math.abs(x_pos);
            }
        }
        return leftValue;
    }
    //gets right speed from joystick position
    public double findRightSpeed(double x_pos, double y_pos){
        //double leftValue = 0.0;
        double rightValue = 0.0;
        if(x_pos == 0.0){
            //leftValue = y_pos;
            rightValue = y_pos;
        }
        if(x_pos < 0.0){
            if(y_pos == 0.0){
                //leftValue = -x_pos;
                rightValue = x_pos;
            }
            else{
                //leftValue = y_pos - Math.abs(x_pos);
                rightValue = y_pos;
            }
        }
        if(x_pos > 0.0){
            if(y_pos == 0.0){
                //leftValue = x_pos;
                rightValue = -x_pos;
            }
            else{
                //leftValue = y_pos;
                rightValue = y_pos - Math.abs(x_pos);
            }
        }
        return -rightValue;
    }

    @Override
    protected void initDefaultCommand(){
        setDefaultCommand(new driveRobot());
    }
}