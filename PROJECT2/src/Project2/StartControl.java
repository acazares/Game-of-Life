/**
 * 
 */
package Project2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alexander Cazares
 *
 */
public class StartControl implements ActionListener {

	private Population model;
	private MainView view;

	public StartControl(Population model, MainView view) {
		// Set the model and the view
		this.model = model;
		this.view = view;
		// Set this listener to the start button
		this.view.setStartListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// If the timer is not running and cells aren't being resurrected
		if(!this.model.isRunning() && !this.model.isResurrecting()) {
			// Start the timer
			this.model.start();
		}
	}
}
