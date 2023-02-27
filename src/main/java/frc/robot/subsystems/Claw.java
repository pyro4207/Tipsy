// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Solenoids extends SubsystemBase {
  /** Creates a new Solenoids. */
  Solenoid sol0 = new Solenoid(PneumaticsModuleType.CTREPCM,4);
  Solenoid sol1 = new Solenoid(PneumaticsModuleType.CTREPCM,5);

   boolean pisExtended = true;
  public Solenoids() {
   


    
  }


  public void pistonIn () {

   
    sol0.set(false);
    sol1.set(true);
    
    };


  public void pistonOut () {
    sol0.set(true);
    sol1.set(false);

  }

  public void togglePiston(){
    if(pisExtended){
      pistonOut();
    } else{
      pistonIn();
    }
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
