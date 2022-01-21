package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    public DeviceManager deviceManager;

    public Drivetrain drivetrain;

    public Arm arm;
    public Flap flap;
    public TrayTilt trayTilt;
    public Intake intake;
    public DuckMechanism duckMechanism;

    public Robot(HardwareMap hardwareMap) {
        deviceManager = new DeviceManager(hardwareMap);
    }

    public void init(boolean autoIsRunning) {
        deviceManager.init(autoIsRunning);

        // drivetrain is only used for TeleOp
        if (!autoIsRunning) {
            drivetrain = new Drivetrain(deviceManager);
        }
        //intake = new Intake(deviceManager); // TODO uncheck
        //arm = new Arm(deviceManager);
        //duckMechanism = new DuckMechanism(deviceManager);
        //flap = new Flap(deviceManager);
        //trayTilt = new TrayTilt(deviceManager);
    }
}
