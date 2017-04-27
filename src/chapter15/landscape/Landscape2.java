package chapter15.landscape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Landscape2 extends JPanel {
	Image tree;
	Image house;
	Image sun;
	String root = System.getProperty("user.dir").replace('\\', '/');

	public Landscape2() {
		super();
		root += "/src/chapter15/landscape";
		tree = loadImageFromFile(root + "/tree.jpg");
		house = loadImageFromFile(root + "/house.jpg");
		sun = loadImageFromFile(root + "/sun.jpg");
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Auto-Scaler
		((Graphics2D) g).scale(getWidth() / 800., getHeight() / 600.);

		// sun
		g.drawImage(sun, 600, 75, 100, 100, null);

		// tree
		g.drawImage(tree, 150, 200, 200, 250, null);

		// house
		g.drawImage(house, 550, 250, 200, 200, null);

		// ground
		g.setColor(Color.GREEN);
		g.drawLine(0, 450, 800, 450);

		// text
		g.setColor(new Color(125, 0, 125));
		g.setFont(new Font("Serif", 3, 40));
		g.drawString("Sunnyvale, CA: A Scenic Landscape", 100, 525);
	}

	public static void main(String[] args) {
		JFrame w = new JFrame("Scenic Landscape");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(3);
		Landscape2 panel = new Landscape2();
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
}
