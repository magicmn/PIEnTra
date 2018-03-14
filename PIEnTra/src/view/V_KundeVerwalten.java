package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
	private SimpleTextPanel pnl_strasse = new SimpleTextPanel("Straße:");
	private SimpleTextPanel pnl_plz = new SimpleTextPanel("Postleitzahl:");
	private SimpleTextPanel pnl_bundesland = new SimpleTextPanel("Bundesland:");
	private SimpleTextPanel pnl_stadt = new SimpleTextPanel("Stadt:");
	
	private JPanel pnl_south;
	private JButton btn_kundesuchen = new JButton("Kunde suchen");
	private JButton btn_kundeaktualisieren = new JButton("Kunde aktualisieren");
	private JButton btn_kundeanlegen = new JButton("Neuen Kunden anlegen");
	private JButton btn_zurueck = new JButton("Zurück zum Hauptmenü");
	private JTextField txt_navigation;

	public V_KundeVerwalten() {
		initView();
		resizeGUI();
		this.setVisible(true);
	}

	private void initView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setSize(750, 490); // Optimale Größe die beim Starten geladen wird.
		this.setMinimumSize(new Dimension(500, 400)); // Um zu verhindern, dass der DAU sich wundert warum das Fenster auf einmal "weg" ist.
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null); // Zentriert Frame in der Mitte des Bildschirms.
		this.addComponentListener(new ResizeListener());  // Fügt Listener für Frame veränderungen hinzu.
		
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
		
		pnl_south = new JPanel(new GridLayout(2, 1));
		JPanel pnl_south_top = new JPanel(new GridLayout(1, 4));
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
	
	/** Enthält variable Gößen **/
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
	
	class ResizeListener implements ComponentListener {
		public void componentResized(ComponentEvent arg0) {
			resizeGUI();
		}
		public void componentHidden(ComponentEvent arg0) {}
		public void componentMoved(ComponentEvent arg0) {}
		public void componentShown(ComponentEvent arg0) {}
	}
	
}
