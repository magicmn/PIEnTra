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

import model.M_Training;
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
	public void felderFuellen(M_Training training) {
		
		view.setText_pnl_firmenname(training.getKunde().getFirmenname());
		view.setText_pnl_ansprechpartner(training.getTrainer().getVorname() + " " + training.getTrainer().getNachname());
	    view.setText_pnl_produktbeschreibung(training.getProdukt().getBeschreibung());
		view.setText_pnl_startdatum(training.getAnfangsdatum());
		view.setText_pnl_enddatum(training.getEnddatum());
		view.setText_pnl_tage(training.getTage()+"");
		view.setText_pnl_trainer(training.getTrainer().getTrainerID()+"");
		view.setText_pnl_ort(training.getOrt().getOrtsID());
		view.setText_pnl_bemerkungen(training.getBemerkungen());
	}
}