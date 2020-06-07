package project.model.set;
/**
 * @author tnguyen4
 * 
 * The beginning of everything is here... though this is gross
 */
import project.model.Coordinate;
import project.model.Dimension;
import project.model.PuzzlePiece;
import project.model.PuzzleSet;

public class LifeSet {
	/** ID for this set */
	public static final int SET_ID = 1;
	public static final int SPACE_BETWEEN = 3; 
	public static final int WIDTH_UNIT = 100;
	public static final int HEIGHT_UNIT = 105;
	
	// define 10 coordinates for all 10 pieces
	// Target piece
	final Coordinate c0 = new Coordinate(WIDTH_UNIT+SPACE_BETWEEN, SPACE_BETWEEN);
	
	// Obstacle pieces 
	final Coordinate c1 = new Coordinate(SPACE_BETWEEN, SPACE_BETWEEN);
	final Coordinate c2 = new Coordinate(SPACE_BETWEEN, HEIGHT_UNIT+SPACE_BETWEEN);
	final Coordinate c3 = new Coordinate(SPACE_BETWEEN, HEIGHT_UNIT*3+SPACE_BETWEEN);
	final Coordinate c4 = new Coordinate(WIDTH_UNIT+SPACE_BETWEEN, HEIGHT_UNIT*2+SPACE_BETWEEN);
	final Coordinate c5 = new Coordinate(WIDTH_UNIT*3 + SPACE_BETWEEN, SPACE_BETWEEN);
	final Coordinate c6 = new Coordinate(WIDTH_UNIT*3+SPACE_BETWEEN, HEIGHT_UNIT+SPACE_BETWEEN);
	final Coordinate c7 = new Coordinate(WIDTH_UNIT*3+SPACE_BETWEEN, HEIGHT_UNIT*3+SPACE_BETWEEN);
	final Coordinate c8 = new Coordinate(SPACE_BETWEEN, HEIGHT_UNIT*4+SPACE_BETWEEN);
	final Coordinate c9 = new Coordinate(WIDTH_UNIT*2+SPACE_BETWEEN, HEIGHT_UNIT*4+SPACE_BETWEEN);
	
	// define 10 dimensions for all 10 pieces 
	// Target piece
	final Dimension d0 = new Dimension(WIDTH_UNIT*2-SPACE_BETWEEN*2, HEIGHT_UNIT*2-SPACE_BETWEEN*2);
	
	// Obstacle
	final Dimension d1 = new Dimension(WIDTH_UNIT-SPACE_BETWEEN*2, HEIGHT_UNIT-SPACE_BETWEEN*2);
	final Dimension d2 = new Dimension(WIDTH_UNIT-SPACE_BETWEEN*2, HEIGHT_UNIT*2-SPACE_BETWEEN*2);
	final Dimension d3 = new Dimension(WIDTH_UNIT-SPACE_BETWEEN*2, HEIGHT_UNIT-SPACE_BETWEEN*2);
	final Dimension d4 = new Dimension(WIDTH_UNIT-SPACE_BETWEEN*2, HEIGHT_UNIT*2-SPACE_BETWEEN*2);
	final Dimension d5 = new Dimension(WIDTH_UNIT-SPACE_BETWEEN*2, HEIGHT_UNIT-SPACE_BETWEEN*2);
	final Dimension d6 = new Dimension(WIDTH_UNIT-SPACE_BETWEEN*2, HEIGHT_UNIT*2-SPACE_BETWEEN*2);
	final Dimension d7 = new Dimension(WIDTH_UNIT-SPACE_BETWEEN*2, HEIGHT_UNIT-SPACE_BETWEEN*2);
	final Dimension d8 = new Dimension(WIDTH_UNIT*2-SPACE_BETWEEN*2, HEIGHT_UNIT-SPACE_BETWEEN*2);
	final Dimension d9 = new Dimension(WIDTH_UNIT*2-SPACE_BETWEEN*2, HEIGHT_UNIT-SPACE_BETWEEN*2);
	
	public PuzzleSet produce() {
		PuzzleSet set = new PuzzleSet();
		set.add(new PuzzlePiece(c0, d0, true));
		set.add(new PuzzlePiece(c1, d1));
		set.add(new PuzzlePiece(c2, d2));
		set.add(new PuzzlePiece(c3, d3));
		set.add(new PuzzlePiece(c4, d4));
		set.add(new PuzzlePiece(c5, d5));
		set.add(new PuzzlePiece(c6, d6));
		set.add(new PuzzlePiece(c7, d7));
		set.add(new PuzzlePiece(c8, d8));
		set.add(new PuzzlePiece(c9, d9));
		return set;
	}
}
