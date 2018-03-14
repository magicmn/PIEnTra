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
	
	JTextField txt_produktbezeichnung = new JTextField(35);
	JTextArea txt_produktbeschreibung = new JTextArea(20, 35);
	JTextField txt_bottom = new JTextField(54);
	
	JButton btn_produktdefninieren = new JButton("Produkt definieren");
	JButton btn_zurueckzumhauptmenu = new JButton("Zur�ck zum Hauptmen�");
	
	public V_ProduktDefinieren(){
		init();
		txt_bottom.setText("PIEnTra / Produkt definieren");
	}
	
	public void init(){
		
		this.setBounds(50, 50, 470, 525);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		txt_produktbeschreibung.setBorder(BorderFactory.createLineBorder(Color.gray));
		txt_bottom.setEnabled(false);

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

		this.add(pnl_center);
		
	}
	
	// Get und Set
	
	public String getText_txt_produktbezeichnung(){
		return txt_produktbezeichnung.getText();
	}
	public String getText_txt_produktbeschreibung(){
		return txt_produktbeschreibung.getText();
	}
	
	//-----------------------------------------------------
	
	public void setText_txt_produktbezeichnung(String text){
		txt_produktbezeichnung.setText(text);
	}
	public void setText_txt_produktbeschreibung(String text){
		txt_produktbeschreibung.setText(text);
	}
}
