// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.Constants.ModuleConstants;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new SingleMotor. */

  public WPI_TalonFX turnArm = new WPI_TalonFX(Constants.ArmConstants.MOTOR_ARM_TURN);
  public WPI_TalonFX turnArm2 = new WPI_TalonFX(Constants.ArmConstants.MOTOR_ARM_TURN2);
  

  public boolean articulationAvailable;
double pulsePerDeg = 4500;
double targetExt;
double pulsePerFulExt = 345000;
  double rightTurnArmAng;
  double armCurAng;
  double rt = 0;
  double lt = 0;
  double armCurExt; 
boolean astop = true;
  public ArmSubsystem() {
    turnArm.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    turnArm2.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    
    turnArm.setInverted(true);
    turnArm2.setInverted(false);
    turnArm2.follow(turnArm);
    
    turnArm.configPeakOutputForward(.80);
    turnArm2.configPeakOutputForward(.80);
    turnArm.configPeakOutputReverse(-.5);
    turnArm2.configPeakOutputReverse(-.5);

    turnArm.config_kP(0, .15, 30);
    turnArm.config_kI(0, 0, 30);
    turnArm.config_kI(0, .5, 30);
    turnArm.config_kF(0, 0, 30);
    turnArm.configAllowableClosedloopError(0, 2000, 30);


    turnArm2.config_kP(0, .15, 30);
    turnArm2.config_kI(0, 0, 30);
    turnArm2.config_kI(0, .5, 30);
    turnArm2.config_kF(0, 0, 30);
    turnArm2.configAllowableClosedloopError(0, 2000, 30);

    articulationAvailable = false;
  }

  public void findTrigVals(){
    rt = RobotContainer.m_driverController.getRightTriggerAxis();
    lt = RobotContainer.m_driverController.getLeftTriggerAxis();// m_robotContainer.m_driverController.getLeftTriggerAxis();
  }

  public void armBreakOn(){
    turnArm.setNeutralMode(NeutralMode.Brake);
    ExtensionSubsystem.extArm.setNeutralMode(NeutralMode.Brake);
    WristSubsystem.wrist.setNeutralMode(NeutralMode.Brake);
    turnArm2.setNeutralMode(NeutralMode.Brake);
  }

  public void setArmFromController(){
      rt = RobotContainer.m_driverController.getRightTriggerAxis();
      lt = RobotContainer.m_driverController.getLeftTriggerAxis();
      rightTurnArmAng = turnArm.getSelectedSensorPosition();
      /*
      if(rt>.1){
        turnArm2.set(-rt/4);
        turnArm.set(rt/4);
        astop = true;
      }else if(lt>.1){
        turnArm2.set(lt/10);
        turnArm.set(-lt/10);
        astop = true;
      }else{
        if(astop){
          turnArm2.set(0);
            turnArm.set(0);
            astop = !astop;
         }
      }*/

      
      
   }

//****************/
  public void armUp() {
    turnArm.set(.8);
   // turnArm2.set(-powerUp);

  }
  public void armDown() {
    turnArm.set(-.4);
    //turnArm2.set(powerUp);
  }
  public void armRotStop() {
    turnArm.set(0);
   // turnArm2.set(0);
  }

  public void resetArmEncoders(){
    turnArm.setSelectedSensorPosition(0);
  }

  public void armRotSetToAng(double tarAng){
    tarAng = tarAng * pulsePerDeg;
    turnArm.set(ControlMode.Position, tarAng); //add about 3000 for robot start "0" to be actual target 0
  }

  

  //*****************/


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    armCurAng = turnArm.getSelectedSensorPosition();
    SmartDashboard.putNumber("armCurAng", armCurAng);
    
   if(armCurAng>130000){
    if(!articulationAvailable){
      articulationAvailable = true;
    }
   } else{
    if(articulationAvailable){
    articulationAvailable = false;
    }
   }
  }
}
