package frc.robot.core;
import java.lang.IllegalArgumentException;
import com.ctre.phoenix6.hardware.TalonFX;
public class Movement {
    TalonFX rMotorController1 = new TalonFX(0);
    TalonFX rMotorController2 = new TalonFX(1);
    TalonFX lMotorController1 = new TalonFX(2);
    TalonFX lMotorController2 = new TalonFX(3);
    public static double Calculate_angle (double[] a) {
        double leftX = a[0];
        double leftY = a[1];
        double tangent = leftY/leftX;
        double radians = Math.atan(tangent);
        double angle = Math.toDegrees(radians);
        return angle;
    };






    public void controlLeftMotor (double[] axis) {
                if (axis.length < 2) {
            throw new IllegalArgumentException("invalid axis: axis length must be more than 1");
        }
        double axisX = axis[0];
        double axisY = axis[1];
        double speed = 0;
        if (axisY > axisX) {
            speed = axisY;
        }
        else if (axisY < axisX) {
            speed = axisX;
        }
        else if (axisY == axisX) {
            speed = 0;
        }
        else {
            System.err.println("Error: Axis Does Not Compute");
        }
        lMotorController1.set(speed);
        lMotorController2.set(speed);
    };
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