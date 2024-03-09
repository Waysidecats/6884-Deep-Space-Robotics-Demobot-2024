package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.ArmSubsystem;
import static frc.robot.Constants.Arm.*;

public class ArmCommand extends Command {
    private ArmSubsystem m_Arm;
    double kRotationAddition;
    double kRotation;
    public ArmCommand (ArmSubsystem Arm, DoubleSupplier RotationSupplier) {
        m_Arm = Arm;
        kRotation = RotationSupplier.getAsDouble();
        addRequirements(m_Arm);
    }

    public void execute() {
        kRotationAddition = kRotation * kRotationMultiplier;
        m_Arm.ArmControl(kRotationAddition);
    }
}
