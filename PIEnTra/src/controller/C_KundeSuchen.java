/**
 * Aktuelle Version: 1.3  
 * Authoren: Julian (1.0), Adrian (1.1) Konstantin (1.2, 1.3,1.4)
 * 
 * Changelog:
 * 1.4
 * 		-getView() erweitert
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


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import model.M_Kunde;
import utils.SimpleSearch;
import view.V_KundeSuchen;

public class C_KundeSuchen {
	
	
	private static C_KundeSuchen instance = null;
	private V_KundeSuchen view;
	private static Object controller;
	
	
	private C_KundeSuchen(Object controller){
		this.controller = controller;
		view = new V_KundeSuchen(controller);
	}
	
	public static C_KundeSuchen getInstance(Object controller) {
		if(instance==null) {
			instance = new C_KundeSuchen(controller);
		}
		setController(controller);
		return instance;
	}

	public V_KundeSuchen getView() {
		if(view==null) {
			view = new V_KundeSuchen(controller);
		}
		view.setVisible(true);
		view.setText_pnl_firmenname("");
		view.setText_pnl_kundenID("");
		return view;
		
	}

	public static Object getController() {
		return controller;
	}

	public static void setController(Object controller) {
		C_KundeSuchen.controller = controller;
	}
	
	
}
