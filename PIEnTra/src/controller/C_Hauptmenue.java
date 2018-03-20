package controller;

import javax.swing.JFrame;

import view.V_Hauptmenue;
/**
 * Controller des Hauptmenues erstellt eine neue {@link view.V_Hauptmenue}.
 * @version 1.4 Javadoc überarbeitet.
 * @version 1.3 Singeloton implementiert.
 * @version 1.2 ActionListener entfernt.
 * @version 1.1 ActionListener hibzugefuegt.
 * @version 1.0 Controller erstellt.
 * @author Julian Klein (1.0, 1.1 & 1.4)
 * @author Konstantin Frei (1.2 & 1.3)
 **/
public class C_Hauptmenue {
	
	private static C_Hauptmenue instance = null;
	private V_Hauptmenue view;

	/** 
	 * Private Konstruktor von {@link controller.C_Hauptmenue}.
	 * Initialisiert eine neue {@link view} von {@link view.V_Hauptmenue}.
	 * Private verhindert, dass einfach so ein neues Objekt von {@link C_Hauptmenue} erstellt wird.
	 * @see #getInstance()
	 **/
	private C_Hauptmenue() {
		view = new V_Hauptmenue();
	}
	
	/**
	 * Singelton pattern. Nur wenn noch kein Objekt vom Typ {@link C_Hauptmenu} vorhanden ist wird eins erstellt.
	 * @return Gibt das Objekt zuürck.
	 * @see #C_Hauptmenue()
	 */
	public static C_Hauptmenue getInstance() {
		if(instance==null) {
			instance = new C_Hauptmenue();
		}
		return instance;
	}
	
	/**
	 * Getter für die View
	 * @return Gibt {@link view} vom Typen {@link V_Hauptmenue} zurueck
	 */
	public JFrame getView() {
		return view;
	}

	
	
}
