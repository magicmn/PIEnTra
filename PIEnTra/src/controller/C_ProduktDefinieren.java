/**
 * View von TrainingKonfigurieren.
 * @version 1.4 produktDefinieren Funktion hinzugef�gt
 * @version 1.3 Singelton implementiert
 * @version 1.2 ActionListener wieder entfernt und in View implementiert!
 * @version 1.1 ActionListener hinzugef�gt!
 * @version 1.0 Controller erstellt
 * @author Adrian Fromm
 * @author Andreas Kann
 * @author Julian Klein
 **/

package controller;

import javax.swing.JFrame;

import model.M_Produkt;
import utils.SimpleMasterWindow;
import view.V_ProduktDefinieren;

public class C_ProduktDefinieren {
	
	private static C_ProduktDefinieren instance = null;
	private static V_ProduktDefinieren view;
	private M_Produkt produkt;

	private C_ProduktDefinieren(){
		view = new V_ProduktDefinieren();
	}

	public JFrame getView() {
		return view;
	}
	public static C_ProduktDefinieren getInstance() {

		if(instance==null) {
			instance = new C_ProduktDefinieren();
		}
		return instance;
	}
	
	public void produktDefinieren(){
		
		produkt = new M_Produkt(view.getText_txt_produktID(), view.getText_txt_produktbezeichnung(), view.getText_txt_produktbeschreibung(), 1.0);
		
	}
	
	
}
