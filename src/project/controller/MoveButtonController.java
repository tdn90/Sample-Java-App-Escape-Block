package project.controller;
/**
 * @author tnguyen4
 * Helper class to disable the button when no piece in the 
 * puzzle is selected
 */
import project.boundary.SlidingPuzzleApp;

public class MoveButtonController {
	SlidingPuzzleApp app;
	
	public MoveButtonController(SlidingPuzzleApp app) {
		this.app = app;
	}
	
	/**
	 * @param option: True to set all button enabled, False to set them disabled
	 */
	public void setAllMoveButtons(boolean option) {
		app.getUpButton().setEnabled(option);
		app.getDownButton().setEnabled(option);
		app.getLeftButton().setEnabled(option);
		app.getRightButton().setEnabled(option);
	}
}
