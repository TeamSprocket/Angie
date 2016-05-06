package org.usfirst.frc.team3473.robot.commands;

import org.usfirst.frc.team3473.robot.OI;
import org.usfirst.frc.team3473.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {

	public Drive() {
	}

	protected void initialize() {
	}

	protected void execute() {
		double speed = OI.JOYSTICK_throttleLeft.getY(), turn = OI.JOYSTICK_throttleRight.getX();
		//						speed  								turn
		Subsystems.drive.drive((Math.abs(speed) > .2) ? speed : 0, (Math.abs(turn) > .07) ? turn : 0);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
