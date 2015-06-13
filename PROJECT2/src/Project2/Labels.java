/**
 * 
 */
package Project2;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Alexander Cazares
 *
 */
public class Labels extends JPanel {
	
	private JLabel label,cellsalive;
	private Integer counter;
	
	public Labels() {
		// Set the counter to 0
		counter = 0;
		// Initialize the labels and set their text
		label = new JLabel();
		label.setText("Generation: " + counter.toString());
		cellsalive = new JLabel();
		cellsalive.setText("Cells Alive: 0");
		// Set the layout and size of this panel
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(500,50));
		this.setMaximumSize(new Dimension(500,50));
		this.setMinimumSize(new Dimension(500,50));
		// Add the labels with spaces between each other and the panel
		this.add(Box.createRigidArea(new Dimension(5,5)));
		this.add(label);
		this.add(Box.createRigidArea(new Dimension(5,5)));
		this.add(cellsalive);
	}
	
	/* updatecounter: --> void
	 * 
	 * This method increases the counter by 1
	 */
	public void updatecounter() {
		// Increase counter
		this.counter++;
		// Set the counter as the label text
		this.label.setText("Generation: " + counter.toString());
	}
	
	/* resetcounter --> void
	 * 
	 * This method resets the counter if it's not already reset
	 */
	public void resetcounter() {
		if(!(this.counter == 0)) { 
			// Reset counter
			this.counter = 0;
			// Set the counter as the label text
			this.label.setText("Generation: " + counter.toString());
		}
	}
	
	/* setNumbAlive: Integer --> void
	 * 
	 * This method sets the number of alive cells to the
	 * appropriate label based on the Integer that it takes
	 * as input
	 */
	public void setNumAlive(Integer cells) {
		// Set number of cells alive
		this.cellsalive.setText("Cells Alive: " + cells.toString());
	}
}
