package org.usfirst.frc.team5188.robot.subsystems;

import org.usfirst.frc.team5188.robot.OI;
import org.usfirst.frc.team5188.robot.commands.Drive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private VictorSP leftDrive;
	private VictorSP rightDrive;
	private AHRS gyro;

	public DriveTrain() {
		leftDrive = new VictorSP(OI.Drive.LEFT);
		rightDrive = new VictorSP(OI.Drive.RIGHT);
		gyro = new AHRS(SerialPort.Port.kMXP);
	}

	/** 
	 * This is used to allow autonomous to get through acceleration and
	 * velocity controls we may place and instead use PID.
	 */
	public void drive(double left, double right) {
		leftDrive.set(left);
		rightDrive.set(-right);
	}

	public void stop() {
		drive(0, 0);
	}

	/** Get gyroscope angle in degrees */
	public double getGyroAngle() {
		return gyro.getAngle();
	}

	public void resetGyro() {
		gyro.reset();
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}
	
	public void smartDashboard() {
		SmartDashboard.putNumber("DriveTrain Left", leftDrive.get());
		SmartDashboard.putNumber("DriveTrain Right", -rightDrive.get());
		SmartDashboard.putNumber("DriveTrain Gyro", gyro.getAngle());
	}
}
