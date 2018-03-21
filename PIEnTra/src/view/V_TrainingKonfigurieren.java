package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.C_Hauptmenue;
import controller.C_KundeWaehlen;
import controller.C_RessourceAendern;
import controller.C_RessourceWaehlen;
import controller.C_TrainingKonfigurieren;
import model.M_Ort;
import model.M_Produkt;
import model.M_Trainer;
import model.M_Training;
import utils.SimpleDatumBerechnen;
import utils.SimpleMasterWindow;
import utils.SimpleSwitchFrame;
import utils.SimpleTextPanel;

/**
 * View von TrainingKonfigurieren.
 * @version 1.7 ComponentListener hinzugefügt, der beim sichtbar werden des Fensters die anderen Klassen nach einem boolean fragt
 * @version 1.6 FocusListener implementiert
 * @version 1.5 Kunden wählen implemetiert
 * @version 1.4 Erbt nun von Superklasse {@link SimpleMasterWindow}.
 * @version 1.3 SimpleSwitchFrame implementiert.
 * @version 1.2 Listener aus Controller entfernt und in View implementiert.
 * @version 1.1 Getter und Setter hinzugefügt.
 * @version 1.0 View implementiert.
 * @author Adrian Fromm
 * @author Andreas Kann
 * @author Julian Klein
 * @author Konstantin Frei
 * @see {@link controller.C_Hauptmenue};
 */
public class V_TrainingKonfigurieren extends SimpleMasterWindow {
	private static final long serialVersionUID = -6381551589496678636L;
	
	/* Deklaration und Initailiserung von verschiedenen Variablen **/
	
	/** 
	 * Standard Größe des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	public static Dimension defaultSize = new Dimension(700, 420);
	/** 
	 * Minimale Größe des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	private static Dimension minSize = new Dimension(700, 410);
	/**
	 * Text der in der Naviagtionsleiste ausgegebn wird.
	 * @see SimpleMasterWindow#initSouth(String navigationText)
	 */
	private static String navigationText = "Training konfigurieren";
	
	private SimpleTextPanel pnl_kundenID = new SimpleTextPanel("Kunden-ID:");
	private SimpleTextPanel pnl_firmenname = new SimpleTextPanel("Firmenname:");
	private SimpleTextPanel pnl_ansprechpartner = new SimpleTextPanel("Ansprechpartner:");
	private SimpleTextPanel pnl_produktID = new SimpleTextPanel("Produktkürzel:");
	private SimpleTextPanel pnl_anfangsdatum = new SimpleTextPanel("Anfangsdatum:",utils.SimpleFormatter.getDatumFormat());
	private SimpleTextPanel pnl_enddatum = new SimpleTextPanel("Enddatum:",utils.SimpleFormatter.getDatumFormat());
	private SimpleTextPanel pnl_tage = new SimpleTextPanel("Tage:");
	private SimpleTextPanel pnl_trainer = new SimpleTextPanel("Trainer:");
	private SimpleTextPanel pnl_ort = new SimpleTextPanel("Ort:");
	private SimpleTextPanel pnl_bemerkungen = new SimpleTextPanel("Bemerkungen:");
	
	private JButton btn_kundewaehlen = new JButton("Kunde wählen");
	private JButton btn_ressourcenwaehlen = new JButton("Ressourcen wählen");
	private JButton btn_trainingspeichern = new JButton("Training speichern");
	private JButton btn_zurueck = new JButton("Zurück zum Hauptmenü");
	
	private V_TrainingKonfigurieren thisView;
	
	private M_Training training;
	private M_Trainer trainer;
	private M_Produkt produkt;
	private M_Ort ort;
	private CheckInput moehrenhoerer;
	private boolean dateCorrect = false;
	private boolean pickedDataCorrect = false;
	
	/* Konstruktor und Methoden die vom Konstruktor aufgerufen werden. */
	
	/**
	 * Konstruktor der View Training Konfigurieren.
	 * Übergibt an die Superklasse die standard und minimal Größe, sowie aktuelle Pfadangaben der Navigationsleiste.
	 * Initialisiere dann den Content und lösche ein überflüssiges Element aus der im Hauptmenu nicht benutzten Menuleiste.
	 * Zuletzt werden die Listener initialisiert.
	 */
	public V_TrainingKonfigurieren() {
		super(
			defaultSize,
			minSize,
			navigationText
		);
		this.thisView = this;
		initContent();
		initMenu();
		initListener();
		resizeGUI();
		this.setVisible(true);
	}

