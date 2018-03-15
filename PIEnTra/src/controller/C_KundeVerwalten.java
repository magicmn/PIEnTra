/**
 * Aktuelle Version: 1.3
 * Authoren: Julian (1.0), Adrian (1.1, 1.2), Andreas (1.1), K0nstantin (1.3)
 * 
 * Changelog:
 * 1.0 	
 * 		-Controller erstellt
 * 1.1
 * 		-ActionListener hinzugefügt!
 * 1.2
 * 		-ActionListener wieder entfernt und in View implementiert!
 * 1.3
 * 		-Singelton Implementiert
 **/


package controller;

import model.M_Kunde;
import view.V_KundeVerwalten;

public class C_KundeVerwalten {
	private static C_KundeVerwalten instance = null;
	private static V_KundeVerwalten view;

	private M_Kunde kunde;

	private C_KundeVerwalten(){
		view = new V_KundeVerwalten();
	}

	public static V_KundeVerwalten getView() {
		return view;
	}
	public void setView(V_KundeVerwalten view) {
		this.view = view;
	}

	public M_Kunde getKunde() {
		return kunde;
	}
	public void setKunde(M_Kunde kunde) {
		this.kunde = kunde;
	}

	public static C_KundeVerwalten getInstance() {

		if(instance==null) {
			instance = new C_KundeVerwalten();
		}
		return instance;
	}
}


