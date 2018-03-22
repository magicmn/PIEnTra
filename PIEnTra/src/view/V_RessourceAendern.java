package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import model.M_Ort;
import model.M_Produkt;
import model.M_Trainer;
import controller.C_RessourceAendern;
import controller.C_TrainingAendern;
import controller.C_TrainingKonfigurieren;
import testdaten.Test_main;
import utils.SimpleDropdownPanel;
import utils.SimpleMasterWindow;
import utils.SimpleSearch;
import utils.SimpleSwitchFrame;
import utils.SimpleTextPanel;

/**
 * View von RessourceAendern.
 * @version 2.1 Bugfixes
 * @version 2.0 V_RessourceWaehlen und V_RessourceAendern zu einer Klasse zusammengeführt
 * @version 1.2 Dropdown Funktionen hinzugefügt.
 * @version 1.1 Listener hinzugefügt. Getter und Setter hinzugefügt.
 * @version 1.0 View implementiert. 
 * @author Adrian Fromm
 * @see {@link controller.C_Hauptmenue};
 */
public class V_RessourceAendern extends SimpleMasterWindow {

	private static final long serialVersionUID = 5395382811986935482L;

	/* Deklaration und Initailiserung von verschiedenen Variablen **/

	/** 
	 * Standard Größe des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	public static Dimension defaultSize = new Dimension(720, 240);
	
	/** 
	 * Minimale Größe des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	private static Dimension minSize = new Dimension(700, 235);
	
	/**
	 * Text der in der Naviagtionsleiste ausgegebn wird.
	 * @see SimpleMasterWindow#initSouth(String navigationText)
	 */
	private static String navigationText = "Training konfigurieren / Kunde wählen";
	
	/**
	 * ArrayListen in den die Werte für die Comboboxen geschrieben werden.
	 * Die ArrayListen bekommen ihren Inhalt aus den jeweiligen Modelklassen
	 */
	private ArrayList<String>arrayList_produktbezeichnung = new ArrayList<String>();
	private ArrayList<String>arrayList_trainer = new ArrayList<String>();
	private ArrayList<String>arrayList_ort = new ArrayList<String>();
	
	/**
	 * Deklaration der Comboboxen. 
	 * SimpleDropdownPanel erbt von JPanel und besitzt erweiterte Funktionen für Comboboxen
	 * @see SimpleDropDownPanel.java
	 */
	private SimpleDropdownPanel pnl_produktbez;
	private SimpleDropdownPanel pnl_trainer;
	private SimpleDropdownPanel pnl_ort;
	
	/**
	 * Deklaration und Initialisierung der restlichen JFrame-Komponenten (JLabel, JTextArea, JScrollPane, JButton)
	 */
	private JLabel lbl_produktb = new JLabel("Produktbeschreibung:");
	private JTextArea textarea = new JTextArea();
	private JScrollPane area = new JScrollPane(textarea);
	private JButton btn_ressourceaendern = new JButton("Button");
	private JButton btn_zurueck = new JButton("Zurück zu Training ändern");
	
	/**
	 * Deklaration und Initialisierung des TrainerListener Objekts (erbt von ItemListener) 
	 * Wird an dieser Stelle deklariert, da er zur Laufzeit einem Objekt hinzugefügt und entfernt werden muss.
	 */
	private TrainerListener trainerlistener = new TrainerListener();
	
	/**
	 * Deklaration und Initialisierung der benötigten Model-Objekte
	 */
	private M_Produkt produkt = null;
	private M_Trainer trainer = null;
	private M_Ort ort = null;

	/**
	 * Deklaration dieser View.
	 * Deklaration des Controllers dieser View.
	 */
	private V_RessourceAendern thisView;
	private static Object controller;

	/* Konstruktor und Methoden die vom Konstruktor aufgerufen werden. */

