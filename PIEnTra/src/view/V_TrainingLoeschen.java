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




public class V_TrainingLoeschen extends JFrame {
	
	private JPanel pnl_center;
	private SimpleTextPanel pnl_trainingsId;
	private SimpleTextPanel pnl_firmenname;
	private SimpleTextPanel pnl_produkt;
	private SimpleTextPanel pnl_startdatum;
	private SimpleTextPanel pnl_enddatum;
	private SimpleTextPanel pnl_tage;
	private SimpleTextPanel pnl_trainer;
	private SimpleTextPanel pnl_ort;
	private SimpleTextPanel pnl_bemerkungen;
	private JPanel pnl_south;
	private JButton btn_trainingSuchen;
	private JButton btn_trainingLoeschen;
	private JButton btn_zurueck;
	private JTextField txt_navigation;

	public V_TrainingLoeschen() {
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
		pnl_center.add(pnl_trainingsId = new SimpleTextPanel("Trainings-ID:"));
		pnl_center.add(pnl_firmenname = new SimpleTextPanel("Firmenname:"));
		pnl_center.add(pnl_produkt = new SimpleTextPanel("Produkt:"));
		pnl_center.add(pnl_startdatum = new SimpleTextPanel("Startdatum:"));
		pnl_center.add(pnl_enddatum = new SimpleTextPanel("Enddatum:"));
		pnl_center.add(pnl_tage= new SimpleTextPanel("Tage:"));
		pnl_center.add(pnl_trainer = new SimpleTextPanel("Trainer:"));
		pnl_center.add(pnl_ort = new SimpleTextPanel("Ort:"));
		pnl_center.add(pnl_bemerkungen = new SimpleTextPanel("Bemerkungen:"));
		this.add(BorderLayout.CENTER, pnl_center);
		
		pnl_south = new JPanel(new GridLayout(2, 1));
		JPanel pnl_south_top = new JPanel(new GridLayout(1, 3));
		pnl_south_top.add(btn_trainingSuchen = new JButton("Training suchen"));
		pnl_south_top.add(btn_trainingLoeschen = new JButton("Training l�schen"));
		pnl_south_top.add(btn_zurueck = new JButton("Zur�ck zum Hauptmen�"));
		pnl_south.add(pnl_south_top);
		JPanel pnl_south_bottom = new JPanel(new FlowLayout());
		pnl_south_bottom.add(txt_navigation = new JTextField("PIEnTra / Training l�schen"));
		txt_navigation.setFocusable(false);
		pnl_south.add(pnl_south_bottom);
		this.add(BorderLayout.SOUTH, pnl_south);
	}
	
	private void resizeGUI() {
		txt_navigation.setPreferredSize(new Dimension(this.getWidth() - 30, txt_navigation.getPreferredSize().height));
		pnl_trainingsId.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_firmenname.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_produkt.setTxtField_Size(pnl_center.getWidth() / 2);
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
