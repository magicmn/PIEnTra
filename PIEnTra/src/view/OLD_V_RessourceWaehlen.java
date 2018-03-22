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
import controller.C_TrainingKonfigurieren;
import testdaten.Test_main;
import utils.SimpleDropdownPanel;
import utils.SimpleMasterWindow;
import utils.SimpleSwitchFrame;
import utils.SimpleTextPanel;

/**
 * View von RessourceWaehlen.
 * @version 1.2 Dropdown Funktionen hinzugef�gt.
 * @version 1.1 Listener hinzugef�gt. Getter und Setter hinzugef�gt.
 * @version 1.0 View implementiert. 
 * @author Adrian Fromm
 * @see {@link controller.C_Hauptmenue};
 */
public class OLD_V_RessourceWaehlen extends SimpleMasterWindow {
	private static final long serialVersionUID = -6381551589496678636L;
	
	/* Deklaration und Initailiserung von verschiedenen Variablen **/
	
	/** 
	 * Standard Gr��e des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	public static Dimension defaultSize = new Dimension(720, 240);
	/** 
	 * Minimale Gr��e des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	private static Dimension minSize = new Dimension(700, 235);
	/**
	 * Text der in der Naviagtionsleiste ausgegebn wird.
	 * @see SimpleMasterWindow#initSouth(String navigationText)
	 */
	private static String navigationText = "Training konfigurieren / Kunde w�hlen";
	
	private ArrayList<String>arrayList_produktbezeichnung = new ArrayList<String>();
	private ArrayList<String>arrayList_trainer = new ArrayList<String>();
	private ArrayList<String>arrayList_ort = new ArrayList<String>();
	
	private SimpleDropdownPanel pnl_produktbez;
	private SimpleDropdownPanel pnl_trainer;
	private SimpleDropdownPanel pnl_ort;
	
	private JLabel lbl_produktb = new JLabel("Produktbeschreibung:");
	private JTextArea textarea = new JTextArea();
	private JScrollPane area = new JScrollPane(textarea);
	
	private JButton btn_ressourcewaehlen = new JButton("Ressource w�hlen");
	private JButton btn_zurueck = new JButton("Zur�ck zu Training konfigurieren");
	
	private TrainerListener trainerlistener = new TrainerListener();
	
	private M_Produkt produkt;
	
	private OLD_V_RessourceWaehlen thisView;
	
	/* Konstruktor und Methoden die vom Konstruktor aufgerufen werden. */
	
	/**
	 * Konstruktor der View RessourceWaehlen
	 */
	public OLD_V_RessourceWaehlen() {
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
		
		pnl_trainer.getComboBox().setEnabled(false);
		pnl_ort.getComboBox().setEnabled(false);
		
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
		btn_ressourcewaehlen.setEnabled(false);
		getPnl_menu().add(btn_ressourcewaehlen);
		getPnl_menu().add(btn_zurueck);	
	}
	
	/**
	 * Initialisiert ActionListener
	 */
	private void initListener() {
		btn_ressourcewaehlen.addActionListener(new RessourceWaehlen());
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
		btn_ressourcewaehlen.setPreferredSize(new Dimension(optimalButtonWidth / 4 , btn_ressourcewaehlen.getPreferredSize().height));
		btn_zurueck.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_ressourcewaehlen.getPreferredSize().height));
		
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
		new OLD_V_RessourceWaehlen();
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
	
	private class RessourceWaehlen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Ressource w�hlen!");
		}
	}
	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Zurueck");
			SimpleSwitchFrame.switchFrame(thisView, C_TrainingKonfigurieren.getInstance(), C_TrainingKonfigurieren.getInstance().getView());
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
		    	}
         	}  
		}
	}
	
	private class OrtListener implements ItemListener {	
        
		public void itemStateChanged(ItemEvent e) {
			
			if(e.getStateChange() == ItemEvent.SELECTED){
				if(pnl_trainer.getComboBox().getSelectedIndex()>-1){
		    		btn_ressourcewaehlen.setEnabled(true);
		    	}
         	}  
		}
	}
}