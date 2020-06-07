package project.controller;

import junit.framework.TestCase;
import project.boundary.SlidingPuzzleApp;
import project.model.Model;

public class TestQuitController extends TestCase {
	SlidingPuzzleApp app;
	Model m;
	QuitController controller; 
	
	public void setUp() {
		m = new Model();
		app = new SlidingPuzzleApp(m);
		controller = new QuitController();
	}
	
	public void testConfirm() {
		// Uncomment each to test
		
		// Press Cancel for this to work
		//assertFalse(controller.comfirm(app));
		
		// Press No for this to work
		//assertFalse(controller.comfirm(app));
		
		// Press Yes for this to work
		//assertTrue(controller.comfirm(app));
	}
}
