package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Intake {
    public MotorPower currentPower; //declaring MotorPower
    //public DuckVelo duckVelocity;
    public DcMotorEx intake; //declaring Intake

    public Intake(DeviceManager deviceManager) {
        intake = deviceManager.intake;

        intake.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER); // when ran, ran without encoder?
        intake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE); // when power is 0, BRAKE


        currentPower = MotorPower.STOP; // default power is at STOP(0)
    }
    public enum MotorPower {
        // set the power for the intake at different states
        IN(-0.08), //-0.8
        OUT(0.05), //0.5
        STOP(0); //0

        public double intakePower;

        MotorPower(double intakePower) {
            this.intakePower = intakePower;
        }
    }

    // ticks per rev = 537.6
    /*public enum DuckVelo{
        FAST(1),
        FASTER(2),
        FASTEST(3);

        public double duckVelo;

        DuckVelo(double duckVelo){ this.duckVelo = duckVelo;}
    }*/

    public void run(MotorPower motorPower){
        intake.setPower(motorPower.intakePower);
        currentPower = motorPower;
    }

    /*public void runDuck(DuckVelo duckVelo){
        intake.setVelocity(duckVelo.duckVelo, AngleUnit.RADIANS);
        duckVelocity = duckVelo;
    }

    public void fast(){
        runDuck(DuckVelo.FAST);
    }
    public void faster(){
        runDuck(DuckVelo.FASTER);
    }
    public void fastest(){
        runDuck(DuckVelo.FASTEST);
    }*/

    public void in(){
        run(MotorPower.IN); //calling the run method for the IN power
    }
    public void out(){
        run(MotorPower.OUT); //calling the run method for the OUT power
    }
    public void stop(){
        run(MotorPower.STOP); //calling the run method for the STOP power
    }
}
