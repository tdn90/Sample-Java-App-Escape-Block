package project.boundary;
/**
 * @author tnguyen4
 */
import java.awt.Graphics;
import java.util.Iterator;
import javax.swing.JPanel;
import project.model.Model;
import project.model.PuzzlePiece;

/** 
 * Knows how to visually present the puzzle. 
 */
public class PuzzleView extends JPanel {
	private static final long serialVersionUID = 1L; // get rid of warning
	
	/* Core Model */
	Model model; 
	public PuzzleView(Model model) {
		this.model = model;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (model == null) { return; }
		for (Iterator<PuzzlePiece> it = model.getSet().iterator(); it.hasNext(); ) {
			PuzzlePiece piece = it.next();
			g.setColor(piece.getColor());
			g.fillRect(piece.getX(), piece.getY(), piece.getWidth(), piece.getHeight());
		}
	}
}
