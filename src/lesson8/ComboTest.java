package lesson8;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class ComboTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		final JComboBox<String> combo = new JComboBox<>(model);
		
		model.addElement("vassya 1");
		model.addElement("vassya 2 ");
		model.addElement("vassya 3");
		
		combo.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				final JLabel label = (JLabel)super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			
				if (index % 2 == 0)  {
					label.setForeground(Color.RED);
				}
				return label;
			}
		});
		combo.setEditable(true);
		combo.setSelectedItem("dlgljjdlkkgfjlk");
		
		
		combo.addActionListener((e)->{
			System.err.println("Selected");
		});
		
		JOptionPane.showMessageDialog(null, new JScrollPane(combo));
	}

}
