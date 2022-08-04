package com.team2073.robot;

import com.team2073.common.robot.AbstractRobotDelegate;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import org.photonvision.PhotonCamera;

public class RobotDelegate extends AbstractRobotDelegate {
    Subsystem subsystem;
    ApplicationContext appCTX = ApplicationContext.getInstance();
    OperatorInterface oi = new OperatorInterface();
    PhotonCamera camera;
    NetworkTableInstance inst = NetworkTableInstance.getDefault();

    public RobotDelegate(double period) {
        super(period);
    }

    @Override
    public void robotInit() {

        NetworkTableInstance.getDefault().startClient("photonvision.local:5800");
        camera = new PhotonCamera(inst,"VGA_USB_Camera");
        // PhotonCamera.setVersionCheckEnabled(false);

    }

    @Override
    public void robotPeriodic() {
        System.out.println(camera.getLatestResult().hasTargets());
    }

}
