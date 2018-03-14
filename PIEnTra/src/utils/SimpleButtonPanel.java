package utils;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SimpleButtonPanel extends JPanel {

	JButton btn;
	
	/** Konstruktor. Setze lediglich Name des Buttons **/
	public SimpleButtonPanel(String lbl_button) {
		btn = new JButton(lbl_button);
		this.add(btn);
	}
	
	/** Konstruktor. Setze Name und Länge des Buttons **/
	public SimpleButtonPanel(String lbl_button, int btn_width) {
		this(lbl_button);
		setBtn_width(btn_width);
	}
	
	/** Setze Länge des Buttons **/
	public void setBtn_width(int btn_width) {
		btn.setSize(new Dimension(btn_width, btn.getSize().height));
		btn.setPreferredSize(new Dimension(btn_width, btn.getPreferredSize().height));
	}
	
	public JButton getButton() {
		return btn;
	}
}
