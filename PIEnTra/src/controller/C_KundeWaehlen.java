package controller;

<<<<<<< HEAD

//import java.lang.ModuleLayer.Controller;

=======

//import java.lang.ModuleLayer.Controller;

>>>>>>> branch 'master' of https://github.com/magicmn/PIEnTra.git
import javax.swing.JFrame;

import model.M_Kunde;
import view.V_KundeWaehlen;

/**
 * {@link controller} für KundeWahelen.
 * @version 1.5 JavaDoc hinzugefuegt.
 * @version 1.4 Kunde als Zwischenattribut eingefuegt.
 * @version 1.3 Singelton pattern implementiert
 * @version 1.2 ActionListener entfernt.
 * @version 1.1 ActionListener angelegt.
 * @version 1.0 Controller angelegt.
 * @author Adrian Fromm (1.0, 1.1, 1.2)
 * @author Julian Klein (1.5)
 * @author Konstantin Frei (1.3)
 * @see V_KundeWaehlen
 * @see M_Kunde
 */
public class C_KundeWaehlen {
	
	private static C_KundeWaehlen instance = null;
	private static V_KundeWaehlen view;
	
	private M_Kunde kunde;
	private static Object controller;
	
	/**
	 * Singelton. Privater Konstruktor der eine neue {@link view} von {@link V_KundeWaehlen} erstellt.
	 * @param controller Referenz zum aufrufendem {@link controller}.
	 * @see C_KundeWaehlen#getInstance()
	 */
	private C_KundeWaehlen(Object controller){
		C_KundeWaehlen.controller = controller;
		view = new V_KundeWaehlen(controller);
	}
	
	/**
	 * Singelton. Falls keine Instanz von {@link C_KundeWaehlen} existiert wird diese erstellt. Sonst wird diese einfach zurueck gegeben.
	 * @return {@link C_KundeWaehlen}
	 */
	public static C_KundeWaehlen getInstance() {

		if(instance==null) {
			instance = new C_KundeWaehlen(controller);
		}
		return instance;
	}

	/**
	 * Getter fuer die View. Gibt es noch keine Instanz der View wird diese erstellt.
	 * @return {@link V_KundeWaehlen}
	 */
	public JFrame getView() {
		if(view == null) {
			view = new V_KundeWaehlen(this);
		}
		return view;
	}
	
	/**
	 * Fuellt die Felder von {@link V_KundeWaehlen} mit Daten aus {@link M_Kunde}.
	 */
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
	
	/**
	 * Getter fuer {@link M_Kunde}.
	 * @return Instanz von {@link M_Kunde}
	 */
	public M_Kunde getKunde() {
		return kunde;
	}

	/**
	 * Setter fuer {@link M_Kunde}
	 * @param kunde Instanz von {@link M_Kunde} die verändert werden soll.
	 */
	public void setKunde(M_Kunde kunde) {
		this.kunde = kunde;
		view.setKunde(kunde);
	}

	/**
	 * Setter fuer die View {@link V_KundeWaehlen}.
	 * @param view {@link V_KundeWaehlen}
	 */
	public static void setView(V_KundeWaehlen view) {
		C_KundeWaehlen.view = view;
	}

}
