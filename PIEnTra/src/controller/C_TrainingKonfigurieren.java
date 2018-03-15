package controller;

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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utils.SimpleSwitchFrame;
import view.V_TrainingKonfigurieren;

public class C_TrainingKonfigurieren {
	
	private V_TrainingKonfigurieren view;
	
	public C_TrainingKonfigurieren(){
		view = new V_TrainingKonfigurieren();
		initListener();
	}
	private void initListener() {
		view.addBtn_kundeWaehlenListener(new KundeWaehlen());
		view.addBtn_ressourceWaehlenListener(new RessourceWaehlen());
		view.addBtn_trainingSpeichernListener(new TrainingSpeichern());
		view.addBtn_zurueckListener(new Zurueck());
	}
	private class KundeWaehlen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Kunde waehlen!");		
		}
	}
	private class RessourceWaehlen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Ressource Wählen");		
		}
	}
	private class TrainingSpeichern implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Training Speichern!");
		}
	}
	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(view, new C_Hauptmenue());		
		}
	}
}