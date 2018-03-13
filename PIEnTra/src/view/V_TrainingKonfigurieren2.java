package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import utils.SimpleTextPanel;

public class V_TrainingKonfigurieren2 extends JFrame {
	
		private SimpleTextPanel txt_kundenId;
		private SimpleTextPanel txt_firmenname;
		private SimpleTextPanel txt_ansprechpartner;
		private SimpleTextPanel txt_produktbeschreibung;
		private SimpleTextPanel txt_anfangsdatum;
		private SimpleTextPanel txt_enddatum;
		private SimpleTextPanel txt_tage;
		private SimpleTextPanel txt_trainer;
		private SimpleTextPanel txt_ort;
		private SimpleTextPanel txt_bemerkungen;
		private JButton btn_kundewaehlen;
		private JButton btn_ressourcenwaehlen;
		private JButton btn_trainingspeichern;
		private JButton btn_zurueck;
		private JTextField txt_navigation;
		
		private int margin = 10;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		public static void main(String[]args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			V_TrainingKonfigurieren2 ad = new V_TrainingKonfigurieren2();
		}

	public V_TrainingKonfigurieren2() {
		initView();
		this.setVisible(true);
	}

	private void initView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setBounds((int) screenSize.getWidth()/20, (int) screenSize.getWidth()/20, (int) screenSize.getWidth()/2, (int) screenSize.getHeight()/2);
		this.setLayout(new BorderLayout());
		
		JPanel pnl_main = new JPanel(new GridLayout(10, 1));
		pnl_main.add(txt_kundenId = new SimpleTextPanel("Kunden-ID:", 20));
		pnl_main.add(txt_firmenname = new SimpleTextPanel("Firmenname:", 20));
		pnl_main.add(txt_ansprechpartner = new SimpleTextPanel("Ansprechpartner:", 20));
		pnl_main.add(txt_produktbeschreibung = new SimpleTextPanel("Produktbeschreibung:", 20));
		pnl_main.add(txt_anfangsdatum = new SimpleTextPanel("Anfangsdatum:", 20));
		pnl_main.add(txt_enddatum = new SimpleTextPanel("Enddatum:", 20));
		pnl_main.add(txt_tage= new SimpleTextPanel("Tage:", 20));
		pnl_main.add(txt_trainer = new SimpleTextPanel("Trainer:", 20));
		pnl_main.add(txt_ort = new SimpleTextPanel("Ort:", 20));
		pnl_main.add(txt_bemerkungen = new SimpleTextPanel("Bemerkungen:", 20));
		
		this.add(BorderLayout.CENTER, pnl_main);
	}
}