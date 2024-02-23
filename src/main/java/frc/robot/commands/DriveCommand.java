package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {
    private DriveSubsystem m_driveSubsystem;
    private DoubleSupplier m_lX;
    private DoubleSupplier m_rX;
    
    public DriveCommand (DriveSubsystem subsystem, DoubleSupplier lXsupp, DoubleSupplier rXsupp) {
        m_lX = lXsupp;
        m_rX = rXsupp;
        
        m_driveSubsystem = subsystem;
        addRequirements(subsystem);

    }
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double lX = m_lX.getAsDouble();
        double lY = m_rX.getAsDouble();
        if (-0.05 < lX || lX < 0.05) {
            lX = 0;
        }
        if (-0.05 < lY || lY < 0.05) {
            lY = 0;
        }
        m_driveSubsystem.Drive (lY,lX);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
    return false;
    }
}
