package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDatumBerechnen {
	
	//dd:MM:yyyy Format für das Datum
	private static DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

	public static int datumBerechnen(String startdatum, String enddatum){
		int tage=0;
		try {
			Date startdatumFormatiert = format.parse(startdatum);
			Date enddatumFormatiert = format.parse(enddatum);
			long diffMillisekunden = enddatumFormatiert.getTime() - startdatumFormatiert.getTime();
			tage = Integer.parseInt( (diffMillisekunden / (1000 * 60 * 60 * 24)+""));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tage;
	}

	public static String datumBerechnen(String startdatum, Integer tage){
		long enddatumMillisekunden = 0;
		String DateAsString = "";
		try {
			long tageMillisekunden = tage * 86400000; 											//Tage in Millisekunden rechnen
			Date startdatumFormatiert = format.parse(startdatum);								//startdatum in Date formatieren dd.MM.yyyy
			enddatumMillisekunden = startdatumFormatiert.getTime() + tageMillisekunden;			//
			Date datum = new Date(enddatumMillisekunden);
			DateAsString = format.format(enddatumMillisekunden);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return DateAsString;
	}
	
}
