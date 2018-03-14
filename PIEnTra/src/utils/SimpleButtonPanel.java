package utils;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SimpleButtonPanel extends JPanel {

	JButton btn;
	
	public SimpleButtonPanel(String lbl_button) {
		btn = new JButton(lbl_button);
		this.add(btn);
	}
	
	public SimpleButtonPanel(String lbl_button, int btn_width) {
		this(lbl_button);
		setBtn_width(btn_width);
	}
	
	public void setBtn_width(int btn_width) {
		btn.setPreferredSize(new Dimension(btn_width, btn.getPreferredSize().height));
	}
}
