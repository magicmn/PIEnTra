package model;

import java.util.ArrayList;

public class M_Produkt {

	private String produktID;
	private String bezeichnung;
	private String beschreibung;
	private double version;
	private ArrayList<M_Trainer> trainer;

	
	public M_Produkt(String produktID, String bezeichnung, String beschreibung, double version, M_Trainer ... trainer) {
		setProduktID(produktID);
		setBeschreibung(beschreibung);
		setBezeichnung(bezeichnung);
		setVersion(version);
		
		this.trainer = new ArrayList<M_Trainer>();
		
		for(int i  = 0; i<trainer.length; i++) {
			this.trainer.add(trainer[i]);
			
			}
		
		
	}
	
	
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public Double getVersion() {
		return version;
	}
	public void setVersion(Double version) {
		this.version = version;
	}
	public String getProduktID() {
		return produktID;
	}
	public void setProduktID(String produktID) {
		this.produktID = produktID;
	}


	public ArrayList<M_Trainer> getTrainer() {
		return trainer;
	}


	public void setTrainer(ArrayList<M_Trainer> trainer) {
		this.trainer = trainer;
	}


	public void setVersion(double version) {
		this.version = version;
	}
	
	
	
	
}
