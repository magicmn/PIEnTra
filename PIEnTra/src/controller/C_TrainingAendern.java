package controller;

import javax.swing.JFrame;

import view.V_TrainingAendern;

public class C_TrainingAendern {

	private static V_TrainingAendern view;
	
	public C_TrainingAendern(){
		view = new V_TrainingAendern();
	}

	public static JFrame getView() {
		return view;
	}
}
