package testdaten;

import utils.SimpleDatumBerechnen;

public class DatumBerechnenTest {
	
	public static void main(String[] args) {
		String a = "11.11.2012";
		String b = "21.11.2012";
		
		System.out.println(SimpleDatumBerechnen.datumBerechnen(a, b));
		System.out.println(SimpleDatumBerechnen.datumBerechnen(a, 5));
	}
	

	

}
