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
		
		
		gww = new M_Produkt("GWW","Produkt Grundlagen Warenwirtschaft", "Systematisch werden Sie in die Funktionalität der Software eingewiesen. Sie lernen\r\n" + 
				"mit Kunden-, Lieferanten- und Artikelverwaltung zu arbeiten und erfahren, wie Sie\r\n" + 
				"das Programm nutzen. Sie sind Einsteiger in das Programm und haben bislang\r\n" + 
				"wenig Erfahrung mit der Anwendung des Programms gesammelt. Nun möchten Sie\r\n" + 
				"den sicheren Umgang mit der Software erlernen.\r\n" + 
				"Zielgruppe: Einsteiger\r\n" + 
				"Voraussetzungen: Keine\r\n" + 
				"Inhalte: Verwalten von Stammdaten (Einrichtung und Pflege von Stammdaten,\r\n" + 
				"Verwalten von Warengruppen und Artikeldaten, Preispflege, Benutzer- und\r\n" + 
				"Rechteverwaltung, Arbeiten mit Stücklistenartikeln).\r\n" + 
				"Dauer: 2-5 Tage\r\n" + 
				"Teilnehmer: 6-10\r\n" + 
				"Methoden: Vortrag, Vorführung und praktische Übungen\r\n" + 
				"Anforderungen: MyERP Version 2.01 Server Edition, Beamer, MyERP Version 2.01,\r\n" + 
				"Windows Client", 1.0);
		eww = new M_Produkt("EWW","Erweitere Grundlagen Warenwirtschaft", "Systematisch werden Sie in die erweiterte Funktionalität der Software eingewiesen.\r\n" + 
				"Sie lernen mit den Funktionen der Auftragsbearbeitung zu arbeiten. Sie sind\r\n" + 
				"Anwender und haben Erfahrung mit dem Programm gesammelt.\r\n" + 
				"Zielgruppe: Anwender\r\n" + 
				"Voraussetzungen: GWW\r\n" + 
				"Inhalte: Auftragsbearbeitung (Erstellung von Angeboten, Lieferscheinen). Arbeiten\r\n" + 
				"mit/ohne Lagerhaltung, Inventur und Preispflege, Grundlagen des Mahnwesens und\r\n" + 
				"des Zahlungseingangs, Sammel-/Abschlagsrechnungen, Arbeiten mit der\r\n" + 
				"Projektverwaltung, Preisänderungen und Kalkulation, Inventur/-auswertungen.\r\n" + 
				"Dauer: 2-5 Tage\r\n" + 
				"Teilnehmer: 6-10\r\n" + 
				"Methoden: Vortrag, Vorführung und praktische Übungen\r\n" + 
				"Anforderungen: MyERP Version 2.01 Server Edition, Beamer, MyERP Version 2.01,\r\n" + 
				"Windows Client", 1.0);
		wwp = new M_Produkt("WWP","Erweitere Grundlagen Warenwirtschaft", "Systematisch werden Sie in die effiziente Anwendung der Software eingewiesen. Sie\r\n" + 
				"vertiefen Ihre Kenntnisse der Kunden-, Lieferanten- und Artikelverwaltung sowie die\r\n" + 
				"Auftragsbearbeitung. Sie liefern die Daten für eine professionelle Angebotserstellung.\r\n" + 
				"Sie erstellen Auswertungen und optimieren die Software für Ihr Unternehmen.\r\n" + 
				"Zielgruppe: Erfahrene Anwender\r\n" + 
				"Voraussetzungen: EWW\r\n" + 
				"Inhalte: Vertiefung der Inhalte aus GWW und EWW. Auswertungen (Aufbereitung der\r\n" + 
				"Daten für die Buchhaltung, Datentransfer, Druck von Listen und Berichten,\r\n" + 
				"Berichtszentrale konfigurieren).\r\n" + 
				"Dauer: 5-10 Tage\r\n" + 
				"Teilnehmer: 6-10\r\n" + 
				"Methoden: Vortrag, Vorführung und praktische Übungen\r\n" + 
				"Anforderungen: MyERP Version 2.01 Server Edition, Beamer, MyERP Version 2.01,\r\n" + 
				"Windows Client", 1.0);
		
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
		
		trainer3.trainingHinzufuegen(training1);
	}

	public static void main(String[] args) {

		

	
		
		
		
		
		
		
	}
	
	

	
	





	public M_Produkt getGww() {
		return gww;
	}




	public void setGww(M_Produkt gww) {
		this.gww = gww;
	}




	public M_Produkt getEww() {
		return eww;
	}




	public void setEww(M_Produkt eww) {
		this.eww = eww;
	}




	public M_Produkt getWwp() {
		return wwp;
	}




	public void setWwp(M_Produkt wwp) {
		this.wwp = wwp;
	}




	public M_Ort getOrt1() {
		return ort1;
	}




	public void setOrt1(M_Ort ort1) {
		this.ort1 = ort1;
	}




	public M_Ort getOrt2() {
		return ort2;
	}




	public void setOrt2(M_Ort ort2) {
		this.ort2 = ort2;
	}




	public M_Ort getOrt3() {
		return ort3;
	}




	public void setOrt3(M_Ort ort3) {
		this.ort3 = ort3;
	}




	public M_Ort getOrt4() {
		return ort4;
	}




	public void setOrt4(M_Ort ort4) {
		this.ort4 = ort4;
	}




	public M_Ort getOrt5() {
		return ort5;
	}




	public void setOrt5(M_Ort ort5) {
		this.ort5 = ort5;
	}




	public M_Ort getOrt6() {
		return ort6;
	}




	public void setOrt6(M_Ort ort6) {
		this.ort6 = ort6;
	}




	public M_Trainer getTrainer1() {
		return trainer1;
	}




	public void setTrainer1(M_Trainer trainer1) {
		this.trainer1 = trainer1;
	}




	public M_Trainer getTrainer2() {
		return trainer2;
	}




	public void setTrainer2(M_Trainer trainer2) {
		this.trainer2 = trainer2;
	}




	public M_Trainer getTrainer3() {
		return trainer3;
	}




	public void setTrainer3(M_Trainer trainer3) {
		this.trainer3 = trainer3;
	}




	public M_Trainer getTrainer4() {
		return trainer4;
	}




	public void setTrainer4(M_Trainer trainer4) {
		this.trainer4 = trainer4;
	}




	public M_Trainer getTrainer5() {
		return trainer5;
	}




	public void setTrainer5(M_Trainer trainer5) {
		this.trainer5 = trainer5;
	}




	public M_Trainer getTrainer6() {
		return trainer6;
	}




	public void setTrainer6(M_Trainer trainer6) {
		this.trainer6 = trainer6;
	}




	public M_Kunde getKunde1() {
		return kunde1;
	}




	public void setKunde1(M_Kunde kunde1) {
		this.kunde1 = kunde1;
	}




	public M_Kunde getKunde2() {
		return kunde2;
	}




	public void setKunde2(M_Kunde kunde2) {
		this.kunde2 = kunde2;
	}




	public M_Kunde getKunde3() {
		return kunde3;
	}




	public void setKunde3(M_Kunde kunde3) {
		this.kunde3 = kunde3;
	}




	public M_ManagementAssistent getmAssistent() {
		return mAssistent;
	}




	public void setmAssistent(M_ManagementAssistent mAssistent) {
		this.mAssistent = mAssistent;
	}




	public M_Training getTraining1() {
		return training1;
	}




	public void setTraining1(M_Training training1) {
		this.training1 = training1;
	}
	

}
