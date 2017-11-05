package org.usfirst.frc.team5188.robot;

import edu.wpi.first.wpilibj.Joystick;

public class SuperJoystickPlus extends Joystick {
	public SuperJoystickPlus(int port) {
		super(port); // also need to clear joy-stick class
	}

	public double getAxis(int axis) {
		return Robot.deadband(this.getRawAxis(axis));
	}
}
