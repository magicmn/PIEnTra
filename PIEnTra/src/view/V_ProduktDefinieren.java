package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class V_ProduktDefinieren extends JFrame{
	
	JPanel pnl_center = new JPanel();
	JPanel pnl_pbezeichnung = new JPanel();
	JPanel pnl_pbeschreibung = new JPanel();
	JPanel pnl_buttons = new JPanel();
	JPanel pnl_txtbottom = new JPanel();
	
	JLabel lbl_produktbezeichnung = new JLabel("Produktbezeichnung:              ");
	JLabel lbl_produktbeschreibung = new JLabel("Produktbeschreibung:             ");
	
	JTextField txt_produktbezeichnung = new JTextField(25);
	JTextArea txt_produktbeschreibung = new JTextArea(25, 25);
	JTextField txt_bottom = new JTextField(40);
	
	JButton btn_produktdefninieren = new JButton("Produkt definieren");
	JButton btn_zurueckzumhauptmenu = new JButton("Zurück zum Hauptmenü");
	
	public V_ProduktDefinieren(){
		init();
		txt_bottom.setText("PIEnTra / Produkt definieren");
	}
	
	public void init(){
		this.setBounds(50, 50, 475, 570);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		txt_produktbeschreibung.setBorder(BorderFactory.createLineBorder(Color.gray));
		txt_bottom.setEnabled(false);
		//btn_produktdefninieren.
		
		pnl_pbezeichnung.setLayout(new FlowLayout());
		pnl_pbezeichnung.add(lbl_produktbezeichnung);
		pnl_pbezeichnung.add(txt_produktbezeichnung);
		
		FlowLayout flowlayout = new FlowLayout();
		flowlayout.setAlignOnBaseline(true);
		pnl_pbeschreibung.setLayout(flowlayout);
		pnl_pbeschreibung.add(lbl_produktbeschreibung);
		pnl_pbeschreibung.add(txt_produktbeschreibung);
		
		pnl_buttons.setLayout(new FlowLayout());
		pnl_buttons.add(btn_produktdefninieren);
		pnl_buttons.add(btn_zurueckzumhauptmenu);
		
		pnl_center.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnl_center.add(pnl_pbezeichnung);
		pnl_center.add(pnl_pbeschreibung);
		pnl_center.add(pnl_buttons);
		pnl_center.add(pnl_txtbottom);
		
		pnl_txtbottom.add(txt_bottom);
		
		//pnl_pbezeichnung.setBorder(BorderFactory.createLineBorder(Color.black));
		//pnl_pbeschreibung.setBorder(BorderFactory.createLineBorder(Color.black));
		//pnl_buttons.setBorder(BorderFactory.createLineBorder(Color.black));
		//pnl_txtbottom.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.add(pnl_center);
		
	}
}
