package lesson7;

import java.awt.Color;
import java.awt.Dimension;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.InternationalFormatter;

public class TextCompponentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final JTextField	tf = new JTextField();
		
		tf.setText("<html><body>fgfgfg</body><html>");
//		tf.setBackground(Color.red);
//		tf.setForeground(Color.yellow);
//		tf.setPreferredSize(new Dimension(400,200));
		tf.setColumns(40);
		tf.addActionListener((e)->{System.err.println("Press enter!");});
		tf.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				System.err.println("Caret moved");
			}
		});
		tf.setInputVerifier(new InputVerifier() {
			@Override
			public boolean verify(JComponent input) {
				return false;
			}
		});
		Document d = tf.getDocument();
		d.addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				System.err.println("REmove: ");
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				System.err.println("Insert: ");
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				System.err.println("Update: ");
			}
		});
		
//		JOptionPane.showMessageDialog(null, tf);
		
		JPasswordField	pw = new JPasswordField();
		
//		JOptionPane.showMessageDialog(null, pw);
		NumberFormat format = DecimalFormat.getInstance();

		 format.setMinimumFractionDigits(2);
         format.setMaximumFractionDigits(2);
         format.setRoundingMode(RoundingMode.HALF_UP);
		
		InternationalFormatter formatter = new InternationalFormatter(format);
        formatter.setAllowsInvalid(false);
        formatter.setMinimum(0.0);
        formatter.setMaximum(1000.00);		

        JFormattedTextField	ftf = new JFormattedTextField(formatter);
		
        ftf.setValue(123);
        
//		JOptionPane.showMessageDialog(null, ftf);
        JTextArea ta = new JTextArea("djfjdf\r\nlkkfjkdjsfkld\n77747\n");
        ta.setRows(10);
        
//		JOptionPane.showMessageDialog(null, new JScrollPane(ta));
		
		JEditorPane	pane = new JEditorPane("text/html","<html><body><h1>URA</h1>"
				+ "<img src=\"https://www.flaticon.com/free-icon/document_16131911?term=reference&page=1&position=2&origin=tag&related_id=16131911\">FFFFFF</img></body></html>");
//		JOptionPane.showMessageDialog(null, new JScrollPane(pane));
//		pane.addHyperlinkListener(null)
		
		
	}
}
