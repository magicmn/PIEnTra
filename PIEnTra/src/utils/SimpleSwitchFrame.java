package utils;

import javax.swing.JFrame;

/**
 * SimpleSwitchFrame ist eine Klasse zum Wechseln der Mockups bei betätigung eines Buttons
 * Die Methode switchFrame bekommt beim aufruf 3 Parameter übergeben.
 * 
 * Beim Aufruf der Methode wird geprüft, ob die Ziel-Instanz schon vorhanden ist.
 * Falls ja, wird die Instanz einfach wieder sichtbar. (switchFrameView)
 * Falls nein, wird eine neue Instanz erstellt. (switchFrameNewObject)
 * 
 * @param start Der erste Parameter steht für das aktuelle JFrame in der die Methode aufgerufen wird, welche geschlossen bzw.
 * unsichtbar gemacht werden soll.
 * @param ziel Der zweite Parameter steht für das Mockup welches geöffnet werden soll.
 * Da das Mockup über den Controller aufgerufen wird, wird an dieser Stelle die Instanz des jeweiligen Controllers
 * übergeben. Der Parameter wird genutzt, falls das Ziel-Mockup noch keine Controller-Instanz hat.
 * @param zielView Der dritte Parameter steht ebenfalls für das Mockup weleches geöffnet werden soll.
 * Der Parameter wird genutzt, falls das Ziel-Mockup schon eine Controller-Instanz hat.
 * @version 1.1 SwitchFrame Methode
 * @version 1.0 SwitchFrameView und SwitchFrameNewObject erstellt
 * @author Adrian Fromm
 */

public class SimpleSwitchFrame {
	
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
