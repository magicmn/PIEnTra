package controller;

import view.V_KundeSuchen;

/**
 * {@link controller} von KundeSuchen.
 * @version 1.5 JavaDoc ueberarbeitet und kleine Codeaenderungen.
 * @version 1.4 getView() erweitert.
 * @version 1.3 Singelotn implementiert.
 * @version 1.2 ActionListener entfernt.
 * @version 1.1 ActionListener hinzugefügt.
 * @version 1.0 Controller erstellt.
 * @author Adrian Fromm (1.1)
 * @author Julian Klein (1.0 & 1.5)
 * @author Konstantin Frei (1.2, 1.3 & 1.4)
 **/
public class C_KundeSuchen {

	private static C_KundeSuchen instance = null;
	private V_KundeSuchen view;
	private static Object controller;
	
	/**
	 * Private Konstruktor der verhindert, dass direkrt eine Instanz der Klasse erzeugt werden kann.
	 * @param controller Refernez zu dem aufrufenden Objekt. Wird später benötigt um dieses Objekt wieder aufzrufen.
	 */
	private C_KundeSuchen(Object controller){
		C_KundeSuchen.controller = controller;
		view = new V_KundeSuchen(controller);
	}
	
	/**
	 * Singelton. Gibt bereits erstelltes Objekt oder gerade neu erstelltes Objekt von {@link C_KundeSuchen} zurueck.
	 * @param controller Refernez zu dem aufrufenden Objekt.
	 * @return Gibt ein bereits existierendes oder ein neu erstelltes Objekt von {@link C_KundeSuchen} zurueck.
	 * @see {@link #C_KundeSuchen(Object)}
	 */
	public static C_KundeSuchen getInstance(Object controller) {
		if(instance==null) {
			instance = new C_KundeSuchen(controller);
		}
		setController(controller);
		return instance;
	}

	/**
	 * Getter für die {@link view} {@link V_KundeSuchen} der entweder eine neue Instanz erstellt oder die alte wieder oeffnet und deren Felder auf "" setzt.
	 * @return Gibt die {@link view} {@link V_KundeSuchen}
	 */
	public V_KundeSuchen getView() {
		if(view == null) {
			view = new V_KundeSuchen(controller);
		} else {
			view.setText_pnl_firmenname("");
			view.setText_pnl_kundenID("");
		}
		view.setVisible(true);
		return view;
		
	}

	/**
	 * Getter um Referenz zum Objekt das C_KundeSuchen oeffnet zu erhalten.
	 * @return Referenz zu aufrufendem Objekt
	 * @see {@link V_KundeSuchen.KundeSuchen#actionPerformed(java.awt.event.ActionEvent)
	 */
	public static Object getController() {
		return controller;
	}

	/**
	 * Setter um Referenz zum Objekt zu editieren.
	 * @param controller Refernz zum Objekt das {@link C_KundeSuchen} aufgerufen hat.
	 */
	public static void setController(Object controller) {
		C_KundeSuchen.controller = controller;
	}
	
	
}
