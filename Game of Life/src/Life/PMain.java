/**
 * 
 */
package Life;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;


/**
 * @author Alexander Cazares
 *
 */
public class PMain extends JFrame {
	
	private Population model;
	private MainView view;
	private OnTick tickcontrol;
	private OnTickResurrect tickrescontrol;
	private CanvasControl canvascontrol;
	private StartControl startcontrol;
	private StopControl stopcontrol;
	private ResetControl resetcontrol;
	private StartResControl startrescontrol;
	private StopResControl stoprescontrol;
	private Timer ticker,resticker;
	
	public PMain() {
		this.initComponents();
		this.setTitle("Game of Life");
		this.setVisible(true);
	}
	
	private void initComponents() {
		// Initialize the view and set it as the content-pane of this
		view = new MainView();
		this.setContentPane(view);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		// Initialize the model
		model = new Population();
		// Initialize all the controllers
		startcontrol = new StartControl(model,view);
		stopcontrol = new StopControl(model,view);
		resetcontrol = new ResetControl(model,view);
		startrescontrol = new StartResControl(model,view);
		stoprescontrol = new StopResControl(model,view);
		canvascontrol = new CanvasControl(model,view);
		tickcontrol = new OnTick(model,view);
		tickrescontrol = new OnTickResurrect(model,view);
		// Initialize the timers, with their listeners
		ticker = new Timer(150,tickcontrol);
		resticker = new Timer(0,tickrescontrol);
		// Set the tickers
		model.setTicktock(ticker);
		model.setTicktockAlive(resticker);
		// The view now observes the model
		model.addObserver(view); 
	}
	
	public static void main(String args[]){
		// Create a window
		PMain window = new PMain();		
	}
}
