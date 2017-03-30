package chapter11.dancestudio;

import java.awt.Image;

public class RandomHopper extends Hopper {

	public RandomHopper(int x, int y, Image leftPic, Image rightPic) {
		super(x, y, leftPic, rightPic);
	}

	public void step() {
		int dir = (int) (Math.random() * 4);
		if (dir == 0) {
			super.turnAround();
			getLeftFoot().moveForward(stepLength);
			getRightFoot().moveForward(stepLength);
		} else if (dir == 1) {
			super.turnRight();
			getLeftFoot().moveForward(stepLength);
			getRightFoot().moveForward(stepLength);
		} else if (dir == 2) {
			super.turnLeft();
			getLeftFoot().moveForward(stepLength);
			getRightFoot().moveForward(stepLength);
		} else if (dir == 4) {
			getLeftFoot().moveForward(stepLength);
			getRightFoot().moveForward(stepLength);
		}
	}

	@Override
	public void firstStep() {
		step();

	}

	@Override
	public void nextStep() {
		step();
	}

	@Override
	public void stop() {
		step();
	}

}
