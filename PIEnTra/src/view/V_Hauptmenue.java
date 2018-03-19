package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.C_KundeVerwalten;
import controller.C_ProduktDefinieren;
import controller.C_TrainingAendern;
import controller.C_TrainingKonfigurieren;
import controller.C_TrainingLoeschen;
import utils.SimpleButtonPanel;
import utils.SimpleMasterWindow;
import utils.SimpleSwitchFrame;

/**
 * View des Hauptmenüs.
 * @version 1.4 Erbt nun von Superklasse {@link SimpleMasterWindow}.
 * @version 1.3 SimpleSwitchFrame implementiert.
 * @version 1.2 Listener in View hinzugefügt.
 * @version 1.1 Listener aus Controller entfernt.
 * @version 1.0 Layout implementiert.
 * @author Adrian Fromm
 * @author Julian Klein
 * @author Konstantin Frei
 * @see {@link controller.C_Hauptmenue};
 */
public class V_Hauptmenue extends SimpleMasterWindow {
	private static final long serialVersionUID = -4276905167099065492L;
	
	/* Deklaration und Initailiserung von verschiedenen Variablen **/
	
	/** 
	 * Standard Größe des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	public static Dimension defaultSize = new Dimension(800, 350);
	/** 
	 * Minimale Größe des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	private static Dimension minSize = new Dimension(700, 200);
	/**
	 * Text der in der Naviagtionsleiste ausgegebn wird.
	 * @see SimpleMasterWindow#initSouth(String navigationText)
	 */
	private static String navigationText = "Hauptmenu";
	
	private SimpleButtonPanel pnl_TrainingKonfigurieren = new SimpleButtonPanel("Training konfigurieren");
	private SimpleButtonPanel pnl_TrainingAendern = new SimpleButtonPanel("Training ändern");
	private SimpleButtonPanel pnl_KundeVerwalten = new SimpleButtonPanel("Kunde verwalten");
	private SimpleButtonPanel pnl_TrainingLoeschen = new SimpleButtonPanel("Training löschen");
	private SimpleButtonPanel pnl_PIEnTraVerlassen = new SimpleButtonPanel("PIEnTra verlassen");
	private SimpleButtonPanel pnl_ProdukteDefinieren = new SimpleButtonPanel("Produkte definieren");
	
	private V_Hauptmenue thisView;
	
	/* Konstruktor und Methoden die vom Konstruktor aufgerufen werden. */
	
	/**
	 * Konstruktor der View Hauptmenue.
	 * Übergibt an die Superklasse die standard und minimal Größe, sowie aktuelle Pfadangaben der Navigationsleiste.
	 * Initialisiere dann den Content und lösche ein überflüssiges Element aus der im Hauptmenu nicht benutzten Menuleiste.
	 * Zuletzt werden die Listener initialisiert.
	 */
	public V_Hauptmenue() {
		super(
			defaultSize,
			minSize,
			navigationText
		);
		this.thisView = this;
		initContent();
		initMenu();
		initListener();
		this.setVisible(true);
	}

	/**
	 * Initialisiere den Inhalt des Centers.
	 */
	private void initContent() {
		getPnl_center().setLayout(new FlowLayout());
		JPanel pnl_content = new JPanel();
		pnl_content.setLayout(new GridLayout(1, 4));
		pnl_content.setBorder(BorderFactory.createEmptyBorder(getPadding() * 2, getPadding(), 0, getPadding())); //Zusätlicher Abstand der nur im Hauptmenü benötigt wird.
		pnl_content.setPreferredSize(new Dimension(700, 150));
		pnl_content.add(pnl_TrainingKonfigurieren);
		JPanel pnl_layoutHelperLeft = new JPanel();
		pnl_layoutHelperLeft.setLayout(new GridLayout(2, 1));
		pnl_layoutHelperLeft.add(pnl_TrainingAendern);
		pnl_layoutHelperLeft.add(pnl_KundeVerwalten);
		pnl_content.add(pnl_layoutHelperLeft);
		JPanel pnl_layoutHelperRight = new JPanel();
		pnl_layoutHelperRight.setLayout(new GridLayout(2, 1));
		pnl_layoutHelperRight.add(pnl_TrainingLoeschen);
		pnl_layoutHelperRight.add(pnl_PIEnTraVerlassen);
		pnl_content.add(pnl_layoutHelperRight);
		pnl_content.add(pnl_ProdukteDefinieren);
		super.getPnl_center().add(pnl_content);
	}
	
	/**
	 * Löscht ein für das Hauptmenü überflüssiges Panel.
	 * @see SimpleMasterWindow#removePnl_menu()
	 */
	private void initMenu() {
		super.removePnl_menu();
	}
	
	/**
	 * Initialisiert ActionListener
	 */
	private void initListener() {
		pnl_TrainingKonfigurieren.addActionListener(new TrainingKonfigurieren());
		pnl_TrainingAendern.addActionListener(new TrainingAendern());
		pnl_KundeVerwalten.addActionListener(new KundeVerwalten());
		pnl_TrainingLoeschen.addActionListener(new TrainingLoeschen());
		pnl_PIEnTraVerlassen.addActionListener((ActionListener) new backAction());
		pnl_ProdukteDefinieren.addActionListener(new ProdukteDefinieren());
	}

	/* Implementierung der ActionListener */
	
	public static void main(String [] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new V_Hauptmenue();
	}
	
	private class TrainingKonfigurieren implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {		
			SimpleSwitchFrame.switchFrame(thisView, C_TrainingKonfigurieren.getInstance(), C_TrainingKonfigurieren.getInstance().getView());
		}
	}
	
	private class TrainingAendern implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(thisView, C_TrainingAendern.getInstance(),  C_TrainingAendern.getInstance().getView());
		}
	}
	
	private class TrainingLoeschen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(thisView, C_TrainingLoeschen.getInstance(), C_TrainingLoeschen.getInstance().getView());
		}
	}
	
	private class KundeVerwalten implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(thisView, C_KundeVerwalten.getInstance(), C_KundeVerwalten.getInstance().getView());
		}
	}
	
	private class ProdukteDefinieren implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(thisView,  C_ProduktDefinieren.getInstance(), C_ProduktDefinieren.getInstance().getView());
		}
	}
	
	private class backAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
}