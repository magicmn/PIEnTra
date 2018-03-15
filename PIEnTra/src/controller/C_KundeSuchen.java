/**
 * Aktuelle Version: 1.1 
 * Authoren: Julian (1.0), Adrian (1.1), Andreas (1.1)
 * 
 * Changelog:
 * 1.0 	
 * 		-Controller erstellt
 * 1.1
 * 		-ActionListener hinzugefügt!
 **/

package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import model.M_Kunde;
import utils.SimpleSearch;
import view.V_KundeSuchen;

public class C_KundeSuchen {
	
	private V_KundeSuchen view;
	private M_Kunde kunde;
	
	public C_KundeSuchen(){
		view = new V_KundeSuchen();
		initListener();
	}
	private void initListener() {
		view.addBtn_kundeSuchenListener(new KundeSuchen());
		view.addBtn_abbrechenListener(new Abbrechen());
	}
	
	private class KundeSuchen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			//implementation der Suchfunktion
			
			try {
				if(!view.getText_pnl_firmenname().equals("") && !view.getText_pnl_kundenID().equals("")) {
					System.out.println("Bitte nur ein Feld füllenn ");		
					kunde = null;
				}
				else if(view.getText_pnl_firmenname().equals("") && view.getText_pnl_kundenID().equals("")) {
					System.out.println("Bitte eins der Felder ausfüllen");
					kunde = null;
				}
				else if(view.getText_pnl_firmenname().equals("") && !view.getText_pnl_kundenID().equals("")) {
					kunde = SimpleSearch.kundeSuchen(view.getText_pnl_kundenID(), M_Kunde.getInterneListe());
				}
				else if(!view.getText_pnl_firmenname().equals("") && view.getText_pnl_kundenID().equals("")) {
					kunde = SimpleSearch.kundeSuchen(view.getText_pnl_firmenname(), M_Kunde.getInterneListe());
				}
				
			}
			catch ( NoSuchElementException e){
				System.out.println("Kein Kunde gefunden");
				kunde = null;
				
			}
			finally {
				if(kunde!=null) {
					System.out.println(kunde);
				}
			}
			
		}
	}
	private class Abbrechen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Abbrechen");
			view.setVisible(false);
		}
	}
	
	public M_Kunde getKunde() {
		return kunde;
	}
	public void setKunde(M_Kunde kunde) {
		this.kunde = kunde;
	}
}
