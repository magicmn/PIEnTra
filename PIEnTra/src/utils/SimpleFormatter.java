package utils;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;
/**
 * Aktuelle Version 1.3
 * 
 * 1.1
 * 	-PLZ Formatter definiert
 * 1.2
 * 	-Rufnummer Formatter definiert
 * 1.3
 * 	-DateFormatter definiert und Funktionen erweitert
 * @author Konstantin
 *
 */
public class SimpleFormatter {

	public static AbstractFormatter getPLZFormat() {
		AbstractFormatter formatter = null;
		try {
			formatter = new MaskFormatter("######");
		} catch (ParseException e) {

			e.printStackTrace();
		}



		return formatter;

	}
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
	public static AbstractFormatter getDatumFormat() {
		AbstractFormatter formatter = null;
		SimpleDateFormat format=null;
		format = new SimpleDateFormat("dd.MM.yyyy");



		formatter = new DateFormatter(format);




		return formatter;

	}


}
