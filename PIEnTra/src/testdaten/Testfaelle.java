package testdaten;

import model.M_Kunde;
import model.M_Ort;
import model.M_Produkt;
import model.M_Trainer;

public class Testfaelle{
	private M_Produkt gww;
	private M_Produkt eww;
	private M_Produkt wwp;
	private M_Ort ort1;
	private M_Ort ort2;
	private M_Ort ort3;
	private M_Ort ort4;
	private M_Ort ort5;
	private M_Ort ort6;
	private M_Trainer trainer1;
	private M_Trainer trainer2;
	private M_Trainer trainer3;
	private M_Trainer trainer4;
	private M_Trainer trainer5;
	private M_Trainer trainer6;
	
	private M_Kunde Kunde1;
	private M_Kunde Kunde2;
	private M_Kunde Kunde3;
	
	public Testfaelle() {
		ort1 = new M_Ort("WA-A-E101", "Gesch�ftsstelle Wallau", "Geb�ude A",1, "01");
		ort2 = new M_Ort("WA-A-E102", "Gesch�ftsstelle Wallau", "Geb�ude A",1, "02");
		ort3 = new M_Ort("HO-K-E201", "Gesch�ftsstelle Hofheim","Geb�ude K",2,"01");
		ort4 = new M_Ort("HO-K-E202", "Gesch�ftsstelle Hofheim","Geb�ude K",2,"02");
		ort5 = new M_Ort("N�-L-E103", "Gesch�ftsstelle N�rnberg", "Geb�ude L",1,",03");
		ort6 = new M_Ort("N�-L-E301", "Gesch�ftsstelle N�rnberg", "Geb�ude L",3,",01");
		
		
		gww = new M_Produkt("gww","Produkt Grundlagen Warenwirtschaft", "Beschreibung test", 1.0, null);
		
	}

	
	

	public static void main(String[] args) {
		

	}

}
