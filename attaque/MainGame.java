import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import gui.EntryGUI;

public class MainGame {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());//Esthetique du menu
		
		EntryGUI entryGUI = new EntryGUI();//instantie la fenêtre
		entryGUI.open();//affiche la fenêtre sur l'écran à l'ouverture 
	}
	
}
