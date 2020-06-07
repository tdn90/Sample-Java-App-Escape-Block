package project.app;

/**
 * @author Dung (Kevin) Nguyen
 */

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import project.boundary.SlidingPuzzleApp;
import project.controller.QuitController;
import project.model.Model;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Model m = new Model();
					final SlidingPuzzleApp frame = new SlidingPuzzleApp(m);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					
					// Disposing the window will complete the application
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							if (new QuitController().comfirm(frame)) {
								frame.dispose();
							}
						}
					});
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
					return;
				}
			}
		});
	}
}
