package frc.robot.SteamExpoCode;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class Lights {
    
    AddressableLED led = new AddressableLED(6);
    AddressableLEDBuffer buffer = new AddressableLEDBuffer(300);

    public int score;
    public void score () {
        score ++;
    }
    public void light () {
    }
}
