package utils;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Panel welches automatisch ein Label und ein Textfeld in einem Panel erstellt. **/
public class TextPanel extends JPanel {

	JLabel label;
	JTextField txt_field;

	public TextPanel(String pnl_name, int txt_size) {
		this.setLayout(null);
		label = new JLabel(pnl_name);
		label.setPreferredSize(new Dimension(160, 20));
		label.setBounds(0, 0, 120, 20);
		txt_field = new JTextField(20);
		txt_field.setBounds(120, 0, txt_size, 20);
		this.add(label);
		this.add(txt_field);
	}

	public JTextField getTextField() {
		return txt_field;
	}
		
	public String getTextFieldValue() {
		return txt_field.getText();
	}

	public void setTextFieldValue(String value) {
		txt_field.setText(value);
	}
}
