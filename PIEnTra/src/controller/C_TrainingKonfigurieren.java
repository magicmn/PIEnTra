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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.M_Kunde;
import utils.SimpleSwitchFrame;
import view.V_TrainingKonfigurieren;

public class C_TrainingKonfigurieren {
	
	private static C_TrainingKonfigurieren instance = null;
	private static V_TrainingKonfigurieren view;
	private M_Kunde kunde;
	
	private C_TrainingKonfigurieren(){
		view = new V_TrainingKonfigurieren();
		
	}

	public JFrame getView() {
		return view;
	}	
	
	public static C_TrainingKonfigurieren getInstance() {

		if(instance==null) {
			instance = new C_TrainingKonfigurieren();
		}
		return instance;
	}

	public M_Kunde getKunde() {
		return kunde;
	}

	public void setKunde(M_Kunde kunde) {
		this.kunde = kunde;
	}
	public void felderFuellen() {
		view.setText_pnl_kundenID(kunde.getKundenID()+"");
		view.setText_pnl_ansprechpartner(kunde.getAnsprechpartner()+"");
		view.setText_pnl_firmenname(kunde.getFirmenname());

	}
	
}