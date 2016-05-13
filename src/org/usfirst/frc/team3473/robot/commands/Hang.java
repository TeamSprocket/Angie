package org.usfirst.frc.team3473.robot.commands;

import org.usfirst.frc.team3473.robot.OI;
import org.usfirst.frc.team3473.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

public class Hang extends Command {

	public Hang() {
	}

	protected void initialize() {
	}

	protected void execute() {
			if (Math.abs(OI.JOYSTICK_gamepad.getRawAxis(5)) > .1) { // arm should go up (+) (hanging arm actuation)
				Subsystems.hang.actuate(OI.JOYSTICK_gamepad.getRawAxis(5), false);
			} else {
				Subsystems.hang.actuate(0, true);
			}
			
			if (OI.JOYSTICK_gamepad.getRawAxis(3) > .1) { //arm extension
				Subsystems.hang.extend(-1);
			} else if (OI.BUTTON_retract.get()) { //arm retraction
				Subsystems.hang.extend(1);
			} else {
				Subsystems.hang.extend(0);
			}
			
			if(OI.JOYSTICK_gamepad.getRawAxis(2) > .1 && OI.BUTTON_spoolSafety.get() && OI.BUTTON_spoolSafety2.get()){ //spool extend
				Subsystems.hang.spool(1);
			} else if(OI.BUTTON_counterSpool.get() && OI.BUTTON_spoolSafety.get()){ //spool retract (climb up)
				Subsystems.hang.spool(-1);
			} else {
				Subsystems.hang.spool(0);
			}

	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
