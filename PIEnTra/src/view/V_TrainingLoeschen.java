package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.C_Hauptmenue;
import controller.C_TrainingLoeschen;
import model.M_Kunde;
import model.M_Training;
import utils.SimpleSearch;
import utils.SimpleSwitchFrame;
import utils.SimpleTextPanel;



public class V_TrainingLoeschen extends JFrame {
	
	private JPanel pnl_center;
	private SimpleTextPanel pnl_trainingsId;
	private SimpleTextPanel pnl_firmenname;
	private SimpleTextPanel pnl_produkt;
	private SimpleTextPanel pnl_startdatum;
	private SimpleTextPanel pnl_enddatum;
	private SimpleTextPanel pnl_tage;
	private SimpleTextPanel pnl_trainer;
	private SimpleTextPanel pnl_ort;
	private SimpleTextPanel pnl_bemerkungen;
	private JPanel pnl_south;
	private JButton btn_trainingSuchen;
	private JButton btn_trainingLoeschen;
	private JButton btn_zurueck;
	private JTextField txt_navigation;
	private M_Training training;
	private JOptionPane popup;

	public V_TrainingLoeschen() {
		initView();
		resizeGUI();
		initListener();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new V_TrainingLoeschen();
	}
	
	private void initView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIEnTra p1.00");
		this.setSize(750, 450); // Optimale Größe die beim Starten geladen wird.
		this.setMinimumSize(new Dimension(500, 400)); // Um zu verhindern, dass der DAU sich wundert warum das Fenster auf einmal "weg" ist.
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null); // Zentriert Frame in der Mitte des Bildschirms.
		this.addComponentListener(new ResizeListener());  // Fügt Listener für Frame veränderungen hinzu.
		
		pnl_center = new JPanel(new GridLayout(10, 1, 2 ,2));
		pnl_center.add(pnl_trainingsId = new SimpleTextPanel("Trainings-ID:"));
		pnl_center.add(pnl_firmenname = new SimpleTextPanel("Firmenname:"));
		pnl_center.add(pnl_produkt = new SimpleTextPanel("Produkt:"));
		pnl_center.add(pnl_startdatum = new SimpleTextPanel("Startdatum:"));
		pnl_center.add(pnl_enddatum = new SimpleTextPanel("Enddatum:"));
		pnl_center.add(pnl_tage= new SimpleTextPanel("Tage:"));
		pnl_center.add(pnl_trainer = new SimpleTextPanel("Trainer:"));
		pnl_center.add(pnl_ort = new SimpleTextPanel("Ort:"));
		pnl_center.add(pnl_bemerkungen = new SimpleTextPanel("Bemerkungen:"));
		this.add(BorderLayout.CENTER, pnl_center);
		
		pnl_south = new JPanel(new GridLayout(2, 1));
		JPanel pnl_south_top = new JPanel(new GridLayout(1, 3));
		pnl_south_top.setBorder(new EmptyBorder(10,8,5,10));
		pnl_south_top.add(btn_trainingSuchen = new JButton("Training suchen"));
		pnl_south_top.add(btn_trainingLoeschen = new JButton("Training löschen"));
		pnl_south_top.add(btn_zurueck = new JButton("Zurück zum Hauptmenü"));
		pnl_south.add(pnl_south_top);
		JPanel pnl_south_bottom = new JPanel(new FlowLayout());
		pnl_south_bottom.add(txt_navigation = new JTextField("PIEnTra / Training löschen"));
		txt_navigation.setFocusable(false);
		pnl_south.add(pnl_south_bottom);
		this.add(BorderLayout.SOUTH, pnl_south);
	}
	
	private void initListener(){
		btn_trainingSuchen.addActionListener(new TrainingSuchen());
		btn_trainingLoeschen.addActionListener(new TrainingLoeschen());
		btn_zurueck.addActionListener(new Zurueck());
	}
	
	private void resizeGUI() {
		txt_navigation.setPreferredSize(new Dimension(this.getWidth() - 30, txt_navigation.getPreferredSize().height));
		pnl_trainingsId.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_firmenname.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_produkt.setTxtField_Size(pnl_center.getWidth() / 2);
		pnl_startdatum.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_enddatum.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_tage.setTxtField_Size(pnl_center.getWidth() / 8);
		pnl_trainer.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_ort.setTxtField_Size(pnl_center.getWidth() / 4);
		pnl_bemerkungen.setTxtField_Size((this.getWidth() - 140));
	}
	
	private class ResizeListener implements ComponentListener {
		public void componentResized(ComponentEvent arg0) {
			resizeGUI();
		}
		public void componentHidden(ComponentEvent arg0) {}
		public void componentMoved(ComponentEvent arg0) {}
		public void componentShown(ComponentEvent arg0) {}
	}
	
	
	//Get und Set
	
	public String getText_pnl_trainingsId() {
		return pnl_trainingsId.getString();
	}

	public void setText_pnl_trainingsId(String pnl_trainingsId) {
		this.pnl_trainingsId.setString(pnl_trainingsId);
	}
	
	public String getText_pnl_firmenname() {
		return pnl_firmenname.getString();
	}

	public void setText_pnl_firmenname(String pnl_firmenname) {
		this.pnl_firmenname.setString(pnl_firmenname);
	}
	
	public String getText_pnl_produkt() {
		return pnl_produkt.getString();
	}

	public void setText_pnl_produkt(String pnl_produkt) {
		this.pnl_produkt.setString(pnl_produkt);
	}
	
	public String getText_pnl_startdatum() {
		return pnl_startdatum.getString();
	}

	public void setText_pnl_startdatum(String pnl_startdatum) {
		this.pnl_startdatum.setString(pnl_startdatum);
	}
	
	public String getText_pnl_enddatum() {
		return pnl_enddatum.getString();
	}

	public void setText_pnl_enddatum(String pnl_enddatum) {
		this.pnl_enddatum.setString(pnl_enddatum);
	}
	
	public String getText_pnl_tage() {
		return pnl_tage.getString();
	}

	public void setText_pnl_tage(String pnl_tage) {
		this.pnl_tage.setString(pnl_tage);
	}
	
	public String getText_pnl_trainer() {
		return pnl_trainer.getString();
	}

	public void setText_pnl_trainer(String pnl_trainer) {
		this.pnl_trainer.setString(pnl_trainer);
	}
	
	public String getText_pnl_ort() {
		return pnl_ort.getString();
	}

	public void setText_pnl_ort(String pnl_ort) {
		this.pnl_ort.setString(pnl_ort);
	}
	
	public String getText_pnl_bemerkungen() {
		return pnl_bemerkungen.getString();
	}

	public void setText_pnl_bemerkungen(String pnl_bemerkungen) {
		this.pnl_bemerkungen.setString(pnl_bemerkungen);
	}
	
	// ActionListener 
	
	private class TrainingSuchen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			//implementation der Suchfunktion
			
			try {
				if(getText_pnl_trainingsId().equals("")) {
					System.out.println("Bitte ID eintragen ");
					popup.showMessageDialog(null, "Bitte tragen Sie ein Trainings-ID ein");
					training = null;
				}

				else if(!getText_pnl_trainingsId().equals("")) {
					training = SimpleSearch.trainingSuchen(getText_pnl_trainingsId(), M_Training.getInterneListe());
				}
				
			}
			catch ( NoSuchElementException e){
				System.out.println("Kein Training gefunden");
				popup.showMessageDialog(null, "Es wurde kein Training mit dieser ID gefunden");
				training = null;
				
			}
			finally {
				if(training!=null) {
					setText_pnl_firmenname(training.getKunde().getFirmenname());
					setText_pnl_produkt(training.getProdukt().getBezeichnung());
					setText_pnl_startdatum(training.getAnfangsdatum());
					setText_pnl_enddatum(training.getEnddatum());
					setText_pnl_tage(training.getTage()+"");
					setText_pnl_trainer(training.getTrainer().getTrainerID()+"");
					setText_pnl_ort(training.getOrt().getOrtsID());
					setText_pnl_bemerkungen(training.getBemerkungen());
				}
			}	
		}
	}
	
	private class TrainingLoeschen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Training löschen");
			training = null;
			for (Iterator<M_Training> iter = M_Training.getInterneListe().listIterator(); iter.hasNext(); ) {
			    training = iter.next();
			    
			        iter.remove();
			    
			}
			
			setText_pnl_trainingsId("");
			setText_pnl_firmenname("");
			setText_pnl_produkt("");
			setText_pnl_startdatum("");
			setText_pnl_enddatum("");
			setText_pnl_tage("");
			setText_pnl_trainer("");
			setText_pnl_ort("");
			setText_pnl_bemerkungen("");
		}
	}
	
	private class Zurueck implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			SimpleSwitchFrame.switchFrame(C_TrainingLoeschen.getView(), new C_Hauptmenue());
		}
	}
}
