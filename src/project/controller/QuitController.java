package project.controller;
/**
 * @author tnguyen4
 */
import javax.swing.JOptionPane;

import project.boundary.SlidingPuzzleApp;

public class QuitController {
	public boolean comfirm(SlidingPuzzleApp app) {
		return JOptionPane.showConfirmDialog(app, "Do you wish to exit the application?") == JOptionPane.OK_OPTION;
	}
}
