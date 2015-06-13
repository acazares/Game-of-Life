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
public class StopControl implements ActionListener {
	
	private Population model;
	private MainView view;
	
	public StopControl(Population model, MainView view) {
		// Set the model and the view
		this.model = model;
		this.view = view;
		// Set this listener to the stop button
		this.view.setStopListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// If the timer is running stop it
		if(this.model.isRunning()) {
			this.model.stop();
		}
	}
}
