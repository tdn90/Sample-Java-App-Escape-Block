package project.model;
/**
 * @author tnguyen4
 */
import java.util.Iterator;
import project.boundary.SlidingPuzzleApp;
import project.model.set.LifeSet;

/**
 * Top-level entity class
 */
public class Model {
	public static final int SPACE_BETWEEN = 3; 
	public static final int WIDTH_UNIT = SlidingPuzzleApp.PUZZLE_WIDTH / 4;
	public static final int HEIGHT_UNIT = SlidingPuzzleApp.PUZZLE_HEIGHT / 5;
	
	/* Available puzzle set */
	LifeSet factory;
	
	/* Puzzle set in use */
	PuzzleSet set;
	
	/* Current selected piece */
	PuzzlePiece selectedPiece;
	
	/*
	 * Keep track of number of moves in the puzzle
	 * Update the puzzle accordingly in controller 
	 */
	int numMoves;	
	
	public Model() {
		this.defaultModel();
	}
	
	// Initializing the puzzle set and get the model ready
	public void defaultModel() {
		numMoves = 0;
		LifeSet fact = new LifeSet();
		this.setFactory(fact);
	}
	
	public void setFactory(LifeSet factory) {
		this.factory = factory;
		this.set = factory.produce();
		this.selectedPiece = null;
	}
	
	public PuzzlePiece getSelectedPiece() {
		return this.selectedPiece;
	}
	
	public void incrementMove() {
		this.numMoves++;
	}
	
	public int getMoves() {
		return this.numMoves;
	}
	
	/**
	 * Set the selected piece for the puzzle
	 * @param selectedPiece the selected PuzzlePiece. If selectedPiece is null, then no piece 
	 * is selected
	 */
	public void setSelectedPiece(PuzzlePiece selectedPiece) {
		// Case 1: no piece is currently selected (user clicks on empty space)
		if (selectedPiece == null) {
			if (this.selectedPiece != null) {
				this.selectedPiece.setDefaultColor();
				this.selectedPiece = null;
			}
		}
		else {
			// Some piece has already been selected before, set back default color
			if (this.selectedPiece != null) {
				this.selectedPiece.setDefaultColor();
			}
			// Update selected piece and its color
			this.selectedPiece = selectedPiece;
			this.selectedPiece.setSelectedColor();
		}
	}
	
