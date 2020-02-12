package hannah97gamer.factorymodmaker.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ModMakerFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public ModMakerFrame() {
		setTitle("Hannah97Gamer's Mod Maker");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		InfoPanel info = new InfoPanel();
		JPanel test = new JPanel();
		tabbedPane.addTab("Mod Info", info);
		tabbedPane.addTab("Tab #2", test);
		
		setSize(800, 600);
		
		setContentPane(tabbedPane);
		
		setVisible(true);
	}
}
