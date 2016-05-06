
package org.usfirst.frc.team3473.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	public void robotInit() {
		
		OI.init();
		RobotMap.init();
		Commands.init();
		Subsystems.init();
		
		RobotMap.gyro.reset();
		
		//push values to smartdashboard
		SmartDashboard.putNumber("Obstacle", Commands.auton.process(OI.JOYSTICK_throttleLeft.getZ())); // left joystick
		SmartDashboard.putNumber("Position", Commands.auton.process(OI.JOYSTICK_throttleRight.getZ())); // right joystick
		SmartDashboard.putNumber("Gyro", RobotMap.gyro.getAngle());
	}

	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		Commands.auton();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		Commands.auton.cancel();
		Commands.start();
	}

	public void teleopPeriodic() {
		SmartDashboard.putNumber("Gyro", RobotMap.gyro.getAngle());
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
	}
}
