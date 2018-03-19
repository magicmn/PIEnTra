package model;
/**
 * Superklasse für alle Personen
 * @author Konstantin
 *
 */
public class M_Person{
	private String vorname;
	private String nachname;

	public M_Person(String vorname, String nachname) {
		super();
		setVorname(vorname);
		setNachname(nachname);

	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	@Override
	public String toString() {
		if(getNachname().equals("")) {
			return getVorname()+"";
		}
		else {

			return ""+getVorname()+", "+getNachname();
		}

	}
	



}
