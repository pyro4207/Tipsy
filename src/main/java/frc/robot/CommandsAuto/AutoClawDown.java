// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandsAuto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoClawDown extends CommandBase {
  
  double t;
  double totTime = 1.8;
  double delay = 2;
  Timer timer;
  /** Creates a new DriveForward. */
  public AutoClawDown() {
    // Use addRequirements() here to declare subsystem dependencies.

    addRequirements(Robot.m_wrist);
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
    System.out.println("AutoClawDropping!!!!!!!!");
    if(timer.hasElapsed(delay)){
    Robot.m_wrist.wristDown();   
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_wrist.wristStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.hasElapsed(delay+totTime)){
      return true;
    } else{
      return false;
    }
    
  }
}
