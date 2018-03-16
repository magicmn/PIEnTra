package controller;

import javax.swing.JFrame;

import view.V_KundeWaehlen;

public class C_KundeWaehlen {
	private static C_KundeWaehlen instance = null;
	private static V_KundeWaehlen view;
	
	private C_KundeWaehlen(){
		view = new V_KundeWaehlen();
	}

	public static JFrame getView() {
		return view;
	}
	public static C_KundeWaehlen getInstance() {

		if(instance==null) {
			instance = new C_KundeWaehlen();
		}
		return instance;
	}
}
