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

import view.V_RessourceAendern;

public class C_RessourceAendern {
	private static C_RessourceAendern instance = null;
	private static V_RessourceAendern view;

	private C_RessourceAendern(){
		view = new V_RessourceAendern();
	}

	public V_RessourceAendern getView() {
		return view;
	}
	public void setView(V_RessourceAendern view) {
		this.view = view;
	}

	public static C_RessourceAendern getInstance() {

		if(instance==null) {
			instance = new C_RessourceAendern();
		}
		return instance;
	}
}


