/**
 * Aktuelle Version: 1.1  
 * Authoren: Julian (1.0), Adrian (1.1), Andreas (1.1)
 * 
 * Changelog:
 * 1.0 	
 * 		-Controller erstellt
 * 1.1
 * 		-ActionListener hinzugefügt!
 * 1.2
 * 		-ActionListener wieder entfernt!
 **/

package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import model.M_Kunde;
import utils.SimpleSearch;
import view.V_KundeSuchen;

public class C_KundeSuchen {
	
	private V_KundeSuchen view;
	
	
	public C_KundeSuchen(){
		view = new V_KundeSuchen();
	}
	
}
