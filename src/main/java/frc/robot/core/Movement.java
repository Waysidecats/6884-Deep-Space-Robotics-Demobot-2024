package frc.robot.core;

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
       double l = leftMotor(axis);
       double r = rightMotor(axis);
       double[] out = {l,r};
       return out;
    }




    public static double leftMotor (double[] axis) {
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
        public static double rightMotor (double[] axis) {
        double axisX = axis[0];
        double axisY = axis[1];
        double speed = 0;
        if (axisY > axisX) {
            speed = axisY;
        }
        else if (axisY < axisX) {
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