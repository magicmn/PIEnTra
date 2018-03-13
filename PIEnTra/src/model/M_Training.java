package model;

import java.util.ArrayList;

public class M_Training {
	private static int interneID;
	private int trainingsID;
	private String anfangsdatum; //zu ändern
	private String enddatum; //zu ändern
	private int tage;
	private String bemerkungen;
	private M_Produkt produkt;
	private M_Ort ort;
	private M_Kunde kunde;
	private M_Trainer trainer;
	private ArrayList<M_ManagementAssistent> managementAssistente;
	
	

	public M_Training(String anfangsdatum, M_Trainer trainer,
			M_Ort ort, M_Kunde kunde, String  enddatum, int tage,
			String bemerkungen, M_Produkt produkt, M_ManagementAssistent ...assistents ) {
		
		
		setInterneID(getInterneID()+1);
		setTrainingsID(interneID);
		setAnfangsdatum(anfangsdatum);
		setEnddatum(enddatum);
		setTage(tage);
		setBemerkungen(bemerkungen);
		setProdukt(produkt);
		setOrt(ort);
		setKunde(kunde);
		setTrainer(trainer);
		this.managementAssistente = new ArrayList<M_ManagementAssistent>();
		for(int i  = 0; i<assistents.length; i++) {
			this.managementAssistente.add(assistents[i]);
			
		}
		
		
		
	}
	
	public ArrayList<M_ManagementAssistent> getManagementAssistente() {
		return managementAssistente;
	}

	public void setManagementAssistente(ArrayList<M_ManagementAssistent> managementAssistente) {
		this.managementAssistente = managementAssistente;
	}

	public int getTrainingsID() {
		return trainingsID;
	}
	public void setTrainingsID(int trainingsID) {
		this.trainingsID = trainingsID;
	}
	public String getAnfangsdatum() {
		return anfangsdatum;
	}
	public void setAnfangsdatum(String anfangsdatum) {
		this.anfangsdatum = anfangsdatum;
	}
	public String getEnddatum() {
		return enddatum;
	}
	public void setEnddatum(String enddatum) {
		this.enddatum = enddatum;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public String getBemerkungen() {
		return bemerkungen;
	}
	public void setBemerkungen(String bemerkungen) {
		this.bemerkungen = bemerkungen;
	}

	public static int getInterneID() {
		return interneID;
	}

	public static void setInterneID(int interneID) {
		M_Training.interneID = interneID;
	}

	public M_Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(M_Produkt produkt) {
		this.produkt = produkt;
	}

	public M_Ort getOrt() {
		return ort;
	}

	public void setOrt(M_Ort ort) {
		this.ort = ort;
	}

	public M_Kunde getKunde() {
		return kunde;
	}

	public void setKunde(M_Kunde kunde) {
		this.kunde = kunde;
	}

	public M_Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(M_Trainer trainer) {
		this.trainer = trainer;
	}
	
}
