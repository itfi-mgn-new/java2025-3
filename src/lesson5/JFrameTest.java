package lesson5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class JFrameTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JFrame	frame = new JFrame();
		
		JDialog d = new JDialog();
	
		frame.setVisible(true);
		frame.setSize(350,200);
		frame.setLocation(300,500);
		frame.setTitle("test window");
		
//		frame.getContentPane().setLayout(null);
		
//		JLabel	label = new JLabel("test", JLabel.CENTER);
		
//		label.setBackground(Color.BLACK);
//		label.setForeground(Color.WHITE);
//		label.setOpaque(true);
		
//		frame.getContentPane().add(label, BorderLayout.CENTER);

		JLabel	label2 = new JLabel("<html><body><font color=red>test2</font></body></html>");
		
		label2.setFont(new Font("Courier", Font.BOLD|Font.ITALIC, 36));
		
		label2.setPreferredSize(new Dimension(100,100));
		
//		frame.getContentPane().add(label2, BorderLayout.NORTH);
		
//		label.setSize(100,100);
//		label.setLocation(100,100);
	
		JSplitPane	sp = new JSplitPane();
	
		JToggleButton tb = new JToggleButton("Press me");
		
		sp.setLeftComponent(tb);		
//		sp.setRightComponent(label2);

		JPanel	panel = new JPanel(new GridLayout(2,2));	
		
		panel.setPreferredSize(new Dimension(400,400));
		
		panel.add(new JCheckBox("Check me"));
		panel.add(new JRadioButton("2"));
		panel.add(new JRadioButton("3"));
		
		final JTextField f = new JTextField("4"); 
		
		panel.add(f);
		
		f.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON3) {
					JMenuItem   mi1 = new JMenuItem("MI 1");
					JMenuItem   mi2 = new JMenuItem("MI 1");
					JMenuItem   mi3 = new JMenuItem("MI 1");
					
					JPopupMenu	menu = new JPopupMenu();
					menu.add(mi1);
					menu.add(mi2);
					menu.add(mi3);
					
					menu.show(f, e.getX(), e.getY());
				}
			}
		});
		
		sp.setRightComponent(panel);
		
		frame.getContentPane().add(sp, BorderLayout.CENTER);
		
		JMenuItem	item1 = new JMenuItem("Item 1");

		item1.setActionCommand("test1");
		item1.addActionListener((e)->{
			System.err.println("Item1 pressed: "+e.getActionCommand());
//			d.setVisible(true);
			JOptionPane.showMessageDialog(frame, 
					new JButton("lkskdfjkldjsfkl"),
					"my title",
					JOptionPane.QUESTION_MESSAGE
					);
			switch(JOptionPane.showConfirmDialog(frame, 
					new JScrollPane(new JTextArea("s,dfjklj")),
					"my title",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE
					))  {
				case JOptionPane.YES_OPTION :
					System.err.println("YES");
					break;
				case JOptionPane.NO_OPTION :
					System.err.println("NO");
					break;
				case JOptionPane.CANCEL_OPTION :
					System.err.println("CANCEL");
					break;
				case -1:
					System.err.println("ESCAPE");
					break;
			}
			
			
		});
		item1.addActionListener((e)->{
			System.err.println("Item1 pressed (2)");			
		});
		JMenuItem	item2 = new JMenuItem("Item 2");
		item2.addActionListener((e)->{
			System.err.println("Item2 pressed");
			
			JFileChooser	chooser = new JFileChooser();
			
			switch (chooser.showOpenDialog(frame)) {
				case JFileChooser.APPROVE_OPTION :
					System.err.println("Approve");
					break;
				case JFileChooser.CANCEL_OPTION :
					System.err.println("CAncel");
					break;
				case -1 :
					System.err.println("ESCAPE");
					break;
			};
			
			JColorChooser cc = new JColorChooser();
			
			cc.showDialog(frame, "Choose olor!!!!!!", Color.red);
			
		});
		JMenu		submenu = new JMenu("Submenu 1");
		
		submenu.add(item1);
		submenu.add(item2);

		final JCheckBoxMenuItem	cb1 = new JCheckBoxMenuItem("Check 1");

		cb1.addActionListener((e)->{
			System.err.println("Checkox1 pressed: "+((JCheckBoxMenuItem)e.getSource()).isSelected());			
		});
		
		final JRadioButtonMenuItem	rb1 = new JRadioButtonMenuItem("Radio 1");
		final JRadioButtonMenuItem	rb2 = new JRadioButtonMenuItem("Radio 2");
		
		JMenu		submenu222 = new JMenu("Submenu 222");
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(rb1);
		group.add(rb2);
		
		submenu222.add(cb1);
		submenu222.addSeparator();
		submenu222.add(rb1);
		submenu222.add(rb2);

		
		
		
		
		JMenuBar	bar = new JMenuBar();
		
		bar.add(submenu);
		bar.add(submenu222);
		
		frame.setJMenuBar(bar);
		
		
		
		JMenuItem	item3 = new JMenuItem("Item 3");
		item3.addActionListener((e)->{
			System.err.println("Item3 pressed");			
		});
		JMenuItem	item4 = new JMenuItem("Item 4");
		item4.addActionListener((e)->{
			System.err.println("Item3 pressed");			
		});
		JMenu		submenu2 = new JMenu("Submenu 2");
		
		submenu2.add(item3);
		submenu2.add(item4);
		
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
		
		frame.pack();
		
//		System.in.read();
//		
//		frame.dispose();
	}

}
