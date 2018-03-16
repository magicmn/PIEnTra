/**
 * Aktuelle Version: 1.0
 * Authoren: Adrian (1.0)
 * 
 * Changelog:
 * 1.0 	
 * 		-Controller erstellt
 * 		-Erzeugt view
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
