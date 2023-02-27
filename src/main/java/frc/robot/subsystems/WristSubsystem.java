// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class WristSubsystem extends SubsystemBase {
  /** Creates a new WristSubsystem. */
  public static WPI_TalonSRX wrist = new WPI_TalonSRX(Constants.ArmConstants.MOTOR_ARM_WRIST);

  public WristSubsystem() {}


  public void wristUp() {
//    if(Robot.m_arm.articulationAvailable){
    wrist.set(-.8);
  //  }
  }
  public void wristDown() {
   // if(Robot.m_arm.articulationAvailable){
    wrist.set(.6);
   // }
  }
  public void wristStop() {
    wrist.set(0); 
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
