package org.usfirst.frc.team5188.robot.commands;

import org.usfirst.frc.team5188.robot.OI;
import org.usfirst.frc.team5188.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Command {
	public Drive() {
		requires(Robot.driveTrain);
	}

	public void execute() {
		SmartDashboard.putBoolean("Drive Shifter", Robot.oi.drive.getRawButton(OI.Buttons.R));
		double shifter = Robot.oi.drive.getRawButton(OI.Buttons.R) ? 0.5 : 1.0;
		double left;
		double right;

		// press for tank drive
		if (Robot.oi.drive.getRawButton(OI.Buttons.L)) {
			left = -Robot.oi.drive.getAxis(OI.Axis.LY) * shifter;
			right = -Robot.oi.drive.getAxis(OI.Axis.RY) * shifter;

			SmartDashboard.putBoolean("Drive Tank", true);
		} else {
			double throttle = -Robot.oi.drive.getAxis(OI.Axis.LY);
			double turn = Robot.oi.drive.getAxis(OI.Axis.RX);

			SmartDashboard.putBoolean("Drive Tank", false);
			// otherwise arcade drive
			left = throttle * shifter * (1 + Math.min(0, turn));
			right = throttle * shifter * (1 - Math.max(0, turn));
		}

		// if pressed we are in reverse (else clause)
		if (Robot.oi.drive.getAxis(OI.Axis.RTrigger) < 0.4) {
			SmartDashboard.putBoolean("Drive Reverse", false);
			Robot.driveTrain.drive(left, right);
		} else {
			// in reverse
			SmartDashboard.putBoolean("Drive Reverse", true);
			Robot.driveTrain.drive(right, left);
		}
	}

	public void end() {
		Robot.driveTrain.stop();
	}

	protected boolean isFinished() {
		return false;
	}
}
