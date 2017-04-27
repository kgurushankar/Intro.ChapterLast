package chapter15.listeners;

import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardDemo extends JPanel implements KeyListener {

	private String ImageLoc = System.getProperty("user.dir").replace('\\', '/');
	private Image img, house, spider;
	int w, h, counter;
	boolean drawHouseImage = false;// initially until keyPressed
	boolean drawTreeImage = false;
	boolean birdFly;
	int vMove, hMove;
	Timer timer;

	public KeyBoardDemo() {
		ImageLoc += "/src/chapter15/listeners/";
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		w = getWidth();
		h = getHeight();

		int xBugPos = w / 6;
		int yBugPos = h / 6;

		if (drawHouseImage) {
			house = getImage(ImageLoc + "doghouse.jpg", 3);
			g.drawImage(house, w / 2, h / 2, null);

		} else {
			house = getImage(ImageLoc + "castle.jpg", 3);
			g.drawImage(house, w / 2, h / 2, null);
		}

		spider = getImage(ImageLoc + "spider.jpg", 10);
		g.drawImage(spider, xBugPos + hMove, yBugPos + vMove, null);

	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		// System.out.println("Key " + keyCode + " was pressed!");
		switch (keyCode) {
		case KeyEvent.VK_UP:
			vMove--;
			break;
		case KeyEvent.VK_DOWN:
			vMove++;
			break;
		case KeyEvent.VK_LEFT:
			hMove--;
			break;

		case KeyEvent.VK_RIGHT:
			hMove++;
		}

		repaint();

	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		char keyChar = e.getKeyChar();
		System.out.println("Key " + keyChar + " was pressed!");
		if (keyChar == '1') {
			if (drawHouseImage)
				drawHouseImage = false;
			else
				drawHouseImage = true;
		} else if (keyChar == '2') {
			if (drawTreeImage)
				drawTreeImage = false;
			else
				drawTreeImage = true;
		}
		repaint();
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
		KeyBoardDemo demo = new KeyBoardDemo();
		window.addKeyListener(demo);
		demo.setBackground(Color.white);
		window.getContentPane().add(demo);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

}
