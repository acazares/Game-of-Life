/**
 * 
 */
package Project2;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * @author Alexander Cazares
 *
 */
public class CanvasControl implements MouseListener {
	
	Population model;
	MainView view;
	
	public CanvasControl(Population model, MainView view) {
		// Set the model and the view
		this.model = model;
		this.view = view;
		// Set this listener to the canvas
		this.view.setMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// If the timer is not running & cells aren't being resurrected
		if(!this.model.isRunning() && !this.model.isResurrecting()) {
			this.view.resetcounter(); // Reset counter
			Point ploc = e.getPoint(); // Where mouse clicked
			int column = ploc.x / 10; // Change pixel x loc to grid x loc
			int row = ploc.y / 10; // Change pixel y loc to grid y loc
			Point gloc = new Point(column,row); // Make a point
			if(!this.model.isAlive(row,column)) { // If dead
				// Bring back to life
				this.model.resurrect(row,column);
				// Add loc in the canvas
				this.view.addloc(gloc);
			}
			else { // If alive
				// Kill cell
				this.model.kill(row,column);
				// Remove loc from the canvas
				this.view.removeloc(gloc);
			}
			// Re-draw
			this.view.draw();
			// Recount alive cells
			this.view.setNumbAlive();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
