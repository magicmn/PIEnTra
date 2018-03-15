package controller;

import javax.swing.JFrame;

import view.V_KundeWaehlen;

public class C_KundeWaehlen {
	private static V_KundeWaehlen view;
	
	public C_KundeWaehlen(){
		view = new V_KundeWaehlen();
	}

	public static JFrame getView() {
		return view;
	}
}
