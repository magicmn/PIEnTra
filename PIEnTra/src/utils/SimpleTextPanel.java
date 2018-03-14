package utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Erzeugt einfaches Objekt mit einem Label und einem Textfeld **/
public class SimpleTextPanel extends JPanel {

	JLabel lbl;
	JTextField txt;
	private String lbl_name;
	private int txt_length = 10;
	
	/** �bergebener String wird zur Textfeldbezeichnung **/
	public SimpleTextPanel(String lbl_name) {
		this.lbl_name = lbl_name;
		initNewPanel();
	}
	/** �bergebener String wird zur Textfeldbezeichnung. �bergebener int wird zur L�nge des Textfeldes. **/
	public SimpleTextPanel(String lbl_name, int txt_length) {
		this.lbl_name = lbl_name;
		this.txt_length = txt_length;
		initNewPanel();
	}
	
	/** Initialisiere  Textfeld und dazugeh�riges Label. **/
	private void initNewPanel() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnl_leftAlign = new JPanel();
		this.add(BorderLayout.WEST, pnl_leftAlign);
		lbl = new JLabel(lbl_name);
		lbl.setPreferredSize(new Dimension(100, lbl.getPreferredSize().height));
		txt = new JTextField();
		txt.setPreferredSize(new Dimension(txt_length, txt.getPreferredSize().height));
		pnl_leftAlign.add(lbl);
		pnl_leftAlign.add(txt);
	}
	
	/** Gibt Textfeld Objekt zur�ck **/
	public JTextField getTxtField() {
		return txt;
	}
	
	/** Setze Textfeld Objekt um an eigene Bed�rfnisse weiter anzupassen. **/
	//public void setTxt_field(JTextField txt) {
	//	this.txt = txt;
	//}
	
	public void setTxtField_Size(int txt_length) {
	//	txt.setSize(new Dimension(txt_length, txt.getPreferredSize().height));
		txt.setColumns(txt_length / 8);
	//	txt.setPreferredSize(new Dimension(txt_length, txt.getPreferredSize().height));
	}
	
	/** Gibt aktuellen Wert des Textfeldes zur�ck. **/
	public String getString() {
		return txt.getText();
	}
	/** Setzt den Wert des Textfeldes **/
	public void setString(String txt_value) {
		txt.setText(txt_value);
	}
}
