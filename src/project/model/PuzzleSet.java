package project.model;
/**
 * @author tnguyen4
 * 
 * This is unnecessary for the scope of this assignment, but just leave it here anyway.
 * 
 * If you really want to get rid of this class, simply declare another variable set 
 * which is an ArrayList<PuzzlePiece> in the Model class and adjust accordingly.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PuzzleSet implements Iterable<PuzzlePiece>{
	List<PuzzlePiece> pieces;
	
	public PuzzleSet() {
		pieces = new ArrayList<>();
	}
	
	/** Add given piece to the set */ 
	public void add(PuzzlePiece piece) {
		pieces.add(piece);
	}
	
	/** Iterate over pieces using provided Java Iterator */
	public Iterator<PuzzlePiece> iterator() {
		return pieces.iterator();
	}
}
