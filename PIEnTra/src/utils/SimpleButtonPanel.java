package utils;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Bessere Buttons in JEDEM LayoutManger seit 1977.
 * F�gt einem Label einen Button hinzu und erm�glicht somit immer gleich gro�e Buttons.
 * @version 2.0 Sinnvoll erweitert. �berfl�ssiges entfernt. Shortcuts hinzugef�gt. Ist jetzt ein echtes Schweizertaschenmesser unter den Buttons.
 * @version 1.0 Hinzugef�gt.
 * @author Julian Klein
 *
 */
public class SimpleButtonPanel extends JPanel{

	private static final long serialVersionUID = -5382589613949093850L;
	JButton btn;
	
	/**
	 * Konstruktor. Erstellt neuen Button und f�gt ihn dem Panel hinzu. Gr��e wird auf eine fixe Gr��e gesetzt.
	 * @param buttonText Wird zum Text des Buttons.
	 */
	public SimpleButtonPanel(String buttonText) {
		btn = new JButton(buttonText);
		this.setLayout(new FlowLayout());
		this.add(btn);
		btn.setPreferredSize(new Dimension(150, btn.getPreferredSize().height));
	}

	/**
	 * Shortcut f�r <code>pnl_PanelMitButton.getButton().addActionListener()<code>
	 * @param listener �bergibt den ActionListener an den Button.
	 */
	public void addActionListener(ActionListener listener) {
		btn.addActionListener(listener);
	}
}
