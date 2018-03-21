package controller;

import model.M_Adresse;
import model.M_Kunde;
import model.M_Person;
import view.V_KundeVerwalten;

/**
 * {@link controller} fuer Kunde verwalten.
 * @version 1.4 Javadoc und kleine Code aenderungen
 * @version 1.3 Singelton implementiert
 * @version 1.2 ActionListener wieder entfernt
 * @version 1.1 ActionListener hinzugefuegt.
 * @version 1.0 Implementiert.
 * @author Adrian Fromm (1.1 & 1.2)
 * @author Andreas Kann (1.1)
 * @author Julian Klein (1.0 & 1.4
 **/
public class C_KundeVerwalten {
	
	private static C_KundeVerwalten instance = null;
	private static V_KundeVerwalten view;
	
	private M_Kunde kunde;

	/**
	 * Privater Konstruktor der eine neue View erstellt.
	 * @see C_KundeVerwalten#getInstance()
	 */
	private C_KundeVerwalten(){
		C_KundeVerwalten.view = new V_KundeVerwalten();
	}
	
	/**
	 * Singelton. Erstellt falls nicht vorhanden ein neues Objekt der Klasse. Ansonsten wird das vorhande zurueckgegeben.
	 * @return Aktuelle Instanz von {@link C_KundeVerwalten}.
	 * @see C_KundeVerwalten#C_KundeVerwalten()
	 */
	public static C_KundeVerwalten getInstance() {

		if(instance == null) {
			instance = new C_KundeVerwalten();
		}
		return instance;
	}

	/**
	 * Getter der die {@link view} von {@link C_KundeVerwalten} zurueck gibt.
	 * @return View von KundeVerwalten.
	 */
	public V_KundeVerwalten getView() {
		return view;
	}
	
	/**
	 * Setter mit der aenderungen am Objekt {@link V_KundeVerwalten} in {@link C_KundeVerwalten} vorgenommen werden können.
	 * @param view Lokale view
	 */
	public void setView(V_KundeVerwalten view) {
		C_KundeVerwalten.view = view;
	}

	/**
	 * Getter um {@link M_Kunde} zu erhalten welches in {@link C_KundeVerwalten} hinterlegt ist.
	 * @return
	 */
	public M_Kunde getKunde() {
		return kunde;
	}
	
	/**
	 * Setter um {@link M_Kunde} zu aendern welches in {@link C_KundeVerwalten} hinterlegt ist.
	 * @param kunde
	 */
	public void setKunde(M_Kunde kunde) {
		this.kunde = kunde;
	}
	
	/**
	 * Methode um in der {@link view} {@link V_KundeVerwalten} die Felder mit Werten aus {@link M_Kunde} zu fuellen.
	 */
	public void felderFuellen() {
		view.setText_pnl_ansprechpartner(kunde.getAnsprechpartner() + "");
		view.setText_pnl_branche(kunde.getBranche() + "");
		view.setText_pnl_bundesland(kunde.getAdresse().getBundesland() + "");
		view.setText_pnl_strasse(kunde.getAdresse().getStrasse() + "");
		view.setText_pnl_stadt(kunde.getAdresse().getStadt() + "");
		view.setText_pnl_kundenID(kunde.getKundenID() + "");
		view.setText_pnl_rufnummer(kunde.getTelefon() + "");
		view.setText_pnl_plz(kunde.getAdresse().getPLZ());
		view.setText_pnl_email(kunde.getEmail());
		view.setText_pnl_firmenname(kunde.getFirmenname());
	}
	
	/**
	 * Methode die in {@link V_KundeVerwalten} eingegebene Daten in das {@link model} {@link M_Kunde} uebergibt.
	 */
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
	
	//@TODO JavaDoc fehlt
	/**
	 * 
	 */
	public void kundeAnlegen() {
		String vorname = "";
		String nachname = "";
		if(view.getText_pnl_ansprechpartner().contains(", *")) {
			String[] ansprechpartner = view.getText_pnl_ansprechpartner().split(", ");
			nachname = ansprechpartner[ansprechpartner.length];
			for(int i = 0; i <= ansprechpartner.length-1; i++) { 
				vorname = vorname + ", " + ansprechpartner[i];
			}
		} else {
			vorname = view.getText_pnl_ansprechpartner();
		}
		kunde = new M_Kunde(view.getText_pnl_firmenname(), view.getText_pnl_branche(), view.getText_pnl_email(), view.getText_pnl_rufnummer(), 
				new M_Adresse(view.getText_pnl_strasse(), view.getText_pnl_bundesland(), view.getText_pnl_stadt(), view.getText_pnl_plz()), 
				new M_Person(vorname, nachname));
		view.setText_pnl_kundenID(kunde.getKundenID() + "");
	}

	public boolean checkKundeAktualisieren() {
		if(view.getText_pnl_plz().equals("")||view.getText_pnl_bundesland().equals("")||view.getText_pnl_strasse().equals("")||view.getText_pnl_stadt().equals("")||view.getText_pnl_email().equals("")||view.getText_pnl_firmenname().equals("")||view.getText_pnl_branche().equals("")||view.getText_pnl_rufnummer().equals("")||view.getText_pnl_ansprechpartner().equals("")){
			return false;
		}
		else{
		return true;
		}
	}
}


