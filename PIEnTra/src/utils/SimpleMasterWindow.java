package utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.V_Hauptmenue;

/**
 * Abstrakt. Superklasse von der alle Views erben.
 * @version 1.0 Hinzugef�gt.
 * @author Julian Klein
 * 
 * @see {@link view.V_TrainingKonfigurieren} (Beispiel fuer Verwendung der Klasse)
 */
public abstract class SimpleMasterWindow extends JFrame {

	private static final long serialVersionUID = 1358815520717015767L;

	private int padding = 10;
	
	private JPanel pnl_center;
	private JPanel pnl_south;
	private JPanel pnl_menu;
	private JPanel pnl_navigationPath;
	
	/**
	 * Konstruktor der die Grundeigenschaften der Fenster �bernimmt.
	 * @param defaultSize Fenster wird in dieser Gr��e ge�ffnet. Wird weitergegeben an {@link #initFrame}.
	 * @param minSize Minimale Gr��e auf die das Fenster verkleinert werden darf. Wird weitergeben an {@link #initFrame}.
	 * @param navigationText Text des unteren Textfeldes das den aktuellen Pfad der Navigation anzeigt. Wird weitergeben an {@link #initSouth}.
	 */
	public SimpleMasterWindow(Dimension defaultSize, Dimension minSize, String navigationText) {
		
		initFrame(defaultSize, minSize);
		initCenter();
		initSouth(navigationText);
		this.setVisible(true);
	}

	/**
	 * Initialisiert die Grundeigenschaften des Frames.
	 * @param defaultSize Fenster wird in dieser Gr��e ge�ffnet. Erhalten von {@link #SimpleMasterWindow}.
	 * @param minSize Minimale Gr��e auf die das Fenster verkleinert werden darf. Erhalten von {@link #SimpleMasterWindow}.
	 */
	private void initFrame(Dimension defaultSize, Dimension minSize) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setSize(defaultSize);
		this.setMinimumSize(minSize);
		this.setLayout(new BorderLayout()); 
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Initialisiert Grundeigenscahften des Centers.
	 */
	private void initCenter() {
		pnl_center = new JPanel();
		pnl_center.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(BorderLayout.CENTER, pnl_center);
	}
	
	/**
	 * Initialisiert den Grundinhalt des Panels unten.
	 * @param navigationText Text des unteren Textfeldes das den aktuellen Pfad der Navigation anzeigt. Erhalten von {@link #SimpleMasterWindow}.
	 */
	private void initSouth(String navigationText) {
			pnl_south = new JPanel();
			pnl_south.setLayout(new BoxLayout(pnl_south, BoxLayout.PAGE_AXIS));
			pnl_south.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
			pnl_menu = new JPanel();
			pnl_menu.setLayout(new FlowLayout(FlowLayout.LEFT));
			pnl_south.add(pnl_menu);
			if (navigationText != "") {
				pnl_navigationPath = new JPanel();
				pnl_navigationPath.setLayout(new GridLayout(1, 1));
				JTextField txt_navigation = new JTextField("PIEnTra / " + navigationText);
				txt_navigation.setFocusable(false);
				pnl_navigationPath.add(txt_navigation);
				pnl_south.add(pnl_navigationPath);
			}
			this.add(BorderLayout.SOUTH, pnl_south);
	}
	
	/**
	 * @return pnl_south_top JPanel in welches der Inhalt der View eingef�gt werden soll.
	 */
	protected JPanel getPnl_menu() {
		return pnl_menu;
	}
	
	/**
	 * L�scht das Panel "pnl_menu" aus dem Panel pnl_south. Wird verwendet um im {@link V_Hauptmenue} einen kleine Anzeigefehler zu beheben, wenn das nicht gef�llte pnl_menu �ber den Inhalt geht.
	 */
	protected void removePnl_menu() {
		pnl_south.remove(pnl_menu);
	}
	
	/**
	 * @return pnl_south_top JPanel in welches die Buttons eingef�gt werden sollen.
	 */
	protected JPanel getPnl_center() {
		return pnl_center;
	}
	
	/**
	 * @return Abstand zwischen Inhalten und R�ndern.
	 */
	protected int getPadding() {
		return padding;
	}
	
	/**
	 * @return JPanel, welches die Navigation enth�lt.
	 */
	protected JPanel getNavigationPathPanel() {
		return pnl_navigationPath;
	}

}
