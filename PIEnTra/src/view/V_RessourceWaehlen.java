package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import controller.C_TrainingKonfigurieren;
import testdaten.Test_main;
import utils.SimpleDropdownPanel;
import utils.SimpleMasterWindow;
import utils.SimpleSearch;
import utils.SimpleSwitchFrame;
import utils.SimpleTextPanel;

/**
 * View von TrainingKonfigurieren.
 * @version 1.5 Dropdown Funktionen hinzugefügt
 * @version 1.4 Erbt nun von Superklasse {@link SimpleMasterWindow}.
 * @version 1.3 SimpleSwitchFrame implementiert.
 * @version 1.2 Listener aus Controller entfernt und in View implementiert.
 * @version 1.1 Listener in Controller hinzugefügt. Getter und Setter hinzugefügt.
 * @version 1.0 View implementiert. 
 * @author Adrian Fromm
 * @author Julian Klein
 * @see {@link controller.C_Hauptmenue};
 */
public class V_RessourceWaehlen extends SimpleMasterWindow {
	private static final long serialVersionUID = -6381551589496678636L;
	
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
	
	private JButton btn_ressourcewaehlen = new JButton("Ressource wählen");
	private JButton btn_zurueck = new JButton("Zurück zu Training konfigurieren");
	
	private M_Produkt produkt;
	
	private V_RessourceWaehlen thisView;
	
	/* Konstruktor und Methoden die vom Konstruktor aufgerufen werden. */
	
	/**
	 * Konstruktor der View RessourceWaehlen
	 */
	public V_RessourceWaehlen() {
		super(
			defaultSize,
			minSize,
			navigationText
		);
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
		getPnl_menu().add(btn_ressourcewaehlen);
		getPnl_menu().add(btn_zurueck);	
	}
	
	/**
	 * Initialisiert ActionListener
	 */
	private void initListener() {
		btn_ressourcewaehlen.addActionListener(new RessourceWaehlen());
		btn_zurueck.addActionListener(new Zurueck());
		pnl_produktbez.getComboBox().addActionListener(new DropdownListener());
	}
	
	protected void resizeGUI() {
		int maxWidthTextBox = this.getWidth() - SimpleTextPanel.getLabelWidth() - (getPadding() * 2) - 25;
		int optimalButtonWidth = (int) super.getPnl_menu().getWidth() - 25;
		pnl_produktbez.setComboBoxFieldWidth(maxWidthTextBox / 2);
		pnl_trainer.setComboBoxFieldWidth(maxWidthTextBox / 2);
		pnl_ort.setComboBoxFieldWidth(maxWidthTextBox / 2);
		btn_ressourcewaehlen.setPreferredSize(new Dimension(optimalButtonWidth / 4 , btn_ressourcewaehlen.getPreferredSize().height));
		btn_zurueck.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_ressourcewaehlen.getPreferredSize().height));
		
	}
	
	private void initComboBox(){
		M_Produkt.getInterneListe().forEach(M_Produkt -> arrayList_produktbezeichnung.add(M_Produkt.getBezeichnung()));
		M_Trainer.getInterneListe().forEach(M_Trainer -> arrayList_trainer.add(M_Trainer.getVorname() +" "+ M_Trainer.getNachname()));
		M_Ort.getInterneListe().forEach(M_Ort -> arrayList_ort.add(M_Ort.getOrtsID()+" , "+M_Ort.getGeschaefstsstelle()));
		//M_Ort.getInterneListe().forEach(M_Ort -> arrayList_ort.add(M_Ort.toString()));		
	}
	
	/* Implementierung der ActionListener */
	
	public static void main(String [] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new Test_main();
		new V_RessourceWaehlen();
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
	/*public void setText_pnl_produktbezeichnung(String text){
		this.pnl_produktbez.setText(text);
	}
	public void setText_pnl_trainer(String text){
		this.pnl_trainer.setText(text);
	}
	public void setText_pnl_prt(String text) {
		this.pnl_ort.setText(text);;
	}*/


	// ActionListener
	
	private class RessourceWaehlen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Ressource wählen!");
			//SimpleSwitchFrame.switchFrame(thisView, C_KundeSuchen.getInstance() , C_KundeSuchen.getInstance().getView());
			System.out.println(getText_pnl_produktbezeichnung());
			//produkt = SimpleSearch.produktSuchen(pnl_produktbez.getComboBox().getSelectedIndex(), M_Produkt.getInterneListe());
	    	
			
			//System.out.println(produkt.getBeschreibung());
		}
	}
	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Zurueck");
			SimpleSwitchFrame.switchFrame(thisView, C_TrainingKonfigurieren.getInstance(), C_TrainingKonfigurieren.getInstance().getView());
		}
	}	
	
	public class DropdownListener implements ActionListener {	
        
	    public void actionPerformed(ActionEvent e) {
	    	if(pnl_produktbez.getComboBox().getSelectedIndex()>-1){
	    	textarea.setText(M_Produkt.getInterneListe().get(pnl_produktbez.getComboBox().getSelectedIndex()).getBeschreibung());
	    	System.out.println(pnl_produktbez.getComboBox().getSelectedIndex());
//	    	pnl_trainer.getComboBox().enable(true);
//	    	pnl_ort
	    	}
	    
	    	
	    }
	}
}