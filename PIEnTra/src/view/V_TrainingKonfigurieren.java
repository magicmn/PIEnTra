package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class V_TrainingKonfigurieren extends JFrame {
	
		private TextField txt_kundenId;
		private TextField txt_firmenname;
		private TextField txt_ansprechpartner;
		private TextField txt_produktbeschreibung;
		private TextField txt_anfangsdatum;
		private TextField txt_enddatum;
		private TextField txt_tage;
		private TextField txt_trainer;
		private TextField txt_ort;
		private TextField txt_bemerkungen;
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
		pnl_center.setLayout(new FlowLayout());
		this.add(BorderLayout.CENTER, pnl_center);
		
		txt_kundenId = new TextField("Kunden-ID:", 20);
		txt_firmenname = new TextField("Firmenname:", 20);
		txt_ansprechpartner = new TextField("Ansprechpartner:", 20);
		txt_produktbeschreibung = new TextField("Produktbeschreibung:", 20);
		txt_anfangsdatum = new TextField("Anfangsdatum:", 20);
		txt_enddatum = new TextField("Enddatum:", 20);
		txt_tage = new TextField("Tage:", 20);
		txt_trainer = new TextField("Trainer:", 20);
		txt_ort = new TextField("Ort:", 20);
		txt_bemerkungen = new TextField("Bemerkungen", 20);
		pnl_center.add(new JPanel().add(txt_kundenId));
		pnl_center.add(new JPanel().add(txt_firmenname));
		pnl_center.add(new JPanel().add(txt_ansprechpartner));
		pnl_center.add(new JPanel().add(txt_produktbeschreibung));
		pnl_center.add(new JPanel().add(txt_anfangsdatum));
		pnl_center.add(new JPanel().add(txt_enddatum));
		pnl_center.add(new JPanel().add(txt_tage));
		pnl_center.add(new JPanel().add(txt_trainer));
		pnl_center.add(new JPanel().add(txt_ort));
		pnl_center.add(new JPanel().add(txt_bemerkungen));
		
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