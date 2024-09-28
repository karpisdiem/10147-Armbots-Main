package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Robot extends TimedRobot {

    // Motor controller object for Talon SRX
    private WPI_TalonSRX motor1;
    private WPI_TalonSRX motor2;
    
    
    // Joystick for controlling the motor
    private Joystick joystick;

    // Robot initialization
    @Override
    public void robotInit() {
        // Initialize the motor controller on CAN ID 1
        motor1 = new WPI_TalonSRX(5);
        motor2 = new WPI_TalonSRX(0);
        
        // Initialize the joystick on USB port 0
        joystick = new Joystick(0);
    }

    // Periodic function called during teleop mode
    @Override
    public void teleopPeriodic() {
        // Get the Y-axis value from the joystick (-1.0 to 1.0)
        double speed = joystick.getY();
        
        // Control the motor speed based on joystick input
        motor1.set(ControlMode.PercentOutput, speed);
        motor2.set(ControlMode.PercentOutput, speed);
    }
}
