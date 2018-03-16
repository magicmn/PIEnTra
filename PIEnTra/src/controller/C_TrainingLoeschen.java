package controller;

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
	
}
