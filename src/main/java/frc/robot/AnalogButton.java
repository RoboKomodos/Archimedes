/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * This is a class that will allow for the analog buttons like the triggers and the dpad to be used as buttons in frc code.
 * There are three constructors that should all be used in different situations.
 */
public class AnalogButton extends Button{
    GenericHID m_joystick;
    int m_axis;
    double m_threshold;
    int m_location;
    boolean locationBased=false;
    /**
     * An implementation of button for analog buttons such as the triggers on an xbox controller
     * @param joystick the joystick to be used for the button
     * @param axis the axis that should be turned into a button
     * @param threshold the level to return true at
     */
    public AnalogButton(GenericHID joystick,int axis,double threshold){
        m_joystick = joystick;
        m_axis = axis;
        m_threshold = threshold;
    }
    /**
     * An implementation of button for analog buttons such as the triggers on an xbox controller
     * @param joystick the joystick to be used for the button
     * @param axis the axis that should be turned into a button
     */
    public AnalogButton(GenericHID joystick,int axis){
        m_joystick = joystick;
        m_axis = axis;
        m_threshold = .75;
    }
    /**
     * An implementation of button for analog buttons such as the Dpad that has different values for different directions.
     * @param joystick the joystick to be used for the button
     * @param axis the axis that should be turned into a button
     * @param location the target value for the button. E.g. Dpad up is 0, right is 90...
     * @param range the range allowed around target value. E.g. -5 to 5 == 0.
     */
    public AnalogButton(GenericHID joystick,int axis,int location,int range){
        m_joystick = joystick;
        m_axis = axis;
        m_threshold = range;
        m_location=location;
        locationBased=true;
    }
    @Override
    public boolean get()
    {
        if(!locationBased){
            //return true if the axis value is above the threshold level.
            return m_joystick.getRawAxis(m_axis)>m_threshold;
        }
        else
        {
            if (m_joystick.getPOV(m_axis)==-1){
                return false;
            }
            //Phi is either the difference in the two angles or 360-phi is the difference
            double phi = Math.abs(m_joystick.getPOV(m_axis)-m_location)%360;
            //since we know that you cannot be more than 180 degrees away a phi greater than 180 must give a difference of 360-phi
            double difference = phi<180?phi:360-phi;
            return difference<m_threshold;
        }    
        
    }
}