package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import utils.SimpleTextPanel;

public class V_TrainingAendern extends JFrame {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		V_TrainingAendern trainingAendern = new V_TrainingAendern();
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	}
	

	private JPanel pnl_center;
	private SimpleTextPanel pnl_trainingsId = new SimpleTextPanel("Trainings-ID:");
	private SimpleTextPanel pnl_firmenname = new SimpleTextPanel("Firmenname:");
	private SimpleTextPanel pnl_ansprechpartner = new SimpleTextPanel("Ansprechpartner:");
	private SimpleTextPanel pnl_produktbeschreibung = new SimpleTextPanel("Produktbeschreibung:");
	private SimpleTextPanel pnl_startdatum = new SimpleTextPanel("Startdatum:");
	private SimpleTextPanel pnl_enddatum = new SimpleTextPanel("Enddatum:");
	private SimpleTextPanel pnl_tage = new SimpleTextPanel("Tage:");
	private SimpleTextPanel pnl_trainer = new SimpleTextPanel("Trainer:");
	private SimpleTextPanel pnl_ort = new SimpleTextPanel("Ort:");
	private SimpleTextPanel pnl_bemerkungen = new SimpleTextPanel("Bemerkungen:");
	private JPanel pnl_south;
	private JButton btn_trainingsuchen = new JButton("Training suchen");
	private JButton btn_ressourcenaendern = new JButton("Ressourcen ändern");
	private JButton btn_trainingaktualisieren = new JButton("Training aktualisieren");
	private JButton btn_zurueck = new JButton("Zurück zum Hauptmenü");
	private JTextField txt_navigation;

	public V_TrainingAendern() {
		initView();
		resizeGUI();
		this.setVisible(true);
	}

	private void initView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setSize(750, 450); // Optimale Größe die beim Starten geladen wird.
		this.setMinimumSize(new Dimension(500, 400)); // Um zu verhindern, dass der DAU sich wundert warum das Fenster auf einmal "weg" ist.
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null); // Zentriert Frame in der Mitte des Bildschirms.
		this.addComponentListener(new ResizeListener());  // Fügt Listener für Frame veränderungen hinzu.
		
		pnl_center = new JPanel(new GridLayout(10, 1, 2 ,2));
		pnl_center.add(pnl_trainingsId);
		pnl_center.add(pnl_firmenname);
		pnl_center.add(pnl_ansprechpartner);
		pnl_center.add(pnl_produktbeschreibung);
		pnl_center.add(pnl_startdatum);
		pnl_center.add(pnl_enddatum);
		pnl_center.add(pnl_tage);
		pnl_center.add(pnl_trainer);
		pnl_center.add(pnl_ort);
		pnl_center.add(pnl_bemerkungen);
		this.add(BorderLayout.CENTER, pnl_center);
		
		pnl_south = new JPanel(new GridLayout(2, 1));
		JPanel pnl_south_top = new JPanel(new GridLayout(1, 4));
		pnl_south_top.add(btn_trainingsuchen);
		pnl_south_top.add(btn_ressourcenaendern);
		pnl_south_top.add(btn_trainingaktualisieren);
		pnl_south_top.add(btn_zurueck);
		pnl_south.add(pnl_south_top);
		JPanel pnl_south_bottom = new JPanel();
	    pnl_south_bottom.setLayout( new BoxLayout(pnl_south_bottom, BoxLayout.X_AXIS));
		pnl_south_bottom.add(txt_navigation = new JTextField("PlEnTra / Training ändern"));
		txt_navigation.setFocusable(false);
		pnl_south.add(pnl_south_bottom);
		this.add(BorderLayout.SOUTH, pnl_south);
	}
	
	/** Enthält variable Gößen **/
	private void resizeGUI() {
		txt_navigation.setPreferredSize(new Dimension(this.getWidth() - 30, txt_navigation.getPreferredSize().height));
		pnl_trainingsId.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_firmenname.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_ansprechpartner.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_produktbeschreibung.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_startdatum.setTxtField_Size(pnl_center.getWidth() / 4);
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