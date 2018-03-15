package model;

import java.util.ArrayList;

/**
 * Modellklasse f�r eine Adresse.
 * @author Konstantin
 *
 */
public class M_Adresse {


	private static int interneID;
	private int adressID;
	
	private static ArrayList<M_Adresse> interneListe;
	private String strasse;
	
	private String bundesland;
	private String stadt;
	private String PLZ;

	public M_Adresse(String strasse, String bundesland, String stadt, String PLZ) {
		setInterneID(getInterneID()+1);
		setAdressID(getInterneID());
		setBundesland(bundesland);
		setPLZ(PLZ);
		setStadt(stadt);
		setStrasse(strasse);
		
		if(this.interneListe == null) {
			this.interneListe =new ArrayList<M_Adresse>();
		}
		getInterneListe().add(this);

	}

	public static int getInterneID() {
		return interneID;
	}

	public static void setInterneID(int interneID) {
		M_Adresse.interneID = interneID;
	}

	public int getAdressID() {
		return adressID;
	}

	public void setAdressID(int adressID) {
		this.adressID = adressID;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getBundesland() {
		return bundesland;
	}

	public void setBundesland(String bundesland) {
		this.bundesland = bundesland;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public String getPLZ() {
		return PLZ;
	}

	public void setPLZ(String pLZ) {
		PLZ = pLZ;
	}

	@Override
	public String toString() {

		return ""+getStrasse()+"\n"+getPLZ()+" "+getStadt()+"\n"+getBundesland();
	}

	public static ArrayList<M_Adresse> getInterneListe() {
		return interneListe;
	}

	public static void setInterneListe(ArrayList<M_Adresse> interneListe) {
		M_Adresse.interneListe = interneListe;
	}








}
