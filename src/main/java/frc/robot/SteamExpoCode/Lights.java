package frc.robot.SteamExpoCode;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Timer;

public class Lights {
    
    AddressableLED led = new AddressableLED(0);
    AddressableLEDBuffer buffer = new AddressableLEDBuffer(300);
    Timer timer = new Timer();
    int cycleNumber = 0;
    int cycleProgress = 0;
    public int score;
    public boolean victory = true;
    public void score () {
    if (!victory) {
           score ++;
        }
    }

    public void innit () {
        led.setLength(buffer.getLength());
        led.setData(buffer);
        led.start();    
    }

    public void light () {

        int numberToVictory = 3;
        if (!victory) {
            for (var i = (buffer.getLength()/numberToVictory); i > 0; i--) {
                buffer.setRGB(i, 193, 33, 51);
            }
            if (score == numberToVictory) {
                score = 0;
                victory = true;
                timer.restart();
                cycleNumber = 0;
            }
        }
        if (victory) {
            victory();
        }
    }
    public void victory () {
        int totalCycleCount = 4;
        if (timer.advanceIfElapsed(0.5)) {
            cycleNumber++;
            if (cycleNumber > totalCycleCount) {
                if (cycleProgress == 0) {
                    cycleProgress++;
                    for (var i = 0; i < buffer.getLength(); i++) {
                        if (i%2 == 0) {
                            buffer.setRGB(i, 193, 33, 51);
                        }
                    }
                }
                if (cycleProgress == 1) {
                    cycleProgress = 0;
                    for (var i = 0; i < buffer.getLength(); i++) {
                        if (!(i%2 == 0)) {
                            buffer.setRGB(i, 193, 33, 51);
                        }
                    }
                }
             led.setData(buffer);   
            }
            for (var i = 0; i < buffer.getLength(); i++) {
                buffer.setRGB(i,0,0,0);
            }
            
        }
        victory = false;
    }


}



