package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;
/**
 * SimpelFormatter ist eine statische samlung aller in der Anwendug benötigte Formate.
 * @version 1.3 DateFormatter definiert und Funktionen erweitert.
 * @version 1.2 Formatter definiert.
 * @version 1.1 PLZ Formatter definiert.
 * @author Konstantin Frei
 *
 */
public class SimpleFormatter {
	
	/**
	 * Masek für Postleitzahl
	 * @return Maske PLZ
	 */
	public static AbstractFormatter getPLZFormat() {
		AbstractFormatter formatter = null;
		try {
			formatter = new MaskFormatter("######");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatter;
	}
	
	/**
	 * Maske für Rufnummer
	 * @return Maske Rufnummer
	 */
	public static AbstractFormatter getRufnummerFormat() {
		AbstractFormatter formatter = null;
		try {
			formatter = new MaskFormatter("+############");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		((MaskFormatter) formatter).setValidCharacters("0123456789-");
		return formatter;
	}
	
	/**
	 * Maske für Datum
	 * @return Masek Datum (dd.MM.yyyy)
	 */
	public static AbstractFormatter getDatumFormat() {
		AbstractFormatter formatter = null;
		SimpleDateFormat format=null;
		format = new SimpleDateFormat("dd.MM.yyyy");
		formatter = new DateFormatter(format);
		return formatter;
	}

}
