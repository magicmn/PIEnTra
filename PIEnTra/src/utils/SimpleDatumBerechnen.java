/**
 * 
 * @author starkovic
 * @author Julian Klein
 * @version 1.1 Setzt bei Falscheingabe Tage und Datum nun -1
 * @version 1.0 implementiert
 */

package utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class SimpleDatumBerechnen {
	//dd.MM.yyyy Format für das Datum in unserem Format
	private static DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	//Regular Expression damit man prüfen kann ob die Eingabe im richtigen Format ist
	static String dateRegEx="^[0-3]{1}[0-9]{1}.[0-1]{1}[1-2]{1}.[1-9]{1}[0-9]{3}$";
	
	//Um die Anzahl der Tage auszurechnen
	public static int datumBerechnen(String startdatum, String enddatum){
		int tage=0;
		if(Pattern.matches(dateRegEx, startdatum) && Pattern.matches(dateRegEx, enddatum)){
			try {
				Date startdatumFormatiert = format.parse(startdatum);
				Date enddatumFormatiert = format.parse(enddatum);
				long diffMillisekunden = enddatumFormatiert.getTime() - startdatumFormatiert.getTime();
				tage = Integer.parseInt( (diffMillisekunden / (1000 * 60 * 60 * 24)+1+""));
				if (tage < 1) {
					System.out.println("Das Startdatum muss vor dem Enddatum liegen!");
					//throw new IllegalArgumentException();
					tage = -1;
				}
			} catch (ParseException e) {
				System.out.println("ParseException");
				tage = -1;
				//JOptionPane.showMessageDialog(null, e,"Vorgang abgebrochen!", JOptionPane.ERROR_MESSAGE);
			} catch (NullPointerException e){
				System.out.println("NullPointerException");
				tage = -1;
				//e.getStackTrace();
			} catch (IllegalArgumentException e){
				System.out.println("Das Startdatum muss vor dem Enddatum liegen! - IllegalArgument");
				//JOptionPane.showMessageDialog(null, "Das Startdatum muss vor dem Enddatum liegen!","Vorgang abgebrochen!", JOptionPane.ERROR_MESSAGE);
				tage = -1;
			}
		}
		if(!Pattern.matches(dateRegEx, startdatum) || !Pattern.matches(dateRegEx, enddatum)){
			//System.out.println("RegEx1 passt nicht!");
			tage = -1;
		}
		return tage;
	}
	
	//Um das Enddatum auszurechnen
	public static String datumBerechnen(String startdatum, Integer tage){
		String DateAsString = "";
		if(Pattern.matches(dateRegEx, startdatum)){
			try {
				long tageMillisekunden = tage * 86400000; 											
				Date startdatumFormatiert = format.parse(startdatum);				
				long enddatumMillisekunden = startdatumFormatiert.getTime() + tageMillisekunden - 86400000;	
				DateAsString = format.format(enddatumMillisekunden);

			} catch (ParseException e) {
				System.out.println("ParseException");
				DateAsString = "-1";
			}
			}
		if(!Pattern.matches(dateRegEx, startdatum)){
			System.out.println("RegEx2 passt nicht!");
			DateAsString = "-1";
		}
		return DateAsString;
	}
	
	public static String pruefeDatum(String startdatum, String enddatum){
		String wert = "";
		if(Pattern.matches(dateRegEx, startdatum) && Pattern.matches(dateRegEx, enddatum)){
			System.out.println("Wert 1 gesetzt!");
			wert = "1";
		}
		if(!Pattern.matches(dateRegEx, startdatum) || !Pattern.matches(dateRegEx, enddatum)){
			System.out.println("Wert 0 gesetzt!");
			System.out.println("RegEx3 passt nicht");
			wert = "0";
		}
		return wert;
	}
}
