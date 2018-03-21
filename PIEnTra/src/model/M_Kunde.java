package model;

import java.util.ArrayList;

/**
 * ModellKLasse für den Kunden
 * @author Konstantin Frei
 */
public class M_Kunde {

	private static int interneID;
	private static ArrayList<M_Kunde> interneListe;
	private int kundenID;
	private String firmenname;
	private String branche;
	private String email;
	private String telefon;
	private M_Person ansprechpartner;
	private M_Adresse adresse;
	
	/**
	 * Konstruktor von {@link M_Kunde}.
	 * Pflegt automatisch eine statische Liste mit allen angelegten Kunden.
	 * @param firmenname Name der Firma z.B: "Aeron Pumpen AG"
	 * @param branche Bereich in dem die Firma tätig ist z.B: "Pharmaindustrie"
	 * @param email Kontankt unter der die Firma erreichbar ist: Mail z.B: "info@aeronpump-it.de"
	 * @param telefon ...: Telefon z.B: "+49 61466939"
	 * @param adresse ...: {@link M_Adresse}
	 * @param ansprechpartner ...: {@link M_Person}
	 */
	public M_Kunde(String firmenname, String branche, String email, String telefon, M_Adresse adresse, M_Person ansprechpartner) {
		setInterneID(getInterneID()+1);
		setKundenID(interneID);
		setFirmenname(firmenname);
		setBranche(branche);
		setTelefon(telefon);
		setEmail(email);
		setAnsprechpartner(ansprechpartner);
		setAdresse(adresse);
		if(M_Kunde.interneListe == null) {
			M_Kunde.interneListe =new ArrayList<M_Kunde>();
		}
		getInterneListe().add(this);
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

	/**
	 * Testmethode. Gibt alle Daten als String zurueck
	 */
	@Override
	public String toString() {
		String returnValue = "" + getFirmenname() + 
				"\nAnsprechpartner: " + getAnsprechpartner() +
				"\n"+ getAdresse() + 
				"\n" + getTelefon() + 
				"\nBranche: " + getBranche() + 
				"\n" + getEmail() + "";
		return returnValue;
	}

	public static ArrayList<M_Kunde> getInterneListe() {
		return interneListe;
	}

	public static void setInterneListe(ArrayList<M_Kunde> interneListe) {
		M_Kunde.interneListe = interneListe;
	}

}
