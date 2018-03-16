package controller;

import javax.swing.JFrame;

import view.V_TrainingAendern;

public class C_TrainingAendern {

	private static C_TrainingAendern instance = null;
	private static V_TrainingAendern view;
	
	private C_TrainingAendern(){
		view = new V_TrainingAendern();
	}

	public static JFrame getView() {
		return view;
	}
	public static C_TrainingAendern getInstance() {

		if(instance==null) {
			instance = new C_TrainingAendern();
		}
		return instance;
	}
}
