package testdaten;

import java.util.NoSuchElementException;

import javax.swing.plaf.synth.SynthSeparatorUI;

import model.M_Adresse;
import model.M_Kunde;
import model.M_ManagementAssistent;
import model.M_Ort;
import model.M_Produkt;
import model.M_Trainer;
import model.M_Training;
import utils.SearchFunktion;

public class Test_main {
	private Testfaelle testfaelle = new Testfaelle();
	
	
	
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
			System.out.println(SearchFunktion.trainerSuchen(3+"", M_Trainer.getInterneListe()));			
			System.out.println("__________________");
			System.out.println(SearchFunktion.trainingSuchen(1+"", M_Training.getInterneListe()));			
			System.out.println("__________________");
			System.out.println(SearchFunktion.ortSuchen("WA-A-E101", M_Ort.getInterneListe()));			
			System.out.println("__________________");		
			System.out.println(SearchFunktion.produktSuchen("EWW", M_Produkt.getInterneListe()));
			System.out.println("__________________");
			System.out.println(SearchFunktion.adresseSuchen(3+"", M_Adresse.getInterneListe()));
			System.out.println("__________________");
			System.out.println(SearchFunktion.managementAssistentSuchen(1+"", M_ManagementAssistent.getInterneListe()));
			System.out.println("__________________");
			System.out.println(SearchFunktion.trainerSuchen(3+"", M_Trainer.getInterneListe()));
			System.out.println("__________________");
			System.out.println(SearchFunktion.trainerSuchen(3+"", M_Trainer.getInterneListe()));
			
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
