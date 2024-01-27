package frc.robot.core;
import edu.wpi.first.wpilibj.XboxController;

public class Movement {
    public static double Calculate_angle (XboxController x) {
        double[] a = input.getAxis(x);
        double leftX = a[0];
        double leftY = a[1];
        double tangent = leftY/leftX;
        double radians = Math.atan(tangent);
        double angle = Math.toDegrees(radians);
        return angle;
    };
}