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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import utils.SimpleComboPanel;

public class V_RessourcenAendern2 extends JFrame {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		V_RessourcenAendern2 test = new V_RessourcenAendern2();
	}
	
	private JPanel pnl_center;
	private SimpleComboPanel pnl_produktbezeichnung = new SimpleComboPanel("Produktbezeichnung:");
	private SimpleComboPanel pnl_trainer = new SimpleComboPanel("Trainer:");
	private SimpleComboPanel pnl_ort = new SimpleComboPanel("Ort:");
	private JTextField txt_navigation = new JTextField("PIEnTra / Training �ndern / Ressourcen �ndern");
	
	public V_RessourcenAendern2() {
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
		pnl_center = new JPanel(new GridLayout(1, 2));
		JPanel pnl_center_right = new JPanel(new GridLayout(3, 1));
		pnl_center_right.add(pnl_produktbezeichnung);
		pnl_center_right.add(pnl_trainer);
		pnl_center_right.add(pnl_ort);
		pnl_center.add(pnl_center_right);
		this.add(BorderLayout.CENTER, pnl_center);
		JPanel pnl_south = new JPanel(new FlowLayout());
		pnl_south.add(txt_navigation);
		this.add(BorderLayout.SOUTH, pnl_south);
	}
	
	/** Enth�lt variable G��en **/
	private void resizeGUI() {
		txt_navigation.setPreferredSize(new Dimension(this.getWidth() - 30, txt_navigation.getPreferredSize().height));
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
