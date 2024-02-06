package frc.robot.core;
import java.lang.IllegalArgumentException;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
public class Movement {
    
    
    PWMTalonSRX rMotorController1 = new PWMTalonSRX(2);
    PWMTalonSRX rMotorController2 = new PWMTalonSRX(3);
    PWMTalonSRX lMotorController1 = new PWMTalonSRX(4);
    PWMTalonSRX lMotorController2 = new PWMTalonSRX(5);


    //Unused code
    public static double Calculate_angle (double[] a) {
        double leftX = a[0];
        double leftY = a[1];
        double tangent = leftY/leftX;
        double radians = Math.atan(tangent);
        double angle = Math.toDegrees(radians);
        return angle;
    };





    //Calculates Left Motor Speeds and sets it
    public void controlLeftMotor (double[] axis) {
                if (axis.length < 2) {
            throw new IllegalArgumentException("invalid axis: axis length must be more than 1");
        }
        double axisX = axis[0];
        double axisY = axis[1];
        double speed = 0;
        if (Math.abs(axisY) > Math.abs(axisX)) {
            speed = axisY;
        }
        else if (Math.abs(axisY) < Math.abs(axisX)) {
            speed = axisX;
        }
        else if (Math.abs(axisY) == Math.abs(axisX)) {
            speed = 0;
        }
        else {
            System.err.println("Error: Axis Does Not Compute");
        }
        lMotorController1.set(speed);
        lMotorController2.set(speed);
    };

    //Calculates Right Motor Speed and sets it
    public void controlRightMotor (double[] axis) {
                if (axis.length < 2) {
            throw new IllegalArgumentException("invalid axis: axis length must be more than 1");
        }


        double axisX = axis[1];
        double axisY = axis[0];
        double speed = 0;
        
        if (Math.abs(axisY) > Math.abs(axisX)) {
            speed = axisY;
        }
        else if (Math.abs(axisY) < Math.abs(axisX)) {
            speed = -axisX;
        }
        else if (axisY == axisX) {
            speed = 0;
        }
        else {
            System.err.println("Error: Axis Does Not Compute");
        
        }
        rMotorController1.set(speed);
        rMotorController2.set(speed);
    };
}