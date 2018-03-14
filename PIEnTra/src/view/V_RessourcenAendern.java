package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class V_RessourcenAendern extends JFrame {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		V_RessourcenAendern test = new V_RessourcenAendern();
	}
	
	JLabel lbl_produktbezeichnung= new JLabel("Produktbezeichnung:");  							
    String comboBoxListeProduktbezeichnung[] = {"du", "bist", "ein", "spast", "ich", "bin", "kein", "spast", "leih mir deine frau aus", "dann wird wenigstens dein sohn kein", "spast"};
    JComboBox produktbezeichnungAuswahl = new JComboBox(comboBoxListeProduktbezeichnung);
    
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
	txt_produktbeschreibung.setBounds(50, 50, 50, 30);
		
	//JPanel für den Hauptbereich des JFrames und für die Buttons
	
	
	JPanel mainPanel = new JPanel(new GridLayout(3,3, 5,10));
	this.add(BorderLayout.LINE_START, mainPanel);
	JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
	this.add(BorderLayout.SOUTH, panelButtons);
	JPanel panel_south = new JPanel();
    panel_south.setLayout( new BoxLayout(panel_south, BoxLayout.X_AXIS));  
    mainPanel.add(lbl_produktbezeichnung);
    mainPanel.add(produktbezeichnungAuswahl);
    mainPanel.add(lbl_produktbeschreibung);
    mainPanel.add(lbl_trainer);
    mainPanel.add(trainerAuswahl);
    mainPanel.add(txt_produktbeschreibung);
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
