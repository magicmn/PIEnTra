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

import utils.TextPanel;

public class V_TrainingKonfigurieren extends JFrame {
	
		private TextPanel txt_kundenId;
		private TextPanel txt_firmenname;
		private TextPanel txt_ansprechpartner;
		private TextPanel txt_produktbeschreibung;
		private TextPanel txt_anfangsdatum;
		private TextPanel txt_enddatum;
		private TextPanel txt_tage;
		private TextPanel txt_trainer;
		private TextPanel txt_ort;
		private TextPanel txt_bemerkungen;
		private JButton btn_kundewaehlen;
		private JButton btn_ressourcenwaehlen;
		private JButton btn_trainingspeichern;
		private JButton btn_zurueck;
		private JTextField txt_navigation;
		
		private int margin = 10;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
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
		this.setBounds((int) screenSize.getWidth()/20, (int) screenSize.getWidth()/20, (int) screenSize.getWidth()/2, (int) screenSize.getHeight()/2);
		this.setMinimumSize(new Dimension(500, 410));
		this.setLayout(new BorderLayout());
		
		JPanel pnl_center = new JPanel();
		pnl_center.setLayout(null);
		this.add(BorderLayout.CENTER, pnl_center);
		
		txt_kundenId = new TextPanel("Trainings-ID:", 120);
		txt_firmenname = new TextPanel("Firmenname:", 200);
		txt_ansprechpartner = new TextPanel("Ansprechpartner:", 200);
		txt_produktbeschreibung = new TextPanel("Produktbeschreibung:", 200);
		txt_anfangsdatum = new TextPanel("Anfangsdatum:", 120);
		txt_enddatum = new TextPanel("Enddatum:", 120);
		txt_tage = new TextPanel("Tage:", 50);
		txt_trainer = new TextPanel("Trainer:", 200);
		txt_ort = new TextPanel("Ort:", 200);
		txt_bemerkungen = new TextPanel("Bemerkungen", 430);
		pnl_center.add(new JPanel().add(txt_kundenId));
		txt_kundenId.setBounds(20, margin, 1000, 20);
		pnl_center.add(new JPanel().add(txt_firmenname));
		txt_firmenname.setBounds(20, autoMargin(), 1000, 20);
		pnl_center.add(new JPanel().add(txt_ansprechpartner));
		txt_ansprechpartner.setBounds(20, autoMargin(), 1000, 20);
		pnl_center.add(new JPanel().add(txt_produktbeschreibung));
		txt_produktbeschreibung.setBounds(20, autoMargin(), 1000, 20);
		pnl_center.add(new JPanel().add(txt_anfangsdatum));
		txt_anfangsdatum.setBounds(20, autoMargin(), 1000, 20);
		pnl_center.add(new JPanel().add(txt_enddatum));
		txt_enddatum.setBounds(20, autoMargin(), 1000, 20);
		pnl_center.add(new JPanel().add(txt_tage));
		txt_tage.setBounds(20, autoMargin(), 1000, 20);
		pnl_center.add(new JPanel().add(txt_trainer));
		txt_trainer.setBounds(20, autoMargin(), 1000, 20);
		pnl_center.add(new JPanel().add(txt_ort));
		txt_ort.setBounds(20, autoMargin(), 1000, 20);
		pnl_center.add(new JPanel().add(txt_bemerkungen));
		txt_bemerkungen.setBounds(20, autoMargin(), 1000, 20);
		
		JPanel pnl_south = new JPanel();
		pnl_south.setLayout(new GridLayout(2,1));
		this.add(BorderLayout.SOUTH, pnl_south);
		
		JPanel pnl_south_top = new JPanel();
		pnl_south.add(pnl_south_top);
		
		JPanel pnl_south_top_inner = new JPanel();
		pnl_south_top_inner.setLayout(new GridLayout(4,1,5,5));
		
		Dimension dim = new Dimension(135, 20);
		btn_kundewaehlen = new JButton("Kunde wählen");
		btn_kundewaehlen.setPreferredSize(dim);
		btn_ressourcenwaehlen = new JButton("Ressourcen wählen");
		btn_ressourcenwaehlen.setPreferredSize(dim);
		btn_trainingspeichern = new JButton("Training speichern");
		btn_trainingspeichern.setPreferredSize(dim);
		btn_zurueck = new JButton("Zurück zum Hauptmenü");
		btn_zurueck.setPreferredSize(dim);
		
		pnl_south_top.add(btn_kundewaehlen);
		pnl_south_top.add(btn_ressourcenwaehlen);
		pnl_south_top.add(btn_trainingspeichern);
		pnl_south_top.add(btn_zurueck);
		
		JPanel pnl_south_bottom = new JPanel();
		pnl_south.add(pnl_south_bottom);
		
		txt_navigation = new JTextField(78);
		pnl_south_bottom.add(txt_navigation);
	}
	
	private int autoMargin() {
		margin = margin + 30;
		return margin;
	}
}