	/**
	 * Check to see if the coordinate (x,y) specified is proper for a potential move
	 * @param x: x coordinate
	 * @param y: y coordinate
	 * @return true if there is no piece placed at (x,y), meaning (x,y) does not belongs to any piece. Return
	 * false otherwise, or if (x,y0 is out of the puzzle boundary
	 */
	public boolean isValidMove(int x, int y) {
		boolean inBound =  x > 0 && x < SlidingPuzzleApp.PUZZLE_WIDTH && y > 0 && y < SlidingPuzzleApp.PUZZLE_HEIGHT;
		// Not in bound? 
		if (!inBound) return false;
		// In bound? Keep checking, see if any piece is already placed there
		else {
			for (Iterator<PuzzlePiece> it = this.set.iterator(); it.hasNext();) {
				PuzzlePiece piece = it.next();
				// Some piece is here (not the moved piece)... Oops!
				if (piece != this.selectedPiece && piece.contains(x,y)) {
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * Attempt to move the piece left 
	 * Precondition: this.selectedPiece MUST be non-null
	 * @return true if a left move is successful, false otherwise
	 */
	public boolean moveSelectedPieceLeft() {
		// Calculate top left coordinate to potentially update puzzle piece
		int next_topLeft_x = this.selectedPiece.getX() - WIDTH_UNIT; 
		int next_topLeft_y = this.selectedPiece.getY();
		
		// If move left, then check whether bottom left + top left corner hit anything, or out of puzzle bound
		int next_bottomLeft_x = next_topLeft_x;
		int next_bottomLeft_y = this.selectedPiece.getY() + this.selectedPiece.getHeight();
		
		if (isValidMove(next_topLeft_x, next_topLeft_y) && isValidMove(next_bottomLeft_x, next_bottomLeft_y)) {
			this.selectedPiece.setX(next_topLeft_x);
			this.selectedPiece.setY(next_topLeft_y);
			return true;
		}
		else return false;
	}
	
	/**
	 * Attempt to move the piece right 
	 * Precondition: this.selectedPiece MUST be non-null
	 * @return true if a right move is successful, false otherwise
	 */
	public boolean moveSelectedPieceRight() {
		// Calculate top left coordinate to potentially update puzzle piece
		int next_topLeft_x = this.selectedPiece.getX() + WIDTH_UNIT; 
		int next_topLeft_y = this.selectedPiece.getY();
		
		// If move right, then check whether bottom right + top right corner hit anything, or out of puzzle bound
		int next_topRight_x = this.selectedPiece.getX() + WIDTH_UNIT + this.selectedPiece.getWidth();
		int next_topRight_y = this.selectedPiece.getY();
		
		int next_bottomRight_x = next_topRight_x;
		int next_bottomRight_y = this.selectedPiece.getY() + this.selectedPiece.getHeight();
		
		if (isValidMove(next_topRight_x, next_topRight_y) && isValidMove(next_bottomRight_x, next_bottomRight_y)) {
			this.selectedPiece.setX(next_topLeft_x);
			this.selectedPiece.setY(next_topLeft_y);
			return true;
		}
		else return false;
	}

	/**
	 * Attempt to move the piece up
	 * Precondition: this.selectedPiece MUST be non-null
	 * @return true if a up move is successful, false otherwise
	 */
	public boolean moveSelectedPieceUp() {
		// Calculate top left coordinate to potentially update puzzle piece
		int next_topLeft_x = this.selectedPiece.getX();
		int next_topLeft_y = this.selectedPiece.getY() - HEIGHT_UNIT;
		
		// If move up, then check whether top right + top left corner hit anything, or out of puzzle bound
		int next_topRight_x = this.selectedPiece.getX() + this.selectedPiece.getWidth();
		int next_topRight_y = next_topLeft_y;
		
		if (isValidMove(next_topLeft_x, next_topLeft_y) && isValidMove(next_topRight_x, next_topRight_y)) {
			this.selectedPiece.setX(next_topLeft_x);
			this.selectedPiece.setY(next_topLeft_y);
			return true;
		}
		else return false;
	}

	/**
	 * Attempt to move the piece down 
	 * Precondition: this.selectedPiece MUST be non-null
	 * @return true if a down move is successful, false otherwise
	 */
	public boolean moveSelectedPieceDown() {
		// Calculate top left coordinate to potentially update puzzle piece
		int next_topLeft_x = this.selectedPiece.getX();
		int next_topLeft_y = this.selectedPiece.getY() + HEIGHT_UNIT;
		
		// If move up, then check whether bottom right + bottom left corner hit anything, or out of puzzle bound
		int next_bottomRight_x = this.selectedPiece.getX() + this.selectedPiece.getWidth();
		int next_bottomRight_y = this.selectedPiece.getY() + this.selectedPiece.getHeight() + HEIGHT_UNIT;
		
		int next_bottomLeft_x = next_topLeft_x;
		int next_bottomLeft_y = this.selectedPiece.getY() + this.selectedPiece.getHeight() + HEIGHT_UNIT;
		
		// check valid move first
		if (isValidMove(next_bottomRight_x, next_bottomRight_y) && isValidMove(next_bottomLeft_x, next_bottomLeft_y)) {
			this.selectedPiece.setX(next_topLeft_x);
			this.selectedPiece.setY(next_topLeft_y);
			return true;
		}
		else return false;
	}
	
	/**
	 * @return true if the target piece is "ready to win", false otherwise
	 */
	public boolean checkWin() {
		if (this.selectedPiece.isTargetPiece) {
			int bottom_y = SlidingPuzzleApp.PUZZLE_HEIGHT - SPACE_BETWEEN; 
			int left_x = this.selectedPiece.getX();
			int right_x = left_x + this.selectedPiece.getWidth();
			return bottom_y == this.selectedPiece.getY() + this.selectedPiece.getHeight() && left_x >= WIDTH_UNIT && right_x <= WIDTH_UNIT * 3;
		}
		else return false;
	}
	
	public PuzzleSet getSet() {
		return this.set;
	}
}
