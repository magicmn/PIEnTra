/**
 * @version 1.4 Löschenfunktion implementiert.
 * @version 1.3 Singelton pattern implementiert
 * @version 1.2 ActionListener entfernt.
 * @version 1.1 ActionListener angelegt.
 * @version 1.0 Controller angelegt.
 * @author Andreas Kann (1.0, 1.1, 1.2)
 * @author Konstantin Frei (1.3)
 * @see V_KundeWaehlen
 * @see M_Kunde
 */
package controller;

import model.M_Kunde;
import model.M_Training;
import view.V_KundeWaehlen;
import view.V_TrainingLoeschen;

public class C_TrainingLoeschen {
	private static C_TrainingLoeschen instance = null;
	private static V_TrainingLoeschen view;
	
	private C_TrainingLoeschen(){
		view = new V_TrainingLoeschen();
	}
	
	public V_TrainingLoeschen getView() {
		return view;
	}
	
	public void setView(V_TrainingLoeschen view) {
		this.view = view;
	}
	
	public static C_TrainingLoeschen getInstance() {

		if(instance==null) {
			instance = new C_TrainingLoeschen();
		}
		return instance;
	}
	/**
	 * Löscht das übergebene Trainings Objekt aus der Internen Liste.
	 * @author Andreas Kann
	 */
	public static void trainingLoeschen(M_Training training){
		M_Training.getInterneListe().remove(training);
	}
	
}
