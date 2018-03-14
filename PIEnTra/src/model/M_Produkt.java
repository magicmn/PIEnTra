package model;

import java.util.ArrayList;

public class M_Produkt {

	private String produktID;
	private static ArrayList<M_Produkt> interneListe;
	private String bezeichnung;
	private String beschreibung;
	private double version;
	private ArrayList<M_Trainer> trainer;


	public M_Produkt(String produktID, String bezeichnung, String beschreibung, double version) {
		setProduktID(produktID);
		setBeschreibung(beschreibung);
		setBezeichnung(bezeichnung);
		setVersion(version);

		this.trainer = new ArrayList<M_Trainer>();

		

			

			if(this.interneListe == null) {
				this.interneListe =new ArrayList<M_Produkt>();
			}
			getInterneListe().add(this);

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

	/**
	 * Den Produkten werden die zuständige Trainer hinzugefügt
	 * @param trainer
	 */
	public void trainerHinzufuegen(M_Trainer trainer ) {
		if(trainer == null) {
			this.trainer = new ArrayList<M_Trainer>();
		}
		this.trainer.add(trainer);
	}


	@Override
	public String toString() {
		String trainers = "";


		if(getTrainer()!=null) {
			for(M_Trainer trainer: getTrainer()) {
				trainers = trainers + " " + trainer.getVorname()+ " "+ trainer.getNachname()+"\n";
			}
		}
		return ""+getBezeichnung()+" (Kürzel "+getProduktID()+")\n"+getBeschreibung()+"\nTrainer: "+ trainers;
	}


	public static ArrayList<M_Produkt> getInterneListe() {
		return interneListe;
	}


	public static void setInterneListe(ArrayList<M_Produkt> interneListe) {
		M_Produkt.interneListe = interneListe;
	}






}
