package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class DuckMechanism {
    public DcMotorEx duckMech;

    public final double RUNNING_POWER = 0.5 * Math.PI;

    public DuckMechanism(DeviceManager deviceManager){
        //this.duckMech = deviceManager.duckMech;
        this.duckMech = deviceManager.intake; // if testing using intake port

        duckMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        duckMech.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void in(){
        duckMech.setVelocity(RUNNING_POWER, AngleUnit.RADIANS);
    }

    public void fastIn(){
        duckMech.setVelocity(RUNNING_POWER*1.5, AngleUnit.RADIANS);
    }

    public void stop(){
        duckMech.setVelocity(0);
    }
}
