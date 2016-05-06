package org.usfirst.frc.team3473.robot;

import org.usfirst.frc.team3473.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3473.robot.subsystems.HangingArm;
import org.usfirst.frc.team3473.robot.subsystems.IntakeArm;

import edu.wpi.first.wpilibj.CameraServer;

public class Subsystems {
	public static Drivetrain drive;
	public static IntakeArm intake;
	public static HangingArm hang;
	public static CameraServer server;
	
	
	public static void init(){
		drive = new Drivetrain();
		intake = new IntakeArm();
		hang = new HangingArm();
		
		//camera init code
		server = CameraServer.getInstance();
		server.setQuality(50);
		server.startAutomaticCapture("cam1");
	}
	
	
}
