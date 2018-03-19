package model;

import java.util.ArrayList;

/**
 * Modellklasse für Training sollte als letzte Modellklasse erzeugt werden.
 * 
 * 
 * @author Konstantin
 *
 */
public class M_Training {
	private static int interneID;
	private static ArrayList<M_Training> interneListe;
	private String  trainingsID;
	private String anfangsdatum; //zu ändern
	private String enddatum; //zu ändern
	private int tage;
	private String bemerkungen;
	private M_Produkt produkt;
	private M_Ort ort;
	private M_Kunde kunde;
	private M_Trainer trainer;
	private ArrayList<M_ManagementAssistent> managementAssistente;


	/**
	 * Mehrere {@link M_ManagementAssistent} können übergeben werden.
	 * @param anfangsdatum
	 * @param trainer
	 * @param ort
	 * @param kunde
	 * @param enddatum
	 * @param tage
	 * @param bemerkungen
	 * @param produkt
	 * @param assistents
	 */
	public M_Training(String anfangsdatum, M_Trainer trainer,
			M_Ort ort, M_Kunde kunde, String  enddatum, int tage,
			String bemerkungen, M_Produkt produkt, M_ManagementAssistent ...assistents ) {


		setInterneID(getInterneID()+1);
		
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
			assistents[i].trainingHinzufuegen(this);
			
		setTrainingsID(idGenerieren());
		

			

		}
		if(this.interneListe == null) {
			this.interneListe =new ArrayList<M_Training>();
		}
		getInterneListe().add(this);



	}

	public static ArrayList<M_Training> getInterneListe() {
		return interneListe;
	}

	public static void setInterneListe(ArrayList<M_Training> interneListe) {
		M_Training.interneListe = interneListe;
	}

	public ArrayList<M_ManagementAssistent> getManagementAssistente() {
		return managementAssistente;
	}

	public void setManagementAssistente(ArrayList<M_ManagementAssistent> managementAssistente) {
		this.managementAssistente = managementAssistente;
	}

	public String getTrainingsID() {
		return trainingsID;
	}
	public void setTrainingsID(String trainingsID) {
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

	/**
	 * 
	 */
	@Override
	public String toString() {
		String mAssistents = "";
		if(getManagementAssistente() != null) {
			for(M_ManagementAssistent mAssistent : getManagementAssistente()) {
				mAssistents = mAssistents+ " \n" + mAssistent.getVorname()+", " + mAssistent.getNachname() + "";
			}
		}

		return "Training ID: "+getTrainingsID()+"\n"+getKunde()+"\n"+"Anfangsdatum: "+getAnfangsdatum()+
				"\nEnddatum: "+ getEnddatum()+"\nTage: "+getTage()+"\nTrainer: "+
				getTrainer().getVorname()+", "+getTrainer().getNachname()+"\nOrt:"+getOrt()+"\nBemerkungen: "+getBemerkungen();
	}
	
	public String idGenerieren() {
		return ""+getProdukt().getProduktID()+".D"+getAnfangsdatum()+".K"+getKunde().getKundenID()+".ID"+getInterneID();
		
	}






}
