/**
 * @ersion 1.3 Singelton implementiert
 * @version 1.2 ActionListener wieder entfernt.
 * @version 1.1 ActionListener hinzugefuegt.
 * @version 1.0 Erstellt.
 * @author Adrian Fromm (1.1 & 1.2)
 * @author Julian Klein (1.0)
 * @author Konstantin Frei (1.3)
 **/

package controller;

import javax.swing.JFrame;

import model.M_Kunde;
<<<<<<< HEAD
import model.M_Ort;
import model.M_Produkt;
import model.M_Trainer;
import model.M_Training;
=======
>>>>>>> branch 'master' of https://github.com/magicmn/PIEnTra.git
import view.V_TrainingKonfigurieren;

public class C_TrainingKonfigurieren {

	private static C_TrainingKonfigurieren instance = null;
	private static V_TrainingKonfigurieren view;
	private M_Kunde kunde;
	private M_Training training;
	private M_Produkt produkt;
	private M_Trainer trainer;
	private M_Ort ort;

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
		if(kunde!=null) {
			view.setText_pnl_kundenID(kunde.getKundenID()+"");
			view.setText_pnl_ansprechpartner(kunde.getAnsprechpartner()+"");
			view.setText_pnl_firmenname(kunde.getFirmenname());
		}
		

	}
public void felderFuellen(M_Produkt produkt, M_Trainer trainer, M_Ort ort) {
		
		setProdukt(produkt);
		setTrainer(trainer);
		setOrt(ort);
		
		view.setText_pnl_produktbeschreibung(getProdukt().getBezeichnung());
		view.setText_pnl_trainer(getTrainer().getVorname()+", "+getTrainer().getNachname());
		view.setText_pnl_ort(getOrt().getOrtsID());
		
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