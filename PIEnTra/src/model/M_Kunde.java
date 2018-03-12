package model;

public class M_Kunde {
	
	private int kundenID;
	private String firmenname;
	private String branche;
	private String email;
	private String telefon;
	private String ansprechpartner;
	
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
	public String getAnsprechpartner() {
		return ansprechpartner;
	}
	public void setAnsprechpartner(String ansprechpartner) {
		this.ansprechpartner = ansprechpartner;
	}
}
