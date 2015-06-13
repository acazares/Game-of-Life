/**
 * 
 */
package Life;

/**
 * @author Alexander Cazares
 *
 */
public interface Cell {
	
	/* isAlive: --> boolean
	 * 
	 * This method returns true if the cell is Alive or 
	 * false if the cell is dead.
	 */
	boolean isAlive();
	boolean equals(Object obj);
	int hashCode();

}
