/**
 * Aktuelle Version: 1.3 
 * Authoren: Julian (1.0), Adrian(1.1, 1.2), Konstantin (1.3)
 * 
 * Changelog:
 * 1.3
 * 		-Singelton implementiert
 * 1.2
 * 		-ActionListener entfernt und in View implementiert!
 * 1.1
 * 		-ActionListener hinzugefügt!
 * 1.0 	
 * 		-Controller erstellt
 **/

package controller;

import javax.swing.JFrame;

import model.M_Ort;
import model.M_Produkt;
import model.M_Trainer;
import model.M_Training;
import view.V_TrainingAendern;

public class C_TrainingAendern {

	private static C_TrainingAendern instance = null;
	private static V_TrainingAendern view;
	private M_Training training;
	private M_Produkt produkt;
	private M_Trainer trainer;
	private M_Ort ort;
	
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
		view.setText_pnl_ansprechpartner(training.getKunde().getAnsprechpartner().getVorname() + " " + training.getKunde().getAnsprechpartner().getNachname());
	    view.setText_pnl_produktbeschreibung(training.getProdukt().getBezeichnung());
		view.setText_pnl_startdatum(training.getAnfangsdatum());
		view.setText_pnl_enddatum(training.getEnddatum());
		view.setText_pnl_tage(training.getTage()+"");
		view.setText_pnl_trainer(training.getTrainer().getVorname()+", "+training.getTrainer().getNachname());
		view.setText_pnl_ort(training.getOrt().getOrtsID());
		view.setText_pnl_bemerkungen(training.getBemerkungen());
		setTraining(training);
		setProdukt(training.getProdukt());
		setTrainer(training.getTrainer());
		setOrt(training.getOrt());
	}
	public void felderFuellen(M_Produkt produkt, M_Trainer trainer, M_Ort ort) {
		
		setProdukt(produkt);
		setTrainer(trainer);
		setOrt(ort);
		view.setText_pnl_firmenname(training.getKunde().getFirmenname());
		view.setText_pnl_ansprechpartner(training.getKunde().getAnsprechpartner().getVorname() + " " + training.getKunde().getAnsprechpartner().getNachname());
	    view.setText_pnl_produktbeschreibung(getProdukt().getBezeichnung());
		view.setText_pnl_startdatum(training.getAnfangsdatum());
		view.setText_pnl_enddatum(training.getEnddatum());
		view.setText_pnl_tage(training.getTage()+"");
		view.setText_pnl_trainer(getTrainer().getVorname()+", "+getTrainer().getNachname());
		view.setText_pnl_ort(getOrt().getOrtsID());
		view.setText_pnl_bemerkungen(training.getBemerkungen());
	}
	
	public void updateTraining() {
		training.setAnfangsdatum(view.getText_pnl_startdatum());
		training.setEnddatum(view.getText_pnl_enddatum());
		training.setTage(Integer.parseInt(view.getText_pnl_tage()));
		training.setProdukt(this.getProdukt());
	}
	
	public void ressourcenAnzeigen() {
		
	}

	public M_Training getTraining() {
		return training;
	}

	public void setTraining(M_Training training) {
		this.training = training;
	}

	public M_Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(M_Produkt produkt) {
		this.produkt = produkt;
	}

	public M_Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(M_Trainer trainer) {
		this.trainer = trainer;
	}

	public M_Ort getOrt() {
		return ort;
	}

	public void setOrt(M_Ort ort) {
		this.ort = ort;
	}
	

}