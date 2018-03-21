package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.AbstractDocument.Content;

import controller.C_Hauptmenue;
import controller.C_TrainingLoeschen;
import model.M_Training;
import utils.SimpleMasterWindow;
import utils.SimpleSearch;
import utils.SimpleSwitchFrame;
import utils.SimpleTextPanel;

/**
 * @version 1.6 Löschenfunktion wurde in den Construktor verschoben.
 * @version 1.5 Löschenfunktion wirft nun Abfragen
 * @version 1.4 Erbt nun von Superklasse {@link SimpleMasterWindow}.
 * @version 1.3 SimpleSwitchFrame implementiert.
 * @version 1.2 Listener aus Controller entfernt und in View implementiert.
 * @version 1.1 Getter und Setter hinzugefügt.
 * @version 1.0 View implementiert.
 * @author Andreas Kann
 * @author Adrian Fromm
 * @author Julian Klein
 * @author Konstantin Frei
 * @see {@link controller.C_Hauptmenue};
 */
public class V_TrainingLoeschen extends SimpleMasterWindow {
	private static final long serialVersionUID = -6381551589496678636L;
	
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
	private static String navigationText = "Training löschen";
	
	private SimpleTextPanel pnl_trainingsID = new SimpleTextPanel("Trainings-ID:");
	private SimpleTextPanel pnl_firmenname = new SimpleTextPanel("Firmenname:");
	private SimpleTextPanel pnl_produkt = new SimpleTextPanel("Produkt:");
	private SimpleTextPanel pnl_startdatum = new SimpleTextPanel("Startdatum:");
	private SimpleTextPanel pnl_enddatum = new SimpleTextPanel("Enddatum:");
	private SimpleTextPanel pnl_tage = new SimpleTextPanel("Tage:");
	private SimpleTextPanel pnl_trainer = new SimpleTextPanel("Trainer:");
	private SimpleTextPanel pnl_ort = new SimpleTextPanel("Ort:");
	private SimpleTextPanel pnl_bemerkungen = new SimpleTextPanel("Bemerkungen:");
	
	private JButton btn_trainingSuchen = new JButton("Training suchen");
	private JButton btn_trainingLöschen = new JButton("Training löschen");
	private JButton btn_zurueck = new JButton("Zurück zum Hauptmenü");
	
	private V_TrainingLoeschen thisView;
	private M_Training training;
	private JOptionPane popup;
	

