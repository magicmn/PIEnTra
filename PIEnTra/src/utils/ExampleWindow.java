package utils;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExampleWindow extends JFrame {

	private JTextField textField;
	
	/**  **/
	public ExampleWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setBounds(200, 200, 800, 250);
		this.setLayout(new BorderLayout());
		initView();
	}

	private void initView() {
		JPanel pnl_center = new JPanel();
		JPanel pnl_south = new JPanel();
		this.add(BorderLayout.CENTER, pnl_center);
		this.add(BorderLayout.SOUTH, pnl_south);
	}
}
