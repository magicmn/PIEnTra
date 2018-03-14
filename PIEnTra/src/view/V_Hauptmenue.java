package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.SimpleButtonPanel;

public class V_Hauptmenue extends JFrame {
	
	private JPanel pnl_center;
	private SimpleButtonPanel btn_TrainingKonfigurieren = new SimpleButtonPanel("Training konfigurieren");
	private SimpleButtonPanel btn_TrainingAendern = new SimpleButtonPanel("Training ändern");
	private SimpleButtonPanel btn_KundeVerwalten = new SimpleButtonPanel("Kunde verwalten");
	private SimpleButtonPanel btn_TrainingLoeschen = new SimpleButtonPanel("Training löschen");
	private SimpleButtonPanel btn_PIEnTraVerlassen = new SimpleButtonPanel("PIEnTra verlassen");
	private SimpleButtonPanel btn_ProdukteDefinieren = new SimpleButtonPanel("Produkte definieren");
	private JPanel pnl_south;
	private JTextField txt_navigation;
	
	public V_Hauptmenue() {
		initView();
		resizeGUI();
		this.setVisible(true);
	}
	
	public static void main(String [] args) {
		new V_Hauptmenue();
	}

	private void initView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setSize(750, 450); // Optimale Größe die beim Starten geladen wird.
		this.setMinimumSize(new Dimension(500, 400)); // Um zu verhindern, dass der DAU sich wundert warum das Fenster auf einmal "weg" ist.
		this.setLayout(new BorderLayout()); 
		this.setLocationRelativeTo(null); // Zentriert Frame in der Mitte des Bildschirms.
		this.addComponentListener(new ResizeListener());  // Fügt Listener für Frame veränderungen hinzu.
		
		JPanel pnl_center_container = new JPanel(new FlowLayout());
		pnl_center = new JPanel(new GridLayout(4, 1));
		pnl_center.add(btn_TrainingKonfigurieren);
		
		pnl_center_container.add(pnl_center);
		this.add(BorderLayout.CENTER, pnl_center_container);
		
		pnl_south = new JPanel(new FlowLayout());
		pnl_south.add(txt_navigation = new JTextField("PIEnTra / Hauptmenü"));
		txt_navigation.setFocusable(false);
		this.add(BorderLayout.SOUTH, pnl_south);
	}
	
	/** Enthält variable Gößen **/
	private void resizeGUI() {
		txt_navigation.setPreferredSize(new Dimension(this.getWidth() - 30, txt_navigation.getPreferredSize().height));
		pnl_center.setSize(new Dimension(200, 200));
		btn_TrainingKonfigurieren.setBtn_width(pnl_center.getWidth() / 5);
		btn_TrainingAendern.setBtn_width(pnl_center.getWidth() / 5);
		btn_KundeVerwalten.setBtn_width(pnl_center.getWidth() / 5);
		btn_TrainingLoeschen.setBtn_width(pnl_center.getWidth() / 5);
		btn_PIEnTraVerlassen.setBtn_width(pnl_center.getWidth() / 5);
		btn_ProdukteDefinieren.setBtn_width(pnl_center.getWidth() / 5);
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