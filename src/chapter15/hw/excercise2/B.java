package chapter15.hw.excercise2;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class B extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getWidth();
		int h = getHeight();
		int d = Math.min(w, h);
		g.setColor(Color.MAGENTA);
		g.fillRoundRect(w / 2 - d / 4, h / 2 - d / 4, d / 2, d / 2, d / 4, d / 4);
		g.setColor(Color.white);
		g.fillOval(w / 2 - d / 4, h / 2 - d / 4, d / 4, d / 4);
		g.fillOval(w / 2 - d / 4, h / 2, d / 4, d / 4);
		g.fillOval(w / 2, h / 2 - d / 4, d / 4, d / 4);
		g.fillOval(w / 2, h / 2, d / 4, d / 4);
	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Drawings");
		window.setBounds(100, 100, 300, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new B();
		canvas.setBackground(Color.WHITE);
		window.getContentPane().add(canvas);
		window.setVisible(true);
	}
}
