package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utils.SimpleTextPanel;

public class V_KundeSuchen extends JFrame {
	
	private JPanel pnl_center;
	private SimpleTextPanel pnl_kundenID = new SimpleTextPanel("Kunden-ID:");
	private SimpleTextPanel pnl_firmenname = new SimpleTextPanel("Firmenname:");
	
	private JPanel pnl_south;
	private JButton btn_kundesuchen = new JButton("Kunde suchen");
	private JButton btn_abbrechen = new JButton("Abbrechen");
	private JTextField txt_navigation;

	public V_KundeSuchen() {
		initView();
		resizeGUI();
		this.setVisible(true);
	}

	private void initView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setSize(400,150); // Optimale Größe die beim Starten geladen wird.
		this.setMinimumSize(new Dimension(400, 150)); // Um zu verhindern, dass der DAU sich wundert warum das Fenster auf einmal "weg" ist.
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null); // Zentriert Frame in der Mitte des Bildschirms.
		this.addComponentListener(new ResizeListener());  // Fügt Listener für Frame veränderungen hinzu.
		
		pnl_center = new JPanel(new GridLayout(2, 1, 2 ,2));
		pnl_center.add(pnl_kundenID);
		pnl_center.add(pnl_firmenname);
	
		this.add(BorderLayout.CENTER, pnl_center);
		
		JPanel pnl_south = new JPanel(new GridLayout(1, 4));
		pnl_south.setBorder(new EmptyBorder(10,10,10,10));
		pnl_south.add(btn_kundesuchen);
		pnl_south.add(btn_abbrechen);
		this.add(BorderLayout.SOUTH, pnl_south);
	}
	
	/** Enthält variable Gößen **/
	private void resizeGUI() {
		pnl_kundenID.setTxtField_Size(this.getWidth() - 260);
		pnl_firmenname.setTxtField_Size(this.getWidth() -140 );
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