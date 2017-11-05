package org.usfirst.frc.team5188.robot.commands;

import org.usfirst.frc.team5188.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RereadPreferences extends Command {
	public void initialize() {
		Robot.oi.rereadPreferences();
	}

	protected boolean isFinished() {
		return true;
	}
}
