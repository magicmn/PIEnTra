package model;

import java.util.ArrayList;

public class M_ManagementAssistent extends M_Person{
	private static int interneID;
	private int mitarbeiterID;
	private ArrayList<M_Training> trainings;
	public M_ManagementAssistent(String vorname, String nachname, M_Training ...trainings) {
		super(vorname, nachname);
		setInterneID(getInterneID()+1);
		setMitarbeiterID(getInterneID());
		this.trainings = new ArrayList<M_Training>();
		for(int i  = 0; i<trainings.length; i++) {
			this.trainings.add(trainings[i]);
			
		}
		
		
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
	
}
