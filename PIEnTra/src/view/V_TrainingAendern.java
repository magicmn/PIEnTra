package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import controller.C_Hauptmenue;
import controller.C_RessourceAendern;
import controller.C_TrainingAendern;
import model.M_Training;
import utils.SimpleDatumBerechnen;
import utils.SimpleMasterWindow;
import utils.SimpleSearch;
import utils.SimpleSwitchFrame;
import utils.SimpleTextPanel;
// @TODO Julian Klein
/**
 * View von TrainingAendern.
 * @version 1.5 noch stub
 * @version 1.4 Erbt nun von Superklasse {@link SimpleMasterWindow}.
 * @version 1.3 SimpleSwitchFrame implementiert.
 * @version 1.2 Listener hinzugefügt.
 * @version 1.1 Listener entfernt. Getter und Setter entfernt.
 * @version 1.0 View implementiert.
 * @author Adrian Fromm
 * @author Jannik Stark
 * @author Julian Klein
 * @author Konstantin
 * @see {@link controller.C_Hauptmenue};
 */
public class V_TrainingAendern extends SimpleMasterWindow {
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
	private static String navigationText = "Training ändern";
	
	private SimpleTextPanel pnl_trainingsID = new SimpleTextPanel("Trainings-ID:");
	private SimpleTextPanel pnl_firmenname = new SimpleTextPanel("Firmenname:");
	private SimpleTextPanel pnl_ansprechpartner = new SimpleTextPanel("Ansprechpartner:");
	private SimpleTextPanel pnl_produktbeschreibung = new SimpleTextPanel("Produktbeschreibung:");
	private SimpleTextPanel pnl_startdatum = new SimpleTextPanel("Startdatum:");
	private SimpleTextPanel pnl_enddatum = new SimpleTextPanel("Enddatum:");
	private SimpleTextPanel pnl_tage = new SimpleTextPanel("Tage:");
	private SimpleTextPanel pnl_trainer = new SimpleTextPanel("Trainer:");
	private SimpleTextPanel pnl_ort = new SimpleTextPanel("Ort:");
	private SimpleTextPanel pnl_bemerkungen = new SimpleTextPanel("Bemerkungen:");
	
	private JButton btn_trainingSuchen = new JButton("Training suchen");
	private JButton btn_ressourcenAendern = new JButton("Ressourcen ändern");
	private JButton btn_trainingAktualisieren = new JButton("Training aktualisieren");
	private JButton btn_zurueck = new JButton("Zurück zum Hauptmenü");
	
	private V_TrainingAendern thisView;
	private M_Training training;
	private CheckInput moehrenhoerer;
	private boolean dateCorrect = false;
	private boolean trainingsIDCorrect = false;
	
	
	/* Konstruktor und Methoden die vom Konstruktor aufgerufen werden. */
	
	/**
	 * Konstruktor der View Hauptmenue.
	 * Übergibt an die Superklasse die standard und minimal Größe, sowie aktuelle Pfadangaben der Navigationsleiste.
	 * Initialisiere dann den Content und lösche ein überflüssiges Element aus der im Hauptmenu nicht benutzten Menuleiste.
	 * Zuletzt werden die Listener initialisiert.
	 */
	public V_TrainingAendern() {
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
//		pnl_firmenname.setFocusable(false);
//		pnl_ansprechpartner.setFocusable(false);
//		pnl_produktbeschreibung.setFocusable(false);
//		pnl_trainer.setFocusable(false);
//		pnl_ort.setFocusable(false);
//		pnl_bemerkungen.setEnabled(false);
		pnl_firmenname.getTextPanel().setEditable(false);
		pnl_ansprechpartner.getTextPanel().setEditable(false);
		pnl_produktbeschreibung.getTextPanel().setEditable(false);
		pnl_trainer.getTextPanel().setEditable(false);
		pnl_ort.getTextPanel().setEditable(false);
		pnl_bemerkungen.getTextPanel().setEditable(false);
		pnl_content.add(pnl_trainingsID);
		pnl_content.add(pnl_firmenname);
		pnl_content.add(pnl_ansprechpartner);
		pnl_content.add(pnl_produktbeschreibung);
		pnl_content.add(pnl_startdatum);
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
		btn_trainingAktualisieren.setEnabled(false);
		getPnl_menu().add(btn_trainingSuchen);
		getPnl_menu().add(btn_ressourcenAendern);
		getPnl_menu().add(btn_trainingAktualisieren);
		getPnl_menu().add(btn_zurueck);
	}
	
	/**
	 * Initialisiert ActionListener
	 */
	private void initListener() {
		
		btn_trainingSuchen.addActionListener(new TrainingSuchen());
		btn_ressourcenAendern.addActionListener(new RessourceAendern());
		btn_trainingAktualisieren.addActionListener(new TrainingAktualisieren());
		btn_zurueck.addActionListener(new Zurueck());
		pnl_enddatum.getTextPanel().addFocusListener(new TageBerechnen());
		pnl_tage.getTextPanel().addFocusListener(new EnddatumBerechnen());
		pnl_trainingsID.getTextPanel().addCaretListener(moehrenhoerer);
	
		moehrenhoerer = new CheckInput(trainingsIDCorrect, dateCorrect, btn_trainingAktualisieren);
		pnl_startdatum.getTextPanel().addCaretListener(moehrenhoerer);
		pnl_enddatum.getTextPanel().addCaretListener(moehrenhoerer);
		pnl_tage.getTextPanel().addCaretListener(moehrenhoerer);
	}
	
