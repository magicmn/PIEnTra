 package testdaten;

import java.util.NoSuchElementException;

import javax.swing.plaf.synth.SynthSeparatorUI;

import controller.Main;
import model.M_Adresse;
import model.M_Kunde;
import model.M_ManagementAssistent;
import model.M_Ort;
import model.M_Produkt;
import model.M_Trainer;
import model.M_Training;
import utils.SimpleSearch;

public class Test_main {
	private Testfaelle testfaelle = new Testfaelle();
	private Main maincontroller = new Main();
	
	
	
	public Test_main() {
		init();
		
		
	}
	
	
	public static void main( String[] args) {
		
		Test_main test_main = new Test_main();
		
	
		
	}

	public void init() {
		
		/*System.out.println(this.testfaelle.getOrt2());
		System.out.println(this.testfaelle.getTrainer3());, 
		System.out.println(this.testfaelle.getmAssistent());
		System.out.println(this.testfaelle.getGww());*/
		//System.out.println(this.getTestfaelle().getTraining1());
		
		try {
			System.out.println(SimpleSearch.trainerSuchen(3+"", M_Trainer.getInterneListe()));			
			System.out.println("__________________");
			System.out.println(SimpleSearch.trainingSuchen("EWW.D11.11.11.K1.ID1", M_Training.getInterneListe()));			
			System.out.println("__________________");
			System.out.println(SimpleSearch.ortSuchen("WA-A-E101", M_Ort.getInterneListe()));			
			System.out.println("__________________");		
			System.out.println(SimpleSearch.produktSuchen("EWW", M_Produkt.getInterneListe()));
			System.out.println("__________________");
			System.out.println(SimpleSearch.adresseSuchen(3+"", M_Adresse.getInterneListe()));
			System.out.println("__________________");
			System.out.println(SimpleSearch.managementAssistentSuchen(1+"", M_ManagementAssistent.getInterneListe()));
			System.out.println("__________________");
			System.out.println(SimpleSearch.trainerSuchen(3+"", M_Trainer.getInterneListe()));
			System.out.println("__________________");
			System.out.println(SimpleSearch.trainerSuchen(3+"", M_Trainer.getInterneListe()));
			
			}
			catch( NoSuchElementException e) {
				System.out.println("Kein Element gefunden");
			}
			
		
		
		
		
		
		
	
	}

	public Testfaelle getTestfaelle() {
		return testfaelle;
	}



	public void setTestfaelle(Testfaelle testfaelle) {
		this.testfaelle = testfaelle;
	}

}
