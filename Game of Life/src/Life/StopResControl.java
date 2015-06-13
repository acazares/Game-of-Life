/**
 * 
 */
package Life;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alexander Cazares
 *
 */
public class StopResControl implements ActionListener {
	
	private Population model;
	private MainView view;

	public StopResControl(Population model, MainView view) {
		// Set the model and view
		this.model = model;
		this.view = view;
		// Add this listener to the stopres button
		this.view.setStopResListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// If cells are being resurrected
		if(this.model.isResurrecting()) {
			// Stop resurrection
			this.model.stopResurrection();
		}
	}
}
