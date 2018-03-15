package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import controller.C_Hauptmenue;
import controller.C_KundeSuchen;
import controller.C_KundeVerwalten;
import controller.C_TrainingAendern;
import utils.SimpleSwitchFrame;
import utils.SimpleTextPanel;

/**
 * Aktuelle Version: 1.2  
 * Authoren: Jannik (1.0, 1.1), Adrian (1.2)
 * 
 * Changelog:
 * 1.0 	
 * 		-Controller erstellt
 * 1.1
 * 		-Get / Set hinzugef�gt
 * 1.2
 * 		-ActionListener hinzugef�gt
 **/
public class V_TrainingAendern extends JFrame {
	
	private SimpleTextPanel pnl_trainingsId = new SimpleTextPanel("Trainings-ID:");
	private SimpleTextPanel pnl_firmenname = new SimpleTextPanel("Firmenname:");
	private SimpleTextPanel pnl_ansprechpartner = new SimpleTextPanel("Ansprechpartner:");
	private SimpleTextPanel pnl_produktbeschreibung = new SimpleTextPanel("Produktbeschreibung:");
	private SimpleTextPanel pnl_startdatum = new SimpleTextPanel("Startdatum:");
	private SimpleTextPanel pnl_enddatum = new SimpleTextPanel("Enddatum:");
	private SimpleTextPanel pnl_tage = new SimpleTextPanel("Tage:");
	private SimpleTextPanel pnl_trainer = new SimpleTextPanel("Trainer:");
	private SimpleTextPanel pnl_ort = new SimpleTextPanel("Ort:");
	private SimpleTextPanel pnl_bemerkungen = new SimpleTextPanel("Bemerkungen:");
	
	private JPanel pnl_center;
	private JPanel pnl_south;
	private JPanel pnl_south_bottom = new JPanel();
	
	private JButton btn_trainingsuchen = new JButton("Training suchen");
	private JButton btn_ressourcenaendern = new JButton("Ressourcen �ndern");
	private JButton btn_trainingaktualisieren = new JButton("Training aktualisieren");
	private JButton btn_zurueck = new JButton("Zur�ck zum Hauptmen�");
	
	private JTextField txt_navigation;

	public V_TrainingAendern() {
		initView();
		resizeGUI();
		initListener();
		this.setVisible(true);
	}

