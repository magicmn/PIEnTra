package testdaten;

import java.awt.Dimension;

import utils.SimpleMasterWindow;
import utils.SimpleTextPanel;

public class testFeldPruefer extends SimpleMasterWindow {

	private static final long serialVersionUID = 2155801843116893113L;
	
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
