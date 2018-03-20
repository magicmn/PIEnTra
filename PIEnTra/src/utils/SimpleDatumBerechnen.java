package utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
/**
* Die Klasse SimpleDatumBerechnen ist alleine dafür da, mit den als Parameter übergebenen Daten zu rechnen, sie zu vergleichen und auf Gültigkeit zu prüfen.
* @author Jannik Stark
* @version 1.0 - SimpleDateFormat geaddet, um die Daten in "dd.MM.yyyy" formatieren zu können [Jannik Stark]
* @version 1.1 - Methode datumBerechnen(String, String) hinzugefügt, die ausrechnet, wie viele Tage zwischen den Daten liegen [Jannik Stark]
* @version 1.2 - Methode datumBerechnen(String, int) hinzugefügt, die aus dem Startdatum und der Anzahl der Tage das Enddatum ausgibt [Jannik Stark]
* @version 1.3 - Regular Expressions hinzugefügt um das Format überprüfen zu können [Jannik Stark]
* @version 1.4 - Methode pruefeDatum(String, String) hinzugefügt, die mithilfe von RegEx prüft, ob die Daten das richtige Format haben [Jannik Stark]
* @author Julian Klein
* @version 1.5 - Setzt bei Falscheingabe die Tage und das Datum auf -1 [Julian Klein]
*/

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
					//System.out.println("Das Startdatum muss vor dem Enddatum liegen!");
					//throw new IllegalArgumentException();
					tage = -1;
				}
			} catch (ParseException e) {
				//System.out.println("ParseException");
				tage = -1;
				//JOptionPane.showMessageDialog(null, e,"Vorgang abgebrochen!", JOptionPane.ERROR_MESSAGE);
			} catch (NullPointerException e){
				//System.out.println("NullPointerException");
				tage = -1;
				//e.getStackTrace();
			} catch (IllegalArgumentException e){
				//System.out.println("Das Startdatum muss vor dem Enddatum liegen! - IllegalArgument");
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
				//e.printStackTrace();
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
