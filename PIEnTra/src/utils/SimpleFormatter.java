package utils;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;

import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.text.MaskFormatter;

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
		
	
	return formatter;
	
}

}
