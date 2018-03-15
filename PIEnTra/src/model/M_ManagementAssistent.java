package model;

import java.util.ArrayList;
/**
 * Modellklasse für ManagemetAssistenten
 * @author Konstantin
 *
 */
public class M_ManagementAssistent extends M_Person{
	private static int interneID;
	private static ArrayList<M_ManagementAssistent> interneListe;
	private int mitarbeiterID;
	private ArrayList<M_Training> trainings;
	public M_ManagementAssistent(String vorname, String nachname) {
		super(vorname, nachname);
		setInterneID(getInterneID()+1);
		setMitarbeiterID(getInterneID());
		
		if(this.interneListe == null) {
			this.interneListe =new ArrayList<M_ManagementAssistent>();
		}
		getInterneListe().add(this);




	}





	public ArrayList<M_Training> getTrainings() {
		return trainings;
	}





	public void setTrainings(ArrayList<M_Training> trainings) {
		this.trainings = trainings;
	}





	public int getMitarbeiterID() {
		return mitarbeiterID;
	}
	public void setMitarbeiterID(int mitarbeiterID) {
		this.mitarbeiterID = mitarbeiterID;
	}





	public static int getInterneID() {
		return interneID;
	}





	public static void setInterneID(int interneID) {
		M_ManagementAssistent.interneID = interneID;
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

	/**Ordnet einem Assistenten ein weiteres Training hinzu
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

		if(getTrainings() != null) {
			for(M_Training training : getTrainings()) {
				trainings = trainings+ " "+training.getTrainingsID() +"";
			}
		}


		return ""+getVorname()+", "+ getNachname()+ "\nTrainings: "+trainings+"";


	}





	public static ArrayList<M_ManagementAssistent> getInterneListe() {
		return interneListe;
	}





	public static void setInterneListe(ArrayList<M_ManagementAssistent> interneListe) {
		M_ManagementAssistent.interneListe = interneListe;
	}



}
