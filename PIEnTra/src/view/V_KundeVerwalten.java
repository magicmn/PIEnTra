/**
 * Aktuelle Version: 1.3 
 * Authoren: Adrian 
 * 
 * Changelog:
 * 
 * 1.3
 * 		-SimpleSwitchFrame implementiert!
 * 1.2
 * 		-ActionListener hinzugef�gt!
 * 1.1
 * 		-Get / Set hinzugef�gt!
 * 1.0 	
 * 		-View erstellt!
 * 
 **/

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.M_Kunde;
import controller.C_Hauptmenue;
import controller.C_KundeSuchen;
import controller.C_KundeVerwalten;
import utils.SimpleSwitchFrame;
import utils.SimpleTextPanel;

public class V_KundeVerwalten extends JFrame {
	
	private JPanel pnl_center;
	private SimpleTextPanel pnl_kundenID = new SimpleTextPanel("Kunden-ID:");
	private SimpleTextPanel pnl_firmenname = new SimpleTextPanel("Firmenname:");
	private SimpleTextPanel pnl_ansprechpartner = new SimpleTextPanel("Ansprechpartner:");
	private SimpleTextPanel pnl_branche = new SimpleTextPanel("Branche:");
	private SimpleTextPanel pnl_email = new SimpleTextPanel("Email:");
	private SimpleTextPanel pnl_rufnummer = new SimpleTextPanel("Rufnummer:");
	private SimpleTextPanel pnl_addresse = new SimpleTextPanel("Addresse");
	private SimpleTextPanel pnl_strasse = new SimpleTextPanel("Stra�e:");
	private SimpleTextPanel pnl_plz = new SimpleTextPanel("Postleitzahl:");
	private SimpleTextPanel pnl_bundesland = new SimpleTextPanel("Bundesland:");
	private SimpleTextPanel pnl_stadt = new SimpleTextPanel("Stadt:");
	
	private JPanel pnl_south;
	private JButton btn_kundesuchen = new JButton("Kunde suchen");
	private JButton btn_kundeaktualisieren = new JButton("Kunde aktualisieren");
	private JButton btn_kundeanlegen = new JButton("Neuen Kunden anlegen");
	private JButton btn_zurueck = new JButton("Zur�ck zum Hauptmen�");
	private JTextField txt_navigation;
	
	private C_KundeSuchen suchview;
	public V_KundeVerwalten thisView;
	
	public V_KundeVerwalten() {
		this.thisView = this;
		initView();
		resizeGUI();
		initListener();
		this.setVisible(true);
	}

