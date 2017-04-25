package chapter15.hw.excercise2;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class A extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getWidth() / 2;
		int h = getHeight() / 2;
		int d = Math.min(w, h);
		g.setColor(Color.RED);
			}

	public static void main(String[] args) {
		JFrame window = new JFrame("Drawings");
		window.setBounds(100, 100, 300, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new A();
		canvas.setBackground(Color.WHITE);
		window.getContentPane().add(canvas);
		window.setVisible(true);
	}
}
