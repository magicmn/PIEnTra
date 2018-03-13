package utils;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Panel welches automatisch ein Label und ein Textfeld in einem Panel erstellt. **/
public class TextPanel extends JPanel {

	JLabel label;
	JTextField txt_field;

	public TextPanel(String pnl_name, int txt_size) {
		this.setLayout(new FlowLayout());
		label = new JLabel(pnl_name);
		txt_field = new JTextField(txt_size);
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
