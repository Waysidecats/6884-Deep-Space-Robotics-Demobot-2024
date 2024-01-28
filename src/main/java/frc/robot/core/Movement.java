package frc.robot.core;
import java.lang.IllegalArgumentException;

public class Movement {
    public static double Calculate_angle (double[] a) {
        double leftX = a[0];
        double leftY = a[1];
        double tangent = leftY/leftX;
        double radians = Math.atan(tangent);
        double angle = Math.toDegrees(radians);
        return angle;
    };

    public static double[] Motors (double[] axis) {
       double l = controlLeftMotor(axis);
       double r = controlRightMotor(axis);
       double[] out = {l,r};
       return out;
    }




    public static double controlLeftMotor (double[] axis) {
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
        return speed;
    };
    public static double controlRightMotor (double[] axis) {
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
        return speed;
    };
}