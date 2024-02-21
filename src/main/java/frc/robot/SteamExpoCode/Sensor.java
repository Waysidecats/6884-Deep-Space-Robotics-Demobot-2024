package frc.robot.SteamExpoCode;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C.Port;

public class Sensor {
    ColorSensorV3 sensor = new ColorSensorV3(Port.kOnboard);
    public int red = -50;
    public int green = -50;
    public int blue = -50;
    int num = 0;
    Lights light = new Lights();

    public void sensing () {
        int redold = red; 
        int blueold = blue;
        int greenold = green;
        if ((redold != red || greenold != green || blueold != blue)&!(redold == -50 || greenold == -50 || blueold == -50)) {
            if (num == 1) {
                light.score();
                num = 0;
            }
            num ++;
        }
        red = sensor.getRed();
        green = sensor.getGreen();
        blue = sensor.getBlue();
    }
}
