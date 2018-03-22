package view;

import javax.swing.JButton;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


/**
 * Nimmt 2 booleans entgegen und überprüft bei Änderung des Textes ob diese true sind. Wenn ja wird ein übergebener Button aktiviert.
 * @author Konstantin Frei
 * @author Julian Klein
 * @version 1.1
 * @version 1.0
 */
public class CheckInput implements CaretListener {

	Boolean bool1;
	Boolean bool2;
	JButton buttonToEnable;
	
	/**
	 * 
	 * @param bool1
	 * @param bool2
	 * @param buttonToEnable
	 */
	public CheckInput(Boolean bool1, Boolean bool2, JButton buttonToEnable) {
		this.bool1 = bool1;
		this.bool2 = bool2;
		this.buttonToEnable = buttonToEnable;
	}
	
	/**
	 * EventMethode. Bei ausfuehrung werden die beiden booleans ueberprueft.
	 */
	public void caretUpdate(CaretEvent arg0) {
		if (bool1 == true && bool2 == true) {
			buttonToEnable.setEnabled(true);
		}
		else {
			buttonToEnable.setEnabled(false);
		}
	}

	public Boolean getBool1() {
		return bool1;
	}

	public void setBool1(Boolean bool1) {
		this.bool1 = bool1;
	}

	public Boolean getBool2() {
		return bool2;
	}

	public void setBool2(Boolean bool2) {
		this.bool2 = bool2;
	}
	

}
