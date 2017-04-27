package chapter15.listeners;

import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseDemo extends JPanel implements MouseListener {

	private Image img, bird;
	int w, h; // width and height of the jpanel;

	boolean birdFly;
	int vMove, hMove;

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		w = getWidth();
		h = getHeight();

		if (birdFly) {
			bird = getImage("bird4.png", 10);
			g.drawImage(bird, w / 4, h / 4 - 20, null);

		} else {
			bird = getImage("bird1.gif", 10);
			g.drawImage(bird, w / 4, 3 * h / 4, null);
		}

	}

	public void mousePressed(MouseEvent e) {
		int xPos = e.getX();
		int yPos = e.getY();
		// System.out.println("Mouse Coordinate: ("+xPos+","+yPos+")");
		// System.out.println("xValues are from " + w/4 + " and " + w/4 +
		// bird.getWidth(null));
		// System.out.println("yValues are from " + h/4 + " and " + h/4 +
		// bird.getHeight(null));
		if (xPos >= w / 4 && xPos < w / 4 + bird.getWidth(null) && yPos >= 3 * h / 4
				&& yPos < 3 * h / 4 + bird.getHeight(null)) {
			System.out.println("Inside the area!");
			birdFly = true;
		}
		repaint();
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public Image getImage(String n, int r) {
		try {
			img = ImageIO.read(new File(n));
		} catch (IOException e) {
			System.out.println("There is no image file!");
		}

		if (img != null) {

			img = img.getScaledInstance(w / r, h / r, Image.SCALE_DEFAULT);
		}
		return img;
	}

	public static void main(String[] args) {

		JFrame window = new JFrame("My Window");
		window.setBounds(50, 50, 1000, 600);
		MouseDemo demo = new MouseDemo();
		demo.addMouseListener(demo);
		demo.setBackground(Color.white);
		window.getContentPane().add(demo);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

}
