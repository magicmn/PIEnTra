package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import utils.SimpleTextPanel;

public class V_TrainingKonfigurieren extends JFrame {
	
	private JPanel pnl_center;
	private SimpleTextPanel pnl_kundenId;
	private SimpleTextPanel pnl_firmenname;
	private SimpleTextPanel pnl_ansprechpartner;
	private SimpleTextPanel pnl_produktbeschreibung;
	private SimpleTextPanel pnl_anfangsdatum;
	private SimpleTextPanel pnl_enddatum;
	private SimpleTextPanel pnl_tage;
	private SimpleTextPanel pnl_trainer;
	private SimpleTextPanel pnl_ort;
	private SimpleTextPanel pnl_bemerkungen;
	private JButton btn_kundewaehlen;
	private JButton btn_ressourcenwaehlen;
	private JButton btn_trainingspeichern;
	private JButton btn_zurueck;
	private JTextField txt_navigation;
		
		// Variablen zur variablen varierung der variablen Fenstergröße.
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = (int) screenSize.getWidth();
	private int height = (int) screenSize.getHeight();
		
	public static void main(String[]args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		V_TrainingKonfigurieren ad = new V_TrainingKonfigurieren();
	}

	public V_TrainingKonfigurieren() {
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
		this.setLocationRelativeTo(null);
		this.addComponentListener(new ResizeListener());
		
		pnl_center = new JPanel(new GridLayout(10, 1, 2 ,2));
		pnl_center.add(pnl_kundenId = new SimpleTextPanel("Kunden-ID:", 20));
		pnl_center.add(pnl_firmenname = new SimpleTextPanel("Firmenname:"));
		pnl_center.add(pnl_ansprechpartner = new SimpleTextPanel("Ansprechpartner:"));
		pnl_center.add(pnl_produktbeschreibung = new SimpleTextPanel("Produktbeschreibung:"));
		pnl_center.add(pnl_anfangsdatum = new SimpleTextPanel("Anfangsdatum:"));
		pnl_center.add(pnl_enddatum = new SimpleTextPanel("Enddatum:"));
		pnl_center.add(pnl_tage= new SimpleTextPanel("Tage:"));
		pnl_center.add(pnl_trainer = new SimpleTextPanel("Trainer:"));
		pnl_center.add(pnl_ort = new SimpleTextPanel("Ort:"));
		pnl_center.add(pnl_bemerkungen = new SimpleTextPanel("Bemerkungen:"));
		this.add(BorderLayout.CENTER, pnl_center);
		
		JPanel pnl_south = new JPanel(new GridLayout(2, 1));
		JPanel pnl_south_top = new JPanel(new GridLayout(1, 4));
		pnl_south_top.add(btn_kundewaehlen = new JButton("Kunde wählen"));
		pnl_south_top.add(btn_ressourcenwaehlen = new JButton("Ressourcen wählen"));
		pnl_south_top.add(btn_trainingspeichern = new JButton("Training speichern"));
		pnl_south_top.add(btn_zurueck = new JButton("Zurück zum Hauptmenü"));
		pnl_south.add(pnl_south_top);
		JPanel pnl_south_bottom = new JPanel(new FlowLayout());
		pnl_south_bottom.add(txt_navigation = new JTextField("PIEnTra / Training konfigurieren"));
		txt_navigation.setFocusable(false);
		pnl_south.add(pnl_south_bottom);
		this.add(BorderLayout.SOUTH, pnl_south);
	}
	
	public void resizeGUI() {
		txt_navigation.setPreferredSize(new Dimension(this.getWidth() - 30, txt_navigation.getPreferredSize().height));
		pnl_kundenId.setTxtField_Size(this.getWidth() / 2);
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