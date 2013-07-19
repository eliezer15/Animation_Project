package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;

public class ProgressView implements PropertyChangeListener {

	JProgressBar progressBar;
    double totalTime;
    double currentTime;
    int percentageCompleted;
	
	public ProgressView(JProgressBar progressBar) {
		
		this.progressBar = progressBar;
		totalTime = 1;
		totalTime = 0;
	}
	public void propertyChange(PropertyChangeEvent event) {
		
		String propertyName = event.getPropertyName();
	    
		if (propertyName.equalsIgnoreCase("totalTime")) {

			totalTime = (int)event.getNewValue();	
		}
		
		else if (propertyName.equalsIgnoreCase("time")){
			
			currentTime = (int)event.getNewValue();
			percentageCompleted = (int)((currentTime/totalTime)*100);
			progressBar.setValue(percentageCompleted);
			progressBar.repaint();
		}
				
	}

}
