package org.usfirst.frc.team3473.robot;

import org.usfirst.frc.team3473.robot.commands.Auton;
import org.usfirst.frc.team3473.robot.commands.Drive;
import org.usfirst.frc.team3473.robot.commands.Hang;
import org.usfirst.frc.team3473.robot.commands.Intake;

public class Commands {
	
	public static Auton auton;
	public static Drive drive;
	public static Hang hang;
	public static Intake intake;
	
	
	public static void init(){
		auton = new Auton();
		drive = new Drive();
		hang = new Hang();
		intake = new Intake();
	}
	
	public static void start(){
		drive.start();
		hang.start();
		intake.start();
	}
	
	public static void auton(){
		auton.start();
	}
	
}