/**
 * Aktuelle Version: 1.1 
 * Authoren: Julian (1.0), Adrian (1.1), Andreas (1.1)
 * 
 * Changelog:
 * 1.0 	
 * 		-Controller erstellt
 * 1.1
 * 		-ActionListener hinzugefügt!
 **/

package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.V_KundeSuchen;

public class C_KundeSuchen {
	
	private V_KundeSuchen view;
	
	public C_KundeSuchen(){
		view = new V_KundeSuchen();
		initListener();
	}
	private void initListener() {
		view.addBtn_kundeSuchenListener(new KundeSuchen());
		view.addBtn_abbrechenListener(new Abbrechen());
	}
	private class KundeSuchen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Kunde suchen!");
			
		}
	}
	private class Abbrechen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Abbrechen");
			view.setVisible(false);
		}
	}
}
