package utils;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Superklasse für JComboBox
 * @version 1.1 SimpleTextPanel als Vorlage genutzt und angepasst
 * @version 1.0 Erstellung von SimpleTextPanel.
 * @author Julian Klein
 * @author Adrian Fromm
 * 
 */

public class SimpleDropdownPanel extends JPanel {
	
	private static final long serialVersionUID = 3073040969515449583L;
	
	static int labelWidth = 120;
	JLabel lbl;
	JComboBox <String>box;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SimpleDropdownPanel(String labelText, ArrayList <String> array) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		lbl = new JLabel(labelText);
		lbl.setPreferredSize(new Dimension(labelWidth, lbl.getPreferredSize().height));
		box = new JComboBox(array.toArray());
		this.add(lbl);
		this.add(box);
	}
	public void setComboBoxFieldWidth(int width){
		box.setPreferredSize(new Dimension(width, box.getPreferredSize().height));
	}
	public static int getLabelWidth() {
		return labelWidth;
	}
	public JComboBox<String> getComboBox(){
		return box;
	}
	public String getText(){
		return box.getSelectedItem().toString();
	}
	public void removeItems(){
		box.removeAllItems();
	}

}
