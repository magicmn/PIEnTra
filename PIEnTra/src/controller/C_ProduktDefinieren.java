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
	
	private static V_ProduktDefinieren view;

	public C_ProduktDefinieren(){
		view = new V_ProduktDefinieren();
	}

	public static JFrame getView() {
		return view;
	}
	
	
}
