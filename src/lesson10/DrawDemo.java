package lesson10;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DrawDemo extends JComponent {
	public static final int SIZE = 10; 

	@Override
	protected void paintComponent(final Graphics g) {
		final Graphics2D g2d = (Graphics2D)g;
		final Dimension size = getSize();
		final AffineTransform oldAt = g2d.getTransform();
		final AffineTransform at = new AffineTransform(g2d.getTransform());
		
		at.scale(getWidth()/SIZE, -getHeight()/SIZE);
		at.translate(SIZE/2, -SIZE/2);
		g2d.setTransform(at);
		
		Stroke str = new BasicStroke(0.05f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 1f);
		
		final Stroke oldStr = g2d.getStroke();
		g2d.setStroke(str);
		
		g2d.drawLine(0, -5, 0, 5);
		g2d.drawLine(5, 0, -5, 0);
		GeneralPath gp = new GeneralPath();
		
		gp.moveTo(-5, 25);
		for (int x = -5; x <= 5; x++) {
			int y = x * x;
			
			gp.lineTo(x, y);
		}
		final AffineTransform at2 = new AffineTransform();
		
		at2.scale(1, 0.2);
		gp.transform(at2);
		
		final Color oldColor = g2d.getColor();
		
		g2d.setColor(Color.RED);
		g2d.draw(gp);
		
		
		
		g2d.setColor(oldColor);
		g2d.setStroke(oldStr);
		g2d.setTransform(oldAt);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawDemo dd = new DrawDemo();
		
		dd.setPreferredSize(new Dimension(200,100));
		dd.setOpaque(false);
		
		JFrame f = new JFrame();
		
		f.getContentPane().add(dd);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300,300);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		
//		JOptionPane.showMessageDialog(null, dd);
	}

}
