package model;

public class M_Kunde {

	private static int interneID;
	private int kundenID;
	private String firmenname;
	private String branche;
	private String email;
	private String telefon;
	private M_Person ansprechpartner;
	private M_Adresse adresse;

	public M_Kunde(String firmenname, String branche, String email, String telefon, M_Adresse adresse, M_Person ansprechpartner) {
		setInterneID(getInterneID()+1);
		setKundenID(interneID);
		setFirmenname(firmenname);
		setBranche(branche);
		setTelefon(telefon);
		setEmail(email);
		setAnsprechpartner(ansprechpartner);
		setAdresse(adresse);
	}



	public int getKundenID() {
		return kundenID;
	}
	public void setKundenID(int kundenID) {
		this.kundenID = kundenID;
	}
	public String getFirmenname() {
		return firmenname;
	}
	public void setFirmenname(String firmenname) {
		this.firmenname = firmenname;
	}
	public String getBranche() {
		return branche;
	}
	public void setBranche(String branche) {
		this.branche = branche;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public M_Person getAnsprechpartner() {
		return ansprechpartner;
	}
	public void setAnsprechpartner(M_Person ansprechpartner) {
		this.ansprechpartner = ansprechpartner;
	}
	public static int getInterneID() {
		return interneID;
	}
	public static void setInterneID(int interneID) {
		M_Kunde.interneID = interneID;
	}



	public M_Adresse getAdresse() {
		return adresse;
	}



	public void setAdresse(M_Adresse adresse) {
		this.adresse = adresse;
	}



	@Override
	public String toString() {
		
		return ""+getFirmenname()+" \nAnsprechpartner: "+ getAnsprechpartner()+"\n"+ getAdresse()+"\n"+getTelefon()+"\nBranche: "+ getBranche()+ "\n"+getEmail()+"";
	}
	
}
