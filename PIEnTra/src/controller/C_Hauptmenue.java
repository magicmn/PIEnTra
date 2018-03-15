package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utils.SimpleSwitchFrame;
import view.V_Hauptmenue;

public class C_Hauptmenue {
	
	private V_Hauptmenue view;

	public C_Hauptmenue() {
		view = new V_Hauptmenue();
		initListener();
	}

	private void initListener() {
		view.addBtn_TrainingKonfigurierenListener(new TrainingKonfigurieren());
		view.addBtn_TrainingAendernListener(new TrainingAendern());
		view.addBtn_TrainingLoeschenListener(new TrainingLoeschen());
		view.addBtn_KundeVerwaltenListener(new KundeVerwalten());
		view.addBtn_ProdukteDefinierenListener(new ProdukteDefinieren());
	}
	
	private class TrainingKonfigurieren implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(view, new C_TrainingKonfigurieren());
		}
	}
	private class TrainingAendern implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			new C_TrainingAendern();
		}
	}
	private class TrainingLoeschen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			new C_TrainingLoeschen();
		}
	}
	private class KundeVerwalten implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			new C_KundeVerwalten();
		}
	}
	private class ProdukteDefinieren implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			new C_ProdukteDefinieren();
		}
	}
	
}
