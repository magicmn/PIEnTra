package testdaten;

import utils.SimpleDatumBerechnen;

public class DatumBerechnenTest {
	
	public static void main(String[] args) {
		String a = "01.01.2016";
		String b = "01.01.2017";
		
		System.out.println(SimpleDatumBerechnen.datumBerechnen(a, b));
		System.out.println(SimpleDatumBerechnen.datumBerechnen(a, 22));
	}
}
