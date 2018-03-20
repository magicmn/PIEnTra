package view;

import javax.swing.JButton;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


/**
 * Nimmt 2 booleans entgegen und überprüft bei Änderung des Textes ob diese true sind. Wenn ja wird ein übergebener Button aktiviert.
 * @author Julian Klein
 * @version 1.0
 */
public class CheckInput implements CaretListener {

	Boolean bool1;
	Boolean bool2;
	JButton buttonToEnable;
	
	public CheckInput(Boolean bool1, Boolean bool2, JButton buttonToEnable) {
		this.bool1 = bool1;
		this.bool2 = bool2;
		this.buttonToEnable = buttonToEnable;
	}
	
	public void caretUpdate(CaretEvent arg0) {
		if (bool1 == true && bool2 == true) {
			buttonToEnable.setEnabled(true);
		}
	}

}
