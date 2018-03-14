package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import utils.SimpleButtonPanel;

public class V_Hauptmenue extends JFrame {
	
	private JPanel pnl_center_container;
	private JPanel pnl_center;
	private SimpleButtonPanel btn_TrainingKonfigurieren = new SimpleButtonPanel("Training konfigurieren");
	private SimpleButtonPanel btn_TrainingAendern = new SimpleButtonPanel("Training �ndern");
	private SimpleButtonPanel btn_KundeVerwalten = new SimpleButtonPanel("Kunde verwalten");
	private SimpleButtonPanel btn_TrainingLoeschen = new SimpleButtonPanel("Training l�schen");
	private SimpleButtonPanel btn_PIEnTraVerlassen = new SimpleButtonPanel("PIEnTra verlassen");
	private SimpleButtonPanel btn_ProdukteDefinieren = new SimpleButtonPanel("Produkte definieren");
	private JPanel pnl_south;
	private JTextField txt_navigation;
	
	public V_Hauptmenue() {
		initView();
		resizeGUI();
		this.setVisible(true);
	}
	
	public static void main(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		new V_Hauptmenue();
	}

	private void initView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setSize(750, 450); // Optimale Gr��e die beim Starten geladen wird.
		this.setMinimumSize(new Dimension(500, 400)); // Um zu verhindern, dass der DAU sich wundert warum das Fenster auf einmal "weg" ist.
		this.setLayout(new BorderLayout()); 
		this.setLocationRelativeTo(null); // Zentriert Frame in der Mitte des Bildschirms.
		this.addComponentListener(new ResizeListener());  // F�gt Listener f�r Frame ver�nderungen hinzu.
		
		pnl_center_container = new JPanel(new FlowLayout());
		pnl_center_container.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));
		pnl_center = new JPanel(new GridLayout(1, 4));
		pnl_center.add(btn_TrainingKonfigurieren);
		JPanel pnl_center_left = new JPanel(new GridLayout(2, 1));
		pnl_center_left.add(btn_TrainingAendern);
		pnl_center_left.add(btn_KundeVerwalten);
		pnl_center.add(pnl_center_left);
		JPanel pnl_center_right = new JPanel(new GridLayout(2, 1));
		pnl_center_right.add(btn_TrainingLoeschen);
		pnl_center_right.add(btn_PIEnTraVerlassen);
		pnl_center.add(pnl_center_right);
		pnl_center.add(btn_ProdukteDefinieren);
		
		pnl_center_container.add(pnl_center);
		this.add(BorderLayout.CENTER, pnl_center_container);
		
		pnl_south = new JPanel(new FlowLayout());
		pnl_south.add(txt_navigation = new JTextField("PIEnTra / Hauptmen�"));
		txt_navigation.setFocusable(false);
		this.add(BorderLayout.SOUTH, pnl_south);
	}
	
	/** Enth�lt variable Gr��en **/
	private void resizeGUI() {
		txt_navigation.setPreferredSize(new Dimension(this.getWidth() - 30, txt_navigation.getPreferredSize().height));
		pnl_center_container.setPreferredSize(new Dimension(this.getWidth(), 200));
		btn_TrainingKonfigurieren.setBtn_width(this.getWidth() / 5);
		btn_TrainingAendern.setBtn_width(this.getWidth() / 5);
		btn_KundeVerwalten.setBtn_width(this.getWidth() / 5);
		btn_TrainingLoeschen.setBtn_width(this.getWidth() / 5);
		btn_PIEnTraVerlassen.setBtn_width(this.getWidth() / 5);
		btn_ProdukteDefinieren.setBtn_width(this.getWidth() / 5);
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