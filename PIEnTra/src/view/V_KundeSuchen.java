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

import controller.C_KundeVerwalten;
import controller.C_KundeWaehlen;
import model.M_Kunde;
import utils.SimpleMasterWindow;
import utils.SimpleSearch;
import utils.SimpleTextPanel;

/**
 * View von TrainingKonfigurieren.
 * @version 1.5 von mehreren controllern wiederverwendbar durch Konstruktorerweiterung
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
public class V_KundeSuchen extends SimpleMasterWindow {
	private static final long serialVersionUID = -6381551589496678636L;

	/* Deklaration und Initailiserung von verschiedenen Variablen **/

	/** 
	 * Standard Größe des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	public static Dimension defaultSize = new Dimension(400, 180);
	/** 
	 * Minimale Größe des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	private static Dimension minSize = new Dimension(400, 180);
	/**
	 * Text der in der Naviagtionsleiste ausgegebn wird.
	 * @see SimpleMasterWindow#initSouth(String navigationText)
	 */
	private static String navigationText = "";

	private SimpleTextPanel pnl_kundenID = new SimpleTextPanel("Kunden-ID:");
	private SimpleTextPanel pnl_firmenname = new SimpleTextPanel("Firmenname:");

	private JButton btn_kundeSuchen = new JButton("Kunde suchen");
	private JButton btn_abbrechen = new JButton("Abrechen");

	private M_Kunde kunde;
	private static Object controller;

	/* Konstruktor und Methoden die vom Konstruktor aufgerufen werden. */

	/**
	 * Konstruktor der View Hauptmenue.
	 * Übergibt an die Superklasse die standard und minimal Größe, sowie aktuelle Pfadangaben der Navigationsleiste.
	 * Initialisiere dann den Content und lösche ein überflüssiges Element aus der im Hauptmenu nicht benutzten Menuleiste.
	 * Zuletzt werden die Listener initialisiert.
	 */
	public V_KundeSuchen(Object controller) {
		super(
				defaultSize,
				minSize,
				navigationText
				);
		initContent();
		initMenu();
		initListener();
		resizeGUI();
		this.controller = controller;
		this.setVisible(true);
	}

	

	/**
	 * Initialisiere den Inhalt des Centers.
	 */
	private void initContent() {
		JPanel pnl_content = new JPanel();
		pnl_content.setLayout(new GridLayout(2, 1));
		pnl_content.setAlignmentY(LEFT_ALIGNMENT);
		pnl_content.add(pnl_kundenID);
		pnl_content.add(pnl_firmenname);
		super.getPnl_center().add(pnl_content);
	}

	/**
	 * Initiailisert die Menu Buttons
	 */
	private void initMenu() {
		getPnl_menu().add(btn_kundeSuchen);
		getPnl_menu().add(btn_abbrechen);
	}

	/**
	 * Initialisiert ActionListener
	 */
	private void initListener() {
		btn_kundeSuchen.addActionListener(new KundeSuchen());
		btn_abbrechen.addActionListener(new Abbrechen());
	}

	protected void resizeGUI() {
		int maxWidthTextBox = this.getWidth() - SimpleTextPanel.getLabelWidth() - (getPadding() * 2) - 25;
		int optimalButtonWidth = (int) super.getPnl_menu().getWidth() - 25;
		pnl_kundenID.setTextFieldWidth(maxWidthTextBox / 2);
		pnl_firmenname.setTextFieldWidth(maxWidthTextBox);
		btn_kundeSuchen.setPreferredSize(new Dimension(optimalButtonWidth / 2 , btn_kundeSuchen.getPreferredSize().height));
		btn_abbrechen.setPreferredSize(new Dimension(optimalButtonWidth / 2, btn_kundeSuchen.getPreferredSize().height));
	}

	/* Implementierung der ActionListener */

	public static void main(String [] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new V_KundeSuchen(controller);
	}

	// Getter und Setter

	public String getText_pnl_kundenID(){
		return pnl_kundenID.getText();
	}
	public String getText_pnl_firmenname(){
		return pnl_firmenname.getText();
	}
	public void setText_pnl_kundenID(String text){
		this.pnl_kundenID.setText(text);
	}
	public void setText_pnl_firmenname(String text){
		this.pnl_firmenname.setText(text);
	}
	public JButton txt(){
		return btn_kundeSuchen;
	}
	// ActionListener

	private class KundeSuchen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			//implementation der Suchfunktion

			try {
				if(!getText_pnl_firmenname().equals("") && !getText_pnl_kundenID().equals("")) {
					System.out.println("Bitte nur ein Feld aussfüllen");		
					kunde = null;
				}
				else if(getText_pnl_firmenname().equals("") && getText_pnl_kundenID().equals("")) {
					System.out.println("Bitte eins der Felder ausfüllen");
					kunde = null;
				}
				else if(getText_pnl_firmenname().equals("") && !getText_pnl_kundenID().equals("")) {
					kunde = SimpleSearch.kundeSuchen(getText_pnl_kundenID(), M_Kunde.getInterneListe());
				}
				else if(!getText_pnl_firmenname().equals("") && getText_pnl_kundenID().equals("")) {
					kunde = SimpleSearch.kundeSuchen(getText_pnl_firmenname(), M_Kunde.getInterneListe());
				}

			}
			catch ( NoSuchElementException e){
				JOptionPane popup = new JOptionPane();
				popup.showMessageDialog(null, "Es wurde kein Kunde gefunden");
				kunde = null;

			}
			finally {
				if(kunde!=null) {
					if(controller instanceof C_KundeVerwalten) {
						C_KundeVerwalten.getInstance().setKunde(kunde);
						C_KundeVerwalten.getInstance().felderFuellen();
						dispose();
					}
					if(controller instanceof C_KundeWaehlen) {
						C_KundeWaehlen.getInstance().setKunde(kunde);
						C_KundeWaehlen.getInstance().felderFuellen();
						dispose();
					}
				}
			}	
		}
	}
	private class Abbrechen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Abbrechen");
			dispose();
		}
	}

	public M_Kunde getKunde() {
		return kunde;
	}
	public void setKunde(M_Kunde kunde) {
		this.kunde = kunde;
	}
}