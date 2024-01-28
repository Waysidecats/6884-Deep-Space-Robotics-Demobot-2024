package frc.robot.core;
import edu.wpi.first.wpilibj.XboxController;

public class input {
 
    //Gets the axis values and puts them in an array
    public static double[] getAxis (XboxController input) {
        double leftX = input.getLeftX();
        double leftY = -1*(input.getLeftY());
        double rightX = input.getRightX();
        double rightY = -1*(input.getRightY());
        double[] output = {leftX, leftY, rightX, rightY};
        return output;
        
    };

    //Gets if the buttons have been pressed and puts the data in an array
    public static boolean[] getButtons (XboxController input) {
        boolean a = input.getAButtonPressed();
        boolean x = input.getXButtonPressed();
        boolean b = input.getBButtonPressed();
        boolean y = input.getYButtonPressed();
        boolean[] output = {a,b,x,y};
        return output;
    };
}
