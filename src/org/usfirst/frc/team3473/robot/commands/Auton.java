package org.usfirst.frc.team3473.robot.commands;

import org.usfirst.frc.team3473.robot.OI;
import org.usfirst.frc.team3473.robot.RobotMap;
import org.usfirst.frc.team3473.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Auton extends Command {
	private int obstacle, 
				pos;
	
	private boolean finished = false;
	
	//times in milliseconds
	private long touch = 550, 
		     rock = 2000, 
		     armDown = 1550, 
		     armHold = 630, 
		     low = 2500, 
		     chev = 1700, 
		     goal = 1000 + armHold, 
		     backUp = 800,  
		     touchAfter[] = {2200,0,0,300,2200};
		     
	public Auton() {
	}

	protected void initialize() {
	}

	protected void execute() {
		obstacle = process(OI.JOYSTICK_throttleLeft.getZ()); // left
		pos = process(OI.JOYSTICK_throttleRight.getZ()); // right
		RobotMap.gyro.reset();
		
		switch (obstacle) {
		
		//low bar
		case 0:
		case 1:
			actuate(true, armDown);
			move(low, .4);
			break;
		
		// cheval de frise
		case 2:
		case 3:
			move(touch, .4);
			actuate(true, armDown);
			pause(1000);
			chevMove(chev, .6, false, armHold);
			pause(1500-armHold);
			break;
		
		// rock wall/rough terrain
		case 4:
			move(rock, .8); 
			break;
			
		// touch defense for 2 pts
		default:
			move(touch, .4);
			finished = true;
			return;
		}

		switch (pos) {
		case 0:
			move(touchAfter[0], .4);
			turn(55); // need to turn right (right = +)
			move(goal, .4);
			shoot();
			move(backUp, -.4);
			turn(-180);
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			move(touchAfter[4], .4);
			turn(-55); // need to turn left
			chevMove(goal, .4, false, armHold);
			shoot();
			move(backUp, -.4);
			turn(-180);
			break;

		}
		
		finished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

	private void shoot(){
		Subsystems.intake.moveRollers(-1);
		pause(2000);
		Subsystems.intake.moveRollers(0);
	}
	
	private void turn(double angle) {
		getToAngle(angle, .7, 0, 0);
	}

	private void getToAngle(double angle, double speed,int successes, int iter) {
		SmartDashboard.putNumber("Gyro", RobotMap.gyro.getAngle());
		SmartDashboard.putNumber("Iterations", iter);
		
		if(iter > 800){
			return;
		}
		
		if(approxEq(angle, RobotMap.gyro.getAngle(), angle)) {
			Subsystems.drive.drive(0, 0);
			
			if (successes > 3) {
				return;
			}
			
			pause(100);
			getToAngle(angle, speed, successes + 1, iter + 1);
			
		} else {
			
			Subsystems.drive.drive(0, ((RobotMap.gyro.getAngle() < angle) ? -1 : 1) * Math.abs(speed) * Math.abs(angle - RobotMap.gyro.getAngle()) / (angle*.65));
			getToAngle(angle, speed, successes, iter + 1);
		}
		

	}

	private boolean approxEq(double a, double b, double angle) {
		return Math.abs(b - a) < Math.abs(angle / 5);
	}

	private void actuate(boolean down, long time) {
		Subsystems.intake.actuate((down) ? -.75 : 1);
		pause(time);
		Subsystems.intake.actuate(0);
		pause((down) ? 2000 - time : 0);
	}

	private void chevMove(long driveTime, double speed, boolean down, long armTime){
		Subsystems.drive.drive(-speed, 0);
		actuate(down, armTime);
		pause(driveTime-armTime);
		Subsystems.drive.drive(0, 0);
	}
	
	private void move(long time, double speed) {
		Subsystems.drive.drive(-speed, 0);
		pause(time);
		Subsystems.drive.drive(0, 0);
	}

	private void pause(long seconds) {
		long l = System.currentTimeMillis();
		while (System.currentTimeMillis() - l < seconds);
	}

	public int process(double d) {
		if (d < -.75) {
			return 0;
		}
		if (d < -.25) {
			return 1;
		}
		if (d < .25) {
			return 2;
		}
		if (d < .75) {
			return 3;
		}
		return 4;
	}

}
