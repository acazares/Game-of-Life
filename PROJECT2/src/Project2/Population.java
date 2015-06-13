/**
 * 
 */
package Project2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import javax.swing.Timer;

/**
 * @author Alexander Cazares
 *
 */
public class Population extends Observable {
	
	private Cell[][] grid;
	private Timer ticktock,ticktockalive;
	
	public Population() {
		// Initialize the array
		this.grid = new Cell[100][100];
		// Set all cells as dead
		this.killcells();
	}
	
	public Population(int rows, int columns) {
		this.grid = new Cell[rows][columns];
	}
	
	/* setTicktock: Timer --> void
	 * 
	 * This method sets the timer that will control
	 * the game
	 */
	public void setTicktock(Timer t){
		// Set the timer t to this.ticktock
		this.ticktock = t;
	}
	
	/* SetTicktockAlive: Timer --> void
	 * 
	 * This method sets another timer that will
	 * be used to resurrect random cells
	 */
	public void setTicktockAlive(Timer t) {
		// Set timer t to this.ticktockalive
		this.ticktockalive = t;
	}
	
	public void update() {
		// Create a new 2D array of cells
		// This will become the next generation
		int rows = this.grid.length;
		int columns = this.grid[rows-1].length;
		Cell [][] ngen = new Cell[rows][columns]; 
		
		for(int r=0; r < rows; r++) { // Rows
			for(int c=0; c < columns; c++){ // Columns
				int Nalive = 0; // neighbors alive
				
				int left = Math.max(0,c-1); // Left column
				int right = Math.min(c+1,columns-1); // right column
				int up = Math.max(0,r-1); // top row
				int down = Math.min(r+1,rows-1); // bottom row
				
				HashSet<Point> set = new HashSet<Point>(); // Set of all 8 neighbors
				// Add neighbors
				set.add(new Point(left,up));
				set.add(new Point(left,r));
				set.add(new Point(left,down));
				set.add(new Point(c,up));
				set.add(new Point(c,down));
				set.add(new Point(right,up));
				set.add(new Point(right,r));
				set.add(new Point(right,down));
				
				set.remove(new Point(c,r)); // Removes itself
				
				for(Point p : set) { // check which neighbors are alive
					if(this.isAlive(p.y,p.x)) {
						Nalive++;
					}
				}
				
				if	(this.isAlive(r,c)) {// If cell is alive
					if(Nalive<2 || Nalive>3) { 
						ngen[r][c] = new Dead(); // Becomes dead
					}
					else {
						ngen[r][c] = new Alive(); // stays alive
					}
				}
				else {
					if(Nalive == 3) {
						ngen[r][c] = new Alive(); // Comes back to life
					}
					else {
						ngen[r][c] = new Dead(); // stays dead
					}
				}
			}
		}
		this.grid = ngen; // replace old generation with new one
		this.setChanged();
		this.notifyObservers(this.getLocs());
	}
	
	/* isAlive: int int --> boolean
	 * 
	 * This method checks to see if a cell is alive in 
	 * the (row,column) location indicated by the two
	 * integers that it takes as input. This method calls
	 * the isAlive method that's in the Cell interface
	 */
	public boolean isAlive(int rowloc, int columnloc) {
		// Check if the cell in this location is alive
		return this.grid[rowloc][columnloc].isAlive();
	}

	/* resurrect: int int --> void
	 * 
	 * This method sets a cell alive in the 
	 * (row,column) location indicated by the two
	 * integers that it takes as input
	 */
	public void resurrect(int rowloc, int columnloc) {
		// Resurrect the cell at the specified location
		this.grid[rowloc][columnloc] = new Alive();
	}
	
	/* kill: int int --> void
	 * 
	 * This method sets a cell dead in the (row,column)
	 * location indicated by the integers that it takes
	 * as input
	 */
	public void kill(int rowloc, int columnloc) {
		// Kill the cell and the specified location
		this.grid[rowloc][columnloc] = new Dead();
	}
	
	/* killcells: --> void
	 * 
	 * This method sets all the cells in this.grid
	 * to be dead
	 */
	public void killcells() {
		int rows = this.grid.length;
		int columns = this.grid[rows-1].length;
		for (int r=0; r < rows; r++) {
			for (int c=0; c < columns; c++) {
				// Make the cell in this location dead
				this.kill(r,c);
			}
		}
	}
	
	/* getlocs: --> ArrayList<Point>
	 * 
	 * This method returns a set of locations of all
	 * the alive cells in this.grid; in x,y order
	 */
	public ArrayList<Point> getLocs() {
		int rows = this.grid.length;
		int columns = this.grid[rows-1].length;
		// Set that's going to contain the locs of the alive cells
		ArrayList<Point> locs = new ArrayList<Point>();
		for(int r=0; r < rows; r++) {
			for(int c=0; c < columns; c++) {
				if(this.grid[r][c].isAlive()) { // If the cell is alive
					// Add the location of the alive cell
					locs.add(new Point(c,r));
				}
			}
		}
		// Return the set of locations of the alive cells
		return locs;
	}
	
	/* stop: --> void
	 * 
	 * This method calls the stop method that is defined
	 * in the Timer class.
	 */
	public void stop() {
		// Stops the timer
		this.ticktock.stop();		
	}
	
	/* stopResurrection: --> void
	 * 
	 * This method calls the stop method that is defined 
	 * in the Timer class; this will stop resurrecting 
	 * random cells
	 */
	public void stopResurrection() {
		// Stops the timer
		this.ticktockalive.stop();
	}

	/* start: --> void
	 * 
	 * This method calls the start method that is defined
	 * in the Timer class
	 */
	public void start() {
		// Starts the timer
		this.ticktock.start();
	}
	
	/* startResurrection: --> void
	 * 
	 * This method calls the start method that is defined
	 * in the Timer class; this will start to resurrect
	 * random cells
	 */
	public void startResurrection() {
		// Starts the timer
		this.ticktockalive.start();
	}
	
	/* isRunning: --> boolean
	 * 
	 * This method calls the isRunning method that is
	 * defined in the Timer class
	 */
	public boolean isRunning() {
		// Checks if the timer is running
		return this.ticktock.isRunning();
	}
	
	/* This method calls the isRunning method that is
	 * defined in the Timer class; this will check to
	 * see if random cells are being resurrected
	 * 
	 */
	public boolean isResurrecting() {
		// Check if cells are resurrecting
		return this.ticktockalive.isRunning();
	}
}
			
	
