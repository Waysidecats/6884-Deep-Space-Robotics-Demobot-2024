
package frc.robot.core;

public class Movement {






    public boolean isClockwiseCloser (double cRotation, double tRotation) {
        boolean output;
        double nRotation = cRotation-tRotation;
        if (nRotation>=180){
            output = true;
        }
        else {
            output = false;
        };

        return output;
    };
}