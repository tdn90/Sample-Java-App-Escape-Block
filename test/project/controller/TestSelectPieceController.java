package project.controller;

import java.awt.Point;
import java.util.Iterator;

import junit.framework.TestCase;
import project.boundary.SlidingPuzzleApp;
import project.model.Model;
import project.model.PuzzlePiece;

public class TestSelectPieceController extends TestCase {
	SlidingPuzzleApp app;
	Model m; 
	SelectPieceController controller; 
	
	public void setUp() {
		m = new Model();
		app = new SlidingPuzzleApp(m);
		controller = new SelectPieceController(app, m);
	}
	
	public void testSelectPiece() {
		// this fakeP is a Point in the target piece
		Point fakeP = new Point(150, 50);
		controller.selectPiece(fakeP);
		Iterator<PuzzlePiece> it = m.getSet().iterator();
		
		// the first piece in the iterator is the target piece
		PuzzlePiece target_piece = it.next();
		assertEquals(target_piece, m.getSelectedPiece());
		assertEquals(target_piece.getColor(), target_piece.SELECTED_COLOR);
		
		Point emptySpaceP = new Point(250, 250);
		controller.selectPiece(emptySpaceP);
		assertNull(m.getSelectedPiece());
		assertEquals(target_piece.getColor(), target_piece.TARGET_COLOR);
	}
}
