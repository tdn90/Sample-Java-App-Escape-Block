package project.controller;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import project.boundary.SlidingPuzzleApp;
import project.model.Model;

public class MoveSelectedPieceController {
	SlidingPuzzleApp app;
	Model model;
	JButton moveOption;
	
	public MoveSelectedPieceController(SlidingPuzzleApp app, Model model, JButton moveOption) {
		this.app = app;
		this.model = model;
		this.moveOption = moveOption;
	}
	
	public void moveSelectedPiece() {
		boolean moved = false;
		if (moveOption.getText() == "^") { // up
			moved = model.moveSelectedPieceUp() ? true : false;
		}
		else if (moveOption.getText() == "v") { //down
			moved = model.moveSelectedPieceDown() ? true : false;
			// If the piece cannot be moved down, either is is really stuck, or it is the target piece "ready to win"
			if (!moved) {
				if (model.checkWin()) {
					model.incrementMove();
					app.getMoveLabel().setText("" + model.getMoves());
					JOptionPane.showMessageDialog(null, "Winner Winner Chicken Dinner!\nYou won after " + model.getMoves() + " moves!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			}
		}
		else if (moveOption.getText() == "<") { // left
			moved = model.moveSelectedPieceLeft() ? true : false;
		}
		else if (moveOption.getText() == ">") { // right
			moved = model.moveSelectedPieceRight() ? true : false;
		} 
		
		if (moved) {
			model.incrementMove();
			app.getMoveLabel().setText("" + model.getMoves());
			this.app.getPuzzleView().repaint();
		}
	}
}
