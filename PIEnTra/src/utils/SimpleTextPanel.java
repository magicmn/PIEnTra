package utils;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleTextPanel extends JPanel {

	JLabel label;
	JTextField txt_field;
	private String pnl_name;
	private int txt_length = 30;
	
	public SimpleTextPanel(String pnl_name, int txt_length) {
		this.pnl_name = pnl_name;
		this.txt_length = txt_length;
		initNewPanel();
	}
	
	public SimpleTextPanel(String pnl_name) {
		this.pnl_name = pnl_name;
		initNewPanel();
	}
	
	private void initNewPanel() {
		this.setLayout(new BorderLayout());
		JPanel pnl_leftAlign = new JPanel();
		this.add(BorderLayout.WEST, pnl_leftAlign);
		label = new JLabel(pnl_name);
		label.setPreferredSize(new Dimension(100, label.getPreferredSize().height));
		txt_field = new JTextField(txt_length);
		pnl_leftAlign.add(label);
		pnl_leftAlign.add(txt_field);
	}
	
}
