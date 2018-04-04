package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.roboraiders.Robot.RoboRaidersAuto;
import com.roboraiders.Robot.Robot;

/**
 * Created by Alex Snyder on 12/6/17.
 */

@Autonomous
@Disabled

public class CryptoboxRandomFarRed extends RoboRaidersAuto {

    public Robot robot = new Robot();

    @Override
    public void runOpMode() throws InterruptedException {

        robot.initialize(hardwareMap);
        robot.initializeServos();
        alignRobot(robot, "red", "far");
        telemetry.addData("Initialized", true);
        telemetry.update();

        waitForStart();
        robot.liftGlyph();

        lowerArm(robot); //jewel is selected
        selectJewel(robot, "red");

        encodersMove(robot, 20, 0.5, "backward"); //drive backward
        Thread.sleep(500);

        imuTurn(robot, 90, 0.5, "right"); //turn right 90 degrees
        Thread.sleep(250);

        encodersMove(robot, 8, 0.5, "forward"); //move forward 8 inches until in front of the center column
        Thread.sleep(250);

        imuTurn(robot, 90, 0.5, "right"); //turn right 90 degrees
        Thread.sleep(250);

        placeGlyphFar(robot); //robot places glyph
        Thread.sleep(500);
    }
}