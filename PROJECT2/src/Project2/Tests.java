/**
 * 
 */
package Project2;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Alexander Cazares
 *
 */

/******************************************************
 ******************************************************
 *** IN ORDER TO REMOVE THE ERRORS IN THIS FILE     ***
 *** AND RUN THE TEST, THE 2D ARRAY OF CELLS THAT'S ***
 *** IN THE MODEL (POPULATION) MUST BE MADE PUBLIC! ***
 *** ALSO UNCOMMENT THE TEST.                       ***
 ******************************************************
 ******************************************************
 */

public class Tests {
	
	private Cell[][] grid;
	
	@Before
	public void setUp() {
		grid = new Cell[4][4];
	}
	
	@After
	public void teardown() {
		grid = null;
		System.gc();
	}
	/*
	@Test
	public void modeltest() {
		Population model = new Population(4,4);
		grid[0][0] = new Dead();
		grid[0][1] = new Dead();
		grid[0][2] = new Alive();
		grid[0][3] = new Dead();
		grid[1][0] = new Dead();
		grid[1][1] = new Alive();
		grid[1][2] = new Dead();
		grid[1][3] = new Dead();
		grid[2][0] = new Alive();
		grid[2][1] = new Alive();
		grid[2][2] = new Alive();
		grid[2][3] = new Alive();
		grid[3][0] = new Alive();
		grid[3][1] = new Alive();
		grid[3][2] = new Dead();
		grid[3][3] = new Alive();
		// Make model.grid equal to grid
		for(int r=0; r<grid.length; r++) {
			System.arraycopy(grid[r],0,model.grid[r],0,grid[r].length);
		}
		
		// Before 
		// Grids are exactly the same, they are equal)
		for(int r=0; r<grid.length; r++) {
			assertArrayEquals(grid[r],model.grid[r]);
		}
		
		// Change grid to the next generation
		// Model.grid and grid are no longer the same
		grid[0][2] = new Dead();
		grid[1][0] = new Alive();
		grid[1][1] = new Dead();
		grid[1][3] = new Alive();
		grid[2][0] = new Dead();
		grid[2][1] = new Dead();
		grid[2][2] = new Dead();
		grid[3][1] = new Dead();
		
		// After 
		// Model.grid has gone to the next generation
		// Model.grid and grid are once again equal
		model.update();
		for(int r=0; r<grid.length; r++) {
			assertArrayEquals(grid[r],model.grid[r]);
		}
	} */
}
