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

import view.V_RessourceWaehlen;

public class C_RessourceWaehlen {
	private static C_RessourceWaehlen instance = null;
	private static V_RessourceWaehlen view;

	private C_RessourceWaehlen(){
		view = new V_RessourceWaehlen();
	}

	public V_RessourceWaehlen getView() {
		return view;
	}
	public void setView(V_RessourceWaehlen view) {
		C_RessourceWaehlen.view = view;
	}

	public static C_RessourceWaehlen getInstance() {

		if(instance==null) {
			instance = new C_RessourceWaehlen();
		}
		return instance;
	}
}


