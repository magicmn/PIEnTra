package utils;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextPanel extends JPanel {

	JLabel label;
	JTextField txt_field;

	public TextPanel(String name) {
		this.setLayout(new FlowLayout());
		label = new JLabel(name);
		txt_field = new JTextField(20);
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
