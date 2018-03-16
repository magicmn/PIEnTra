/**
 * Aktuelle Version: 1.2  
 * Authoren: Adrian (1.0, 1.1, 1.2), Konstantin (1.3)
 * 
 * Changelog:
 * 1.3
 * 		-Singelton implementiert
 * 1.2
 * 		-ActionListener wieder entfernt und in View implementiert!
 * 1.1
 * 		-ActionListener hinzugefügt!
 * 1.0 	
 * 		-Controller erstellt
 **/

package controller;

import javax.swing.JFrame;

import view.V_ProduktDefinieren;

public class C_ProduktDefinieren {
	
	private static C_ProduktDefinieren instance = null;
	private static V_ProduktDefinieren view;

	private C_ProduktDefinieren(){
		view = new V_ProduktDefinieren();
	}

	public JFrame getView() {
		return view;
	}
	public static C_ProduktDefinieren getInstance() {

		if(instance==null) {
			instance = new C_ProduktDefinieren();
		}
		return instance;
	}
	
	
}
