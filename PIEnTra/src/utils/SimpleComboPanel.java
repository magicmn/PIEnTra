package utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Erzeugt einfaches Objekt mit einem Label und einem Textfeld **/
public class SimpleComboPanel extends JPanel {

	JLabel lbl;
	JComboBox box;
	private String lbl_name;
	private int box_length = 10;
	
	/** Übergebener String wird zur Textfeldbezeichnung **/
	public SimpleComboPanel(String lbl_name) {
		this.lbl_name = lbl_name;
		initNewPanel();
	}
	/** Übergebener String wird zur Textfeldbezeichnung. Übergebener int wird zur Länge des Textfeldes. **/
	public SimpleComboPanel(String lbl_name, int box_length) {
		this.lbl_name = lbl_name;
		this.box_length = box_length;
		initNewPanel();
	}
	
	/** Initialisiere  Textfeld und dazugehöriges Label. **/
	private void initNewPanel() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnl_leftAlign = new JPanel();
		this.add(BorderLayout.WEST, pnl_leftAlign);
		lbl = new JLabel(lbl_name);
		lbl.setPreferredSize(new Dimension(100, lbl.getPreferredSize().height));
		box = new JComboBox();
		box.setPreferredSize(new Dimension(box_length, box.getPreferredSize().height));
		pnl_leftAlign.add(lbl);
		pnl_leftAlign.add(box);
	}
	
	/** Gibt Textfeld Objekt zurück **/
	public JComboBox getComboBox() {
		return box;
	}
	
	/** Setze Textfeld Objekt um an eigene Bedürfnisse weiter anzupassen. **/
	//public void setTxt_field(JTextField txt) {
	//	this.txt = txt;
	//}
	
	public void setBoxField_Size(int box_length) {
		box.setSize(new Dimension(box_length, box.getPreferredSize().height));
		box.setPreferredSize(new Dimension(box_length, box.getPreferredSize().height));
	}
}
