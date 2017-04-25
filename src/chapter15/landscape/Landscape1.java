package chapter15.landscape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Landscape1 extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		((Graphics2D) g).scale(getWidth() / 800., getHeight() / 600.);

		g.setColor(Color.ORANGE);
		g.drawOval(600, 75, 100, 100);

		g.setColor(Color.BLACK);
		g.fillRect(200, 250, 50, 200);
		g.setColor(Color.GREEN);
		g.fillOval(150, 200, 150, 100);

		g.setColor(new Color(125, 0, 125));
		g.fillRect(550, 300, 150, 150);
		g.setColor(Color.BLUE);

		int[] x = { 550, 700, 620 };
		int[] y = { 300, 300, 250 };
		g.fillPolygon(x, y, 3);

		g.setColor(Color.GREEN);
		g.drawLine(0, 450, 800, 450);
		g.setColor(new Color(125, 0, 125));
		g.setFont(new Font("Serif", 3, 40));
		g.drawString("Sunnyvale, CA: A Scenic Landscape", 100, 525);
	}

	public static void main(String[] args) {
		JFrame w = new JFrame("Scenic Landscape");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(3);
		Landscape1 panel = new Landscape1();
		panel.setBackground(Color.WHITE);
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
	}
}
