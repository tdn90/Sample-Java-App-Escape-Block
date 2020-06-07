package project.boundary;
/**
 * @author tnguyen4
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import project.controller.MoveSelectedPieceController;
import project.controller.SelectPieceController;
import project.controller.ResetPuzzleController;
import project.model.Model;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class SlidingPuzzleApp extends JFrame {
	private static final long serialVersionUID = 1L; // just to get rid of warning
	public static final int PUZZLE_WIDTH = 400;
	public static final int PUZZLE_HEIGHT = 525; 

	/**
	 * This boundary would have these fields:
	 * Entity object 
	 * active (action-able) elements 
	 */
	Model model;	
	JPanel contentPane;
	PuzzleView panel;
	JLabel moveLabel;
	JButton btnReset;
	JButton upButton;
	JButton left_button;
	JButton right_button;
	JButton down_button;
	
	public Model getModel() { return this.model; }
	public JLabel getMoveLabel() { return this.moveLabel; }
	public PuzzleView getPuzzleView() { return this.panel; }
	public JButton getUpButton() { return this.upButton; }
	public JButton getDownButton() { return this.down_button; }
	public JButton getLeftButton() { return this.left_button; }
	public JButton getRightButton() { return this.right_button; }
	
	/**
	 * Create the frame.
	 */
	public SlidingPuzzleApp(Model m) {
		this.model = m;
		setTitle("SlidingPuzzleApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 608);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/**
		 * Within this puzzle view, let's have our first controller: selectPiece
		 */
		panel = new PuzzleView(m);
		panel.setBackground(Color.GRAY);
		panel.setSize(new Dimension(PUZZLE_WIDTH, PUZZLE_HEIGHT));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectPieceController(SlidingPuzzleApp.this, model).selectPiece(me.getPoint());
			}
		});
		
		/**
		 * Active element! Our second controller goes here: resetPuzzle
		 */
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetPuzzleController(SlidingPuzzleApp.this, model).resetPuzzle();
			}
		});
		
		/**
		 * Multiple active element here for moving the piece...
		 * Our third controller comes to the rescue: moveSelectedPiece
		 */
		upButton = new JButton("^");
		upButton.setEnabled(false);
		upButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoveSelectedPieceController(SlidingPuzzleApp.this, model, upButton).moveSelectedPiece();
			}
		});
		
		left_button = new JButton("<");
		left_button.setEnabled(false);
		left_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoveSelectedPieceController(SlidingPuzzleApp.this, model, left_button).moveSelectedPiece();
			}
		});
		
		right_button = new JButton(">");
		right_button.setEnabled(false);
		right_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoveSelectedPieceController(SlidingPuzzleApp.this, model, right_button).moveSelectedPiece();
			}
		});
		
		down_button = new JButton("v");
		down_button.setEnabled(false);
		down_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MoveSelectedPieceController(SlidingPuzzleApp.this, model, down_button).moveSelectedPiece();
			}
		});
		
		JLabel lblMoves = new JLabel("Moves:");
		// Another interesting "passive" element that will need updates
		moveLabel = new JLabel("" + model.getMoves());
		// ----------------------------------
		// Ewww!!! Gross!!!
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(38)
										.addComponent(upButton))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(left_button)
										.addGap(33)
										.addComponent(right_button)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnReset)
										.addComponent(down_button))
									.addGap(15))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblMoves)
							.addGap(18)
							.addComponent(moveLabel)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMoves)
								.addComponent(moveLabel))
							.addGap(189)
							.addComponent(upButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(right_button)
								.addComponent(left_button))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(down_button)
							.addPreferredGap(ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
							.addComponent(btnReset)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
