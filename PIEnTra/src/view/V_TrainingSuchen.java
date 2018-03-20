package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.M_Training;
import utils.SimpleMasterWindow;
import utils.SimpleTextPanel;

public class V_TrainingSuchen extends SimpleMasterWindow {
	private static final long serialVersionUID = -6381551589496678636L;

	/* Deklaration und Initailiserung von verschiedenen Variablen **/

	/** 
	 * Standard Größe des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	public static Dimension defaultSize = new Dimension(400, 120);
	/** 
	 * Minimale Größe des Fensters.
	 * @see SimpleMasterWindow#initFrame(Dimension defaultSize, Dimension minSize)
	 * */
	private static Dimension minSize = new Dimension(400, 120);
	/**
	 * Text der in der Naviagtionsleiste ausgegebn wird.
	 * @see SimpleMasterWindow#initSouth(String navigationText)
	 */
	private static String navigationText = "";

	private SimpleTextPanel pnl_trainingsID = new SimpleTextPanel("Trainings-ID:");

	private JButton btn_trainingSuchen = new JButton("Training suchen");
	private JButton btn_abbrechen = new JButton("Abbrechen");

	private M_Training training;
	private static Object controller;

	/* Konstruktor und Methoden die vom Konstruktor aufgerufen werden. */

	/**
	 * Konstruktor der View Hauptmenue.
	 * Übergibt an die Superklasse die standard und minimal Größe, sowie aktuelle Pfadangaben der Navigationsleiste.
	 * Initialisiere dann den Content und lösche ein überflüssiges Element aus der im Hauptmenu nicht benutzten Menuleiste.
	 * Zuletzt werden die Listener initialisiert.
	 */
	public V_TrainingSuchen(Object controller) {
		super(defaultSize, minSize, navigationText);
		initContent();
		initMenu();
		initListener();
		resizeGUI();
		this.controller = controller;
		this.setVisible(true);
	}

	

	/**
	 * Initialisiere den Inhalt des Centers.
	 */
	private void initContent() {
		JPanel pnl_content = new JPanel();
		pnl_content.setLayout(new GridLayout(2, 1));
		pnl_content.setAlignmentY(LEFT_ALIGNMENT);
		pnl_content.add(pnl_trainingsID);
		super.getPnl_center().add(pnl_content);
	}

	/**
	 * Initiailisert die Menu Buttons
	 */
	private void initMenu() {
		getPnl_menu().add(btn_trainingSuchen);
		getPnl_menu().add(btn_abbrechen);
	}

	/**
	 * Initialisiert ActionListener
	 */
	private void initListener() {
		btn_trainingSuchen.addActionListener(new TrainingSuchen());
		btn_abbrechen.addActionListener(new Abbrechen());
	}

	protected void resizeGUI() {
		int maxWidthTextBox = this.getWidth() - SimpleTextPanel.getLabelWidth() - (getPadding() * 2) - 25;
		int optimalButtonWidth = (int) super.getPnl_menu().getWidth() - 25;
		pnl_trainingsID.setTextFieldWidth(maxWidthTextBox / 2);
		btn_trainingSuchen.setPreferredSize(new Dimension(optimalButtonWidth / 2 , btn_trainingSuchen.getPreferredSize().height));
		btn_abbrechen.setPreferredSize(new Dimension(optimalButtonWidth / 2, btn_trainingSuchen.getPreferredSize().height));
	}

	/* Implementierung der ActionListener */

	public static void main(String [] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new V_TrainingSuchen(controller);
	}

	// Getter und Setter

	public String getText_pnl_trainingsID(){
		return pnl_trainingsID.getText();
	}
	public void setText_pnl_trainingsID(String text){
		this.pnl_trainingsID.setText(text);
	}
	public JButton txt(){
		return btn_trainingSuchen;
	}
	public M_Training getTraining() {
		return training;
	}
	public void setTraining(M_Training training) {
		this.training = training;
	}
	// ActionListener

/**
 * Durch das betätigen der "Training suchen" Taste wird versucht ein Training in der Internen Liste anhand der TrainingsID zu selektieren.
 * War der Suchvorgang wird eine Referenz auf den gefundenen Ku
 * nden der Suchenden Instanz übergeben. 
 *
 */
	private class TrainingSuchen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			//implementation der Suchfunktion

			try {
				if(getText_pnl_trainingsID().equals("")) {	
					training = null;
					throw new NoSuchElementException();
				}

			}
			catch ( NoSuchElementException e){
				JOptionPane popup = new JOptionPane();
				popup.showMessageDialog(null, "Das Textfeld darf nicht leer sein!", "Vorgang abgebrochen", JOptionPane.WARNING_MESSAGE);
				training = null;
			}
			
			//Übergabe der Referenz auf den Kunden und anschliessendes Schliessen des Views
//			finally {
//				if(training!=null) {
//					if(controller instanceof C_TrainingAendern) {
//						C_TrainingAendern.getInstance().setTraining(training);
//						C_KundeVerwalten.getInstance().felderFuellen();
//						dispose();
//					}
//					if(controller instanceof C_TrainingAendern) {
//						C_KundeWaehlen.getInstance().setTraining(training);
//						C_KundeWaehlen.getInstance().felderFuellen();
//						dispose();
//					}
//				}
//			}	
		}
	}
	private class Abbrechen implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Abbrechen");
			dispose();
		}
	}
}
