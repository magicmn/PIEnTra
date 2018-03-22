/**
 * Aktuelle Version: 1.3
 * Authoren: Julian (1.0), Adrian (1.1, 1.2), Andreas (1.1), K0nstantin (1.3)
 * 
 * Changelog:
 * 1.3
 * 		-Singelton Implementiert* 
 * 1.2
 * 		-ActionListener wieder entfernt und in View implementiert!
 * 1.1
 * 		-ActionListener hinzugefügt!
 * 1.0 	
 * 		-Controller erstellt
 *
 **/


package controller;

import view.OLD_V_RessourceWaehlen;

public class OLD_C_RessourceWaehlen {
	private static OLD_C_RessourceWaehlen instance = null;
	private static OLD_V_RessourceWaehlen view;

	private OLD_C_RessourceWaehlen(){
		view = new OLD_V_RessourceWaehlen();
	}

	public OLD_V_RessourceWaehlen getView() {
		return view;
	}
	public void setView(OLD_V_RessourceWaehlen view) {
		OLD_C_RessourceWaehlen.view = view;
	}

	public static OLD_C_RessourceWaehlen getInstance() {

		if(instance==null) {
			instance = new OLD_C_RessourceWaehlen();
		}
		return instance;
	}
}


