/**
 * 
 */
package Project2;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author Alexander Cazares
 *
 */
public class OnTickResurrect implements ActionListener {
	
	private Population model;
	private MainView view;
	private Random ranCells;
	
	public OnTickResurrect(Population model, MainView view) {
		// Set the model and the view
		this.model = model;
		this.view = view;
		// Initialize the random generator
		this.ranCells = new Random();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Row between 0 and 99
		int row = this.ranCells.nextInt(99); 
		// Column between 0 and 99
		int column = this.ranCells.nextInt(99);
		// If the cell is not alive
		if(!this.model.isAlive(row,column)) {
			// Bring it to life
			this.model.resurrect(row,column);
			// Add the loc of the alive cell to the canvas class
			this.view.addloc(new Point(column,row));
			// Recount the number of alive cells
			this.view.setNumbAlive();
			// Redraw the cells
			this.view.draw();
		}
	}
}
