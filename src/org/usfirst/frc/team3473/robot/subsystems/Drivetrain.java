package org.usfirst.frc.team3473.robot.subsystems;

import org.usfirst.frc.team3473.robot.OI;
import org.usfirst.frc.team3473.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	public void setRight(double speed) {
		RobotMap.TALON_frontRIGHT.set(-speed);
		RobotMap.TALON_centerRIGHT.set(-speed);
		RobotMap.TALON_backRIGHT.set(-speed);
	}

	public void setLeft(double speed) {
		RobotMap.TALON_frontLEFT.set(speed);
		RobotMap.TALON_centerLEFT.set(speed);
		RobotMap.TALON_backLEFT.set(speed);
	}
	
	public void drive(double speed, double turnAngle) {
		if (Math.abs(turnAngle) < .1) {
			setLeft((OI.BUTTON_slowLeft.get() ? .85 : 1) * -speed);
			setRight((OI.BUTTON_slowRight.get() ? .85 : 1) * -speed);
		} else {
			setLeft(turnAngle);
			setRight(-turnAngle);
		}
	}

	public void initDefaultCommand() {
	}
}
