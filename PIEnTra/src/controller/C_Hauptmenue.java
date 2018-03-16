package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import utils.SimpleSwitchFrame;
import view.V_Hauptmenue;
/**
 * Aktuelle Version: 1.2  
 * Authoren: Julian (1.0, 1.1), Konstantin (1.2, 1.3)
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

public class C_Hauptmenue {
	
	private static C_Hauptmenue instance = null;
	private V_Hauptmenue view;

	private C_Hauptmenue() {
		view = new V_Hauptmenue();
	
	}
	public static C_Hauptmenue getInstance() {

		if(instance==null) {
			instance = new C_Hauptmenue();
		}
		return instance;
	}
	public JFrame getView() {
		return view;
	}

	
	
}
