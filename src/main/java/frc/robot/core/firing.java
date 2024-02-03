package frc.robot.core;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;

public class Firing {
    CANSparkMax motor = new CANSparkMax(1, MotorType.kBrushless);
    PIDController PID = new PIDController(0.1, 0, 0);
        PIDController iPID = new PIDController(0.07, 20, 0);
    public void fire (boolean[] buttons) {
        if (buttons[2]) {   

        };
    }
    public void Aim (boolean[] buttons) {
        RelativeEncoder encoder = motor.getEncoder();
        if (buttons[2]) {
            double location = (360)*(encoder.getPosition());
            double target = location + 720;
            PID.setSetpoint(target);
            double output = PID.calculate(location);
            motor.set(output);
        }
    }
    public void AimIntegral (boolean[] buttons) {
        RelativeEncoder encoder = motor.getEncoder();
        if (buttons[0]) {
            double location = encoder.getPosition();
            double target = location+2;
            iPID.setSetpoint(target);
            double output = iPID.calculate(location);
            motor.set(output);
        }
    }
}
