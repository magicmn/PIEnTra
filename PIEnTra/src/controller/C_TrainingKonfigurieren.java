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

import javax.swing.JFrame;

import utils.SimpleSwitchFrame;
import view.V_TrainingKonfigurieren;

public class C_TrainingKonfigurieren {
	
	private static V_TrainingKonfigurieren view;
	
	public C_TrainingKonfigurieren(){
		view = new V_TrainingKonfigurieren();
		
	}

	public static JFrame getView() {
		return view;
	}	
	
}