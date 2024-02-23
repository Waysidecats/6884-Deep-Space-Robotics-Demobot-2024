package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import static frc.robot.Constants.Drive.*;

public class DriveSubsystem extends SubsystemBase {
    DifferentialDrive Arcade;
    WPI_TalonSRX m_lMotor1 = new WPI_TalonSRX(kLMotor1ID);
    WPI_TalonSRX m_lMotor2 = new WPI_TalonSRX(kLMotor2ID);
    WPI_TalonSRX m_rMotor1 = new WPI_TalonSRX(kRMotor2ID);
    WPI_TalonSRX m_rMotor2 = new WPI_TalonSRX(kRMotor2ID);
    public DriveSubsystem () {


        m_lMotor2.follow(m_lMotor1);
        m_rMotor2.follow(m_rMotor1);

        m_rMotor1.setInverted(true);
        m_lMotor2.setInverted(true);

        Arcade = new DifferentialDrive(m_lMotor1, m_rMotor1);
    }

    public void Drive (double forward, double rotation) {
        Arcade.arcadeDrive(forward, rotation);
    }
}
