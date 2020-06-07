package project.model;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author tnguyen4
 */
import junit.framework.TestCase;
import project.boundary.SlidingPuzzleApp;

public class TestModel extends TestCase {
	public static final int SPACE_BETWEEN = Model.SPACE_BETWEEN; 
	public static final int WIDTH_UNIT = Model.WIDTH_UNIT;
	public static final int HEIGHT_UNIT = Model.HEIGHT_UNIT;
	public static final int WINDOW_WIDTH = SlidingPuzzleApp.PUZZLE_WIDTH;
	public static final int WINDOW_HEIGHT = SlidingPuzzleApp.PUZZLE_HEIGHT;
	
	Model m;
	
	public void setUp() {
		m = new Model();
	}
	
	public void testIncrementMove() {
		int num = 10;
		for (int i = 0; i < num; i++) {
			m.incrementMove();
		}
		assertEquals(num, m.getMoves());
	}
	
	public void testGetMoves() {
		assertTrue(m.getMoves() == 0);
		assertFalse(m.getMoves() == -1);
	}
	
	public void testSetSelectedPiece() {
		assertNull(m.selectedPiece);
		m.setSelectedPiece(null);
		assertNull(m.selectedPiece);
		
		Iterator<PuzzlePiece> it = m.getSet().iterator();
		PuzzlePiece first_piece = it.next();
		m.setSelectedPiece(first_piece);
		assertNotNull(m.selectedPiece);
		
		PuzzlePiece second_piece = it.next();
		m.setSelectedPiece(second_piece);
		assertNotNull(m.selectedPiece);
		
		m.setSelectedPiece(null);
		assertNull(m.selectedPiece);
	}
	
	public void testIsValidMove() {
		int x_coord = -50; 
		int x_coord_1 = 50;
		int x_coord_2 = 1000;
		int y_coord = -50;
		int y_coord_1 = 50;
		int y_coord_2 = 1000;
		assertFalse(m.isValidMove(x_coord, y_coord));
		assertFalse(m.isValidMove(x_coord, y_coord_1));
		assertFalse(m.isValidMove(x_coord, y_coord_2));
		
		assertFalse(m.isValidMove(x_coord_1, y_coord));
		assertFalse(m.isValidMove(x_coord_1, y_coord_1));
		assertFalse(m.isValidMove(x_coord_1, y_coord_2));
		
		assertFalse(m.isValidMove(x_coord_2, y_coord));
		assertFalse(m.isValidMove(x_coord_2, y_coord_1));
		assertFalse(m.isValidMove(x_coord_2, y_coord_2));
		
		int x_coord_3 = 399;
		int y_coord_3 = 399;
		assertTrue(m.isValidMove(x_coord_3, y_coord_3));
	}
	
	public void testMoveSelectedPiece() {
		ArrayList<PuzzlePiece> pieceLists = (ArrayList<PuzzlePiece>) m.getSet().pieces;
		PuzzlePiece piece_4 = pieceLists.get(4);
		m.setSelectedPiece(piece_4);
		assertTrue(m.moveSelectedPieceRight());
		assertFalse(m.moveSelectedPieceRight());
		
		assertTrue(m.moveSelectedPieceLeft());
		assertFalse(m.moveSelectedPieceLeft());
		
		PuzzlePiece piece_7 = pieceLists.get(7);
		m.setSelectedPiece(piece_7);
		assertTrue(m.moveSelectedPieceLeft());
		assertTrue(m.moveSelectedPieceUp());
		assertFalse(m.moveSelectedPieceUp());
		assertTrue(m.moveSelectedPieceDown());
		assertFalse(m.moveSelectedPieceDown());
	}
	
	//TODO
	public void testWin() {
		
	}
	
}
