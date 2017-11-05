package org.usfirst.frc.team5188.robot;

import org.usfirst.frc.team5188.robot.commands.ResetGyro;
import org.usfirst.frc.team5188.robot.commands.TurnToDegree;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static class Drive {
		public static final int LEFT = 0, RIGHT = 1;
	}
	public static class Controller {
		public static final int DRIVE = 0, OPERATOR = 1;
	}
	public static class Buttons {
		public static int
		A = 1,
		B = 2,
		X = 3,
		Y = 4,
		L = 5,
		R = 6,
		BACK = 7,
		START = 8,
		L_STICK = 9,
		R_STICK = 10,
		TOTAL_BUTTONS = 10;
	}
	public static class Axis {
		public static int
		LX = 0,
		LY = 1,
		LTrigger = 2,
		RTrigger = 3,
		RX = 4,
		RY = 5,
		AXIS_TOTAL = 6;
	}

	public SuperJoystickPlus drive;
	public SuperJoystickPlus operator;
	
	public OI() {
		drive = new SuperJoystickPlus(Controller.DRIVE);
		operator = new SuperJoystickPlus(Controller.OPERATOR);

		JoystickButton button = new JoystickButton(drive, Axis.LY);
		button.whenPressed(new ResetGyro());
		SmartDashboard.putData("Turn To Degree", new TurnToDegree());
	}
}
