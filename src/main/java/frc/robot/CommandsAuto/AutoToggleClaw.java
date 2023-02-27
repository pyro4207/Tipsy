// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandsAuto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;


public class AutoToggleClaw extends CommandBase {
  /** Creates a new ArmUp. */
  double t;
  double totT = 100;
  double delay = 1000;
  boolean complete = false;
  public AutoToggleClaw() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    t = System.currentTimeMillis();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (System.currentTimeMillis()-t > delay) {
      Robot.m_Solenoids.togglePiston();
      complete = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_arm.armRotStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if((System.currentTimeMillis()-t > totT+delay )|| complete){
      return true;
    } else {
      return false;
    }
   
  }
}