	/**
	 * Initialisiere den Inhalt des Centers.
	 */
	private void initContent() {
		JPanel pnl_content = new JPanel();
		pnl_content.setLayout(new GridLayout(10, 1));
		pnl_content.setAlignmentY(LEFT_ALIGNMENT);
		pnl_content.add(pnl_kundenID);
		pnl_content.add(pnl_firmenname);
		pnl_content.add(pnl_ansprechpartner);
		pnl_content.add(pnl_produktID);
		pnl_content.add(pnl_anfangsdatum);
		pnl_content.add(pnl_enddatum);
		pnl_content.add(pnl_tage);
		pnl_content.add(pnl_trainer);
		pnl_content.add(pnl_ort);
		pnl_content.add(pnl_bemerkungen);
		super.getPnl_center().add(pnl_content);
	}
	
	/**
	 * Initiailisert die Menu Buttons
	 */
	private void initMenu() {
		btn_trainingspeichern.setEnabled(false);
		getPnl_menu().add(btn_kundewaehlen);
		getPnl_menu().add(btn_ressourcenwaehlen);
		getPnl_menu().add(btn_trainingspeichern);
		getPnl_menu().add(btn_zurueck);
		
	}
	
	/**
	 * Initialisiert ActionListener
	 */
	private void initListener() {
		this.addComponentListener(new getOnShown());
		btn_kundewaehlen.addActionListener(new KundeWaehlen());
		btn_ressourcenwaehlen.addActionListener(new RessourceWaehlen());
		btn_trainingspeichern.addActionListener(new TrainingSpeichern());
		btn_zurueck.addActionListener(new Zurueck());
		pnl_enddatum.getTextPanel().addFocusListener(new TageBerechnen());
		pnl_tage.getTextPanel().addFocusListener(new EnddatumBerechnen());
		moehrenhoerer = new CheckInput(pickedDataCorrect, dateCorrect, btn_trainingspeichern);
		pnl_anfangsdatum.getTextPanel().addCaretListener(moehrenhoerer);
		pnl_enddatum.getTextPanel().addCaretListener(moehrenhoerer);
		pnl_tage.getTextPanel().addCaretListener(moehrenhoerer);
	}
	
