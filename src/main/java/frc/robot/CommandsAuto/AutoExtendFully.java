// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandsAuto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;


public class AutoExtendFully extends CommandBase {
 // ArmSubsystem arm;
  double t;
  double totTime = 7;
  double delay = 2;
  Timer timer;
  /** Creates a new DriveForward. */
  public AutoExtendFully() {
    // Use addRequirements() here to declare subsystem dependencies.
    //arm = Robot.m_arm;
    addRequirements(Robot.m_extension);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer = new Timer();
    t = System.currentTimeMillis();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.hasElapsed(delay)){
      System.out.println("AutoExtending!!!!!!!!");
      Robot.m_extension.armExtend(1);   
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_extension.armExtStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.hasElapsed(totTime+delay)){
      return true;
    } else{
      return false;
    }
    
  }
}
