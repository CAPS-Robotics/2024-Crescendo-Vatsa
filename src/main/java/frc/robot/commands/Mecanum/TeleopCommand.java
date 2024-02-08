// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Mecanum;

// import frc.robot.Dashboard;
import frc.robot.subsystems.MecanumSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class TeleopCommand extends Command {

  Joystick logitech;
  double speed;
  double maxSpeed = .5;
  double xAxis;
  double yAxis;
  double zAxis;

  boolean rightBumper;
  boolean leftBumper;

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private MecanumSubsystem mec_subsystem;
  // private Dashboard dashboard;

  public TeleopCommand(MecanumSubsystem subsystem, Joystick joystick) {
    this.mec_subsystem = subsystem;
    this.logitech = joystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(mec_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    speed = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    xAxis = logitech.getX() * maxSpeed; //Not used
    yAxis = logitech.getY() * maxSpeed;
    zAxis = logitech.getRawAxis(3) * maxSpeed;

    System.err.println(yAxis);
    // leftBumper = logitech.getRawButton(5);
    // rightBumper = logitech.getRawButton(6);
    double bob = 0;
    mec_subsystem.drive(xAxis, yAxis, bob);
    // if(xAxis != 0) {
    //   if(xAxis > 0) {
    //     mec_subsystem.strafeRight(maxSpeed);
    //   }
    //   if(xAxis < 0) {
    //     mec_subsystem.strafeLeft(maxSpeed);
    //   }
    // } else {
    //   mec_subsystem.drive(xAxis, yAxis, bob);
    // }

    // Update the dashboard with current values
    // dashboard.updateTeleopTab(leftBumper, rightBumper, yAxis, zAxis);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
//12.428616523742676