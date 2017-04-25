package chapter15.hw.excercise2;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class D extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getWidth() / 2;
		int h = getHeight() / 2;
		int d = Math.min(w, h);
		g.setColor(Color.ORANGE);
		int gap = 20;
		g.drawOval(w - d / 2, h - d / 6, d / 3, d / 3);
		g.drawOval(w - d / 2 + d / gap, h - d / 6 + d / gap, d / 3 - 2 * d / gap, d / 3 - 2 * d / gap);

		g.drawOval(w + d / 6, h - d / 6, d / 3, d / 3);
		g.drawOval(w + d / 6 + d / gap, h - d / 6 + d / gap, d / 3 - 2 * d / gap, d / 3 - 2 * d / gap);

		g.drawLine(w - d / 3, h - d / 6, w + d / 3, h - d / 6);
		g.drawLine(w - d / 3, h + d / 6, w + d / 3, h + d / 6);
	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Drawings");
		window.setBounds(100, 100, 300, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new D();
		canvas.setBackground(Color.WHITE);
		window.getContentPane().add(canvas);
		window.setVisible(true);
	}
}
