package utils;

import javax.swing.JFrame;

public class SimpleSwitchFrame {
	
	public static void switchFrame(JFrame start, Object ziel, JFrame zielView){
		if(ziel == null){
			switchFrameNewObject(start, ziel);
			}
		else{
			switchFrameView(start, zielView);
			}
	}
	
	public static void switchFrameView(JFrame frameClose, JFrame frameOpen){
		frameClose.dispose();
		frameOpen.setVisible(true);
	}
	public static void switchFrameNewObject(JFrame frameClose, Object frameOpen){
		frameClose.setVisible(false);
		frameOpen = new Object();
	}
}