	private void initView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setSize(750, 490); // Optimale Gr��e die beim Starten geladen wird.
		this.setMinimumSize(new Dimension(500, 400)); // Um zu verhindern, dass der DAU sich wundert warum das Fenster auf einmal "weg" ist.
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null); // Zentriert Frame in der Mitte des Bildschirms.
		this.addComponentListener(new ResizeListener());  // F�gt Listener f�r Frame ver�nderungen hinzu.
		
		pnl_addresse.getTxtField().setVisible(false);
		pnl_addresse.setBorder(new EmptyBorder(8,0,0,0));
		
		pnl_center = new JPanel(new GridLayout(11, 1, 2 ,2));
		pnl_center.add(pnl_kundenID);
		pnl_center.add(pnl_firmenname);
		pnl_center.add(pnl_ansprechpartner);
		pnl_center.add(pnl_branche);
		pnl_center.add(pnl_email);
		pnl_center.add(pnl_rufnummer);
		pnl_center.add(pnl_addresse);
		pnl_center.add(pnl_strasse);
		pnl_center.add(pnl_plz);
		pnl_center.add(pnl_bundesland);
		pnl_center.add(pnl_stadt);
		this.add(BorderLayout.CENTER, pnl_center);
		pnl_kundenID.getTxtField().setEditable(false);
		
		pnl_south = new JPanel(new GridLayout(2, 1));
		JPanel pnl_south_top = new JPanel(new GridLayout(1, 4));
		pnl_south_top.setBorder(new EmptyBorder(10,8,5,10));
		pnl_south_top.add(btn_kundesuchen);
		pnl_south_top.add(btn_kundeaktualisieren);
		pnl_south_top.add(btn_kundeanlegen);
		pnl_south_top.add(btn_zurueck);
		
		pnl_south.add(pnl_south_top);
		JPanel pnl_south_bottom = new JPanel(new FlowLayout());
		pnl_south_bottom.add(txt_navigation = new JTextField("PIEnTra / Kunde verwalten"));
		txt_navigation.setFocusable(false);
		pnl_south.add(pnl_south_bottom);
		this.add(BorderLayout.SOUTH, pnl_south);
	}
	
	/** Enth�lt variable G��en **/
	private void resizeGUI() {
		txt_navigation.setPreferredSize(new Dimension(this.getWidth() - 30, txt_navigation.getPreferredSize().height));
		pnl_kundenID.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_firmenname.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_ansprechpartner.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_branche.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_email.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_rufnummer.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_strasse.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_plz.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_bundesland.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_stadt.setTxtField_Size((pnl_center.getWidth() / 2));
	}
	
	private void initListener(){
		btn_kundesuchen.addActionListener(new KundeSuchen());
		btn_kundeaktualisieren.addActionListener(new KundeAktualisieren());
		btn_kundeanlegen.addActionListener(new KundeAnlegen());
		btn_zurueck.addActionListener(new Zurueck());
	}
	
	class ResizeListener implements ComponentListener {
		public void componentResized(ComponentEvent arg0) {
			resizeGUI();
		}
		public void componentHidden(ComponentEvent arg0) {}
		public void componentMoved(ComponentEvent arg0) {}
		public void componentShown(ComponentEvent arg0) {}
	}
	
	// Get und Set
	
	public String getText_pnl_kundenID(){
		return pnl_kundenID.getString();
	}
	public String getText_pnl_firmenname(){
		return pnl_firmenname.getString();
	}
	public String getText_pnl_ansprechpartner() {
		return pnl_ansprechpartner.getString();
	}
	public String getText_pnl_branche() {
		return pnl_branche.getString();
	}
	public String getText_pnl_email() {
		return pnl_email.getString();
	}
	public String getText_pnl_rufnummer() {
		return pnl_rufnummer.getString();
	}
	public String getText_pnl_strasse() {
		return pnl_strasse.getString();
	}
	public String getText_pnl_plz() {
		return pnl_plz.getString();
	}
	public String getText_pnl_bundesland() {
		return pnl_bundesland.getString();
	}
	public String getText_pnl_stadt() {
		return pnl_stadt.getString();
	}
	
	//------------------------------------------------------
	
	public void setText_pnl_kundenID(String text){
		this.pnl_kundenID.setString(text);
	}
	public void setText_pnl_firmenname(String text){
		this.pnl_firmenname.setString(text);
	}
	public void setText_pnl_ansprechpartner(String text) {
		this.pnl_ansprechpartner.setString(text);;
	}
	public void setText_pnl_branche(String text) {
		this.pnl_branche.setString(text);
	}
	public void setText_pnl_email(String text) {
		this.pnl_email.setString(text);
	}
	public void setText_pnl_rufnummer(String text) {
		this.pnl_rufnummer.setString(text);
	}
	public void setText_pnl_strasse(String text) {
		this.pnl_strasse.setString(text);
	}
	public void setText_pnl_plz(String text) {
		this.pnl_plz.setString(text);
	}
	public void setText_pnl_bundesland(String text) {
		this.pnl_bundesland.setString(text);
	}
	public void setText_pnl_stadt(String text) {
		this.pnl_stadt.setString(text);
	}
	
	//Action Listener

	private class KundeSuchen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Kunde suchen!");
			C_KundeSuchen.getInstance().getView().setVisible(true);;
		}
	}
	private class KundeAktualisieren implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			C_KundeVerwalten.getInstance().kundeAktualisieren();
			System.out.println("Kunde aktualisieren!");
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

	public JPanel getPnl_center() {
		return pnl_center;
	}

	public void setPnl_center(JPanel pnl_center) {
		this.pnl_center = pnl_center;
	}

	public SimpleTextPanel getPnl_kundenID() {
		return pnl_kundenID;
	}

	public void setPnl_kundenID(SimpleTextPanel pnl_kundenID) {
		this.pnl_kundenID = pnl_kundenID;
	}

	public SimpleTextPanel getPnl_firmenname() {
		return pnl_firmenname;
	}

	public void setPnl_firmenname(SimpleTextPanel pnl_firmenname) {
		this.pnl_firmenname = pnl_firmenname;
	}

	public SimpleTextPanel getPnl_ansprechpartner() {
		return pnl_ansprechpartner;
	}

	public void setPnl_ansprechpartner(SimpleTextPanel pnl_ansprechpartner) {
		this.pnl_ansprechpartner = pnl_ansprechpartner;
	}

	public SimpleTextPanel getPnl_branche() {
		return pnl_branche;
	}

	public void setPnl_branche(SimpleTextPanel pnl_branche) {
		this.pnl_branche = pnl_branche;
	}

	public SimpleTextPanel getPnl_email() {
		return pnl_email;
	}

	public void setPnl_email(SimpleTextPanel pnl_email) {
		this.pnl_email = pnl_email;
	}

	public SimpleTextPanel getPnl_rufnummer() {
		return pnl_rufnummer;
	}

	public void setPnl_rufnummer(SimpleTextPanel pnl_rufnummer) {
		this.pnl_rufnummer = pnl_rufnummer;
	}

	public SimpleTextPanel getPnl_addresse() {
		return pnl_addresse;
	}

	public void setPnl_addresse(SimpleTextPanel pnl_addresse) {
		this.pnl_addresse = pnl_addresse;
	}

	public SimpleTextPanel getPnl_strasse() {
		return pnl_strasse;
	}

	public void setPnl_strasse(SimpleTextPanel pnl_strasse) {
		this.pnl_strasse = pnl_strasse;
	}

	public SimpleTextPanel getPnl_plz() {
		return pnl_plz;
	}

	public void setPnl_plz(SimpleTextPanel pnl_plz) {
		this.pnl_plz = pnl_plz;
	}

	public SimpleTextPanel getPnl_bundesland() {
		return pnl_bundesland;
	}

	public void setPnl_bundesland(SimpleTextPanel pnl_bundesland) {
		this.pnl_bundesland = pnl_bundesland;
	}

	public SimpleTextPanel getPnl_stadt() {
		return pnl_stadt;
	}

	public void setPnl_stadt(SimpleTextPanel pnl_stadt) {
		this.pnl_stadt = pnl_stadt;
	}

	public JPanel getPnl_south() {
		return pnl_south;
	}

	public void setPnl_south(JPanel pnl_south) {
		this.pnl_south = pnl_south;
	}

}
