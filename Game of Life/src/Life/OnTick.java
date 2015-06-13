/**
 * 
 */
package Life;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Alexander Cazares
 *
 */
public class OnTick implements ActionListener {
	
	Population model;
	MainView view;
	
	public OnTick(Population model, MainView view) {
		// Set the model and the view
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Update the model
		this.model.update();
		// Update the counter
		this.view.updatecounter();
		// Recount alive cells
		this.view.setNumbAlive();
	}

}
