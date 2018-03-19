/**
 * Aktuelle Version: 1.3 
 * Authoren: Julian (1.0), Adrian,Andreas (1.1, 1.2), Konstantin (1.3)
 * 
 * Changelog:
 * 1.3
 * 		-Singelton implementiert
 * 1.2
 * 		-ActionListener wieder entfernt! | getView hinzugefügt
 * 1.1
 * 		-ActionListener hinzugefügt!
 * 1.0 	
 * 		-Controller erstellt
 **/

package controller;

import view.V_TrainingLoeschen;

public class C_TrainingLoeschen {
	private static C_TrainingLoeschen instance = null;
	private static V_TrainingLoeschen view;
	
	private C_TrainingLoeschen(){
		view = new V_TrainingLoeschen();
	}
	public V_TrainingLoeschen getView() {
		return view;
	}
	public void setView(V_TrainingLoeschen view) {
		this.view = view;
	}
	public static C_TrainingLoeschen getInstance() {

		if(instance==null) {
			instance = new C_TrainingLoeschen();
		}
		return instance;
	}
	
}
