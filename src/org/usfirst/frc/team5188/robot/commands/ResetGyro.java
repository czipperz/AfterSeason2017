package org.usfirst.frc.team5188.robot.commands;

import org.usfirst.frc.team5188.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetGyro extends Command {
	public ResetGyro() {
		// This command could cause Drive to stop.  Chris thinks it will
		// just cause it to stop for one tick (1/30th of a second)
		requires(Robot.driveTrain);
	}
	
	public void initialize() {
		Robot.driveTrain.resetGyro();
	}

	protected boolean isFinished() {
		return true;
	}
}
