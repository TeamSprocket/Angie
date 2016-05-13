package org.usfirst.frc.team3473.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;

public class RobotMap {

	/**
	 *  Sensors
	 */
	
	public static AnalogGyro gyro;
	
	/** 
	 *  Talons
	 */
	
	public static CANTalon  TALON_frontRIGHT,
				TALON_centerRIGHT,
				TALON_backRIGHT,
				TALON_frontLEFT,
				TALON_centerLEFT,
				TALON_backLEFT,
				TALON_intakeTop,
				TALON_intakeBot,
				TALON_intakeActuation,
				TALON_hangActuation,          
				TALON_hangExtension, 
				TALON_spool;
	
	/**
	 *  Initialize every sensor and talon
	 */
	public static void init() {

		TALON_frontRIGHT = new CANTalon(Phannels.PORT_drivebaseFrontRIGHT);
		TALON_centerRIGHT = new CANTalon(Phannels.PORT_drivebaseCenterRIGHT);
		TALON_backRIGHT = new CANTalon(Phannels.PORT_drivebaseBackRIGHT);
		TALON_frontLEFT = new CANTalon(Phannels.PORT_drivebaseFrontLEFT);
		TALON_centerLEFT = new CANTalon(Phannels.PORT_drivebaseCenterLEFT);
		TALON_backLEFT = new CANTalon(Phannels.PORT_drivebaseBackLEFT);
		TALON_intakeTop = new CANTalon(Phannels.PORT_intakeTop);
		TALON_intakeBot = new CANTalon(Phannels.PORT_intakeBot);
		TALON_intakeActuation = new CANTalon(Phannels.PORT_intakeActuation);
		TALON_hangActuation = new CANTalon(Phannels.PORT_hangActuation);
		TALON_hangExtension = new CANTalon(Phannels.PORT_hangExtension);
		TALON_spool = new CANTalon(Phannels.PORT_spool);
		
		gyro = new AnalogGyro(Phannels.PORT_gyro);
	}

}
