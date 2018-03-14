package model;

public class M_Ort {
	private static int interneID;
	private String ortsID;
	private String geschaefstsstelle;
	private String gebaeude;
	private int etage;
	private String raum;
	
	public M_Ort(String ortsID, String geschaeftsstelle, String gebaeude, int etage, String raum ){
		setInterneID(getInterneID()+1);
		setOrtsID(ortsID);
		setGeschaefstsstelle(geschaeftsstelle);
		setGebaeude(gebaeude);
		setEtage(etage);
		setRaum("Raum E"+etage+"-"+raum);
		
		
	}
	
	public static void main(String[] args) {

	}

	public String getOrtsID() {
		return ortsID;
	}

	private void setOrtsID(String ortsID) {
		this.ortsID=ortsID;
		
	}

	public static int getInterneID() {
		return interneID;
	}

	public static void setInterneID(int interneID) {
		M_Ort.interneID = interneID;
	}

	
	public String getGeschaefstsstelle() {
		return geschaefstsstelle;
	}

	public void setGeschaefstsstelle(String geschaefstsstelle) {
		this.geschaefstsstelle = geschaefstsstelle;
	}

	public String getGebaeude() {
		return gebaeude;
	}

	public void setGebaeude(String gebaeude) {
		this.gebaeude = gebaeude;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public String getRaum() {
		return raum;
	}

	public void setRaum(String raum) {
		this.raum = raum;
	}

	@Override
	public String toString() {
		
		
		return ""+getOrtsID()+ ", "+ getGeschaefstsstelle() + ", "+ getGebaeude()+ ", " + getRaum();
	}
	
	

	

}
