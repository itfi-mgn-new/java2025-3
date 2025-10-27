package lesson5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class JFrameTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JFrame	frame = new JFrame();
	
		frame.setVisible(true);
		frame.setSize(350,200);
		frame.setLocation(300,500);
		frame.setTitle("test window");
		
//		frame.getContentPane().setLayout(null);
		
		JLabel	label = new JLabel("test", JLabel.CENTER);
		
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setOpaque(true);
		
//		frame.getContentPane().add(label, BorderLayout.CENTER);

		JLabel	label2 = new JLabel("<html><body><font color=red>test2</font></body></html>");
		
		label2.setFont(new Font("Courier", Font.BOLD|Font.ITALIC, 36));
		
		label2.setPreferredSize(new Dimension(100,100));
		
//		frame.getContentPane().add(label2, BorderLayout.NORTH);
		
		label.setSize(100,100);
		label.setLocation(100,100);
	
		JSplitPane	sp = new JSplitPane();
	
		sp.setLeftComponent(label);
//		sp.setRightComponent(label2);

		JPanel	panel = new JPanel(new GridLayout(2,2));	
		
		panel.add(new JLabel("1"));
		panel.add(new JLabel("2"));
		panel.add(new JLabel("3"));
		panel.add(new JLabel("4"));
		
		sp.setRightComponent(panel);
		
		frame.getContentPane().add(sp, BorderLayout.CENTER);
		
		
		
		frame.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.err.println("Call closing");
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
		
//		System.in.read();
//		
//		frame.dispose();
	}

}
