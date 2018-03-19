/**
 * Aktuelle Version: 1.2  
 * Authoren: Adrian (1.0, 1.1, 1.2), Konstantin (1.3)
 * 
 * Changelog:
 * 1.4
 * 		-Kunde als Zwischenattribut eingefügt
 * 1.3
 * 		-Singelton implementiert
 * 1.2
 * 		-ActionListener wieder entfernt!
 * 1.1
 * 		-ActionListener hinzugefügt!
 * 1.0 	
 * 		-Controller erstellt
 **/

package controller;

import javax.swing.JFrame;

import model.M_Kunde;
import view.V_KundeWaehlen;

public class C_KundeWaehlen {
	private static C_KundeWaehlen instance = null;
	private static V_KundeWaehlen view;
	private M_Kunde kunde;
	
	private C_KundeWaehlen(){
		view = new V_KundeWaehlen();
	}

	public JFrame getView() {
		return view;
	}
	public static C_KundeWaehlen getInstance() {

		if(instance==null) {
			instance = new C_KundeWaehlen();
		}
		return instance;
	}
	public void felderFuellen() {
		view.setText_pnl_ansprechpartner(kunde.getAnsprechpartner()+"");
		view.setText_pnl_branche(kunde.getBranche()+"");
		view.setText_pnl_bundesland(kunde.getAdresse().getBundesland()+"");
		view.setText_pnl_strasse(kunde.getAdresse().getStrasse()+"");
		view.setText_pnl_stadt(kunde.getAdresse().getStadt()+"");
		view.setText_pnl_kundenID(kunde.getKundenID()+"");
		view.setText_pnl_rufnummer(kunde.getTelefon()+"");
		view.setText_pnl_plz(kunde.getAdresse().getPLZ());
		view.setText_pnl_email(kunde.getEmail());
		view.setText_pnl_firmenname(kunde.getFirmenname());

	}

	public M_Kunde getKunde() {
		return kunde;
	}

	public void setKunde(M_Kunde kunde) {
		this.kunde = kunde;
		view.setKunde(kunde);
		
	}

	public static void setInstance(C_KundeWaehlen instance) {
		C_KundeWaehlen.instance = instance;
	}

	public static void setView(V_KundeWaehlen view) {
		C_KundeWaehlen.view = view;
	}
	
}
