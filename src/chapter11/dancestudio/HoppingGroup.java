package chapter11.dancestudio;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class HoppingGroup implements StudentGroup {
	private Hopper maleDancer;
	private Hopper femaleDancer;
	private Image leftMansShoe, rightMansShoe;
	private Image leftWomansShoe, rightWomansShoe;

	private DanceFloor danceFloor;

	private enum State {
		READY, MOVING, STOPPED
	}

	private State currentState;

	// Constructor
	public HoppingGroup(DanceFloor df) {
		danceFloor = df;
		leftMansShoe = (new ImageIcon("leftshoe.gif")).getImage();
		rightMansShoe = (new ImageIcon("rightshoe.gif")).getImage();
		leftWomansShoe = (new ImageIcon("leftsandal.gif")).getImage();
		rightWomansShoe = (new ImageIcon("rightsandal.gif")).getImage();
	}

	// Sets up this group of participants
	public void setup(int floorDir, Dance steps1, Dance steps2) {
		int x = danceFloor.getWidth() / 2;
		int y = danceFloor.getHeight() / 2;
		if (floorDir == 0) {
			maleDancer = new RandomHopper(x, y + Hopper.PIXELS_PER_INCH * 12, leftMansShoe, rightMansShoe);
			femaleDancer = new RandomHopper(x, y - Hopper.PIXELS_PER_INCH * 12, leftWomansShoe, rightWomansShoe);
			maleDancer.turnLeft();
			femaleDancer.turnRight();
		} else {
			maleDancer = new RandomHopper(x, y - Hopper.PIXELS_PER_INCH * 12, leftMansShoe, rightMansShoe);
			femaleDancer = new RandomHopper(x, y + Hopper.PIXELS_PER_INCH * 12, leftWomansShoe, rightWomansShoe);
			maleDancer.turnRight();
			femaleDancer.turnLeft();
		}
		currentState = State.READY;
		danceFloor.update(this);

		// maleDancer.learn(steps1);
		// femaleDancer.learn(steps2);
	}

	// Moves the group by one step
	public void makeNextStep() {
		if (currentState == State.READY) {
			maleDancer.firstStep();
			femaleDancer.firstStep();
			currentState = State.MOVING;
		} else if (currentState == State.MOVING) {
			maleDancer.nextStep();
			femaleDancer.nextStep();
			currentState = State.READY;
		} else if (currentState == State.STOPPED) // never happens
		{
			maleDancer.turnAround();
			femaleDancer.turnAround();
			currentState = State.READY;
		}

		danceFloor.update(this);
	}

	// Draws this group
	public void draw(Graphics g) {
		maleDancer.draw(g);
		femaleDancer.draw(g);
	}

}
