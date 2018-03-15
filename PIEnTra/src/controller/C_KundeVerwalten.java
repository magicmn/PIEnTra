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

import view.V_KundeVerwalten;

public class C_KundeVerwalten {

	private V_KundeVerwalten view;
	
	public C_KundeVerwalten(){
		view = new V_KundeVerwalten();
		initListener();
	}
	private void initListener() {
		view.addBtn_kundeSuchenListener(new KundeSuchen());
		view.addBtn_kundeAktualisierenListener(new KundeAktualisieren());
		view.addBtn_kundeAnlegenListener(new KundeAnlegen());
		view.addBtn_hauptmenueListener(new Hauptmenue());
	}
	private class KundeSuchen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Kunde suchen!");
			new C_KundeSuchen();
		}
	}
	private class KundeAktualisieren implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Kunde aktualisieren!");
		}
	}
	private class KundeAnlegen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Kunde anlegen!");
		}
	}
	private class Hauptmenue implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Zurück zum Hauptmenü");
		}
	}
}

