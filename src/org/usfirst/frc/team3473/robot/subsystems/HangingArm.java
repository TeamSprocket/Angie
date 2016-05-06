package org.usfirst.frc.team3473.robot.subsystems;

import org.usfirst.frc.team3473.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HangingArm extends Subsystem {

	public void actuate(double speed, boolean intake) {
		RobotMap.TALON_hangActuation.set(speed*.8);
	}

	public void extend(double speed) {
		RobotMap.TALON_hangExtension.set(speed);
	}

	public void spool(double speed) {
		RobotMap.TALON_spool.set(speed);
	}

	public void initDefaultCommand() {
	}
}
