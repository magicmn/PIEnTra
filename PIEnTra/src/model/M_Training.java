package model;

public class M_Training {
	private int trainingsID;
	private String anfangsdatum;
	private String enddatum;
	private int tage;
	
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
	private String bemerkungen;
}
