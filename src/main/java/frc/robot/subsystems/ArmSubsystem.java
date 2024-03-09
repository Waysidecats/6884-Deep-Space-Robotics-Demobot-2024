package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.Arm;

public class ArmSubsystem extends SubsystemBase{
    PIDController PID = new PIDController(36, 0, 0);
    ArmFeedforward feedforward = new ArmFeedforward(0, 0, 0);
    TalonFX Kraken = new TalonFX(0);
    public ArmSubsystem () {}

    public void ArmControl (Double RotationAddition) {
        PID.setSetpoint(365*(Kraken.getPosition().getValueAsDouble())+RotationAddition);
        Kraken.getPosition();
        Kraken.setVoltage(
            PID.calculate(360*Kraken.getPosition().getValueAsDouble())+
            feedforward.calculate(Units.degreesToRadians(PID.getSetpoint()),
            Units.rotationsToRadians(Arm.kVelocity)));
    }
}
