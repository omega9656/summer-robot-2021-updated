package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

@Autonomous(name = "Open CV")
public class OpenCVAuto extends LinearOpMode {

    private OpenCvInternalCamera cam;
    private DuckDetectorOpenCV duckDetectorOpenCV;
    private String pos;

    @Override
    public void runOpMode(){
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        WebcamName webcamName = hardwareMap.get(WebcamName.class, "Webcam 1");

        OpenCvCamera camera = OpenCvCameraFactory.getInstance().createWebcam(webcamName, cameraMonitorViewId);

        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                telemetry.addLine("OPENED");
            }
            @Override
            public void onError(int errorCode)
            {
                telemetry.addLine("NO!");
            }
        });

        camera.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
        camera.setViewportRenderer(OpenCvCamera.ViewportRenderer.GPU_ACCELERATED);

        camera.setPipeline(duckDetectorOpenCV);

        pos = duckDetectorOpenCV.pos;

        while(!isStarted()){
            pos = duckDetectorOpenCV.pos;
            telemetry.addData("pos", pos);
        }

    }
}
