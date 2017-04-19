package chapter11.dancestudio;

// Represents a display panel for a dance group

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class DanceFloor extends JPanel {
	// Constructor
	public DanceFloor() {
		setBackground(Color.WHITE);
	}

	// Called from DanceGroup
	public void update(StudentGroup students) {
		this.students = students;
		repaint();
	}

	private StudentGroup students;

	// Called when this panel needs to be repainted
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int xreps = getWidth() / 100 + 1;
		int yreps = getHeight() / 100 + 1;
		boolean color = false;
		for (int i = 1; i < xreps * 2; i++) {// x
			for (int j = 1; j < yreps * 2; j++) {// y
				color = !color;
				g.setColor((color) ? Color.RED : Color.BLUE);
				g.fillRect(50 * (i - 1), 50 * (j - 1), 50, 50);
			}
		}
		if (students != null)
			students.draw(g);
	}
}
