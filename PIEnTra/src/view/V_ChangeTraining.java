package view;
import javax.swing.*;

public class V_ChangeTraining extends JFrame {
	
	//JLabels und JTextfields zur Eingabe
	JTextField txt_trainingsid = new JTextField();  						//Text-Feld Trainings-ID
	JLabel lbl_trainingsid = new JLabel("Trainings-ID:");					//Label Trainings-ID
	JTextField txt_firmenname = new JTextField();  							//Text-Feld Firmenname
	JLabel lbl_firmenname = new JLabel("Firmenname:");						//Label Firmenname
	JTextField txt_ansprechpartner = new JTextField(); 						//Text-Feld Ansprechpartner
	JLabel lbl_ansprechpartner = new JLabel("Ansprechpartner:");			//Label Ansprechpartner
	JTextField txt_produktbeschreibung = new JPasswordField();  			//Text-Feld Produktbeschreibung
	JLabel lbl_produktbeschreibung = new JLabel("Produktbeschreibung:");	//Label Produktbeschreibung
	JTextField txt_startdatum = new JTextField();							//Text-Feld Startdatum
	JLabel lbl_startdatum = new JLabel("Startdatum:");						//Label Startdatum
	JTextField txt_enddatum = new JTextField();								//Text-Feld Enddatum
	JLabel lbl_enddatum = new JLabel("Enddatum:");							//Label Enddatum
	JTextField txt_tage = new JTextField();									//Text-Feld Tage
	JLabel lbl_tage = new JLabel("Tage:");									//Label Tage
	JTextField txt_trainer = new JTextField();								//Text-Feld Trainer
	JLabel lbl_trainer = new JLabel("Trainer:");							//Label Trainer
	JTextField txt_ort = new JTextField();									//Text-Feld Ort
	JLabel lbl_ort = new JLabel("Ort:");									//Label Ort
	JTextField txt_bemerkungen = new JTextField();							//Text-Feld Bemerkungen
	JLabel lbl_bemerkungen = new JLabel("Bemerkungen:");					//Label Bemerkungen

		
	//JButtons erstellen
	JButton btn_suchen = new JButton("Training suchen");					//Button suchen
	JButton btn_ressourcenAendern = new JButton("Ressourcen ändern");		//Button Ressourcen ändern
	JButton btn_refreshTraining = new JButton("Training aktualisieren");	//Button Training aktualisieren
	JButton btn_back = new JButton("Zurück zum Hauptmenü");					//Button Zurück


}