	protected void resizeGUI() {
		int maxWidthTextBox = this.getWidth() - SimpleTextPanel.getLabelWidth() - (getPadding() * 2) - 25;
		int optimalButtonWidth = (int) super.getPnl_menu().getWidth() - 25;
		pnl_trainingsID.setTextFieldWidth(maxWidthTextBox / 4);
		pnl_firmenname.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_ansprechpartner.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_produktbeschreibung.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_startdatum.setTextFieldWidth(maxWidthTextBox / 4);
		pnl_enddatum.setTextFieldWidth(maxWidthTextBox / 4);
		pnl_tage.setTextFieldWidth(maxWidthTextBox / 8);
		pnl_trainer.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_ort.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_bemerkungen.setTextFieldWidth(maxWidthTextBox);
		btn_trainingSuchen.setPreferredSize(new Dimension(optimalButtonWidth / 4 , btn_trainingSuchen.getPreferredSize().height));
		btn_ressourcenAendern.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_trainingSuchen.getPreferredSize().height));
		btn_trainingAktualisieren.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_trainingSuchen.getPreferredSize().height));
		btn_zurueck.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_trainingSuchen.getPreferredSize().height));
		
	}

	/* Implementierung der ActionListener */
	
	public static void main(String [] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new V_TrainingAendern();
	}
	
	// Getter und Setter
	
	public String getText_pnl_trainingsID(){
		return pnl_trainingsID.getText();
	}
	public String getText_pnl_firmenname(){
		return pnl_firmenname.getText();
	}
	public String getText_pnl_ansprechpartner() {
		return pnl_ansprechpartner.getText();
	}
	public String getText_pnl_produktbeschreibung() {
		return pnl_produktbeschreibung.getText();
	}
	public String getText_pnl_startdatum() {
		return pnl_startdatum.getText();
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
	public void setText_pnl_trainingsID(String text){
		this.pnl_trainingsID.setText(text);
	}
	public void setText_pnl_firmenname(String text){
		this.pnl_firmenname.setText(text);
	}
	public void setText_pnl_ansprechpartner(String text) {
		this.pnl_ansprechpartner.setText(text);
	}
	public void setText_pnl_produktbeschreibung(String text) {
		this.pnl_produktbeschreibung.setText(text);
	}
	public void setText_pnl_startdatum(String text) {
		this.pnl_startdatum.setText(text);
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
	
	// ActionListener
	
	private class TrainingSuchen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane popup = new JOptionPane();
			try {
				if(getText_pnl_trainingsID().equals("")) {
					System.out.println("Bitte ID eintragen ");
					popup.showMessageDialog(null, "Bitte tragen Sie ein Trainings-ID ein");
					training = null;
					moehrenhoerer.setBool1(false);;
				}
				else if(!getText_pnl_trainingsID().equals("")) {
					training = SimpleSearch.trainingSuchen(getText_pnl_trainingsID(), M_Training.getInterneListe());
				}
			} catch (NoSuchElementException e){
				popup.showMessageDialog(null, "Es wurde kein Training mit dieser ID gefunden");
				training = null;
				moehrenhoerer.setBool1(false);
				
			} finally {
				if(training!=null) {
					moehrenhoerer.setBool1(true);
					
					C_TrainingAendern.getInstance().felderFuellen(training);
//					setText_pnl_firmenname(training.getKunde().getFirmenname());
//					setText_pnl_ansprechpartner(training.getTrainer().getVorname() + " " + training.getTrainer().getNachname());
//					setText_pnl_produktbeschreibung(training.getProdukt().getBeschreibung());
//					setText_pnl_startdatum(training.getAnfangsdatum());
//					setText_pnl_enddatum(training.getEnddatum());
//					setText_pnl_tage(training.getTage()+"");
//					setText_pnl_trainer(training.getTrainer().getTrainerID()+"");
//					setText_pnl_ort(training.getOrt().getOrtsID());
//					setText_pnl_bemerkungen(training.getBemerkungen());
				}
			}
		}
	}
	private class RessourceAendern implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(thisView, C_RessourceAendern.getInstance(), C_RessourceAendern.getInstance().getView());
		}
	}
	private class TrainingAktualisieren implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}

	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(thisView, C_Hauptmenue.getInstance(), C_Hauptmenue.getInstance().getView());
		}
	}
	
	private class TageBerechnen implements FocusListener {
		public void focusGained(FocusEvent arg0) {
			pnl_enddatum.getTextPanel().setEditable(true);
			}
		public void focusLost(FocusEvent arg0) {
			
			int tage = (SimpleDatumBerechnen.datumBerechnen(getText_pnl_startdatum(), getText_pnl_enddatum()));
			if (tage == -1 ){
				pnl_enddatum.getTextPanel().setEditable(false);
				
				moehrenhoerer.setBool2(false);;
			} else {
				setText_pnl_tage(tage + "");
				moehrenhoerer.setBool2(true);;
				pnl_enddatum.getTextPanel().setEditable(true);
			}
		}
	}
	
	private class EnddatumBerechnen implements FocusListener {
		public void focusGained(FocusEvent arg0) {
			pnl_tage.getTextPanel().setEditable(true);
		}
		public void focusLost(FocusEvent arg0) {
			
			String datum = "";
			try {
				datum = SimpleDatumBerechnen.datumBerechnen(getText_pnl_startdatum(), Integer.parseInt(getText_pnl_tage()));
			} catch(NumberFormatException e) {
				datum = "-1";
			}
			finally {
			if (datum.equals("-1")) {
				moehrenhoerer.setBool2(false);;
				pnl_tage.getTextPanel().setEditable(false);
			} else {
				setText_pnl_enddatum(datum);
				moehrenhoerer.setBool2(true);;
				pnl_tage.getTextPanel().setEditable(true);
			}
			}
		}
	}
}