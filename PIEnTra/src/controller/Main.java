package controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import testdaten.Test_main;
import view.V_KundeSuchen;

public class Main {

	public static void main(String[] args){
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
		new C_Hauptmenue();
		
		new Test_main();
	}
}