	private void initView() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setSize(750, 450); // Optimale Gr��e die beim Starten geladen wird.
		this.setMinimumSize(new Dimension(500, 400)); // Um zu verhindern, dass der DAU sich wundert warum das Fenster auf einmal "weg" ist.
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null); // Zentriert Frame in der Mitte des Bildschirms.
		this.addComponentListener(new ResizeListener());  // F�gt Listener f�r Frame ver�nderungen hinzu.
		
		pnl_center = new JPanel(new GridLayout(10, 1, 2 ,2));
		
		pnl_center.add(pnl_trainingsId);
		pnl_center.add(pnl_firmenname);
		pnl_center.add(pnl_ansprechpartner);
		pnl_center.add(pnl_produktbeschreibung);
		pnl_center.add(pnl_startdatum);
		pnl_center.add(pnl_enddatum);
		pnl_center.add(pnl_tage);
		pnl_center.add(pnl_trainer);
		pnl_center.add(pnl_ort);
		pnl_center.add(pnl_bemerkungen);
		
		this.add(BorderLayout.CENTER, pnl_center);
		
		pnl_south = new JPanel(new GridLayout(2, 1));
		JPanel pnl_south_top = new JPanel(new GridLayout(1, 4));
		
		pnl_south_top.setBorder(new EmptyBorder(10,8,5,10));
		pnl_south_top.add(btn_trainingsuchen);
		pnl_south_top.add(btn_ressourcenaendern);
		pnl_south_top.add(btn_trainingaktualisieren);
		pnl_south_top.add(btn_zurueck);
		
		pnl_south.add(pnl_south_top);
		pnl_south_bottom.add(txt_navigation = new JTextField("PlEnTra / Training �ndern"));
		
		txt_navigation.setFocusable(false);
		pnl_south.add(pnl_south_bottom);
		this.add(BorderLayout.SOUTH, pnl_south);
	}
	
	/** Enth�lt variable G��en **/
	private void resizeGUI() {
		txt_navigation.setPreferredSize(new Dimension(this.getWidth() - 30, txt_navigation.getPreferredSize().height));
		pnl_trainingsId.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_firmenname.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_ansprechpartner.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_produktbeschreibung.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_startdatum.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_enddatum.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_tage.setTxtField_Size(pnl_center.getWidth() / 8);
		pnl_trainer.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_ort.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_bemerkungen.setTxtField_Size((this.getWidth() - 140));
	}
	private void initListener(){
		btn_trainingsuchen.addActionListener(new TrainingSuchen());
		btn_ressourcenaendern.addActionListener(new RessourceAendern());
		btn_trainingaktualisieren.addActionListener(new TrainingAktualisieren());
		btn_zurueck.addActionListener(new Zurueck());
	}
	
	private class ResizeListener implements ComponentListener {
		public void componentResized(ComponentEvent arg0) {
			resizeGUI();
		}
		public void componentHidden(ComponentEvent arg0) {}
		public void componentMoved(ComponentEvent arg0) {}
		public void componentShown(ComponentEvent arg0) {}
	}
	
	//Get und Set
	
	//Get Trainings-ID
	public String getTrainingsId() {
		return pnl_trainingsId.getString();
	}
	//Set Trainings-ID
	public void setTextTrainingsId(String txt_trainingsId) {
		this.pnl_trainingsId.setString(txt_trainingsId);
	}
	//Get Firmenname
	public String getFirmenname() {
		return pnl_firmenname.getString();
	}	
	//Set Firmenname
	public void setTextFirmenname(String txt_firmenname) {
		this.pnl_firmenname.setString(txt_firmenname);
	}	
	//Get Ansprechpartner
	public String getAnsprechpartner() {
		return pnl_ansprechpartner.getString();
	}
	//Set Ansprechpartner
	public void setTextAnsprechpartner(String txt_ansprechpartner) {
		this.pnl_ansprechpartner.setString(txt_ansprechpartner);
	}
	//Get Produktbeschreibung
	public String getProduktbeschreibung() {
		return pnl_produktbeschreibung.getString();
	}
	//Set Produktbeschreibung
	public void setTextProduktbeschreibung(String txt_produktbeschreibung) {
		this.pnl_produktbeschreibung.setString(txt_produktbeschreibung);
	}
	//Get Startdatum
	public String getStartdatum() {
		return pnl_startdatum.getString();
	}
	//Set Startdatum
	public void setTextStartdatum(String txt_startdatum) {
		this.pnl_startdatum.setString(txt_startdatum);
	}	
	//Get Enddatum
	public String getEnddatum() {
		return pnl_enddatum.getString();
	}
	//Set Enddatum
	public void setTextEnddatum(String txt_enddatum) {
		this.pnl_enddatum.setString(txt_enddatum);
	}	
	//Get Tage
	public String getTage() {
		return pnl_tage.getString();
	}
	//Set Tage
	public void setTextTage(String txt_tage) {
		this.pnl_tage.setString(txt_tage);
	}	
	//Get Trainer
	public String getTrainer() {
		return pnl_trainer.getString();
	}
	//Set Trainer
	public void setTextTrainer(String txt_trainer) {
		this.pnl_trainer.setString(txt_trainer);
	}	
	//Get Ort
	public String getOrt() {
		return pnl_ort.getString();
	}
	//Set Ort
	public void setTextOrt(String txt_ort) {
		this.pnl_ort.setString(txt_ort);
	}	
	//Get Bemerkungen
	public String getBemerkungen() {
		return pnl_bemerkungen.getString();
	}
	//Set Bemerkungen
	public void setTextBemerkungen(String txt_bemerkungen) {
		this.pnl_bemerkungen.setString(txt_bemerkungen);
	}	
	
	//ActionListener
	//--------------------------------------------------------------
	
	private class TrainingSuchen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Training suchen!");
			
		}
	}
	private class RessourceAendern implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Ressource �ndern!");
		}
	}
	private class TrainingAktualisieren implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Training aktualisieren!");
		}
	}
	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(C_TrainingAendern.getView(), new C_Hauptmenue());
		}
	}
	
}