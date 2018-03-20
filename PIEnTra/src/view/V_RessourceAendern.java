package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import model.M_Adresse;
import model.M_Ort;
import model.M_Person;
import model.M_Produkt;
import model.M_Trainer;
import model.M_Training;
import controller.C_KundeSuchen;
import controller.C_TrainingAendern;
import controller.C_TrainingKonfigurieren;
import testdaten.Test_main;
import utils.SimpleDropdownPanel;
import utils.SimpleMasterWindow;
import utils.SimpleSwitchFrame;
import utils.SimpleTextPanel;

/**
 * View von TrainingKonfigurieren.
 * @version 1.5 Dropdown Funktionen hinzugef�gt
 * @version 1.4 Erbt nun von Superklasse {@link SimpleMasterWindow}.
 * @version 1.3 SimpleSwitchFrame implementiert.
 * @version 1.2 Listener aus Controller entfernt und in View implementiert.
 * @version 1.1 Listener in Controller hinzugef�gt. Getter und Setter hinzugef�gt.
 * @version 1.0 View implementiert. 
 * @author Adrian Fromm
 * @author Julian Klein
 * @see {@link controller.C_Hauptmenue};
 */
public class V_RessourceAendern extends SimpleMasterWindow {
	private static final long serialVersionUID = -6381551589496678636L;
	
	/* Deklaration und Initailiserung von verschiedenen Variablen **/
	
	/** 
	 * Standard Gr��e des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	public static Dimension defaultSize = new Dimension(700, 235);
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
	
	private JButton btn_ressourceaendern = new JButton("Ressource �ndern");
	private JButton btn_zurueck = new JButton("Zur�ck zu Training �ndern");
	
	private V_RessourceAendern thisView;
	
	/* Konstruktor und Methoden die vom Konstruktor aufgerufen werden. */
	
	/**
	 * Konstruktor der View Hauptmenue.
	 * �bergibt an die Superklasse die standard und minimal Gr��e, sowie aktuelle Pfadangaben der Navigationsleiste.
	 * Initialisiere dann den Content und l�sche ein �berfl�ssiges Element aus der im Hauptmenu nicht benutzten Menuleiste.
	 * Zuletzt werden die Listener initialisiert.
	 */
	public V_RessourceAendern() {
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
		getPnl_menu().add(btn_ressourceaendern);
		getPnl_menu().add(btn_zurueck);
		
	}
	
	/**
	 * Initialisiert ActionListener
	 */
	private void initListener() {
		btn_ressourceaendern.addActionListener(new RessourceAendern());
		btn_zurueck.addActionListener(new Zurueck());
		pnl_produktbez.getComboBox().addActionListener(new DropdownListener());
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
		new V_RessourceAendern();
		
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
	
	private class RessourceAendern implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("RessourceAendern!");
			System.out.println(pnl_produktbez.getText());
			//SimpleSwitchFrame.switchFrame(thisView, C_KundeSuchen.getInstance() , C_KundeSuchen.getInstance().getView());
		}
	}
	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Zurueck");
			SimpleSwitchFrame.switchFrame(thisView, C_TrainingAendern.getInstance(), C_TrainingAendern.getInstance().getView());
		}
	}	
	
	public class DropdownListener implements ActionListener {	
        
	    public void actionPerformed(ActionEvent e) {

	    	System.out.println(pnl_produktbez.getComboBox().getSelectedIndex());
	    	//textarea.setText(arrayList_produktbezeichnung.);
	    	
	    }
	}

}