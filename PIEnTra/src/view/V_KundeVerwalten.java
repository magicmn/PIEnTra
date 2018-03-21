package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.C_Hauptmenue;
import controller.C_KundeSuchen;
import controller.C_KundeVerwalten;
import utils.SimpleMasterWindow;
import utils.SimpleSwitchFrame;
import utils.SimpleTextPanel;

/**
 * View von TrainingKonfigurieren.
 * @version 1.5 Kundensuchfunktion implementiert
 * @version 1.4 Erbt nun von Superklasse {@link SimpleMasterWindow}.
 * @version 1.3 SimpleSwitchFrame implementiert.
 * @version 1.2 Listener aus Controller entfernt und in View implementiert.
 * @version 1.1 Getter und Setter hinzugef�gt.
 * @version 1.0 View implementiert. 
 * @author Adrian Fromm
 * @author Julian Klein
 * @see {@link controller.C_Hauptmenue};
 */
public class V_KundeVerwalten extends SimpleMasterWindow {
	private static final long serialVersionUID = -6381551589496678636L;
	
	/* Deklaration und Initailiserung von verschiedenen Variablen **/
	
	/** 
	 * Standard Gr��e des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	public static Dimension defaultSize = new Dimension(850, 450);
	/** 
	 * Minimale Gr��e des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	private static Dimension minSize = new Dimension(700, 200);
	/**
	 * Text der in der Naviagtionsleiste ausgegebn wird.
	 * @see SimpleMasterWindow#initSouth(String navigationText)
	 */
	private static String navigationText = "Training konfigurieren / Kunde w�hlen";
	
	private SimpleTextPanel pnl_kundenID = new SimpleTextPanel("Kunden-ID:");
	private SimpleTextPanel pnl_firmenname = new SimpleTextPanel("Firmenname:");
	private SimpleTextPanel pnl_ansprechpartner = new SimpleTextPanel("Ansprechpartner:");
	private SimpleTextPanel pnl_branche = new SimpleTextPanel("Branche:");
	private SimpleTextPanel pnl_email = new SimpleTextPanel("E-Mail:");
	private SimpleTextPanel pnl_rufnummer = new SimpleTextPanel("Rufnummer:");
	private JLabel lbl_adresse = new JLabel("Adresse");
	private SimpleTextPanel pnl_strasse = new SimpleTextPanel("Strasse:");
	private SimpleTextPanel pnl_postleitzahl = new SimpleTextPanel("Postleitzahl:");
	private SimpleTextPanel pnl_bundesland = new SimpleTextPanel("Bundesland:");
	private SimpleTextPanel pnl_stadt = new SimpleTextPanel("Stadt:");
	private JOptionPane popup = new JOptionPane();
	
	private JButton btn_kundeSuchen = new JButton("Kunde suchen");
	private JButton btn_kundeAktualisieren = new JButton("Kunde aktualisieren");
	private JButton btn_kundeAnlegen = new JButton("Kunde anlegen");
	private JButton btn_zurueck = new JButton("Zur�ck zum Hauptmenu");
	
	private V_KundeVerwalten thisView;
	
	/* Konstruktor und Methoden die vom Konstruktor aufgerufen werden. */
	
	/**
	 * Konstruktor der View Kunde verwalten.
	 * �bergibt an die Superklasse die standard und minimal Gr��e, sowie aktuelle Pfadangaben der Navigationsleiste.
	 * Initialisiere dann den Content und l�sche ein �berfl�ssiges Element aus der im Hauptmenu nicht benutzten Menuleiste.
	 * Zuletzt werden die Listener initialisiert.
	 */
	public V_KundeVerwalten() {
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
		pnl_content.setLayout(new GridLayout(11, 1));
		pnl_content.setAlignmentY(LEFT_ALIGNMENT);
		pnl_content.add(pnl_kundenID);
		pnl_content.add(pnl_firmenname);
		pnl_content.add(pnl_ansprechpartner);
		pnl_content.add(pnl_branche);
		pnl_content.add(pnl_email);
		pnl_content.add(pnl_rufnummer);
		pnl_content.add(lbl_adresse);
		pnl_content.add(pnl_strasse);
		pnl_content.add(pnl_postleitzahl);
		pnl_content.add(pnl_bundesland);
		pnl_content.add(pnl_stadt);
		super.getPnl_center().add(pnl_content);
	}
	
