package org.usfirst.frc.team5188.robot.subsystems;

import org.usfirst.frc.team5188.robot.commands.Climb;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber extends Subsystem {
	private VictorSP climber;
	
	public Climber() {
		climber = new VictorSP(2);
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new Climb());
	}

	public void set(double d) {
		climber.set(d);
	}

	public void stop() {
		set(0);
	}

	public void smartDashboard() {
		SmartDashboard.putNumber("Climber Value", climber.get());
	}
}
