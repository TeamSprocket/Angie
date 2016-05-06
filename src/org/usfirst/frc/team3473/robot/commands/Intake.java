package org.usfirst.frc.team3473.robot.commands;

import org.usfirst.frc.team3473.robot.OI;
import org.usfirst.frc.team3473.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

public class Intake extends Command {

	public Intake() {
	}

	protected void initialize() {
	}

	protected void execute() {
		
		// intake/outtake
		if (OI.BUTTON_intake.get() || OI.BUTTON_driveIntake.get()) {
			Subsystems.intake.moveRollers(1);
		} else if (OI.BUTTON_outtake.get() || OI.BUTTON_driveOuttake.get()) {
			Subsystems.intake.moveRollers(-1);
		} else {
			Subsystems.intake.moveRollers(0);
		}
		
		// intake arm actuation
		Subsystems.intake.actuate(-OI.JOYSTICK_gamepad.getY());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