	/**
	 * Initiailisert die Menu Buttons
	 */
	private void initMenu() {
		getPnl_menu().add(btn_kundeSuchen);
		getPnl_menu().add(btn_kundeAktualisieren);
		getPnl_menu().add(btn_kundeAnlegen);
		getPnl_menu().add(btn_zurueck);
		
	}
	
	/**
	 * Initialisiert ActionListener
	 */
	private void initListener() {
		btn_kundeSuchen.addActionListener(new KundeSuchen());
		btn_kundeAktualisieren.addActionListener(new KundeAktualisieren());
		btn_kundeAnlegen.addActionListener(new KundeAnlegen());
		btn_zurueck.addActionListener(new Zurueck());
	}
	
	protected void resizeGUI() {
		int maxWidthTextBox = this.getWidth() - SimpleTextPanel.getLabelWidth() - (getPadding() * 2) - 25;
		int optimalButtonWidth = (int) super.getPnl_menu().getWidth() - 25;
		pnl_kundenID.setTextFieldWidth(maxWidthTextBox / 4);
		pnl_firmenname.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_ansprechpartner.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_branche.setTextFieldWidth(maxWidthTextBox / 4);
		pnl_email.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_rufnummer.setTextFieldWidth(maxWidthTextBox / 2);
		lbl_adresse.setPreferredSize(new Dimension(SimpleTextPanel.getLabelWidth(), lbl_adresse.getPreferredSize().height));
		pnl_strasse.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_postleitzahl.setTextFieldWidth(maxWidthTextBox / 4);
		pnl_bundesland.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_stadt.setTextFieldWidth(maxWidthTextBox / 2);
		btn_kundeSuchen.setPreferredSize(new Dimension(optimalButtonWidth / 4 , btn_kundeSuchen.getPreferredSize().height));
		btn_kundeAktualisieren.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_kundeSuchen.getPreferredSize().height));
		btn_kundeAnlegen.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_kundeSuchen.getPreferredSize().height));
		btn_zurueck.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_kundeSuchen.getPreferredSize().height));
		
	}

	/* Implementierung der ActionListener */
	
	public static void main(String [] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new V_KundeVerwalten();
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
	public String getText_pnl_branche() {
		return pnl_branche.getText();
	}
	public String getText_pnl_email() {
		return pnl_email.getText();
	}
	public String getText_pnl_rufnummer() {
		return pnl_rufnummer.getText();
	}
	public String getText_pnl_strasse() {
		return pnl_strasse.getText();
	}
	public String getText_pnl_plz() {
		return pnl_postleitzahl.getText();
	}
	public String getText_pnl_bundesland() {
		return pnl_bundesland.getText();
	}
	public String getText_pnl_stadt() {
		return pnl_stadt.getText();
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
	public void setText_pnl_branche(String text) {
		this.pnl_branche.setText(text);
	}
	public void setText_pnl_email(String text) {
		this.pnl_email.setText(text);
	}
	public void setText_pnl_rufnummer(String text) {
		this.pnl_rufnummer.setText(text);
	}
	public void setText_pnl_strasse(String text) {
		this.pnl_strasse.setText(text);
	}
	public void setText_pnl_plz(String text) {
		this.pnl_postleitzahl.setText(text);
	}
	public void setText_pnl_bundesland(String text) {
		this.pnl_bundesland.setText(text);
	}
	public void setText_pnl_stadt(String text) {
		this.pnl_stadt.setText(text);
	}
	// ActionListener
	
	private class KundeSuchen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Kunde suchen!");
			C_KundeSuchen.getInstance(C_KundeVerwalten.getInstance()).getView().setVisible(true);
		}
	}
	private class KundeAktualisieren implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(C_KundeVerwalten.getInstance().checkKundeAktualisieren()==false){
				popup.showMessageDialog(null, "Bitte f�llen Sie alle Felder aus!");
			}
			else{
			C_KundeVerwalten.getInstance().kundeAktualisieren();
			}
		}
	}
	private class KundeAnlegen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			C_KundeVerwalten.getInstance().kundeAnlegen();
			System.out.println("Kunde anlegen!");
		}
	}
	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(thisView, C_Hauptmenue.getInstance(), C_Hauptmenue.getInstance().getView());
		}
	}
}