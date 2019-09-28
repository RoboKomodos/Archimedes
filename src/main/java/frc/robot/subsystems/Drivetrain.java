package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Drivetrain extends Subsystem {
    private Victor leftMotor;
    private Victor rightMotor;
    public Drivetrain(){
        leftMotor = new Victor(RobotMap.leftDrive);
        rightMotor = new Victor(RobotMap.rightDrive);
    }

    @Override
    protected void initDefaultCommand() {
        

    }

    public void setSpeed(double leftSpeed, double rightSpeed){
        leftMotor.set(leftSpeed);
        rightMotor.set(rightSpeed);
    }
    /** 
     * Joystick to Drivetrain formula
     *  Accepts values from -1 to 1
     *  http://home.kendra.com/mauser/joystick.html
     */
    public void setJoystickPosition(double dx, double dy){
        dx*=-1;
        double v=(2-Math.abs(dx))*dy;
        double w=(2-Math.abs(dy))*dx;
        setSpeed((v-w)/2,(v+w)/2);
    }

}