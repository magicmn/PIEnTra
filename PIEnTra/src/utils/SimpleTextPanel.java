package utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Erzeugt einfaches Objekt mit einem Label und einem Textfeld **/
public class SimpleTextPanel extends JPanel {

	JLabel lbl;
	JFormattedTextField txt;
	private String lbl_name;
	private int txt_length = 10;
	
	/** Übergebener String wird zur Textfeldbezeichnung **/
	public SimpleTextPanel(String lbl_name) {
		this.lbl_name = lbl_name;
		initNewPanel();
	}
	
	/** Übergebener String wird zur Textfeldbezeichnung. JFormattedTextField.AbstractFormatter definiert die Maske**/
	public SimpleTextPanel(String lbl_name,JFormattedTextField.AbstractFormatter format) {
		this.lbl_name = lbl_name;
		initNewPanel(format);
	}
	/** Übergebener String wird zur Textfeldbezeichnung. Übergebener int wird zur Länge des Textfeldes. **/
	public SimpleTextPanel(String lbl_name, int txt_length) {
		this.lbl_name = lbl_name;
		this.txt_length = txt_length;
		initNewPanel();
	}
	
	/** Übergebener String wird zur Textfeldbezeichnung. Übergebener int wird zur Länge des Textfeldes. JFormattedTextField.AbstractFormatter definiert die Maske **/
	public SimpleTextPanel(String lbl_name, int txt_length, JFormattedTextField.AbstractFormatter format) {
		this.lbl_name = lbl_name;
		this.txt_length = txt_length;
		initNewPanel(format);
	}
	
	/** Initialisiere  Textfeld und dazugehöriges Label. **/
	private void initNewPanel() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnl_leftAlign = new JPanel();
		this.add(BorderLayout.WEST, pnl_leftAlign);
		lbl = new JLabel(lbl_name);
		lbl.setPreferredSize(new Dimension(100, lbl.getPreferredSize().height));
		txt = new JFormattedTextField();
		txt.setPreferredSize(new Dimension(txt_length, txt.getPreferredSize().height));
		pnl_leftAlign.add(lbl);
		pnl_leftAlign.add(txt);
	}
	
	/** Initialisiere  Textfeld und dazugehöriges Label mit JFormattedTextField.AbstractFormatter. **/
	private void initNewPanel(JFormattedTextField.AbstractFormatter format) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnl_leftAlign = new JPanel();
		this.add(BorderLayout.WEST, pnl_leftAlign);
		lbl = new JLabel(lbl_name);
		lbl.setPreferredSize(new Dimension(100, lbl.getPreferredSize().height));
		txt = new JFormattedTextField(format);
		txt.setPreferredSize(new Dimension(txt_length, txt.getPreferredSize().height));
		pnl_leftAlign.add(lbl);
		pnl_leftAlign.add(txt);
	}
	
	/** Gibt Textfeld Objekt zurück **/
	public JFormattedTextField getTxtField() {
		return txt;
	}
	
	/** Setze Textfeld Objekt um an eigene Bedürfnisse weiter anzupassen. **/
	//public void setTxt_field(JFormattedTextField txt) {
	//	this.txt = txt;
	//}
	
	public void setTxtField_Size(int txt_length) {
		txt.setSize(new Dimension(txt_length, txt.getPreferredSize().height));
		txt.setPreferredSize(new Dimension(txt_length, txt.getPreferredSize().height));
	}
	
	/** Gibt aktuellen Wert des Textfeldes zurück. **/
	public String getString() {
		return txt.getText();
	}
	/** Setzt den Wert des Textfeldes **/
	public void setString(String txt_value) {
		txt.setText(txt_value);
	}
	
}
