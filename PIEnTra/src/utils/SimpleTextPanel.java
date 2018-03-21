package utils;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Kluge TextPanel seit 1977.
 * Klasse erbt von Panel und enthaelt ein JLabel und ein JFormattedTextField.
 * @author Julian Klein
 * @version V start-to-end (Julian Klein)
 */
public class SimpleTextPanel extends JPanel {
	private static final long serialVersionUID = 1630037309453430313L;
	
	static int labelWidth = 120;
	JLabel lbl;
	JFormattedTextField txt;
	
	/**
	 * Konstruktor. Erstellt ein TextFeld und ein Label das den uebergebenen String zeigt.
	 * @param labelText Wird später vor dem Textfeld angezeigt.
	 */
	public SimpleTextPanel(String labelText) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		lbl = new JLabel(labelText);
		lbl.setPreferredSize(new Dimension(labelWidth, lbl.getPreferredSize().height));
		txt = new JFormattedTextField();
		this.add(lbl);
		this.add(txt);
	}
	
	/**
	 * Konstruktor. Erstellt ein TextFeld und ein Label das den uebergebenen String zeigt und dem TextFeld ein bestimmtes Format zuweist.
	 * @param labelText Wird später vor dem Textfeld angezeigt.
	 * @param format Format welches das Textfeld zugewisen bekommen soll.
	 */
	public SimpleTextPanel(String labelText, AbstractFormatter format) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		lbl = new JLabel(labelText);
		lbl.setPreferredSize(new Dimension(labelWidth, lbl.getPreferredSize().height));
		txt = new JFormattedTextField(format);
		this.add(lbl);
		this.add(txt);
	}

	/**
	 * Shortcut für <code>object.getTxt().setPrefferedSize(new Dimension(@param, getTxt().getPrefferedSize().height))</code>.</br>
	 * Setzt die Breite des Textfeldes auf den im Parameter uebergebenen Wert.
	 * @param width Angabe der gewuenschten Breite.
	 */
	public void setTextFieldWidth(int width) {
		txt.setPreferredSize(new Dimension(width, txt.getPreferredSize().height));
	}
	
	/**
	 * Getter mit dessen Hilfe sich z.B. kombiniert mit {@link #setTextFieldWidth(int)} variable Groeßen berechnen lassen. Bsp.: {@link view.V_TrainingKonfigurieren#resizeGUI()}
	 * @return Gibt Breite der Label zurueck.
	 */
	public static int getLabelWidth() {
		return labelWidth;
	}

	/**
	 * Shortcut fuer <code>object.{@link #getTextPanel()}.getText()</code>.
	 * @return Text des Textfeldes als String.
	 */
	public String getText() {
		return txt.getText();
	}
	
	/**
	 * Shortcut fuer <code>object.{@link #getTextPanel()}.setText(String text)</code>.
	 * @param text Text den das Textfeld anzeigen soll.
	 */
	public void setText(String text) {
		txt.setText(text);
	}
	
	/**
	 * Standard getter fuer das Textfeld
	 * @return Textfeld als JFormattedTextField
	 */
	public JFormattedTextField getTextPanel() {
		return txt;
	}
	
	/**
	 * Shortcut fuer object.{@link #getTextPanel()}.setFocusable(true/false)
	 * @param enable true/false ob Objekt anklickbar & aenderbar ist.
	 */
	@Override
	public void setFocusable(boolean enable) {
		txt.setFocusable(enable);
	}

}
