package frc.robot.core;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Movement {
    
    WPI_TalonSRX rMotorController1 = new WPI_TalonSRX(2);
    WPI_TalonSRX rMotorController2 = new WPI_TalonSRX(3);
    WPI_TalonSRX lMotorController1 = new WPI_TalonSRX(4);
    WPI_TalonSRX lMotorController2 = new WPI_TalonSRX(5);
    DifferentialDrive drive = new DifferentialDrive(lMotorController1, rMotorController1);

    public void init () {
        lMotorController2.follow(lMotorController1);
        rMotorController2.follow(rMotorController1);
        rMotorController1.setInverted(true);
    }

   public void Motors (double[] input) {
        double lX = input[0];
        double lY = input[1];
        if (0.1 < lX & lX< -0.1) {
            lX = 0;
        }
        if (0.1 < lY & lY < -0.1) {
            lY = 0;
        }
        drive.arcadeDrive(lY, lX);
   }
};
