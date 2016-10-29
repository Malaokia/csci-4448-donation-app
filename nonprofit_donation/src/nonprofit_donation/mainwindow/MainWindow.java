package nonprofit_donation.mainwindow;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nonprofit_donation.controller.Controller;

public class MainWindow extends JFrame implements Controller{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static MainWindow mw = null;
	
	private MainWindow(String title) {
		super(title);
		createDefaultWindow(title);
		
	}
	
	private void createDefaultWindow(String title) {
		this.setTitle(title);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(600,350));
		this.setContentPane(panel);
		this.pack();
	}
	
	public static void setPanel(JPanel panel) {
		
	}
	
	public static MainWindow getMainWindow(String title) {
		if(mw == null) {
			mw = new MainWindow(title);
		}
		return mw;
	}
	
	public static MainWindow getMainWindow() {
		return mw;
	}
}
