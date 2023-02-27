package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class NavXGyro extends HFGyro {

    private AHRS ahrs;
    public final int flagOnErrorValue = 4207;
    public NavXGyro() { //int gyroAxis) {
    //	useGyroAxis = gyroAxis;
        ahrs = new AHRS(SPI.Port.kMXP);
      //  ahrs.
    }
    public void reset() {
    	ahrs.reset();
    }
    public double getAngle() {
      //ahrs.getRawGyroY()
		return ahrs.getAngle();

    }

    public void displayAngles() {
    	System.out.println("XAxis " + ahrs.getRawGyroX() + "\tYAxis " + ahrs.getRawGyroY() +
    	          "\tZAxis " + ahrs.getRawGyroZ() + "\tYaw " + ahrs.getYaw() + " ang" + ahrs.getAngle());
    }

    public void showAllGyro() {
    	SmartDashboard.putString("XAxis",  "" + ahrs.getRawGyroX());
    	SmartDashboard.putString("YAxis",  "" + ahrs.getRawGyroY());
    	SmartDashboard.putString("ZAxis",  "" + ahrs.getRawGyroZ());
    	SmartDashboard.putString("Yaw",  "" + ahrs.getYaw());
    }
    public double getCompassHeading() {
    	if(0< 1 || ahrs.isMagnetometerCalibrated()) {
    		return ahrs.getCompassHeading();
    	} else {
    		return flagOnErrorValue;
    	}
    }
    public double getVelocityX() {
    	return ahrs.getVelocityX();
    }
    public double getVelocityY() {
    	return ahrs.getVelocityY();
    }
    public double getVelocityZ() {
    	return ahrs.getVelocityZ();
    }
    public double getDisplacementX() {
    	return ahrs.getDisplacementX();
    }
    public double getDisplacementY() {
    	return ahrs.getDisplacementY();
    }
    public double getDisplacementZ() {
    	return ahrs.getDisplacementZ();
    }
    
    public boolean isMoving() {
    	return ahrs.isMoving();
    }

    public Rotation2d getRotation2d(){
   return new Rotation2d(ahrs.getAngle()*Math.PI/180);
   //   System.out.println(ahrs.getRotation2d().toString());
    //  return ahrs.getRotation2d();
    }
    public double getRate() {
      return ahrs.getRate();
    }
  
}