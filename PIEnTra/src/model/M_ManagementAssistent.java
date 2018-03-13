package model;

import java.util.ArrayList;

public class M_ManagementAssistent extends M_Person{
	private static int interneID;
	private int mitarbeiterID;
	private ArrayList<M_Training> trainings;
	public M_ManagementAssistent(String vorname, String nachname) {
		super(vorname, nachname);
		setInterneID(getInterneID()+1);
		setMitarbeiterID(getInterneID());
		
		
		
		
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
		// TODO Auto-generated method stub
		return super.getVorname();
	}





	@Override
	public void setVorname(String vorname) {
		// TODO Auto-generated method stub
		super.setVorname(vorname);
	}





	@Override
	public String getNachname() {
		// TODO Auto-generated method stub
		return super.getNachname();
	}





	@Override
	public void setNachname(String nachname) {
		// TODO Auto-generated method stub
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
	
}
