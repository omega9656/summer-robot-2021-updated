package org.firstinspires.ftc.teamcode.hardware;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.util.Encoder;

public class Drivetrain {
    public DcMotorEx backLeft;
    public DcMotorEx backRight;
    public DcMotorEx frontLeft;
    public DcMotorEx frontRight;

    public Drivetrain(DeviceManager deviceManager){
        backLeft = deviceManager.backLeft;
        backRight = deviceManager.backRight;

        frontLeft = deviceManager.frontLeft;
        frontRight = deviceManager.frontRight;


        // set motor modes
        //backLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //backRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //frontLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //frontRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // set 0 power behavior to brake (actively resists movement)
        backLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        // All motors should rotate toward the front of the robot
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);


    }



}