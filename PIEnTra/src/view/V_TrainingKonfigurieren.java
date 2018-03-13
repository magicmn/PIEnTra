package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class V_TrainingKonfigurieren extends JFrame {
	
		private JTextField txt_kundenId;
		private JTextField txt_firmenname;
		private JTextField txt_ansprechpartner;
		private JTextField txt_produktbeschreibung;
		private JTextField txt_anfangsdatum;
		private JTextField txt_enddatum;
		private JTextField txt_tage;
		private JTextField txt_trainer;
		private JTextField txt_ort;
		private JTextField txt_bemerkungen;
		private JButton btn_kundewaehlen;
		private JButton btn_ressourcenwaehlen;
		private JButton btn_trainingspeichern;
		private JButton btn_zurueck;
		private JTextField txt_navigation;
		
		public static void main(String[]args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			V_TrainingKonfigurieren ad = new V_TrainingKonfigurieren();
		}

	public V_TrainingKonfigurieren() {
		initView();
		this.setVisible(true);
	}

	private void initView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setBounds(200, 200, 900, 450);
		this.setLayout(new BorderLayout());
		//this.setResizable(false);
		
		JPanel pnl_center = new JPanel();
		pnl_center.setLayout(new GridLayout(10,2,0,10));
		this.add(BorderLayout.CENTER, pnl_center);
		
		txt_kundenId = new JTextField(20);
		txt_firmenname = new JTextField();
		txt_ansprechpartner = new JTextField();
		txt_produktbeschreibung = new JTextField();
		txt_anfangsdatum = new JTextField();
		txt_enddatum = new JTextField();
		txt_tage = new JTextField();
		txt_trainer = new JTextField();
		txt_ort = new JTextField();
		txt_bemerkungen = new JTextField();
		pnl_center.add(new JLabel("Kunden-ID: "));
		pnl_center.add(txt_kundenId);
		pnl_center.add(new JLabel("Firmenname: "));
		pnl_center.add(txt_firmenname);
		pnl_center.add(new JLabel("Ansprechpartner: "));
		pnl_center.add(txt_ansprechpartner);
		pnl_center.add(new JLabel("Produktbeschreibung: "));
		pnl_center.add(txt_produktbeschreibung);
		pnl_center.add(new JLabel("Anfangsdatum: "));
		pnl_center.add(txt_anfangsdatum);
		pnl_center.add(new JLabel("Enddatum: "));
		pnl_center.add(txt_enddatum);
		pnl_center.add(new JLabel("Tage: "));
		pnl_center.add(txt_tage);
		pnl_center.add(new JLabel("Trainer: "));
		pnl_center.add(txt_trainer);
		pnl_center.add(new JLabel("Ort: "));
		pnl_center.add(txt_ort);
		pnl_center.add(new JLabel("Bemerkungen: "));
		pnl_center.add(txt_bemerkungen);
		
		JPanel pnl_south = new JPanel();
		pnl_south.setLayout(new GridLayout(2,1));
		this.add(BorderLayout.SOUTH, pnl_south);
		
		JPanel pnl_south_top = new JPanel();
		pnl_south.add(pnl_south_top);
		
		JPanel pnl_south_top_inner = new JPanel();
		pnl_south_top_inner.setLayout(new GridLayout(4,1,5,5));
		
		btn_kundewaehlen = new JButton("Kunde wählen");
		btn_ressourcenwaehlen = new JButton("Ressourcen wählen");
		btn_trainingspeichern = new JButton("Trainingspeichern");
		btn_zurueck = new JButton("Zurück zum Hauptmenü");
		pnl_south_top.add(btn_kundewaehlen);
		pnl_south_top.add(btn_ressourcenwaehlen);
		pnl_south_top.add(btn_trainingspeichern);
		pnl_south_top.add(btn_zurueck);
		
		JPanel pnl_south_bottom = new JPanel();
		pnl_south.add(pnl_south_bottom);
		
		txt_navigation = new JTextField(40);
		pnl_south_bottom.add(txt_navigation);
	}
}