	protected void resizeGUI() {
		int maxWidthTextBox = this.getWidth() - SimpleTextPanel.getLabelWidth() - (getPadding() * 2) - 25;
		int optimalButtonWidth = (int) super.getPnl_menu().getWidth() - 25;
		pnl_kundenID.setTextFieldWidth(maxWidthTextBox / 4);
		pnl_firmenname.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_ansprechpartner.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_produktID.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_anfangsdatum.setTextFieldWidth(maxWidthTextBox / 4);
		pnl_enddatum.setTextFieldWidth(maxWidthTextBox / 4);
		pnl_tage.setTextFieldWidth(maxWidthTextBox / 8);
		pnl_trainer.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_ort.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_bemerkungen.setTextFieldWidth(maxWidthTextBox);
		btn_kundewaehlen.setPreferredSize(new Dimension(optimalButtonWidth / 4 , btn_kundewaehlen.getPreferredSize().height));
		btn_ressourcenwaehlen.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_kundewaehlen.getPreferredSize().height));
		btn_trainingspeichern.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_kundewaehlen.getPreferredSize().height));
		btn_zurueck.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_kundewaehlen.getPreferredSize().height));
		
	}

	/* Implementierung der ActionListener */
	
	public static void main(String [] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new V_TrainingKonfigurieren();
	}
	
	// Getter und Setter
	
	public String getText_pnl_kundenID(){
		return pnl_kundenID.getText();
	}
	public String getText_pnl_firmenname(){
		return pnl_firmenname.getText();
	}
	public String getText_pnl_ansprechpartner() {
		return pnl_ansprechpartner.getText();
	}
	public String getText_pnl_produktbeschreibung() {
		return pnl_produktID.getText();
	}
	public String getText_pnl_anfangsdatum() {
		return pnl_anfangsdatum.getText();
	}
	public String getText_pnl_enddatum() {
		return pnl_enddatum.getText();
	}
	public String getText_pnl_tage() {
		return pnl_tage.getText();
	}
	public String getText_pnl_trainer() {
		return pnl_trainer.getText();
	}
	public String getText_pnl_ort() {
		return pnl_ort.getText();
	}
	public String getText_pnl_bemerkungen() {
		return pnl_bemerkungen.getText();
	}
	public void setText_pnl_kundenID(String text){
		this.pnl_kundenID.setText(text);
	}
	public void setText_pnl_firmenname(String text){
		this.pnl_firmenname.setText(text);
	}
	public void setText_pnl_ansprechpartner(String text) {
		this.pnl_ansprechpartner.setText(text);;
	}
	public void setText_pnl_produktbeschreibung(String text) {
		this.pnl_produktID.setText(text);
	}
	public void setText_pnl_anfangsdatum(String text) {
		this.pnl_anfangsdatum.setText(text);
	}
	public void setText_pnl_enddatum(String text) {
		this.pnl_enddatum.setText(text);
	}
	public void setText_pnl_tage(String text) {
		this.pnl_tage.setText(text);
	}
	public void setText_pnl_trainer(String text) {
		this.pnl_trainer.setText(text);
	}
	public void setText_pnl_ort(String text) {
		this.pnl_ort.setText(text);
	}
	public void setText_pnl_bemerkungen(String text) {
		this.pnl_bemerkungen.setText(text);
	}
	

	public M_Training getTraining() {
		return training;
	}

	public void setTraining(M_Training training) {
		this.training = training;
	}

	public M_Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(M_Trainer trainer) {
		this.trainer = trainer;
	}

	public M_Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(M_Produkt produkt) {
		this.produkt = produkt;
	}

	public M_Ort getOrt() {
		return ort;
	}

	public void setOrt(M_Ort ort) {
		this.ort = ort;
	}

	//FocusListener
	private class EnddatumBerechnen implements FocusListener {
		public void focusGained(FocusEvent arg0) {}
		public void focusLost(FocusEvent arg0) {
			String datum = "";
			try {
				datum = SimpleDatumBerechnen.datumBerechnen(getText_pnl_anfangsdatum(), Integer.parseInt(getText_pnl_tage()));
			} catch(NumberFormatException e) {
				datum = "-1";
			} finally {
				if (datum.equals("-1")) {
					moehrenhoerer.setBool2(false);
				} else {
					setText_pnl_enddatum(datum);
					moehrenhoerer.setBool2(true);
				}
			}
		}
	}
	
	private class TageBerechnen implements FocusListener {
		public void focusGained(FocusEvent arg0) {}
		public void focusLost(FocusEvent arg0) {
			int tage = (SimpleDatumBerechnen.datumBerechnen(getText_pnl_anfangsdatum(), getText_pnl_enddatum()));
			if (tage == -1 ){
				moehrenhoerer.setBool2(false);
			} else {
				setText_pnl_tage(tage + "");
				moehrenhoerer.setBool2(true);
			}
		}
	}
	
	private class getOnShown implements ComponentListener {

		@Override
		public void componentHidden(ComponentEvent arg0) {}
		@Override
		public void componentMoved(ComponentEvent arg0) {}
		@Override
		public void componentResized(ComponentEvent arg0) {}
		@Override
		public void componentShown(ComponentEvent arg0) {
			if (getText_pnl_firmenname().equals("") && getText_pnl_produktbeschreibung().equals("")) {
				moehrenhoerer.setBool1(true);
			} else {
				moehrenhoerer.setBool1(false);
			}
		}
		
	}
	
	// ActionListener
	private class KundeWaehlen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Kunde waehlen!");
			SimpleSwitchFrame.switchFrame(thisView, C_KundeWaehlen.getInstance(),  C_KundeWaehlen.getInstance().getView());
		}
	}
	private class RessourceWaehlen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Ressource Wählen");
			C_RessourceAendern.getInstance(C_TrainingKonfigurieren.getInstance());
			C_RessourceAendern.getInstance(C_TrainingKonfigurieren.getInstance()).getView();
		
			//SimpleSwitchFrame.switchFrame(thisView, C_RessourceWaehlen.getInstance(), C_RessourceWaehlen.getInstance().getView());
		}
	}
	private class TrainingSpeichern implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Training Speichern!");
		}
	}
	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(thisView, C_Hauptmenue.getInstance(), C_Hauptmenue.getInstance().getView());
		}
	}
}