	/**
	 * Konstruktor der View RessourceWaehlen
	 */
	public V_RessourceAendern(Object controller) {
		super(
				defaultSize,
				minSize,
				navigationText
				);
		V_RessourceAendern.controller = controller;
		this.thisView = this;
		initComboBox();
		initContent();
		initMenu();
		initListener();
		resizeGUI();
		this.setVisible(true);

	}
	/**
	 * Überladener Konstruktor der View RessourceWaehlen
	 */
	public V_RessourceAendern(Object controller, M_Produkt produkt, M_Trainer trainer, M_Ort ort) {
		super(
				defaultSize,
				minSize,
				navigationText
				);
		this.setProdukt(produkt);
		this.setTrainer(trainer);
		this.setOrt(ort);
		V_RessourceAendern.controller =controller; 
		this.thisView = this;
		initComboBox();
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

		area.setPreferredSize(new Dimension(200, 80));
		area.setBorder(BorderFactory.createLineBorder(Color.gray));
		area.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		textarea.setText("");
		textarea.setLineWrap(true);

		pnl_produktbez = new SimpleDropdownPanel("Produktbezeichnung:", arrayList_produktbezeichnung);
		pnl_trainer = new SimpleDropdownPanel("Trainer:", arrayList_trainer);
		pnl_ort = new SimpleDropdownPanel("Ort:", arrayList_ort);

		pnl_produktbez.getComboBox().setSelectedIndex(-1);
		pnl_trainer.getComboBox().setSelectedIndex(-1);
		pnl_ort.getComboBox().setSelectedIndex(-1);

		pnl_trainer.getComboBox().setEnabled(false);
		pnl_ort.getComboBox().setEnabled(false);

		if(controller instanceof C_TrainingAendern) {
			produkt = ((C_TrainingAendern) controller).getProdukt();
			trainer = ((C_TrainingAendern) controller).getTrainer();
			ort = ((C_TrainingAendern) controller).getOrt();
			
			pnl_trainer.getComboBox().setEnabled(true);
			pnl_ort.getComboBox().setEnabled(true);

			pnl_produktbez.getComboBox().setSelectedItem(produkt.getBezeichnung());
			pnl_trainer.getComboBox().setSelectedItem(trainer.getVorname() + trainer.getNachname()+"");
			pnl_ort.getComboBox().setSelectedItem(ort.toString());
		}
		
		GridLayout grid = new GridLayout(3,1);
		grid.setVgap(5);

		JPanel pnl_content = new JPanel();
		JPanel pnl_content_left = new JPanel();
		JPanel pnl_content_right = new JPanel();

		pnl_content_left.setLayout(grid);
		pnl_content_left.setAlignmentY(LEFT_ALIGNMENT);
		pnl_content_left.add(pnl_produktbez);
		pnl_content_left.add(pnl_trainer);
		pnl_content_left.add(pnl_ort);

		pnl_content_right.setLayout(new BoxLayout(pnl_content_right, BoxLayout.PAGE_AXIS));
		pnl_content_right.add(lbl_produktb);
		pnl_content_right.add(area);

		pnl_content_right.setBorder(new EmptyBorder(10,35,10,10));

		pnl_content.setLayout(new FlowLayout());
		pnl_content.add(pnl_content_left);
		pnl_content.add(pnl_content_right);

		super.getPnl_center().add(pnl_content);
		super.getNavigationPathPanel().setBorder(new EmptyBorder(8,0,0,0));
	}

	/**
	 * Initiailisert die Menu Buttons
	 */
	private void initMenu() {

		btn_ressourceaendern.setEnabled(false);
		getPnl_menu().add(btn_ressourceaendern);
		getPnl_menu().add(btn_zurueck);	
		
		if(getController() instanceof C_TrainingAendern) {
			btn_ressourceaendern.setText("Ressource ändern");
			btn_zurueck.setText("Zurück zu Training ändern");
		}
		if(getController() instanceof C_TrainingKonfigurieren) {
			btn_ressourceaendern.setText("Ressource wählen");
			btn_zurueck.setText("Zurück zu Training konfigurieren");
		}

	}

	/**
	 * Initialisiert ActionListener
	 */
	private void initListener() {

		btn_ressourceaendern.addActionListener(new RessourceWaehlen());
		btn_zurueck.addActionListener(new Zurueck());	

		pnl_produktbez.getComboBox().addItemListener(new ProduktbezeichnungListener());
		pnl_trainer.getComboBox().addItemListener(trainerlistener);
		pnl_ort.getComboBox().addItemListener(new OrtListener());

	}

