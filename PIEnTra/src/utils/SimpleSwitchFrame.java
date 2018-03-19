/**
 * Aktuelle Version: 1.1
 * Authoren: Adrian
 * 
 * Changelog:
 * 
 * 1.1
 * 		-switchFrame Methode erstellt
 * 1.0 	
 * 		-switchFrameView / switchFrameNewObject Methode erstellt
 **/

package utils;

import javax.swing.JFrame;

public class SimpleSwitchFrame {

	/**
	 * SimpleSwitchFrame ist eine Klasse zum Wechseln der Mockups bei bet�tigung eines Buttons
	 * Die Methode switchFrame bekommt beim aufruf 3 Parameter �bergeben.
	 * 
	 * Der erste Parameter (@param start) steht f�r das aktuelle JFrame in der die Methode aufgerufen wird, welche geschlossen bzw.
	 * unsichtbar gemacht werden soll.
	 * 
	 * Der zweite Parameter (@param ziel) steht f�r das Mockup welches ge�ffnet werden soll.
	 * Da das Mockup �ber den Controller aufgerufen wird, wird an dieser Stelle die Instanz des jeweiligen Controllers
	 * �bergeben.
	 * Der Parameter wird genutzt, falls das Ziel-Mockup noch keine Controller-Instanz hat.
	 * 
	 * Der dritte Parameter (@param zielView) steht ebenfalls f�r das Mockup weleches ge�ffnet werden soll.
	 * Der Parameter wird genutzt, falls das Ziel-Mockup schon eine Controller-Instanz hat.
	 * 
	 * Beim Aufruf der Methode wird gepr�ft, ob die Ziel-Instanz schon vorhanden ist.
	 * Falls ja, wird die Instanz einfach wieder sichtbar. (switchFrameView)
	 * Falls nein, wird eine neue Instanz erstellt. (switchFrameNewObject)
	 *
	 */
	
	public static void switchFrame(JFrame start, Object ziel, JFrame zielView){
		if(ziel == null){
			switchFrameNewObject(start, ziel);
		}
		else{
			switchFrameView(start, zielView);
		}
	}
	
	public static void switchFrameView(JFrame frameClose, JFrame frameOpen){
		frameClose.dispose();
		frameOpen.setVisible(true);
	}
	
	public static void switchFrameNewObject(JFrame frameClose, Object frameOpen){
		frameClose.setVisible(false);
		frameOpen = new Object();
	}
}
