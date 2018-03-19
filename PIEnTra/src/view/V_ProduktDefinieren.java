package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.C_Hauptmenue;
import utils.SimpleMasterWindow;
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
public class V_ProduktDefinieren extends SimpleMasterWindow {
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
	private tatic String navigationText = "Produkt definieren";
	
	JPanel pnl_produktbezeichnung;
	JPanel pnl_produktbeschreibung;
	JLabel lbl_produktbezeichnung = new JLabel("Produktbezeichnung:");
	JLabel lbl_produktbeschreibung = new JLabel("Produktbeschreibung:");
	JTextField txt_produktbezeichnung = new JTextField(35);
	JTextArea txt_produktbeschreibung = new JTextArea(20, 35);
	
	private JButton btn_produktdefinieren = new JButton("Produkt definieren");
	private JButton btn_zurueck = new JButton("Zurück zum Hauptmenü");
	
	private V_ProduktDefinieren thisView;
	
	/* Konstruktor und Methoden die vom Konstruktor aufgerufen werden. */
	
	/**
	 * Konstruktor der View Hauptmenue.
	 * Übergibt an die Superklasse die standard und minimal Größe, sowie aktuelle Pfadangaben der Navigationsleiste.
	 * Initialisiere dann den Content und lösche ein überflüssiges Element aus der im Hauptmenu nicht benutzten Menuleiste.
	 * Zuletzt werden die Listener initialisiert.
	 */
	public V_ProduktDefinieren() {
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
		pnl_content.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_produktbezeichnung = new JPanel();
		pnl_produktbezeichnung.setLayout(new FlowLayout());
		pnl_produktbezeichnung.add(lbl_produktbezeichnung);
		pnl_produktbezeichnung.add(txt_produktbezeichnung);
		FlowLayout flowlayout = new FlowLayout();
		flowlayout.setAlignOnBaseline(true);
		pnl_produktbeschreibung = new JPanel();
		pnl_produktbeschreibung.setLayout(flowlayout);
		pnl_produktbeschreibung.add(lbl_produktbeschreibung);
		pnl_produktbeschreibung.add(txt_produktbeschreibung);
		
		pnl_content.add(pnl_produktbezeichnung);
		pnl_content.add(pnl_produktbeschreibung);
		super.getPnl_center().add(pnl_content);
	}
	
	/**
	 * Initiailisert die Menu Buttons
	 */
	private void initMenu() {
		getPnl_menu().add(btn_produktdefinieren);
		getPnl_menu().add(btn_zurueck);
		
	}
	
	/**
	 * Initialisiert ActionListener
	 */
	private void initListener() {
		btn_produktdefinieren.addActionListener(new ProduktDefinieren());
		btn_zurueck.addActionListener(new Zurueck());
	}
	
	protected void resizeGUI() {
		int maxWidthTextBox = this.getWidth() - SimpleTextPanel.getLabelWidth() - (getPadding() * 2) - 25;
		int optimalButtonWidth = (int) super.getPnl_menu().getWidth() - 25;
		lbl_produktbezeichnung.setPreferredSize(new Dimension(SimpleTextPanel.getLabelWidth(), lbl_produktbezeichnung.getPreferredSize().height));
		lbl_produktbeschreibung.setPreferredSize(new Dimension(SimpleTextPanel.getLabelWidth(), lbl_produktbeschreibung.getPreferredSize().height));
		pnl_produktbezeichnung.setPreferredSize(new Dimension(maxWidthTextBox, txt_produktbezeichnung.getPreferredSize().height));
		pnl_produktbeschreibung.setPreferredSize(new Dimension(maxWidthTextBox, 400));
		btn_produktdefinieren.setPreferredSize(new Dimension(optimalButtonWidth / 4 , btn_produktdefinieren.getPreferredSize().height));
		btn_zurueck.setPreferredSize(new Dimension(optimalButtonWidth / 4, btn_produktdefinieren.getPreferredSize().height));
		
	}

	/* Implementierung der ActionListener */
	
	public static void main(String [] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new V_ProduktDefinieren();
	}
	
	// Getter und Setter
	public String getText_txt_produktbezeichnung(){
		return txt_produktbezeichnung.getText();
	}
	public String getText_txt_produktbeschreibung(){
		return txt_produktbeschreibung.getText();
	}
	public void setText_txt_produktbezeichnung(String text){
		txt_produktbezeichnung.setText(text);
	}
	public void setText_txt_produktbeschreibung(String text){
		txt_produktbeschreibung.setText(text);
	}
	
	// ActionListener
	
	private class ProduktDefinieren implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Produkt definieren!");
		}
	}
	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(thisView,C_Hauptmenue.getInstance(), C_Hauptmenue.getInstance().getView());
		}
	}
}