package chapter11.dancestudio;

import java.awt.Image;

public class Hopper extends Biped {
	protected int stepLength;

	public Hopper(int x, int y, Image leftPic, Image rightPic) {
		super(x, y, leftPic, rightPic); // must be the first statement
		stepLength = PIXELS_PER_INCH * 12;
	}

	@Override
	public void firstStep() {
		getLeftFoot().moveForward(-stepLength);
		getRightFoot().moveForward(-stepLength);

	}

	@Override
	public void nextStep() {
		getLeftFoot().moveForward(stepLength);
		getRightFoot().moveForward(stepLength);
	}

	@Override
	public void stop() {
	}

	@Override
	public int distanceTraveled() {
		return 0;
	}

}
