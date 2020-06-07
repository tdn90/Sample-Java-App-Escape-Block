package project.model;
/**
 * @author tnguyen4
 */
import java.awt.Color;

public class PuzzlePiece {
	// This probably should be in the SlidingPuzzleApp... but whatever :p
	public final Color DEFAULT_COLOR = Color.ORANGE;
	public final Color SELECTED_COLOR = Color.CYAN;
	public final Color TARGET_COLOR = Color.RED;
	
	boolean isTargetPiece;
	Coordinate topLeft;
	Dimension dim;
	Color color; 
	
	/* Constructor to create a default piece */
	public PuzzlePiece(Coordinate topLeft, Dimension dim) {
		this.topLeft = topLeft;
		this.dim = dim;
		this.setDefaultColor();
	}
	
	/* 
	 * Constructor to create the target piece
	 * Boy! I wish Java allows easy default argument handling
	 */
	public PuzzlePiece(Coordinate topLeft, Dimension dim, boolean isTargetPiece) {
		this.topLeft = topLeft;
		this.dim = dim;
		this.isTargetPiece = isTargetPiece;
		if (isTargetPiece) this.color = TARGET_COLOR;
		else this.setDefaultColor();
	}
	
	public void setDefaultColor() {
		if (!this.isTargetPiece) this.color = DEFAULT_COLOR;
		else this.color = TARGET_COLOR;
	}
	
	public void setSelectedColor() {
		this.color = SELECTED_COLOR;
	}
	
	/**
	 * @param p_x: x-coord of a clicked point 
	 * @param p_y: y-coord of a clicked point
	 * @return true if this piece area contains the point specified, false otherwise
	 */
	public boolean contains(double p_x, double p_y) {
		int topLeft_x = topLeft.x;
		int topLeft_y = topLeft.y;
		int bottomRight_x = topLeft_x + dim.width;
		int bottomRight_y = topLeft_y + dim.height;
		return p_x >= topLeft_x && p_x <= bottomRight_x
				&& p_y >= topLeft_y && p_y <= bottomRight_y;
	}
	
	public void setX(int x) {
		this.topLeft.x = x;
	}
	
	public void setY(int y) {
		this.topLeft.y = y;
	}
	
	public int getX() {
		return this.topLeft.x;
	}
	
	public int getY() {
		return this.topLeft.y;
	}
	
	public int getWidth() {
		return this.dim.width;
	}
	
	public int getHeight() {
		return this.dim.height;
	}
	
	public Color getColor() {
		return this.color;
	}
}
