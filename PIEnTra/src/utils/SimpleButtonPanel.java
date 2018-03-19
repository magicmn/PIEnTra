package utils;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Bessere Buttons in JEDEM LayoutManger seit 1977.
 * Fügt einem Label einen Button hinzu und ermöglicht somit immer gleich große Buttons.
 * @version 2.0 Sinnvoll erweitert. Überflüssiges entfernt. Shortcuts hinzugefügt. Ist jetzt ein echtes Schweizertaschenmesser unter den Buttons.
 * @version 1.0 Hinzugefügt.
 * @author Julian Klein
 *
 */
public class SimpleButtonPanel extends JPanel{

	private static final long serialVersionUID = -5382589613949093850L;
	JButton btn;
	
	/**
	 * Konstruktor. Erstellt neuen Button und fügt ihn dem Panel hinzu. Größe wird auf eine fixe Größe gesetzt.
	 * @param buttonText Wird zum Text des Buttons.
	 */
	public SimpleButtonPanel(String buttonText) {
		btn = new JButton(buttonText);
		this.setLayout(new FlowLayout());
		this.add(btn);
		btn.setPreferredSize(new Dimension(150, btn.getPreferredSize().height));
	}

	/**
	 * Shortcut für <code>pnl_PanelMitButton.getButton().addActionListener()<code>
	 * @param listener Übergibt den ActionListener an den Button.
	 */
	public void addActionListener(ActionListener listener) {
		btn.addActionListener(listener);
	}
}
