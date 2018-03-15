/**
 * Aktuelle Version: 1.2 
 * Authoren: Julian (1.0), Adrian (1.1, 1.2), Andreas (1.1)
 * 
 * Changelog:
 * 1.0 	
 * 		-Controller erstellt
 * 1.1
 * 		-ActionListener hinzugefügt!
 * 1.2
 * 		-ActionListener wieder entfernt und in View implementiert!
 **/


package controller;

import model.M_Kunde;
import view.V_KundeVerwalten;

public class C_KundeVerwalten {

	private static V_KundeVerwalten view;
	private C_KundeSuchen suchview;
	private M_Kunde kunde;
	
	public C_KundeVerwalten(){
		view = new V_KundeVerwalten();

	}

	public static V_KundeVerwalten getView() {
		return view;
	}
	public void setView(V_KundeVerwalten view) {
		this.view = view;
	}
	public C_KundeSuchen getSuchview() {
		return suchview;
	}
	public void setSuchview(C_KundeSuchen suchview) {
		this.suchview = suchview;
	}
	public M_Kunde getKunde() {
		return kunde;
	}
	public void setKunde(M_Kunde kunde) {
		this.kunde = kunde;
	}
	
	
}

