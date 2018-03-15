package utils;

import javax.swing.JFrame;

public class SimpleSwitchFrame {
	
	public static void switchFrame(JFrame frameClose, Object frameOpen){
		frameClose.dispose();
		frameOpen = new Object();
	}
}
