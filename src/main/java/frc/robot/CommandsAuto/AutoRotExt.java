// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandsAuto;



import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoRotExt extends ParallelCommandGroup {
  /** Creates a new AutoPickup1ThenShoot2Sequential. */
  public AutoRotExt() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new AutoArmUpHigh(),
      new AutoExtendFully(),
      new AutoClawDown()
    );
  }
}
