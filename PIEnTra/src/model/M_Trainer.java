package model;

import java.util.ArrayList;
/**
  Modellklasse für Trainer.
  Soll mindestens ein Produkt haben.
  Trainings wird durch die Methode trainingHinzufügen() initialisiert.
 * @author Konstantin
 *
 */
public class M_Trainer extends M_Person {
	private static int interneID;
	private static ArrayList<M_Trainer> interneListe;
	private int trainerID; 
	private ArrayList<M_Produkt> produkte;
	private ArrayList<M_Training> trainings ; //muss durch die Methode trainingHinzufügen() initialisiert werden


	public M_Trainer(String vorname, String nachname, M_Produkt ... produkte) {
		super(vorname, nachname);
		setInterneID(getInterneID()+1);
		setTrainerID(getInterneID());


		this.produkte = new ArrayList<M_Produkt>();
		for(int i  = 0; i<produkte.length; i++) {
			this.produkte.add(produkte[i]);
			produkte[i].trainerHinzufuegen(this); //Trainer wird automatisch den zugeordneten M_Produkten hinzugefügt als Attribut

		}
		if(this.interneListe == null) {
			this.interneListe =new ArrayList<M_Trainer>();
		}
		getInterneListe().add(this);




	}



	



	public static ArrayList<M_Trainer> getInterneListe() {
		return interneListe;
	}







	public static void setInterneListe(ArrayList<M_Trainer> interneListe) {
		M_Trainer.interneListe = interneListe;
	}







	public ArrayList<M_Training> getTrainings() {
		return trainings;
	}



	public void setTrainings(ArrayList<M_Training> trainings) {
		this.trainings = trainings;
	}



	@Override
	public String getVorname() {

		return super.getVorname();
	}

	@Override
	public void setVorname(String vorname) {

		super.setVorname(vorname);
	}

	@Override
	public String getNachname() {

		return super.getNachname();
	}

	@Override
	public void setNachname(String nachname) {

		super.setNachname(nachname);
	}

	public static int getInterneID() {
		return interneID;
	}

	public static void setInterneID(int interneID) {
		M_Trainer.interneID = interneID;
	}

	public int getTrainerID() {
		return trainerID;
	}

	public void setTrainerID(int trainerID) {
		this.trainerID = trainerID;
	}

	public ArrayList<M_Produkt> getProdukte() {
		return produkte;
	}

	public void setProdukte(ArrayList<M_Produkt> produkte) {
		this.produkte = produkte;
	}
	/**Ordnet einem Trainer ein weiteres Training hinzu
	 * 
	 * @param training
	 */
	public void trainingHinzufuegen(M_Training training ) {
		if(trainings == null) {
			trainings = new ArrayList<>();
		}
		trainings.add(training);
	}



	@Override
	public String toString() {
		String trainings = "";
		String produkte = "";

		if(getProdukte()!=null) {
			for(M_Produkt produkt : getProdukte()) {
				produkte = produkte+" "+ produkt.getProduktID() +"";
			}
		}

		if(getTrainings()!=null) {
			for(M_Training training : getTrainings()) {
				trainings = trainings+ " "+training.getTrainingsID() +"";
			}
		}


		return ""+getVorname()+", "+ getNachname()+ "\nProdukte: " + produkte +"\nTrainings: "+trainings+"";
	}




}
