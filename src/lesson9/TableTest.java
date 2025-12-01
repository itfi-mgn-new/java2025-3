package lesson9;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final MyTableModel    tm = new MyTableModel();
		final JTable	table = new JTable(tm);
		
		tm.add(new FIO("ivanov","ivan","ivanovich",21));
		tm.add(new FIO("petroff","petr","petrovich",22));
		
		table.setDefaultRenderer(String.class, 
				new DefaultTableCellRenderer() {
					@Override
					public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int column) {
						// TODO Auto-generated method stub
						final JLabel label = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
					
						if (column == 0) {
							label.setForeground(Color.red);
						}
						else {
							label.setForeground(Color.green);
						}
						return label; 
					}
				});
		
		JOptionPane.showMessageDialog(null, 
				new JScrollPane(table));
	}

}

class FIO {
	String family;
	String name;
	String partoName;
	int age;
	public FIO(String family, String name, String partoName, int age) {
		super();
		this.family = family;
		this.name = name;
		this.partoName = partoName;
		this.age = age;
	}
}

class MyTableModel extends DefaultTableModel {
	final List<FIO> content = new ArrayList<>();
	
	public void add(final FIO fio) {
		content.add(fio);
		fireTableRowsInserted(content.size()-1, content.size()-1);
	}

	public void remove(int row) {
		content.remove(row);
		fireTableRowsDeleted(row, row);
	}
	
	@Override
	public int getRowCount() {
		return content != null ? content.size() : 0;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
			case 0 : return "Family";
			case 1 : return "Name";
			case 2 : return "PatroName";
			case 3 : return "Age";
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0 : return String.class;
			case 1 : return String.class;
			case 2 : return String.class;
			case 3 : return Integer.class;
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0 : return content.get(rowIndex).family;
			case 1 : return content.get(rowIndex).name;
			case 2 : return content.get(rowIndex).partoName;
			case 3 : return content.get(rowIndex).age;
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0 : 
				content.get(rowIndex).family = aValue.toString();
				break;
			case 1 : 
				content.get(rowIndex).name = aValue.toString();
				break;
			case 2 : 
				content.get(rowIndex).partoName = aValue.toString();
				break;
			case 3 : 
				content.get(rowIndex).age = ((Number)aValue).intValue();
				break;
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}
}
