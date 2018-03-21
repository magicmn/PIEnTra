package utils;

import javax.swing.JFrame;

/**
 * SimpleSwitchFrame ist eine Klasse zum Wechseln der Mockups bei bet�tigung eines Buttons
 * Die Methode switchFrame bekommt beim aufruf 3 Parameter �bergeben.
 * 
 * Beim Aufruf der Methode wird gepr�ft, ob die Ziel-Instanz schon vorhanden ist.
 * Falls ja, wird die Instanz einfach wieder sichtbar. (switchFrameView)
 * Falls nein, wird eine neue Instanz erstellt. (switchFrameNewObject)
 * 
 * @version 1.2 Minimale Codeuberarbeitung (Julian Klein)
 * @version 1.1 SwitchFrame Methode
 * @version 1.0 SwitchFrameView und SwitchFrameNewObject erstellt
 * @author Adrian Fromm
 */
public abstract class SimpleSwitchFrame {
	
	/**
	 * Ueberprueft ob ein Objekt des Zielframes bereits existiert.
	 * Wenn nicht wird es erstellt.
	 * Ansonsten wird es nur sichtbar gemacht.
	 * @param start  Der erste Parameter steht f�r das aktuelle JFrame in der die Methode aufgerufen wird, welche geschlossen bzw.
	 * unsichtbar gemacht werden soll.
	 * @param ziel Der zweite Parameter steht f�r das Mockup welches ge�ffnet werden soll.
	 * Da das Mockup �ber den Controller aufgerufen wird, wird an dieser Stelle die Instanz des jeweiligen Controllers
	 * �bergeben. Der Parameter wird genutzt, falls das Ziel-Mockup noch keine Controller-Instanz hat.
	 * @param zielView Der dritte Parameter steht ebenfalls f�r das Mockup weleches ge�ffnet werden soll.
	 * Der Parameter wird genutzt, falls das Ziel-Mockup schon eine Controller-Instanz hat.
	 */
	public static void switchFrame(JFrame start, Object ziel, JFrame zielView){
		start.setVisible(false);
		if(ziel == null) {
			ziel = new Object();
			//switchFrameNewObject(start, ziel);
		} else {
			zielView.setVisible(true);
			//switchFrameView(start, zielView);
		}
	}
	
//	private static void switchFrameView(JFrame frameClose, JFrame frameOpen){
//		frameClose.setVisible(false);
//		frameOpen.setVisible(true);
//	}
//	
//	private static void switchFrameNewObject(JFrame frameClose, Object frameOpen){
//		frameClose.setVisible(false);
//		frameOpen = new Object();
//	}
}
