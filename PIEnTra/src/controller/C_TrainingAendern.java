/**
 * Aktuelle Version: 1.3 
 * Authoren: Julian (1.0), Adrian(1.1, 1.2), Konstantin (1.3)
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

import javax.swing.JFrame;

import view.V_TrainingAendern;

public class C_TrainingAendern {

	private static C_TrainingAendern instance = null;
	private static V_TrainingAendern view;
	
	private C_TrainingAendern(){
		view = new V_TrainingAendern();
	}

	public JFrame getView() {
		return view;
	}
	public static C_TrainingAendern getInstance() {

		if(instance==null) {
			instance = new C_TrainingAendern();
		}
		return instance;
	}
}
