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

	private ArrayList<String>arrayList_produktbezeichnung = new ArrayList<String>();
	private ArrayList<String>arrayList_trainer = new ArrayList<String>();
	private ArrayList<String>arrayList_ort = new ArrayList<String>();

	private SimpleDropdownPanel pnl_produktbez;
	private SimpleDropdownPanel pnl_trainer;
	private SimpleDropdownPanel pnl_ort;

	private JLabel lbl_produktb = new JLabel("Produktbeschreibung:");
	private JTextArea textarea = new JTextArea();
	private JScrollPane area = new JScrollPane(textarea);

	private JButton btn_ressourceaendern = new JButton("Button");
	private JButton btn_zurueck = new JButton("Zurück zu Training ändern");

	private TrainerListener trainerlistener = new TrainerListener();

	private M_Produkt produkt = null;
	private M_Trainer trainer = null;
	private M_Ort ort = null;
	boolean success = false;

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
	public V_RessourceAendern(Object controller, M_Produkt produkt, M_Trainer trainer, M_Ort ort) {
		super(
				defaultSize,
				minSize,
				navigationText
				);
		this.setProdukt(produkt);
		this.setTrainer(trainer);
		this.setOrt(ort);
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
		if(getOrt() == null && getProdukt()==null&&getTrainer()==null) {
			pnl_produktbez.getComboBox().setSelectedIndex(-1);
			pnl_trainer.getComboBox().setSelectedIndex(-1);
			pnl_ort.getComboBox().setSelectedIndex(-1);

			pnl_trainer.getComboBox().setEnabled(false);
			pnl_ort.getComboBox().setEnabled(false);
		}
		else {
			pnl_produktbez.getComboBox().setSelectedItem(produkt.getBezeichnung());
			pnl_trainer.getComboBox().setSelectedItem(trainer.getVorname() + trainer.getNachname());
			pnl_ort.getComboBox().setSelectedItem(ort);
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
		if(controller instanceof C_TrainingAendern) {
			btn_ressourceaendern.setLabel("Ressource ändern");
			setSuccess(true);
		}
		if(controller instanceof C_TrainingKonfigurieren) {
			btn_ressourceaendern.setLabel("Ressource wählen");
			setSuccess(true);
		}
		
	
		btn_ressourceaendern.setEnabled(false);
		getPnl_menu().add(btn_ressourceaendern);
		getPnl_menu().add(btn_zurueck);	
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

	protected void resizeGUI() {
		int maxWidthTextBox = this.getWidth() - SimpleTextPanel.getLabelWidth() - (getPadding() * 2) - 25;
		int optimalButtonWidth = (int) super.getPnl_menu().getWidth() - 25;
		pnl_produktbez.setComboBoxFieldWidth(maxWidthTextBox / 2);
		pnl_trainer.setComboBoxFieldWidth(maxWidthTextBox / 2);
		pnl_ort.setComboBoxFieldWidth(maxWidthTextBox / 2);
		btn_ressourceaendern.setPreferredSize(new Dimension(optimalButtonWidth / 4 , btn_ressourceaendern.getPreferredSize().height));
		btn_zurueck.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_ressourceaendern.getPreferredSize().height));

	}

	private void initComboBox(){
		M_Produkt.getInterneListe().forEach(M_Produkt -> arrayList_produktbezeichnung.add(M_Produkt.getBezeichnung()));
		M_Ort.getInterneListe().forEach(M_Ort -> arrayList_ort.add(M_Ort.getOrtsID()+" , "+M_Ort.getGeschaefstsstelle()));		
	}

	/* Implementierung der ActionListener */

	public static void main(String [] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new Test_main();
		new V_RessourceAendern(controller);
	}

	// Getter und Setter

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

	// ActionListener Buttons

	public static Object getController() {
		return controller;
	}

	public static void setController(Object controller) {
		V_RessourceAendern.controller = controller;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
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



	private class RessourceWaehlen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			if(ort!=null&&produkt!=null&&trainer!=null) {
				
				if(controller instanceof C_TrainingAendern) {
					System.out.println("fuellenm");
					((C_TrainingAendern) controller).felderFuellen(produkt, trainer, ort);
					dispose();
				}
				if(controller instanceof C_TrainingKonfigurieren) {
					System.out.println("woobWOOB");
					((C_TrainingKonfigurieren) controller).felderFuellen(produkt, trainer, ort);
					dispose();
				}
				System.out.println("Ressource wählen!2");
			}
			
			System.out.println("Ressource wählen!");
		}
	}
	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Zurueck");
			SimpleSwitchFrame.switchFrame(thisView, C_TrainingAendern.getInstance(), C_TrainingAendern.getInstance().getView());
		}
	}	

	// ActionListener ComboBox

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