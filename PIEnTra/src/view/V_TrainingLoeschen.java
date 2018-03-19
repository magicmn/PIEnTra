package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.C_Hauptmenue;
import model.M_Training;
import utils.SimpleMasterWindow;
import utils.SimpleSearch;
import utils.SimpleSwitchFrame;
import utils.SimpleTextPanel;

/**
 * View von TrainingKonfigurieren.
 * @version 1.4 Erbt nun von Superklasse {@link SimpleMasterWindow}.
 * @version 1.3 SimpleSwitchFrame implementiert.
 * @version 1.2 Listener hinzugefügt.
 * @version 1.1 Listener entfernt. Getter und Setter entfernt.
 * @version 1.0 View implementiert.
 * @author Adrian Fromm
 * @author Julian Klein
 * @author Konstantin Frei
 * @see {@link controller.C_Hauptmenue};
 */
public class V_TrainingLoeschen extends SimpleMasterWindow {
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
	
	/* Konstruktor und Methoden die vom Konstruktor aufgerufen werden. */
	
	/**
	 * Konstruktor der View Hauptmenue.
	 * Übergibt an die Superklasse die standard und minimal Größe, sowie aktuelle Pfadangaben der Navigationsleiste.
	 * Initialisiere dann den Content und lösche ein überflüssiges Element aus der im Hauptmenu nicht benutzten Menuleiste.
	 * Zuletzt werden die Listener initialisiert.
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
	}

	/**
	 * Initialisiere den Inhalt des Centers.
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
	 * Initiailisert die Menu Buttons
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

	/* Implementierung der ActionListener */
	
	public static void main(String [] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new V_TrainingLoeschen();
	}
	
	// Getter und Setter
	
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
	
	// ActionListener
	
	private class TrainingSuchen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			//implementation der Suchfunktion
			
			try {
				if(getText_pnl_trainingsID().equals("")) {
					System.out.println("Bitte ID eintragen ");
					popup.showMessageDialog(null, "Bitte tragen Sie ein Trainings-ID ein");
					training = null;
				}

				else if(!getText_pnl_trainingsID().equals("")) {
					training = SimpleSearch.trainingSuchen(getText_pnl_trainingsID(), M_Training.getInterneListe());
				}
				
			}
			catch ( NoSuchElementException e){
				System.out.println("Kein Training gefunden");
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
	
	private class TrainingLoeschen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Training löschen");
			if (training != null)
			{
				for (Iterator<M_Training> iter = M_Training.getInterneListe().listIterator(); iter.hasNext(); ) {
				    training = iter.next();
				    
				        iter.remove();
				    
				}
				
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
			else {
				popup.showMessageDialog(null, "Bitte wählen Sie vorher ein Training aus");

			}
		}
	}
	
	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(thisView, C_Hauptmenue.getInstance(), C_Hauptmenue.getInstance().getView());
		}
	}
}