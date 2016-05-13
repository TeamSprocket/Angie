package org.usfirst.frc.team3473.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static Joystick  JOYSTICK_throttleLeft, 
				JOYSTICK_throttleRight, 
				JOYSTICK_gamepad;

	/**
	 * Buttons
	 */
	public static JoystickButton BUTTON_turnOnCenter,
				     BUTTON_intake, 
				     BUTTON_outtake, 
				     BUTTON_retract, 
				     BUTTON_disable, 
				     BUTTON_counterSpool, 
				     BUTTON_slowLeft, 
				     BUTTON_slowRight, 
				     BUTTON_spoolSafety,
				     BUTTON_spoolSafety2,
				     BUTTON_driveIntake,
				     BUTTON_driveOuttake;

	//instantiate joysticks/joystick buttons
	public static void init() {
		JOYSTICK_throttleLeft = new Joystick(0);
		JOYSTICK_throttleRight = new Joystick(1);
		JOYSTICK_gamepad = new Joystick(2);

		BUTTON_driveIntake = new JoystickButton(JOYSTICK_throttleRight, 1);
		BUTTON_slowLeft = new JoystickButton(JOYSTICK_throttleRight, 4);
		BUTTON_slowRight = new JoystickButton(JOYSTICK_throttleRight, 5);
		
		BUTTON_driveOuttake = new JoystickButton(JOYSTICK_throttleLeft, 1);
		
		BUTTON_intake = new JoystickButton(JOYSTICK_gamepad, 1);
		BUTTON_outtake = new JoystickButton(JOYSTICK_gamepad, 2);
		BUTTON_disable = new JoystickButton(JOYSTICK_gamepad, 3);
		BUTTON_counterSpool = new JoystickButton(JOYSTICK_gamepad, 5);
		BUTTON_retract = new JoystickButton(JOYSTICK_gamepad, 6);
		BUTTON_spoolSafety2 = new JoystickButton(JOYSTICK_gamepad, 7);
		BUTTON_spoolSafety = new JoystickButton(JOYSTICK_gamepad, 8);
	}

}
