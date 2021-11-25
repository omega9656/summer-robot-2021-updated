package org.firstinspires.ftc.teamcode.auto;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class DuckDetectorOpenCV extends OpenCvPipeline {

    private int width;

    String pos = "";

    public DuckDetectorOpenCV(){

    }

    @Override
    public final Mat processFrame(Mat input){

        Mat workingMatrix = new Mat();

        input.copyTo(workingMatrix);

        if(workingMatrix.empty()){
            pos = "Right!";
            return input;
        }

        // converts camera to detect in yellow color scale
        Imgproc.cvtColor(input, workingMatrix, Imgproc.COLOR_RGB2YCrCb);
        //Core.extractChannel();

        Mat left = workingMatrix.submat(120, 150, 0, 30);
        Mat center = workingMatrix.submat(120, 150, 80, 150);

        double leftTot = Core.sumElems(left).val[2];
        double centerTot = Core.sumElems(center).val[2];

        if(leftTot > centerTot){
            pos = "Left";
        }
        else if(centerTot >= leftTot){
            pos = "Middle";
        }

        return workingMatrix;


    }
}
