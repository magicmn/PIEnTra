package controller;

import view.V_TrainingLoeschen;

public class C_TrainingLoeschen {
	private static V_TrainingLoeschen view;
	
	public C_TrainingLoeschen(){
		view = new V_TrainingLoeschen();
	}
	public static V_TrainingLoeschen getView() {
		return view;
	}
	public void setView(V_TrainingLoeschen view) {
		this.view = view;
	}
	
}
