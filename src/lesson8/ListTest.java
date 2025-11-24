package lesson8;

import java.awt.Color;
import java.awt.Component;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final DefaultListModel<String> model = new DefaultListModel<>();
		final JList<String> list = new JList<>(model);
		final ListSelectionModel lsm = list.getSelectionModel();
		
		lsm.addListSelectionListener((e)->{
			System.err.println("Selected");
		});
		lsm.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		list.setCellRenderer(new DefaultListCellRenderer() {
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
		
		
		
		model.addElement("vassya 1");
		model.addElement("vassya 2 ");
		model.addElement("vassya 3");
		
		JOptionPane.showMessageDialog(null, new JScrollPane(list));
	}

}
