// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PhotonVisCamera extends SubsystemBase {
  /** Creates a new PhotonCamera. */

  final double  CAMERA_HEIGHT_METERS = Units.inchesToMeters(0);
  final double TARGET_HEIGHT_METERS = Units.feetToMeters(0);
  final double TARGET_DISTANCE_METERS = Units.feetToMeters(0);
  final double CAMERA_PITCH_RADIANS = Units.degreesToRadians(0);
 // PhotonVisCamera photonCam = new PhotonVisCamera();

  public PhotonVisCamera() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  
  }





}
