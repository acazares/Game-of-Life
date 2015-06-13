/**
 * 
 */
package Project2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Alexander Cazares
 *
 */
public class Buttons extends JPanel {
	
	private JButton start,stop,reset,
					startres,stopres;

	public Buttons(){
		// Initialize the buttons
		// Add their text
		start = new JButton();
		start.setText("Start");
		stop = new JButton();
		stop.setText("Stop");
		reset = new JButton();
		reset.setText("Reset");
		startres = new JButton();
		startres.setText("Start Resurrection");
		stopres = new JButton();
		stopres.setText("Stop Resurrection");
		
		// Create layout and its size
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		this.setPreferredSize(new Dimension(350,100));
		this.setMaximumSize(new Dimension(350,100));
		this.setMinimumSize(new Dimension(350,100));
		layout.setVgap(15); // Set gap
		this.setLayout(layout); // Set the layout
		
		// Add the buttons
		this.add(start);
		this.add(reset);
		this.add(stop);
		this.add(startres);
		this.add(stopres);
	}

	/* setStartlistener: ActionListener --> void
	 * 
	 * This method simply runs the addActionListener method
	 * that is defined in the JPanel class; with the listener
	 * that it takes as input
	 */
	public void setStartlistener(ActionListener act) {
		// Add the action-listener to the start button
		start.addActionListener(act);
	}
	
	/* setStoplistener: ActionListener --> void
	 * 
	 * This method simply runs the addActionListener method
	 * that is defined in the JPanel class; with the listener
	 * that it takes as input
	 */
	public void setStoplistener(ActionListener act) {
		// Add the action-listener to the stop button
		stop.addActionListener(act);
	}
	
	/* setResetlistener: ActionListener --> void
	 * 
	 * This method simply runs the addActionListener method
	 * that is defined in the JPanel class; with the listener
	 * that it takes as input
	 */
	public void setResetlistener(ActionListener act) {
		// Add the action-listener to the reset button
		reset.addActionListener(act);
	}
	
	/* setStartReslistener: ActionListener --> void
	 * 
	 * This method adds an action listener to the startres
	 * button by calling the addActionListener method defined
	 * in the JPanel class
	 */
	public void setStartReslistener(ActionListener act) {
		// Add listener to startres button
		startres.addActionListener(act);
	}
	
	/* setStopReslistener: ActionListener --> void
	 * 
	 * This method adds an action listener to the stopres
	 * button by calling the addActionListener method
	 * defined in the JPanel class
	 */
	public void setStopReslistener(ActionListener act) {
		// Add listener to stopres button
		stopres.addActionListener(act);
	}
}
