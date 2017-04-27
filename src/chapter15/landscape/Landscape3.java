package chapter15.landscape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Landscape3 extends JPanel implements KeyListener {
	private static String root = System.getProperty("user.dir").replace('\\', '/');
	private Image tree;
	private boolean treeI;
	private Image house;
	private boolean houseI;
	private Image sun;
	private boolean sunI;
	private Image bird;
	private int loc[] = { 50, 50 };

	public Landscape3() {
		super();
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
		root += "/src/chapter15/landscape/";
		tree = loadImageFromFile(root + "tree.jpg");
		house = loadImageFromFile(root + "house.jpg");
		sun = loadImageFromFile(root + "sun.jpg");
		bird = loadImageFromFile(root + "bird.png");

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Auto-Scaler
		((Graphics2D) g).scale(getWidth() / 800., getHeight() / 600.);

		// sun
		if (sunI) {
			g.drawImage(sun, 600, 75, 100, 100, null);
		} else {
			g.setColor(Color.ORANGE);
			g.drawOval(600, 75, 100, 100);
		}

		// tree
		if (treeI) {
			g.drawImage(tree, 150, 200, 200, 250, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(200, 250, 50, 200);
			g.setColor(Color.GREEN);
			g.fillOval(150, 200, 150, 100);
		}

		// house
		if (houseI) {
			g.drawImage(house, 550, 250, 200, 200, null);
		} else {
			g.setColor(new Color(125, 0, 125));
			g.fillRect(550, 300, 150, 150);
			g.setColor(Color.BLUE);

			int[] x = { 550, 700, 620 };
			int[] y = { 300, 300, 250 };
			g.fillPolygon(x, y, 3);
		}

		// ground
		g.setColor(Color.GREEN);
		g.drawLine(0, 450, 800, 450);

		// text
		g.setColor(new Color(125, 0, 125));
		g.setFont(new Font("Serif", 3, 40));
		g.drawString("Sunnyvale, CA: A Scenic Landscape", 100, 525);

		// Moving Img
		g.drawImage(bird, loc[0], loc[1], 50, 50, null);
	}

	public static void main(String[] args) {
		JFrame w = new JFrame("Scenic Landscape");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(3);
		Landscape3 panel = new Landscape3();
		panel.setBackground(Color.WHITE);
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
	}

	private Image loadImageFromFile(String FileLoc) {
		try {
			return ImageIO.read(new File(FileLoc));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File " + FileLoc + " not Found");
			System.exit(1);
		}
		return null;

	}

	public void keyTyped(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_1) {
			sunI = (!sunI);
		} else if (key == KeyEvent.VK_2) {
			treeI = (!treeI);
		} else if (key == KeyEvent.VK_3) {
			houseI = (!houseI);
		} else if (key == KeyEvent.VK_4) {
			sunI = (!sunI);
			treeI = (!treeI);
			houseI = (!houseI);
		}
		repaint();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP && loc[1] > 0) {
			loc[1] -= 10;
		} else if (key == KeyEvent.VK_DOWN && loc[1] < 550) {
			loc[1] += 10;
		} else if (key == KeyEvent.VK_LEFT && loc[0] > 0) {
			loc[0] -= 10;
		} else if (key == KeyEvent.VK_RIGHT && loc[0] < 750) {
			loc[0] += 10;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
