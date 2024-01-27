package frc.robot.core;
import edu.wpi.first.wpilibj.XboxController;

public class input {
 
    public static double[] getAxis (XboxController input) {
        double leftX = input.getLeftX();
        double leftY = input.getLeftY();
        double rightX = input.getRightX();
        double rightY = input.getRightY();
        double[] output = {leftX, leftY, rightX, rightY};
        return output;
        
    };
    public static boolean[] getButtons (XboxController input) {
        boolean a = input.getAButtonPressed();
        boolean x = input.getXButtonPressed();
        boolean b = input.getBButtonPressed();
        boolean y = input.getYButtonPressed();
        boolean[] output = {a,b ,x,y};
        return output;
    };
}
