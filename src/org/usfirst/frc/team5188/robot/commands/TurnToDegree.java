package org.usfirst.frc.team5188.robot.commands;

import org.usfirst.frc.team5188.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class TurnToDegree extends PIDCommand {
	public TurnToDegree() {
		// make sure to calibrate
		// p, i, d
		super(0.1, 0, 0);
		requires(Robot.driveTrain);
	}

	protected void initialize() {
		// go 20 degrees to the right
		setSetpoint(20 + returnPIDInput());
	}

	@Override
	protected double returnPIDInput() {
		return Robot.driveTrain.getGyroAngle();
	}

	@Override
	protected void usePIDOutput(double speed) {
		// these may need to be flipped so that left is reversed.
		Robot.driveTrain.drive(speed, -speed);
	}

	@Override
	protected boolean isFinished() {
		return getPIDController().onTarget();
	}
}
