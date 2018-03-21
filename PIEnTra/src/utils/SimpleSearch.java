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


/**
 * (Besser als Google)
 * Klasse die statische Methoden zum durchsuchen bestimmter Listen enthält
 * @author Konstantin Frei
 * @see #kundeSuchen(String, ArrayList)
 * @see #ortSuchen(String, ArrayList)
 * @see #managementAssistentSuchen(String, ArrayList)
 * @see #trainerSuchen(String, ArrayList)
 * @see #trainingSuchen(String, ArrayList)
 * @see #adresseSuchen(String, ArrayList)
 * @see #produktSuchen(String, ArrayList)
 */
public abstract class SimpleSearch {
	
	/**
	 * Sucht in {@link M_Kunde} nach Kunde ueber die Kunden ID oder den Firmennamen.
	 * @param id Kann entweder die Kunden ID oder den Firmennamen enthalten.
	 * @param array Die Liste muss mit {@link M_Kunde#getInterneListe()} mitgegeben werden.
	 * @return Gefundenenes Element des Typen {@link M_Kunde}.
	 * @throws NoSuchElementException Wird geworfen, wenn kein Objekt gefunden wurde.
	 */
	public static M_Kunde kundeSuchen (String id, ArrayList<M_Kunde> array) throws NoSuchElementException{
		for(M_Kunde element : array) {
			if(id.equals(element.getKundenID() + "") || id.equals(element.getFirmenname() + "")) {
				return element;
			}
		}
		throw new NoSuchElementException();
	}

	/**
	 * Sucht in {@link M_Ort} nach einem Ort ueber die Ort ID
	 * @param id Orts ID
	 * @param array Die Liste muss mit {@link M_Ort#getInterneListe()} mitgegeben werden.
	 * @return Gefundenes Objekt des Typen {@link M_Ort}.
	 * @throws NoSuchElementException Wird geworfen, wenn kein Objekt gefunden wurde.
	 */
	public static M_Ort ortSuchen (String id, ArrayList<M_Ort> array) throws NoSuchElementException{
		for(M_Ort element : array) {
			if(id.equals(element.getOrtsID() + "")) {
				return element;
			}

		}
		throw new NoSuchElementException();
	}

	/**
	 * Sucht in {@link M_ManagementAssistent} nach einem Mitarbeiter ueber die MitarbeiterID.
	 * @param id MitarbeiterID
	 * @param array Die Liste muss mit {@link M_ManagementAssistent#getInterneListe()} mitgegeben werden.
	 * @return Gefundenes Objekt des Typen {@link M_ManagementAssistent}.
	 * @throws NoSuchElementException Wird geworfen, wenn kein Objekt gefunden wurde.
	 */
	public static M_ManagementAssistent managementAssistentSuchen (String id, ArrayList<M_ManagementAssistent> array) throws NoSuchElementException{
		for(M_ManagementAssistent element : array) {
			if(id.equals(element.getMitarbeiterID() + "")) {
				return element;
			}

		}
		throw new NoSuchElementException();
	}

	/**
	 * Sucht in {@link M_Trainer} nach einem Mitarbeiter ueber die TrainerID.
	 * @param id TrainerID
	 * @param array Die Liste muss mit {@link M_Trainer#getInterneListe()} mitgegeben werden.
	 * @return Gefundenes Objekt des Typen {@link M_Trainer}.
	 * @throws NoSuchElementException Wird geworfen, wenn kein Objekt gefunden wurde.
	 */
	public static M_Trainer trainerSuchen (String id, ArrayList<M_Trainer> array) throws NoSuchElementException{

		for(M_Trainer element : array) {
			if(id.equals(element.getTrainerID() + "")) {

				return element;
			}
		}
		throw new NoSuchElementException();
	}
	
	public static M_Trainer trainerSuchen (String vorname, String nachname, ArrayList<M_Trainer> array) throws NoSuchElementException{

		for(M_Trainer element : array) {
			if(vorname.equals(element.getVorname()+"") && vorname.equals(element.getNachname())) {

				return element;
			}
		}
		throw new NoSuchElementException();
	}

	/**
	 * Sucht in {@link M_Training} nach einem Training ueber die TrainingsID.
	 * @param id TrainingsID
	 * @param array Die Liste muss mit {@link M_Training#getInterneListe()} mitgegeben werden.
	 * @return Gefundenes Objekt des Typen {@link M_Training}.
	 * @throws NoSuchElementException Wird geworfen, wenn kein Objekt gefunden wurde.
	 */
	public static M_Training trainingSuchen (String id, ArrayList<M_Training> array) throws NoSuchElementException{

		for(M_Training element : array) {
			if(id.equals(element.getTrainingsID() + "")) {
				return element;
			}
		}
		throw new NoSuchElementException();
	}

	/**
	 * Sucht in {@link M_Adresse} nach einer {@link M_Adresse} ueber die AdressID.
	 * @param id AdressID
	 * @param array Die Liste muss mit {@link M_Adresse#getInterneListe()} mitgegeben werden.
	 * @return Gefundenes Objekt des Typen {@link M_Adresse}.
	 * @throws NoSuchElementException Wird geworfen, wenn kein Objekt gefunden wurde.
	 */
	public static M_Adresse adresseSuchen (String id, ArrayList<M_Adresse> array) throws NoSuchElementException{

		for(M_Adresse element : array) {
			if(id.equals(element.getAdressID() + "")) {
				return element;
			}

		}
		throw new NoSuchElementException();
	}
	
	/**
	 * Sucht in {@link M_Produkt} nach einem Produkt ueber die ProduktID.
	 * @param id ProduktID
	 * @param array Die Liste muss mit {@link M_Produkt#getInterneListe()} mitgegeben werden.
	 * @return Gefundenes Objekt des Typen {@link M_Produkt}.
	 * @throws NoSuchElementException Wird geworfen, wenn kein Objekt gefunden wurde.
	 */
	public static M_Produkt produktSuchen (String id, ArrayList<M_Produkt> array) throws NoSuchElementException{
		for(M_Produkt element : array) {
			if(id.equals(element.getProduktID() + "")) {
				return element;
			}

		}
		throw new NoSuchElementException();
	}

}
