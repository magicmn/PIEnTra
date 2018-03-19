 package utils;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SimpleTextPanel extends JPanel {
	private static final long serialVersionUID = 1630037309453430313L;
	
	static int labelWidth = 120;
	JLabel lbl;
	JFormattedTextField txt;
	
	public SimpleTextPanel(String labelText) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		lbl = new JLabel(labelText);
		lbl.setPreferredSize(new Dimension(labelWidth, lbl.getPreferredSize().height));
		txt = new JFormattedTextField();
		this.add(lbl);
		this.add(txt);
	}
	
	public SimpleTextPanel(String labelText, AbstractFormatter format) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		lbl = new JLabel(labelText);
		lbl.setPreferredSize(new Dimension(labelWidth, lbl.getPreferredSize().height));
		txt = new JFormattedTextField(format);
		this.add(lbl);
		this.add(txt);
	}

	public void setTextFieldWidth(int width) {
		txt.setPreferredSize(new Dimension(width, txt.getPreferredSize().height));
	}
	
	public static int getLabelWidth() {
		return labelWidth;
	}

	public String getText() {
		return txt.getText();
	}
	
	public void setText(String text) {
		txt.setText(text);
	}
	public JFormattedTextField getTextPanel() {
		return txt;
	}
	
	public void setEnabled(boolean enable) {
		txt.setEnabled(enable);
	}

}
