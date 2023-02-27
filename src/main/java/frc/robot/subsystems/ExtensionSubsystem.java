// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.ResourceBundle.Control;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ExtensionSubsystem extends SubsystemBase {
  /** Creates a new ExtensionSubsystem. */

  DigitalInput outLimitSwitch = new DigitalInput(0);
  DigitalInput inLimitSwitch = new DigitalInput(1);
 // DigitalInput inLimitSwitch = new DigitalInput(1);

  public static WPI_TalonFX extArm = new WPI_TalonFX(Constants.ArmConstants.MOTOR_ARM_EXT);
  Boolean outSwitchState;
  Boolean inSwitchState;
  double pulsePerDeg = 4500;
double targetExt;
double pulsePerFulExt = 620000;
  double armCurExt; 
  double curExtVolt;
boolean astop = true;
  public ExtensionSubsystem() {
    extArm.configPeakOutputForward(.8);
    extArm.configPeakOutputReverse(-.8);
    extArm.set(ControlMode.PercentOutput, 0);
    extArm.config_kP(0, .15, 30);
    extArm.config_kI(0, 0, 30);
    extArm.config_kI(0, .5, 30);
    extArm.config_kF(0, 0, 30);
    extArm.configAllowableClosedloopError(0, 2000, 30);
  }

  public void resetExtEncoder(){
    extArm.setSelectedSensorPosition(0);
  }

  public void armExtend (double inPer) {
    if(outSwitchState){
      extArm.set(8);
    }else {
      extArm.set(0);
    }
  }

  public void armRetract () {

    if(inSwitchState){
      extArm.set(-.8);
    }else {
      extArm.set(0);
    }
  }


  public void armExtStop () {
    extArm.set(0.0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    outSwitchState = outLimitSwitch.get();
    SmartDashboard.putBoolean("Out Limit Switch", outSwitchState);

    inSwitchState = inLimitSwitch.get();
    SmartDashboard.putBoolean("In Limit Switch", inSwitchState);

    armCurExt = extArm.getSelectedSensorPosition();
    SmartDashboard.putNumber("Arm Extention Length", armCurExt);
  }
}
