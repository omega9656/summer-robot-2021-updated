package org.firstinspires.ftc.teamcode.hardware;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.util.Encoder;

public class Drivetrain {
    public DcMotorEx backLeft;
    public DcMotorEx backRight;
    public DcMotorEx frontLeft;
    public DcMotorEx frontRight;

    public Encoder rightEncoder;
    public Encoder leftEncoder;
    public Encoder midEncoder;

    public Drivetrain(DeviceManager deviceManager){
        backLeft = deviceManager.backLeft;
        backRight = deviceManager.backRight;

        frontLeft = deviceManager.frontLeft;
        frontRight = deviceManager.frontRight;


        // set motor modes
        backLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        // set 0 power behavior to brake (actively resists movement)
        backLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        // All motors should rotate toward the front of the robot
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        // shadow encoders to motors they r ports of

    }

    // constants of odo
    final static double VERT_DISTANCE = 17.8; // L
    final static double MIDPOINT_TO_MID = .5; // B
    final static double RADIUS = 3.3; // R
    final static double TICKS_PER_REV = 8192; // N
    final static double CM_PER_TICK = 2.0 * Math.PI * RADIUS/TICKS_PER_REV;

    public int currentRightPos = 0;
    public int currentLeftPos = 0;
    public int currentMidPos = 0;

    public int oldRightPos = 0;
    public int oldLeftPos = 0;
    public int oldMidPos = 0;

    public void odometry(){
        oldRightPos = currentRightPos;
        oldLeftPos = currentLeftPos;
        oldMidPos = currentMidPos;

        currentRightPos = -rightEncoder.getCurrentPosition();
        currentLeftPos = -leftEncoder.getCurrentPosition();
        currentMidPos = -midEncoder.getCurrentPosition();

        int dn1 = currentRightPos - oldRightPos;
        int dn2 = currentLeftPos - oldLeftPos;
        int dn3 = currentMidPos - oldMidPos;

        double dtheta = CM_PER_TICK * (dn2-dn1) / VERT_DISTANCE;
        double dx = CM_PER_TICK * (dn1+dn2) / 2.0;
        double dy = CM_PER_TICK * (dn3 - (dn2-dn1) * MIDPOINT_TO_MID/VERT_DISTANCE);
        
    }



}