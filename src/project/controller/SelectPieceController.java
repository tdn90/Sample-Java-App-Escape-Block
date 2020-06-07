package project.controller;
/**
 * @author tnguyen4
 */
import java.awt.Point;
import java.util.Iterator;

import project.boundary.SlidingPuzzleApp;
import project.model.Model;
import project.model.PuzzlePiece;

public class SelectPieceController {
	SlidingPuzzleApp app;
	Model model; 
	
	public SelectPieceController(SlidingPuzzleApp app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	/**
	 * Select a piece if the user clicks on a specific piece; un-select 
	 * any selected piece if the user clicks on an empty space. Do nothing 
	 * if no piece is already selected 
	 * @param p: A point at which the user clicks the mouse
	 */
	public void selectPiece(Point p) {
		boolean selected = false;
		for (Iterator<PuzzlePiece> it = model.getSet().iterator(); it.hasNext();) {
			PuzzlePiece piece = it.next();
			if (piece.contains(p.getX(), p.getY())) {
				model.setSelectedPiece(piece);
				selected = true;
				break;
			}
		}
		if (!selected)
			model.setSelectedPiece(null);
		new MoveButtonController(app).setAllMoveButtons(selected);
		app.getPuzzleView().repaint();
	}
}