	/**
	 * Konstruktor der View_Training Löschen.
=======
	/**
	 * Konstruktor der View_Training Löschen.
>>>>>>> branch 'master' of https://github.com/magicmn/PIEnTra.git
	 * Übergibt an die Superklasse die standard und minimal Größe, sowie aktuelle Pfadangaben der Navigationsleiste.
	 * Initialisiert den Content, das Menu, die resizeGUI und sämtliche Listener.
	 * Zuletzt wird die View sichbar gesetzt.
	 */
	public V_TrainingLoeschen() {
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
	 * Initialisiert den Inhalt des Centers.
	 */
	private void initContent() {
		JPanel pnl_content = new JPanel();
		pnl_content.setLayout(new GridLayout(10, 1));
		pnl_content.setAlignmentY(LEFT_ALIGNMENT);
		pnl_content.add(pnl_trainingsID);
		pnl_content.add(pnl_firmenname);
		pnl_content.add(pnl_produkt);
		pnl_content.add(pnl_startdatum);
		pnl_content.add(pnl_enddatum);
		pnl_content.add(pnl_tage);
		pnl_content.add(pnl_trainer);
		pnl_content.add(pnl_ort);
		pnl_content.add(pnl_bemerkungen);
		super.getPnl_center().add(pnl_content);
	}
	
	/**
	 * Initialisiert die Menu Buttons
	 */
	private void initMenu() {
		getPnl_menu().add(btn_trainingSuchen);
		getPnl_menu().add(btn_trainingLöschen);
		getPnl_menu().add(btn_zurueck);
		
	}
	
	/**
	 * Initialisiert ActionListener
	 */
	private void initListener() {
		btn_trainingSuchen.addActionListener(new TrainingSuchen());
		btn_trainingLöschen.addActionListener(new TrainingLoeschen());
		btn_zurueck.addActionListener(new Zurueck());
	}
	
	protected void resizeGUI() {
		int maxWidthTextBox = this.getWidth() - SimpleTextPanel.getLabelWidth() - (getPadding() * 2) - 25;
		int optimalButtonWidth = (int) super.getPnl_menu().getWidth() - 25;
		pnl_trainingsID.setTextFieldWidth(maxWidthTextBox / 4);
		pnl_firmenname.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_produkt.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_startdatum.setTextFieldWidth(maxWidthTextBox / 4);
		pnl_enddatum.setTextFieldWidth(maxWidthTextBox / 4);
		pnl_tage.setTextFieldWidth(maxWidthTextBox / 8);
		pnl_trainer.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_ort.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_bemerkungen.setTextFieldWidth(maxWidthTextBox);
		btn_trainingSuchen.setPreferredSize(new Dimension(optimalButtonWidth / 4 , btn_trainingSuchen.getPreferredSize().height));
		btn_trainingLöschen.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_trainingSuchen.getPreferredSize().height));
		btn_zurueck.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_trainingSuchen.getPreferredSize().height));
		
	}

	/**
	 * For testing
	 */
	public static void main(String [] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new V_TrainingLoeschen();
	}
	
	// Getter und Setter ----------------------------------------------------------------------------------
	
	public String getText_pnl_trainingsID(){
		return pnl_trainingsID.getText();
	}
	public String getText_pnl_firmenname(){
		return pnl_firmenname.getText();
	}
	public String getText_pnl_produkt() {
		return pnl_produkt.getText();
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
	public M_Training get_training(){
		return training;
	}
	public void setText_pnl_trainingsID(String text){
		this.pnl_trainingsID.setText(text);
	}
	public void setText_pnl_firmenname(String text){
		this.pnl_firmenname.setText(text);
	}
	public void setText_pnl_produkt(String text) {
		this.pnl_produkt.setText(text);
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
	
	// ActionListener -----------------------------------------------------------------------------------
	
	/**
	 * Durchsucht die interne Liste nach einem Objekt mit der eingebenen ID und füllt die Formularfelder.
	 * Gibt dabei Fehlermedungen aus sollte zuvor keine oder eine flasche Eingabe erfolgt sein.
	 * @author Andreas Kann
	 */
	private class TrainingSuchen implements ActionListener {
		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent arg0) {
			
			//Suchfunktion: durchsucht die interne Liste nach einem Objekt mit der eingebenen ID
			
			try {
				if(getText_pnl_trainingsID().equals("")) {
					popup.showMessageDialog(null, "Bitte tragen Sie eine Trainings-ID ein");
					training = null;
				}

				else if(!getText_pnl_trainingsID().equals("")) {
					training = SimpleSearch.trainingSuchen(getText_pnl_trainingsID(), M_Training.getInterneListe());
				}
				
			}
			catch ( NoSuchElementException e){
				popup.showMessageDialog(null, "Es wurde kein Training mit dieser ID gefunden");
				training = null;
				
			}
			finally {
				if(training!=null) {
					setText_pnl_firmenname(training.getKunde().getFirmenname());
					setText_pnl_produkt(training.getProdukt().getBezeichnung());
					setText_pnl_startdatum(training.getAnfangsdatum());
					setText_pnl_enddatum(training.getEnddatum());
					setText_pnl_tage(training.getTage()+"");
					setText_pnl_trainer(training.getTrainer().getTrainerID()+"");
					setText_pnl_ort(training.getOrt().getOrtsID());
					setText_pnl_bemerkungen(training.getBemerkungen());
				}
			}	
		}
	}
	/**
	 * Gibt die Anweisung das zuvor ausgewählte Trainings-Objekt zu löschen.
	 * Ruft die Löschenfunktion des Controllers erst nach einer Sicherheitsabfrage auf.
	 * 
	 * @author Andreas Kann
	 *
	 */
	
	private class TrainingLoeschen implements ActionListener {
		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent arg0) {
			if (training != null)
			{
				int input = JOptionPane.showConfirmDialog(null, "Wollen Sie das Training wirklich löschen ?");
				
				if (input == 0){
					C_TrainingLoeschen.trainingLoeschen(training);
					
					setText_pnl_trainingsID("");
					setText_pnl_firmenname("");
					setText_pnl_produkt("");
					setText_pnl_startdatum("");
					setText_pnl_enddatum("");
					setText_pnl_tage("");
					setText_pnl_trainer("");
					setText_pnl_ort("");
					setText_pnl_bemerkungen("");
					training = null;
				}
			}
			else {
				popup.showMessageDialog(null, "Bitte wählen Sie vorher ein Training aus");

			}
		}
	}
	
	/**
	 * Navigiert zurück zum Hauptmenu.
	 * 
	 * @author Andreas Kann
	 *
	 */
	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(thisView, C_Hauptmenue.getInstance(), C_Hauptmenue.getInstance().getView());
		}
	}
}