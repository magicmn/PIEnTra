/**
 * Aktuelle Version: 1.3
 * Authoren: Julian (1.0), Adrian (1.1, 1.2), Andreas (1.1), K0nstantin (1.3)
 * 
 * Changelog:
 * 1.3
 * 		-Singelton Implementiert* 
 * 1.2
 * 		-ActionListener wieder entfernt und in View implementiert!
 * 1.1
 * 		-ActionListener hinzugefügt!
 * 1.0 	
 * 		-Controller erstellt
 *
 **/


package controller;

import model.M_Adresse;
import model.M_Kunde;
import model.M_Person;
import view.V_KundeVerwalten;

public class C_KundeVerwalten {
	private static C_KundeVerwalten instance = null;
	private static V_KundeVerwalten view;

	private M_Kunde kunde;

	private C_KundeVerwalten(){
		view = new V_KundeVerwalten();
	}

	public V_KundeVerwalten getView() {
		return view;
	}
	public void setView(V_KundeVerwalten view) {
		this.view = view;
	}

	public M_Kunde getKunde() {
		return kunde;
	}
	public void setKunde(M_Kunde kunde) {
		this.kunde = kunde;
	}

	public static C_KundeVerwalten getInstance() {

		if(instance==null) {
			instance = new C_KundeVerwalten();
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
	public void kundeAktualisieren() {
		kunde.getAdresse().setPLZ(view.getText_pnl_plz());
		kunde.getAdresse().setBundesland(view.getText_pnl_bundesland());
		kunde.getAdresse().setStrasse(view.getText_pnl_strasse());
		kunde.getAdresse().setStadt(view.getText_pnl_stadt());
		kunde.setEmail(view.getText_pnl_email());
		kunde.setFirmenname(view.getText_pnl_firmenname());
		kunde.setBranche(view.getText_pnl_branche());
		kunde.setTelefon(view.getText_pnl_rufnummer());
		String[] ansprechpartner = view.getText_pnl_ansprechpartner().split(", ");
		kunde.getAnsprechpartner().setVorname(ansprechpartner[0]);
		kunde.getAnsprechpartner().setNachname(ansprechpartner[1]);	


	}
	public void kundeAnlegen() {
		String vorname = "";
		String nachname = "";
		if(view.getText_pnl_ansprechpartner().contains(", *")) {
			String[] ansprechpartner = view.getText_pnl_ansprechpartner().split(", ");

			nachname = ansprechpartner[ansprechpartner.length];
			for(int i = 0; i <= ansprechpartner.length-1;i++) { 
				vorname = vorname + ", "+ansprechpartner[i];
			}
		}
		else {
			vorname = view.getText_pnl_ansprechpartner();

		}





		kunde = new M_Kunde(view.getText_pnl_firmenname(), view.getText_pnl_branche(), view.getText_pnl_email(), view.getText_pnl_rufnummer(), 
				new M_Adresse(view.getText_pnl_strasse(), view.getText_pnl_bundesland(), view.getText_pnl_stadt(), view.getText_pnl_plz()), 

				new M_Person(vorname, nachname));
		view.setText_pnl_kundenID(kunde.getKundenID()+"");
	}
}


