package testdaten;

import model.M_Adresse;
import model.M_Kunde;
import model.M_ManagementAssistent;
import model.M_Ort;
import model.M_Person;
import model.M_Produkt;
import model.M_Trainer;
import model.M_Training;

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
	
	private M_Kunde kunde1;
	private M_Kunde kunde2;
	private M_Kunde kunde3;
	
	private M_ManagementAssistent mAssistent;
	
	
	private M_Training training1;
	
	public Testfaelle() {
		
		 
		ort1 = new M_Ort("WA-A-E101", "Geschäftsstelle Wallau", "Gebäude A",1, "01");
		ort2 = new M_Ort("WA-A-E102", "Geschäftsstelle Wallau", "Gebäude A",1, "02");
		ort3 = new M_Ort("HO-K-E201", "Geschäftsstelle Hofheim","Gebäude K",2,"01");
		ort4 = new M_Ort("HO-K-E202", "Geschäftsstelle Hofheim","Gebäude K",2,"02");
		ort5 = new M_Ort("NÜ-L-E103", "Geschäftsstelle Nürnberg", "Gebäude L",1,",03");
		ort6 = new M_Ort("NÜ-L-E301", "Geschäftsstelle Nürnberg", "Gebäude L",3,",01");
		
		
		gww = new M_Produkt("GWW","Produkt Grundlagen Warenwirtschaft", "Beschreibung test", 1.0, null);
		eww = new M_Produkt("EWW","Erweitere Grundlagen Warenwirtschaft", "Beschreibung test", 1.0, null);
		wwp = new M_Produkt("WWP","Erweitere Grundlagen Warenwirtschaft", "Beschreibung test", 1.0, null);
		
		trainer1 = new M_Trainer("Lukas", "Poodolski", eww,gww);
		trainer2 = new M_Trainer("Roland", "Keiser", gww);
		trainer3 = new M_Trainer("Ralf", "Siehgel", eww,gww,wwp);
		trainer4 = new M_Trainer("Karl", "Lager-Feld", eww);
		trainer5 = new M_Trainer("Heidi", "Kluhm", wwp);
		trainer6 = new M_Trainer("Swanja", "Ikeah", wwp);
		
		kunde1 = new M_Kunde("Aeron Pumpen AG", "Pharmaindustrie", "info@aeronpump-it.de", "+49 61466939", new M_Adresse("Rainer-Kausing-Straße 4", "Hessen", "Hochheim/Main", "65239"), new M_Person("Heinrich", "Klaist"));
		kunde2 = new M_Kunde("Agosini", "Edelmetalverarbeitung", "info@agosini.de", "+49 7231 9611", new M_Adresse("Kanzlereistr. 17","baden-Würtenberg", "Pforzheim", "75175"), new M_Person("Maria", "Jung"));
		kunde3 = new M_Kunde("ETONGRUPPE", "Automobilzulieferer", "info@etongruppe.com", "+49 7771 8191", new M_Adresse("Hardterring 8", "Baden-Würtenberg", "Stockach", "78333"), new M_Person("Dietmar", "Bohnlen"));
		
		mAssistent = new M_ManagementAssistent("peter", "Lustig");
		
		training1 = new M_Training("11.11.11", trainer1, ort1, kunde1, "12.12.12", 365, "Test", eww, mAssistent);
		
		
		
		
	}

	
	

	public static void main(String[] args) {
		
		

	}

}
