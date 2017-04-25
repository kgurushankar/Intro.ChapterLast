package chapter15.hw.excercise2;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.scene.effect.ColorAdjust;

public class G extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int w = getWidth() / 2;
		int h = getHeight() / 2;
		int d = Math.min(w, h);
		g.setColor(Color.PINK);
		g.drawArc(w - d / 2, h - d / 2, d, d, 0, -270);
		g.drawLine(w, h - d / 2, w, h);
		g.drawLine(w + d / 2, h, w, h);
	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Drawings");
		window.setBounds(100, 100, 300, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new G();
		canvas.setBackground(Color.WHITE);
		window.getContentPane().add(canvas);
		window.setVisible(true);
	}
}
