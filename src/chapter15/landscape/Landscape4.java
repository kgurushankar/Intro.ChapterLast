package chapter15.landscape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Landscape4 extends JPanel implements KeyListener, MouseListener {
	private static String root = System.getProperty("user.dir").replace('\\', '/');
	private Image tree;
	private boolean treeI;
	private Image house;
	private boolean houseI;
	private Image sun;
	private boolean sunI;
	private Image bird;
	private int loc[] = { 50, 50 };

	public Landscape4() {
		super();
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addMouseListener(this);
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
		Landscape4 panel = new Landscape4();
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
		int key = e.getKeyChar();
		System.out.println(e.getKeyChar());
		if (key == '1') {
			sunI = (!sunI);
		} else if (key == '2') {
			treeI = (!treeI);
		} else if (key == '3') {
			houseI = (!houseI);
		} else if (key == '4') {
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

	@Override
	public void mouseClicked(MouseEvent e) {
		int mousex = e.getX() * 800 / getWidth();
		int mousey = e.getY() * 600 / getHeight();

		if (mousex >= loc[0] && mousex <= loc[0] + 50 && mousey >= loc[1] && mousey <= loc[1] + 50) {
			if (e.getButton() == 1) {
				loc[0] = 650 - 50;
				loc[1] = 350 - 25;
			} else if (e.getButton() == 3) {
				loc[0] = (int) (Math.random() * 750);
				loc[1] = (int) (Math.random() * 550);
			}
		}
		repaint();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
