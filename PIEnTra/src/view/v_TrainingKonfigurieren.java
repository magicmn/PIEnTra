package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class v_TrainingKonfigurieren extends JFrame {
	
		private JTextField txt_kundenId;
		private JTextField txt_firmenname;
		private JTextField txt_ansprechpartner;
		
		public static void main(String[]args) {
			v_TrainingKonfigurieren ad = new v_TrainingKonfigurieren();
		}
		
	/**  **/
	public v_TrainingKonfigurieren() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setBounds(200, 200, 800, 250);
		initView();
		this.setVisible(true);
	}

	private void initView() {
		JPanel pnl_center = new JPanel();
		pnl_center.setLayout(new GridLayout(10,2));
		JLabel lbl_kundenId = new JLabel("Kunden-ID");
		txt_kundenId = new JTextField(10);
		JLabel lbl_firmenname = new JLabel("Firmenname");
		txt_firmenname = new JTextField();
		JLabel lbl_ansprechpartner = new JLabel("Ansprechpartner");
		txt_ansprechpartner = new JTextField(10);
		pnl_center.add(lbl_kundenId);
		pnl_center.add(txt_kundenId);
		pnl_center.add(lbl_ansprechpartner);
		this.add(BorderLayout.CENTER, pnl_center);
	}
}