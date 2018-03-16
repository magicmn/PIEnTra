package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.C_Hauptmenue;
import controller.C_KundeWaehlen;
import controller.C_TrainingKonfigurieren;
import utils.SimpleSwitchFrame;
import utils.SimpleTextPanel;

/**
 * Aktuelle Version: 1.2  
 * Authoren: Andreas (1.0), Adrian(1.1) Konstantin (1.2)
 * 
 * Changelog:
 * 1.0 	
 * 		-Layout definiert
 * 1.1
 * 		
 * 		-Getter und setter angepasst
 * 1.2
 * 		-ActionListener wieder hinzugefügt
 **/
public class V_TrainingKonfigurieren extends JFrame {
	
	private JPanel pnl_center;
	private SimpleTextPanel pnl_kundenID = new SimpleTextPanel("Kunden-ID:");
	private SimpleTextPanel pnl_firmenname = new SimpleTextPanel("Firmenname:");
	private SimpleTextPanel pnl_ansprechpartner = new SimpleTextPanel("Ansprechpartner:");
	private SimpleTextPanel pnl_produktbeschreibung = new SimpleTextPanel("Produktbeschreibung:");
	private SimpleTextPanel pnl_anfangsdatum = new SimpleTextPanel("Anfangsdatum:");
	private SimpleTextPanel pnl_enddatum = new SimpleTextPanel("Enddatum:");
	private SimpleTextPanel pnl_tage = new SimpleTextPanel("Tage:");
	private SimpleTextPanel pnl_trainer = new SimpleTextPanel("Trainer:");
	private SimpleTextPanel pnl_ort = new SimpleTextPanel("Ort:");
	private SimpleTextPanel pnl_bemerkungen = new SimpleTextPanel("Bemerkungen:");
	private JPanel pnl_south;
	private JButton btn_kundewaehlen = new JButton("Kunde wählen");
	private JButton btn_ressourcenwaehlen = new JButton("Ressourcen wählen");
	private JButton btn_trainingspeichern = new JButton("Training speichern");
	private JButton btn_zurueck = new JButton("Zurück zum Hauptmenü");
	private JTextField txt_navigation;
	public V_TrainingKonfigurieren view ;
	
	public V_TrainingKonfigurieren() {
		this.view = this;
		initView();
		resizeGUI();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new V_TrainingKonfigurieren();
	}

