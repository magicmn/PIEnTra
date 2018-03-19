package utils;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SimpleDropdownPanel extends JPanel {
	private static final long serialVersionUID = 1630037309453430313L;
	
	static int labelWidth = 120;
	JLabel lbl;
	JFormattedTextField txt;
	JComboBox box;
	
	public SimpleDropdownPanel(String labelText) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		lbl = new JLabel(labelText);
		lbl.setPreferredSize(new Dimension(labelWidth, lbl.getPreferredSize().height));
		txt = new JFormattedTextField();
		this.add(lbl);
		this.add(txt);
	}
	
	public SimpleDropdownPanel(String labelText, AbstractFormatter format) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		lbl = new JLabel(labelText);
		lbl.setPreferredSize(new Dimension(labelWidth, lbl.getPreferredSize().height));
		txt = new JFormattedTextField(format);
		this.add(lbl);
		this.add(txt);
	}
	
	public SimpleDropdownPanel(String labelText, ArrayList <String> array) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		lbl = new JLabel(labelText);
		lbl.setPreferredSize(new Dimension(labelWidth, lbl.getPreferredSize().height));
		//box.setModel(new DefaultComboBoxModel<>(test.toArray()));
		box = new JComboBox(array.toArray());
		this.add(lbl);
		this.add(box);
	}

	/*public void setTextFieldWidth(int width) {
		txt.setPreferredSize(new Dimension(width, txt.getPreferredSize().height));
	}*/
	
	public void setComboBoxFieldWidth(int width){
		box.setPreferredSize(new Dimension(width, box.getPreferredSize().height));
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
	public JComboBox getComboBox(){
		return box;
	}
}
