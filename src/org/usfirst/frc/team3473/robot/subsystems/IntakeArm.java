package org.usfirst.frc.team3473.robot.subsystems;

import org.usfirst.frc.team3473.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeArm extends Subsystem {
	
	public void moveRollers(double speed) {
		RobotMap.TALON_intakeTop.set(-speed);
		RobotMap.TALON_intakeBot.set(-speed);
	}
	
	public void actuate(double speed) {
		if(speed>0){
			RobotMap.TALON_intakeActuation.set(.7 * speed);
		} else {
			RobotMap.TALON_intakeActuation.set(.5 * speed);
		}
	}

	public void initDefaultCommand() {
	}
}
