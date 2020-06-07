package project.controller;

import junit.framework.TestCase;
import project.boundary.SlidingPuzzleApp;
import project.model.Model;

public class TestResetPuzzleController extends TestCase{
	SlidingPuzzleApp app; 
	Model m;
	ResetPuzzleController controller; 
	
	public void setUp() {
		m = new Model();
		app = new SlidingPuzzleApp(m);
		controller = new ResetPuzzleController(app, m);
	}
	
	public void testResetPuzzle() {
		controller.resetPuzzle();
		// test all button disabled 
		assertFalse(app.getUpButton().isEnabled());
		assertFalse(app.getDownButton().isEnabled());
		assertFalse(app.getLeftButton().isEnabled());
		assertFalse(app.getRightButton().isEnabled());
		
		// test number of moves
		assertEquals(m.getMoves(), Integer.parseInt(app.getMoveLabel().getText()));
		assertEquals(0, m.getMoves());
	}
}
