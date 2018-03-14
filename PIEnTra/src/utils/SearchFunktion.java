package utils;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import model.M_Adresse;
import model.M_Kunde;
import model.M_ManagementAssistent;
import model.M_Ort;
import model.M_Produkt;
import model.M_Trainer;
import model.M_Training;



public class SearchFunktion {



	public static M_Kunde kundeSuchen (String id, ArrayList<M_Kunde> array) throws NoSuchElementException{

		for(M_Kunde element : array) {
			if(id.equals(element.getKundenID()+"")) {
				return element;
			}

		}
		throw new NoSuchElementException();

	}



	public static M_Ort ortSuchen (String id, ArrayList<M_Ort> array) throws NoSuchElementException{

		for(M_Ort element : array) {
			if(id.equals(element.getOrtsID()+"")) {
				return element;
			}

		}
		throw new NoSuchElementException();

	}



	public static M_ManagementAssistent managementAssistentSuchen (String id, ArrayList<M_ManagementAssistent> array) throws NoSuchElementException{

		for(M_ManagementAssistent element : array) {
			if(id.equals(element.getMitarbeiterID()+"")) {
				return element;
			}

		}
		throw new NoSuchElementException();

	}


	public static M_Trainer trainerSuchen (String id, ArrayList<M_Trainer> array) throws NoSuchElementException{

		for(M_Trainer element : array) {
			if(id.equals(element.getTrainerID()+"")) {
				return element;
			}

		}
		throw new NoSuchElementException();

	}

	public static M_Training trainingSuchen (String id, ArrayList<M_Training> array) throws NoSuchElementException{

		for(M_Training element : array) {
			if(id.equals(element.getTrainingsID()+"")) {
				return element;
			}

		}
		throw new NoSuchElementException();

	}

	public static M_Adresse adresseSuchen (String id, ArrayList<M_Adresse> array) throws NoSuchElementException{

		for(M_Adresse element : array) {
			if(id.equals(element.getAdressID()+"")) {
				return element;
			}

		}
		throw new NoSuchElementException();





	}
	public static M_Produkt produktSuchen (String id, ArrayList<M_Produkt> array) throws NoSuchElementException{

		for(M_Produkt element : array) {
			if(id.equals(element.getProduktID()+"")) {
				return element;
			}

		}
		throw new NoSuchElementException();

	}

}