	/**
	 * Anpassung der Komponentengrößen
	 */
	protected void resizeGUI() {
		int maxWidthTextBox = this.getWidth() - SimpleTextPanel.getLabelWidth() - (getPadding() * 2) - 25;
		int optimalButtonWidth = (int) super.getPnl_menu().getWidth() - 25;
		pnl_produktbez.setComboBoxFieldWidth(maxWidthTextBox / 2);
		pnl_trainer.setComboBoxFieldWidth(maxWidthTextBox / 2);
		pnl_ort.setComboBoxFieldWidth(maxWidthTextBox / 2);
		btn_ressourceaendern.setPreferredSize(new Dimension(optimalButtonWidth / 4 , btn_ressourceaendern.getPreferredSize().height));
		btn_zurueck.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_ressourceaendern.getPreferredSize().height));

	}

	/**
	 * Initialisiert die ArrayListen.
	 * Hinweis: arrayList_trainer wird zur Laufzeit abhängig von der Combobox-Auswahl von Produktbezeichnung initialisiert.
	 */
	private void initComboBox(){

		M_Produkt.getInterneListe().forEach(M_Produkt -> arrayList_produktbezeichnung.add(M_Produkt.getBezeichnung()));
		M_Ort.getInterneListe().forEach(M_Ort -> arrayList_ort.add(M_Ort.getOrtsID()+" , "+M_Ort.getGeschaefstsstelle()));		
	}

	// Getter und Setter Dropdownfelder

	public String getText_pnl_produktbezeichnung(){
		return pnl_produktbez.getText();
	}
	public String getText_pnl_trainer(){
		return pnl_trainer.getText();
	}
	public String getText_pnl_ort() {
		return pnl_ort.getText();
	}
	public String getText_pnl_produktbeschreibung(){
		return textarea.getText();
	}

	// Getter und Setter Model

	public static Object getController() {
		return controller;
	}
	public static void setController(Object controller) {
		V_RessourceAendern.controller = controller;
	}
	public M_Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(M_Trainer trainer) {
		this.trainer = trainer;
	}
	public M_Ort getOrt() {
		return ort;
	}
	public void setOrt(M_Ort ort) {
		this.ort = ort;
	}
	public M_Produkt getProdukt() {
		return produkt;
	}
	public void setProdukt(M_Produkt produkt) {
		this.produkt = produkt;
	}

	/* Implementierung der ActionListener */
	
	/**
	 * Die interne Klasse "Ressource Waehlen" implementiert den ActionListener für "btn_ressourcewaehlen".
	 * 
	 * Jenachdem von welcher Controller Instanz diese View aufgerufen wird, werden unterschiedliche Aktionen ausgeführt.
	 * Die Aktionen füllen die Felder in der View V_TrainingKonfigurieren oder V_TrainingAendern
	 * Die Aktion nutzt die Methode "felderFuellen" aus dem jeweiligen Controller der View.
	 * 
	 */	
	private class RessourceWaehlen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			if(ort!=null&&produkt!=null&&trainer!=null) {

				if(controller instanceof C_TrainingAendern) {
					System.out.println("Ressource ändern");
					((C_TrainingAendern) controller).felderFuellen(produkt, trainer, ort);
					C_RessourceAendern.getInstance(C_TrainingAendern.getInstance()).setView(null);
					dispose();
				}
				if(controller instanceof C_TrainingKonfigurieren) {
					System.out.println("Ressource wählen");
					((C_TrainingKonfigurieren) controller).felderFuellen(produkt, trainer, ort);
					C_RessourceAendern.getInstance(C_TrainingKonfigurieren.getInstance()).setView(null);
					dispose();
				}	
			}
		}
	}
	
	/**
	 * Die interne Klasse "Zurueck" implementiert den ActionListener für "btn_zurueck".
	 * 
	 * Jenachdem von welcher Controller Instanz diese View aufgerufen wird, werden unterschiedliche Aktionen ausgeführt.
	 * Die Aktionen brechen die View ab und wechseln wieder in die entsprechende View aus der V_RessourceAendern aufgerufen wurde.
	 * 
	 */	
	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Zurueck");

			if(controller instanceof C_TrainingAendern) {			
				SimpleSwitchFrame.switchFrame(thisView, C_TrainingAendern.getInstance(), ((C_TrainingAendern) controller).getView());
				C_RessourceAendern.getInstance(C_TrainingAendern.getInstance()).setView(null);
			}
			if(controller instanceof C_TrainingKonfigurieren) {
				SimpleSwitchFrame.switchFrame(thisView, C_TrainingKonfigurieren.getInstance(), ((C_TrainingKonfigurieren) controller).getView());;
				C_RessourceAendern.getInstance(C_TrainingKonfigurieren.getInstance()).setView(null);
			}
		}
	}	

	/*    Implementierung der ItemListener    */
	
	/**
	 * Die interne Klasse "ProduktbezeichnungListener" implementiert den ItemListener für "pnl_produktbez".
	 * 
	 * Die Auswahl die in der Combobox von pnl_produktbez gewählt wird, beeinflusst die Auswahlmöglichkeiten
	 * von pnl_trainer.
	 * 
	 * Jenachdem welche Produktbezeichnung gewählt wird, sind in pnl_trainer auch nur die Trainer auswählbar, die im 
	 * Objekt M_Trainer die ausgewählt Produktbezeichnung stehen haben.
	 * 
	 * Es muss an dieser Stelle der ItemListener von pnl_trainer entfernt und nach ausführung der Aktion wieder hinzugefügt werden,
	 * da dieser sonst beim auswählen einer Produktbezeichnung direkt mit ausgelöst wird.
	 * 
	 * Erst nachdem eine Auswahl getroffen wurde, kann man einen Trainer auswählen.
	 */		
	private class ProduktbezeichnungListener implements ItemListener {	
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED){

				pnl_trainer.getComboBox().removeItemListener(trainerlistener);

				if(pnl_produktbez.getComboBox().getSelectedIndex()>-1){

					arrayList_trainer.clear();
					pnl_trainer.removeItems();

					pnl_trainer.getComboBox().setEnabled(true);

					produkt = M_Produkt.getInterneListe().get(pnl_produktbez.getComboBox().getSelectedIndex());
					produkt.getTrainer().forEach(n -> arrayList_trainer.add(n.getVorname()+" "+n.getNachname()));

					textarea.setText(M_Produkt.getInterneListe().get(pnl_produktbez.getComboBox().getSelectedIndex()).getBeschreibung());

					System.out.println(arrayList_trainer);

					for(String item : arrayList_trainer){			
						pnl_trainer.getComboBox().addItem(item);			    		
					}
				}
				
				pnl_trainer.getComboBox().setSelectedIndex(-1);
				pnl_ort.getComboBox().setSelectedIndex(-1);
				pnl_trainer.getComboBox().addItemListener(trainerlistener);
			} 
		}
	}
	
	/**
	 * Die interne Klasse "TrainerListener" implementiert den ItemListener für "pnl_trainer".
	 * 
	 * Erst nachdem eine Auswahl getroffen wurde, kann man einen Ort auswählen.
	 * 
	 */
	private class TrainerListener implements ItemListener {	

		public void itemStateChanged(ItemEvent e) {

			if(e.getStateChange() == ItemEvent.SELECTED){
				if(pnl_trainer.getComboBox().getSelectedIndex()>-1){
					pnl_ort.getComboBox().setEnabled(true);

					trainer = produkt.getTrainer().get(pnl_trainer.getComboBox().getSelectedIndex());

				}
			}  
		}
	}
	
	/**
	 * Die interne Klasse "OrtListener" implementiert den ItemListener für "pnl_ort".
	 * 
	 * Erst nachdem eine Auswahl getroffen wurde, wird btn_ressourceaendern zum auswählen freigeschaltet.
	 * 
	 */
	private class OrtListener implements ItemListener {	

		public void itemStateChanged(ItemEvent e) {

			if(e.getStateChange() == ItemEvent.SELECTED){
				if(pnl_trainer.getComboBox().getSelectedIndex()>-1){
					btn_ressourceaendern.setEnabled(true);
					ort = M_Ort.getInterneListe().get((pnl_ort.getComboBox().getSelectedIndex()));
				}
			}  
		}
	}
}
