/**
 * Aktuelle Version: 1.2  
 * Authoren: Adrian (1.0, 1.1, 1.2), Konstantin (1.3)
 * 
 * Changelog:
 * 1.3
 * 		-Singelton implementiert
 * 1.2
 * 		-ActionListener wieder entfernt!
 * 1.1
 * 		-ActionListener hinzugefügt!
 * 1.0 	
 * 		-Controller erstellt
 **/

package controller;

import javax.swing.JFrame;

import view.V_KundeWaehlen;

public class C_KundeWaehlen {
	private static C_KundeWaehlen instance = null;
	private static V_KundeWaehlen view;
	
	private C_KundeWaehlen(){
		view = new V_KundeWaehlen();
	}

	public JFrame getView() {
		return view;
	}
	public static C_KundeWaehlen getInstance() {

		if(instance==null) {
			instance = new C_KundeWaehlen();
		}
		return instance;
	}
}
