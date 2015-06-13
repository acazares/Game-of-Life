/**
 * 
 */
package Life;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

/**
 * @author Alexander Cazares
 *
 */
public class Canvas extends JPanel {
	
	private ArrayList<Point> locs;
	
	public Canvas() {
		// Initialize the array of points
		this.locs = new ArrayList<Point>();
		
		// Set the size and color of the panel
		this.setPreferredSize(new Dimension(1000,1000));
		this.setMaximumSize(new Dimension(1000,1000));
		this.setMinimumSize(new Dimension(1000,1000));
		this.setBackground(Color.black);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 
		// Set the width and height of the square
		int width = 10; 
		int height = 10;
		// Create the graphics
		Graphics2D painter = (Graphics2D) g;
		// Color of the grid
		painter.setColor(Color.gray);
		// Draw the grid
		for(int i = 10; i < 1000; i += 10) {
			painter.drawLine(i,0,i,1000); // Lines on the y-axis
			painter.drawLine(0,i,1000,i); // Lines in the x-axis
		}
		// Color of the cells
		painter.setColor(Color.cyan);
		for(Point p : this.locs) {
			int x = p.x * width; // Change grid x location to pixel x location
			int y = p.y * height; // Change grid y location to pixel y location
			// Initialize the square
			Rectangle2D.Double square = new Rectangle2D.Double(x,y,width,height);
			// Fill and draw the square
			painter.fill(square);
			painter.draw(square);
		}
	}
	
	/* setlocs: ArrayList<Point> --> void
	 * 
	 * This is a set method that sets the ArrayList<Point>
	 * that it takes as input to the ArrayList<Point> that's 
	 * in this class
	 */
	public void setlocs(ArrayList<Point> locs) {
		// Set locs
		this.locs = locs;
	}
	
	/* addloc: Point --> void
	 * 
	 * This method runs the add method that is defined in the
	 * ArrayList class; with the Point that it takes as input
	 */
	public void addloc(Point loc) {
		// Add loc
		this.locs.add(loc);
	}
	
	/* removeloc: Point --> void
	 * 
	 * This method runs the remove method that is defined in the
	 * ArrayList class; with the Point that it takes as input
	 */
	public void removeloc(Point loc) {
		// Remove loc
		this.locs.remove(loc);
	}
	
	/* removeall: --> void
	 * 
	 * This method removes all the locs that are in this.locs; method
	 * called also defined in ArrayList class
	 */
	public void removeall() {
		// Remove all the locs
		this.locs.removeAll(locs);
	}
	
	/* numbLocs: --> Integer
	 * 
	 * This method returns the size of the array,
	 * A.K.A the number of cells alive
	 */
	public Integer numbLocs() {
		// Return the size of the array
		return this.locs.size();
	}
}
