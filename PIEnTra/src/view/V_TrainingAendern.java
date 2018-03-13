package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class V_TrainingAendern extends JFrame {
	
	public static void main(String[] args) {
		V_TrainingAendern trainingAendern = new V_TrainingAendern();
	}
	
	//JLabels und JTextfields zur Eingabe
	JTextField txt_trainingsid = new JTextField();  							//Text-Feld Trainings-ID
	JLabel lbl_trainingsid = new JLabel("Trainings-ID:");						//Label Trainings-ID
	JTextField txt_firmenname = new JTextField();  								//Text-Feld Firmenname
	JLabel lbl_firmenname = new JLabel("Firmenname:");							//Label Firmenname
	JTextField txt_ansprechpartner = new JTextField(); 							//Text-Feld Ansprechpartner
	JLabel lbl_ansprechpartner = new JLabel("Ansprechpartner:");				//Label Ansprechpartner
	JTextField txt_produktbeschreibung = new JPasswordField();  				//Text-Feld Produktbeschreibung
	JLabel lbl_produktbeschreibung = new JLabel("Produktbeschreibung:");		//Label Produktbeschreibung
	JTextField txt_startdatum = new JTextField();								//Text-Feld Startdatum
	JLabel lbl_startdatum = new JLabel("Startdatum:");							//Label Startdatum
	JTextField txt_enddatum = new JTextField();									//Text-Feld Enddatum
	JLabel lbl_enddatum = new JLabel("Enddatum:");								//Label Enddatum
	JTextField txt_tage = new JTextField();										//Text-Feld Tage
	JLabel lbl_tage = new JLabel("Tage:");										//Label Tage
	JTextField txt_trainer = new JTextField();									//Text-Feld Trainer
	JLabel lbl_trainer = new JLabel("Trainer:");								//Label Trainer
	JTextField txt_ort = new JTextField();										//Text-Feld Ort
	JLabel lbl_ort = new JLabel("Ort:");										//Label Ort
	JTextField txt_bemerkungen = new JTextField();								//Text-Feld Bemerkungen
	JLabel lbl_bemerkungen = new JLabel("Bemerkungen:");						//Label Bemerkungen

	//JButtons erstellen
	JButton btn_suchen = new JButton("Training suchen");						//Button suchen
	JButton btn_ressourcenAendern = new JButton("Ressourcen ändern");			//Button Ressourcen ändern
	JButton btn_TrainingAktualisieren = new JButton("Training aktualisieren");	//Button Training aktualisieren
	JButton btn_zurueck = new JButton("Zurück zum Hauptmenü");					//Button Zurück

	public V_TrainingAendern(){
		init();
	}
	
	public void init(){setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//Fenstergröße
	this.setBounds(50, 50, 750,350);
	//this.setLayout(new BorderLayout());
		
	//JPanel für den Hauptbereich des JFrames und für die Buttons
	JPanel mainPanel = new JPanel(new GridLayout(10,2));
	this.add(BorderLayout.CENTER, mainPanel);
	JPanel panel_south = new JPanel(new FlowLayout(FlowLayout.CENTER));
	this.add(BorderLayout.CENTER, panel_south);
	
		
//	//BoxLayout für das mainPanel einstellen

		
	//Dem mainPanel und buttonPanel hinzufügen + nächste Zeile mit new Dimension
	mainPanel.add(lbl_trainingsid);
	mainPanel.add(txt_trainingsid);
	mainPanel.add(Box.createRigidArea(new Dimension(0,0)));
	mainPanel.add(lbl_firmenname);
	mainPanel.add(txt_firmenname);
	mainPanel.add(Box.createRigidArea(new Dimension(0,0)));
	mainPanel.add(lbl_ansprechpartner);
	mainPanel.add(txt_ansprechpartner);
	mainPanel.add(Box.createRigidArea(new Dimension(0,0)));
	mainPanel.add(lbl_produktbeschreibung);
	mainPanel.add(txt_produktbeschreibung);
	mainPanel.add(Box.createRigidArea(new Dimension(0,0)));
	mainPanel.add(lbl_startdatum);
	mainPanel.add(txt_startdatum);
	mainPanel.add(Box.createRigidArea(new Dimension(0,0)));
	mainPanel.add(lbl_enddatum);
	mainPanel.add(txt_enddatum);
	mainPanel.add(Box.createRigidArea(new Dimension(0,0)));
	mainPanel.add(lbl_tage);
	mainPanel.add(txt_tage);
	mainPanel.add(Box.createRigidArea(new Dimension(0,0)));
	mainPanel.add(lbl_trainer);
	mainPanel.add(txt_trainer);
	mainPanel.add(Box.createRigidArea(new Dimension(0,0)));
	mainPanel.add(lbl_ort);
	mainPanel.add(txt_ort);
	mainPanel.add(Box.createRigidArea(new Dimension(0,0)));
	mainPanel.add(lbl_bemerkungen);
	mainPanel.add(txt_bemerkungen);
	mainPanel.add(Box.createRigidArea(new Dimension(0,0)));
	
	panel_south.add(btn_suchen);
	panel_south.add(Box.createRigidArea(new Dimension(5,0)));
	panel_south.add(btn_ressourcenAendern);
	panel_south.add(Box.createRigidArea(new Dimension(5,0)));
	panel_south.add(btn_TrainingAktualisieren);
	panel_south.add(Box.createRigidArea(new Dimension(5,0)));
	panel_south.add(btn_zurueck);
	panel_south.add(Box.createRigidArea(new Dimension(5,0)));

	//Hinzufügen der JPanels zum BorderLayout
	getContentPane().add(mainPanel);
	getContentPane().add(panel_south, BorderLayout.SOUTH);
	
	setVisible(true);
}
	
}