	private void initView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setSize(750, 450); // Optimale Größe die beim Starten geladen wird.
		this.setMinimumSize(new Dimension(500, 400)); // Um zu verhindern, dass der DAU sich wundert warum das Fenster auf einmal "weg" ist.
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null); // Zentriert Frame in der Mitte des Bildschirms.
		this.addComponentListener(new ResizeListener());  // Fügt Listener für Frame veränderungen hinzu.
		
		pnl_center = new JPanel(new GridLayout(10, 1, 2 ,2));
		pnl_center.add(pnl_kundenID);
		pnl_center.add(pnl_firmenname);
		pnl_center.add(pnl_ansprechpartner);
		pnl_center.add(pnl_produktbeschreibung);
		pnl_center.add(pnl_anfangsdatum);
		pnl_center.add(pnl_enddatum);
		pnl_center.add(pnl_tage);
		pnl_center.add(pnl_trainer);
		pnl_center.add(pnl_ort);
		pnl_center.add(pnl_bemerkungen);
		this.add(BorderLayout.CENTER, pnl_center);
		
		pnl_south = new JPanel(new GridLayout(2, 1));
		JPanel pnl_south_top = new JPanel(new GridLayout(1, 4));
		pnl_south_top.setBorder(new EmptyBorder(10,8,5,10));
		pnl_south_top.add(btn_kundewaehlen);
		pnl_south_top.add(btn_ressourcenwaehlen);
		pnl_south_top.add(btn_trainingspeichern);
		pnl_south_top.add(btn_zurueck);
		pnl_south.add(pnl_south_top);
		JPanel pnl_south_bottom = new JPanel(new FlowLayout());
		pnl_south_bottom.add(txt_navigation = new JTextField("PIEnTra / Training konfigurieren"));
		txt_navigation.setFocusable(false);
		pnl_south.add(pnl_south_bottom);
		this.add(BorderLayout.SOUTH, pnl_south);
		
		btn_kundewaehlen.addActionListener(new KundeWaehlen());
		btn_ressourcenwaehlen.addActionListener(new RessourceWaehlen());
		btn_trainingspeichern.addActionListener(new TrainingSpeichern());
		btn_zurueck.addActionListener(new Zurueck());
	
	}
	
	/** Enthält variable Gößen **/
	private void resizeGUI() {
		txt_navigation.setPreferredSize(new Dimension(this.getWidth() - 30, txt_navigation.getPreferredSize().height));
		pnl_kundenID.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_firmenname.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_ansprechpartner.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_produktbeschreibung.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_anfangsdatum.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_enddatum.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_tage.setTxtField_Size(pnl_center.getWidth() / 8);
		pnl_trainer.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_ort.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_bemerkungen.setTxtField_Size((this.getWidth() - 140));
	}
	
	private class ResizeListener implements ComponentListener {
		public void componentResized(ComponentEvent arg0) {
			resizeGUI();
		}
		public void componentHidden(ComponentEvent arg0) {}
		public void componentMoved(ComponentEvent arg0) {}
		public void componentShown(ComponentEvent arg0) {}
	}
	
	// Get und Set
	
	public String getText_pnl_kundenID(){
		return pnl_kundenID.getString();
	}
	public String getText_pnl_firmenname(){
		return pnl_firmenname.getString();
	}
	public String getText_pnl_ansprechpartner() {
		return pnl_ansprechpartner.getString();
	}
	public String getText_pnl_produktbeschreibung() {
		return pnl_produktbeschreibung.getString();
	}
	public String getText_pnl_anfangsdatum() {
		return pnl_anfangsdatum.getString();
	}
	public String getText_pnl_enddatum() {
		return pnl_enddatum.getString();
	}
	public String getText_pnl_tage() {
		return pnl_tage.getString();
	}
	public String getText_pnl_trainer() {
		return pnl_trainer.getString();
	}
	public String getText_pnl_ort() {
		return pnl_ort.getString();
	}
	public String getText_pnl_bemerkungen() {
		return pnl_bemerkungen.getString();
	}
	
	//------------------------------------------------------
	
	public void setText_pnl_kundenID(String text){
		this.pnl_kundenID.setString(text);
	}
	public void setText_pnl_firmenname(String text){
		this.pnl_firmenname.setString(text);
	}
	public void setText_pnl_ansprechpartner(String text) {
		this.pnl_ansprechpartner.setString(text);;
	}
	public void setText_pnl_produktbeschreibung(String text) {
		this.pnl_produktbeschreibung.setString(text);
	}
	public void setText_pnl_anfangsdatum(String text) {
		this.pnl_anfangsdatum.setString(text);
	}
	public void setText_pnl_enddatum(String text) {
		this.pnl_enddatum.setString(text);
	}
	public void setText_pnl_tage(String text) {
		this.pnl_tage.setString(text);
	}
	public void setText_pnl_trainer(String text) {
		this.pnl_trainer.setString(text);
	}
	public void setText_pnl_ort(String text) {
		this.pnl_ort.setString(text);
	}
	public void setText_pnl_bemerkungen(String text) {
		this.pnl_bemerkungen.setString(text);
	}
	
	//Action Listener
//	
//	public void addBtn_kundeWaehlenListener(ActionListener ActionListener) {
//		btn_kundewaehlen.addActionListener(ActionListener);
//	}
//	public void addBtn_ressourceWaehlenListener(ActionListener ActionListener) {
//		btn_ressourcenwaehlen.addActionListener(ActionListener);
//	}
//	public void addBtn_trainingSpeichernListener(ActionListener ActionListener) {
//		btn_trainingspeichern.addActionListener(ActionListener);
//	}
//	public void addBtn_zurueckListener(ActionListener ActionListener) {
//		btn_zurueck.addActionListener(ActionListener);
//	}
	private class KundeWaehlen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Kunde waehlen!");
			SimpleSwitchFrame.switchFrame(C_TrainingKonfigurieren.getView(),  C_KundeWaehlen.getInstance());
		}
	}
	private class RessourceWaehlen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Ressource Wählen");		
		}
	}
	private class TrainingSpeichern implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Training Speichern!");
		}
	}
	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(view, C_Hauptmenue.getInstance());		
		}
	}
}