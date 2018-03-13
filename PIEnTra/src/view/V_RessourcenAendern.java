package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class V_RessourcenAendern extends JFrame {

	public static void main(String[] args) {
		V_RessourcenAendern test = new V_RessourcenAendern();
	}
	
	JLabel lbl_produktbezeichnung= new JLabel("Produktbezeichnung:");  							
    String comboBoxListeProduktbezeichnung[] = {"du", "bist", "ein", "spast", "ich", "bin", "kein", "spast", "leih mir deine frau aus", "dann wird wenigstens dein sohn kein", "spast"};
    JComboBox transaktionstypAuswahl = new JComboBox(comboBoxListeProduktbezeichnung);
    
	JLabel lbl_trainer = new JLabel("Trainer:");  							
    String comboBoxListeTrainer[] = {};
    JComboBox trainerAuswahl = new JComboBox(comboBoxListeTrainer);
    
	JLabel lbl_ort = new JLabel("Ort:");  							
    String comboBoxListeOrt[] = {};
    JComboBox ortAuswahl = new JComboBox(comboBoxListeOrt);
    
	JButton btn_ressourcenAendern = new JButton("Ressourcen ändern");			
	JButton btn_zurueck = new JButton("Zurück zu Training ändern");		
	
	JTextField txt_info = new JTextField("PlEnTra / Training ändern / Ressourcen ändern");
	JLabel lbl_produktbeschreibung= new JLabel("                     Produktbeschreibung:"); 
	JTextArea txt_produktbeschreibung = new JTextArea();
	
	
	public V_RessourcenAendern() {
		init();
	}
	public void init(){setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//Fenstergröße
	this.setBounds(50, 50, 750,290);
	//txt_produktbeschreibung.setBounds(50, 50, 50, 30);
	//this.setResizable(false);
		
	//JPanel für den Hauptbereich des JFrames und für die Buttons
	
	
	JPanel mainPanel = new JPanel(new GridLayout(3,2, 5,10));
	this.add(BorderLayout.CENTER, mainPanel);
	JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
	this.add(BorderLayout.SOUTH, panelButtons);
	JPanel panel_south = new JPanel();
    panel_south.setLayout( new BoxLayout(panel_south, BoxLayout.X_AXIS));
    
    
    
    mainPanel.add(lbl_produktbezeichnung);
    mainPanel.add(transaktionstypAuswahl);
    mainPanel.add(lbl_trainer);
    mainPanel.add(trainerAuswahl);
    mainPanel.add(lbl_ort);
    mainPanel.add(ortAuswahl);
    panelButtons.add(btn_ressourcenAendern);
    panelButtons.add(btn_zurueck);
    panel_south.add(txt_info);
    
	getContentPane().add(mainPanel, BorderLayout.PAGE_START);
	getContentPane().add(panelButtons, BorderLayout.WEST);
	getContentPane().add(panel_south, BorderLayout.SOUTH);

    txt_info.setEditable(false);
	setVisible(true);
}
}
