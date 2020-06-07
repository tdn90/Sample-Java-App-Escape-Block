package project.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

import junit.framework.TestCase;
import project.boundary.SlidingPuzzleApp;
import project.model.Model;
import project.model.PuzzlePiece;

public class TestMoveSelectedPieceController extends TestCase {
	SlidingPuzzleApp app;
	Model m;
	JButton upButton;
	JButton left_button;
	JButton right_button;
	JButton down_button;


	/*
	 * This will store all the pieces in the puzzle just as their original order in
	 * PuzzleSet
	 */
	ArrayList<PuzzlePiece> pieceLists;

	MoveSelectedPieceController controller_up;
	MoveSelectedPieceController controller_down;
	MoveSelectedPieceController controller_left;
	MoveSelectedPieceController controller_right;

	public void setUp() {
		m = new Model();
		app = new SlidingPuzzleApp(m);

		pieceLists = new ArrayList<>();
		for (Iterator<PuzzlePiece> it = m.getSet().iterator(); it.hasNext();) {
			pieceLists.add(it.next());
		}

		upButton = new JButton("^");
		controller_up = new MoveSelectedPieceController(app, m, upButton);

		left_button = new JButton("<");
		controller_left = new MoveSelectedPieceController(app, m, left_button);

		right_button = new JButton(">");
		controller_right = new MoveSelectedPieceController(app, m, right_button);

		down_button = new JButton("v");
		controller_down = new MoveSelectedPieceController(app, m, down_button);
	}

	public void testUpButton() {
		/*
		 * Does not need to test case when no piece selected Because if no piece is
		 * selected, the controller won't be called anyway
		 */

		// some piece selected but cannot move
		PuzzlePiece target_piece = pieceLists.get(0);
		m.setSelectedPiece(target_piece);
		controller_up.moveSelectedPiece();
		assertEquals(0, m.getMoves());

		// piece selected, can move
		PuzzlePiece piece_7 = pieceLists.get(7);
		m.setSelectedPiece(piece_7);
		assertTrue(m.moveSelectedPieceLeft()); // move left first to open space
		controller_up.moveSelectedPiece(); // now can move up
		assertEquals(1, m.getMoves());
	}

	public void testDownButton() {
		/*
		 * Does not need to test case when no piece selected Because if no piece is
		 * selected, the controller won't be called anyway
		 */

		// some piece selected but cannot move
		PuzzlePiece target_piece = pieceLists.get(0);
		m.setSelectedPiece(target_piece);
		controller_down.moveSelectedPiece();
		assertEquals(0, m.getMoves());

		// piece selected, can move
		PuzzlePiece piece_7 = pieceLists.get(7);
		m.setSelectedPiece(piece_7);
		assertTrue(m.moveSelectedPieceLeft()); // move left first to open space
		assertTrue(m.moveSelectedPieceUp());
		controller_down.moveSelectedPiece(); // now can move up
		assertEquals(1, m.getMoves());
	}

	public void testLeftButton() {
		/*
		 * Does not need to test case when no piece selected Because if no piece is
		 * selected, the controller won't be called anyway
		 */

		// some piece selected but cannot move
		PuzzlePiece target_piece = pieceLists.get(0);
		m.setSelectedPiece(target_piece);
		controller_left.moveSelectedPiece(); 
		assertEquals(0, m.getMoves());

		// piece selected, can move
		PuzzlePiece piece_7 = pieceLists.get(7);
		m.setSelectedPiece(piece_7);
		controller_left.moveSelectedPiece(); // now can move left
		assertEquals(1, m.getMoves());
	}

	public void testRightButton() {
		/*
		 * Does not need to test case when no piece selected Because if no piece is
		 * selected, the controller won't be called anyway
		 */

		// some piece selected but cannot move
		PuzzlePiece target_piece = pieceLists.get(0);
		m.setSelectedPiece(target_piece);
		controller_right.moveSelectedPiece();
		assertEquals(0, m.getMoves());

		// piece selected, can move
		PuzzlePiece piece_4 = pieceLists.get(4);
		m.setSelectedPiece(piece_4);
		controller_right.moveSelectedPiece(); // now can move up
		assertEquals(1, m.getMoves());
	}
}
