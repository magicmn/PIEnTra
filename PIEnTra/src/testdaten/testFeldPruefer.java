package testdaten;

import java.awt.Dimension;

import javax.swing.JFrame;

import utils.SimpleMasterWindow;
import utils.SimpleTextPanel;

public class testFeldPruefer extends SimpleMasterWindow {

	private SimpleTextPanel panel;
	private static testFeldPruefer instance = null;
	public testFeldPruefer(Dimension defaultSize, Dimension minSize, String navigationText) {
		super(defaultSize, minSize, navigationText);
		
	}
	

	public static void main(String[] args) {
	 instance = new testFeldPruefer(new Dimension(500, 200), new Dimension( 300, 100), "test");

	}
	public void init() {
		
	}
	

}
