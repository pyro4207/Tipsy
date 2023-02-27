// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandsAuto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;


public class AutoArmUpHigh extends CommandBase {
  //ArmSubsystem arm;
  /** Creates a new DriveForward. */
  
  double totT = 8; 
  Timer timer;
  public AutoArmUpHigh() {
    // Use addRequirements() here to declare subsystem dependencies.
    
    addRequirements(Robot.m_arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer = new Timer();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("AutoArmTurning!!!!!!!!");
    Robot.m_arm.armRotSetToAng(105);    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.hasElapsed(totT)){
    return true;
  } else {
    return false;
  }
 
  }
}
