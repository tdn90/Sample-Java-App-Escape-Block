package project.controller;
/**
 * @author tnguyen4
 */
import project.boundary.SlidingPuzzleApp;
import project.model.Model;

public class ResetPuzzleController {
	SlidingPuzzleApp app; 
	Model model; 
	
	public ResetPuzzleController (SlidingPuzzleApp app, Model model) {
		this.app = app; 
		this.model = model; 
	}
	
	public void resetPuzzle() {
		// Reset the model
		this.model.defaultModel();
		
		// Update the move label for application
		app.getMoveLabel().setText("" + model.getMoves());
		this.app.getPuzzleView().repaint();
		
		// Disable all button since no piece is selected
		new MoveButtonController(app).setAllMoveButtons(false);
	}
}
