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
public class StartResControl implements ActionListener {
	
	private Population model;
	private MainView view;

	public StartResControl(Population model, MainView view) {
		// Set the model and the view
		this.model = model;
		this.view = view;
		// Add this listener to the startres button
		this.view.setStartResListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// If the main timer isn't running and if cells aren't being
		// resurrected
		if(!this.model.isResurrecting() && !this.model.isRunning()) {
			this.view.resetcounter();
			// Start the resurrection
			this.model.startResurrection();
		}
	}
}
