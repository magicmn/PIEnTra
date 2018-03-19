/**
 * Aktuelle Version: 1.3  
 * Authoren: Julian (1.0), Adrian (1.1) Konstantin (1.2, 1.3)
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


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import model.M_Kunde;
import utils.SimpleSearch;
import view.V_KundeSuchen;

public class C_KundeSuchen {
	
	
	private static C_KundeSuchen instance = null;
	private V_KundeSuchen view;
	
	
	private C_KundeSuchen(){
		view = new V_KundeSuchen();
	}
	
	public static C_KundeSuchen getInstance() {
		if(instance==null) {
			instance = new C_KundeSuchen();
		}
		return instance;
	}

	public V_KundeSuchen getView() {
		return view;
		
	}
	
}
