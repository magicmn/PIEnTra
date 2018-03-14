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

import utils.SimpleTextPanel;

public class V_TrainingKonfigurieren extends JFrame {
	
	private JPanel pnl_center;
	private SimpleTextPanel pnl_kundenId = new SimpleTextPanel("Kunden-ID:");
	private SimpleTextPanel pnl_firmenname = new SimpleTextPanel("Firmenname:");
	private SimpleTextPanel pnl_ansprechpartner = new SimpleTextPanel("Ansprechpartner:");
	private SimpleTextPanel pnl_produktbeschreibung = new SimpleTextPanel("Produktbeschreibung:");
	private SimpleTextPanel pnl_anfangsdatum = new SimpleTextPanel("Anfangsdatum:");
	private SimpleTextPanel pnl_enddatum = new SimpleTextPanel("Enddatum:");
	private SimpleTextPanel pnl_tage = new SimpleTextPanel("Tage:");
	private SimpleTextPanel pnl_trainer = new SimpleTextPanel("Trainer:");
	private SimpleTextPanel pnl_ort = new SimpleTextPanel("Ort:");
	private SimpleTextPanel pnl_bemerkungen = new SimpleTextPanel("Bemerkungen:");
	private JPanel pnl_south;
	private JButton btn_kundewaehlen = new JButton("Kunde w�hlen");
	private JButton btn_ressourcenwaehlen = new JButton("Ressourcen w�hlen");
	private JButton btn_trainingspeichern = new JButton("Training speichern");
	private JButton btn_zurueck = new JButton("Zur�ck zum Hauptmen�");
	private JTextField txt_navigation;

	public V_TrainingKonfigurieren() {
		initView();
		resizeGUI();
		this.setVisible(true);
	}

	private void initView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setSize(750, 450); // Optimale Gr��e die beim Starten geladen wird.
		this.setMinimumSize(new Dimension(500, 400)); // Um zu verhindern, dass der DAU sich wundert warum das Fenster auf einmal "weg" ist.
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null); // Zentriert Frame in der Mitte des Bildschirms.
		this.addComponentListener(new ResizeListener());  // F�gt Listener f�r Frame ver�nderungen hinzu.
		
		pnl_center = new JPanel(new GridLayout(10, 1, 2 ,2));
		pnl_center.add(pnl_kundenId);
		pnl_center.add(pnl_firmenname);
		pnl_center.add(pnl_ansprechpartner);
		pnl_center.add(pnl_produktbeschreibung);
		pnl_center.add(pnl_anfangsdatum);
		pnl_center.add(pnl_enddatum);
		pnl_center.add(pnl_tage);
		pnl_center.add(pnl_trainer);
		pnl_center.add(pnl_ort);
		pnl_center.add(pnl_bemerkungen);
		this.add(BorderLayout.CENTER, pnl_center);
		
		pnl_south = new JPanel(new GridLayout(2, 1));
		JPanel pnl_south_top = new JPanel(new GridLayout(1, 4));
		pnl_south_top.add(btn_kundewaehlen);
		pnl_south_top.add(btn_ressourcenwaehlen);
		pnl_south_top.add(btn_trainingspeichern);
		pnl_south_top.add(btn_zurueck);
		pnl_south.add(pnl_south_top);
		JPanel pnl_south_bottom = new JPanel(new FlowLayout());
		pnl_south_bottom.add(txt_navigation = new JTextField("PIEnTra / Training konfigurieren"));
		txt_navigation.setFocusable(false);
		pnl_south.add(pnl_south_bottom);
		this.add(BorderLayout.SOUTH, pnl_south);
	}
	
	/** Enth�lt variable G��en **/
	private void resizeGUI() {
		txt_navigation.setPreferredSize(new Dimension(this.getWidth() - 30, txt_navigation.getPreferredSize().height));
		pnl_kundenId.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_firmenname.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_ansprechpartner.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_produktbeschreibung.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_anfangsdatum.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_enddatum.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_tage.setTxtField_Size(pnl_center.getWidth() / 8);
		pnl_trainer.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_ort.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_bemerkungen.setTxtField_Size((this.getWidth() - 140));
	}
	
	private class ResizeListener implements ComponentListener {
		public void componentResized(ComponentEvent arg0) {
			resizeGUI();
		}
		public void componentHidden(ComponentEvent arg0) {}
		public void componentMoved(ComponentEvent arg0) {}
		public void componentShown(ComponentEvent arg0) {}
	}
	
}