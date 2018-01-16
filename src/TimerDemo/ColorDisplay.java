package TimerDemo;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ColorDisplay extends JFrame {
	
		JButton startStopButton; // To start and stop the animation
		
      	Timer timer; // The timer that drives the animation.  A timer
                    // is started when the user starts the animation.
                    // Each time an ActionEvent is received from the
                    // timer, the background color of the display panel will change.
                    // The value of this variable is null when the
                    // animation is not in progress.
 
		Display display; // A JPanel to display the color
		
      	int colorIndex;// This is be a number between 0 and 100 that
                       // will be used to determine the color.  It will
                       // increase by 1 each time a timer event is
                       // processed.
  
      public ColorDisplay() {
             
          display = new Display();       

          getContentPane().add(display, BorderLayout.CENTER);
        

          JPanel buttonBar = new JPanel();
                
          buttonBar.setBackground(Color.gray);
          getContentPane().add(buttonBar, BorderLayout.SOUTH); 

          startStopButton = new JButton("Start");
          buttonBar.add(startStopButton);

          
          startStopButton.addActionListener( new ActionListener() {
          	// The action listener that responds to the 
                     // button. Starts or stops the animation.  It
                     // checks the value of timer to find out which
                     // to do.  Timer is non-null when the animation
                     // is running, so if timer is null, the 
                     // animation needs to be started.
   
                public void actionPerformed(ActionEvent evt) {
                   if (timer == null)
                      startAnimation();
                   else 
                      stopAnimation();
                }
             });
             
            setSize(300,300);
            setLocationRelativeTo(null);
          	setVisible(true);
       }///end constructor
      
      
		ActionListener timerListener = new ActionListener() {
			
			// Define an action listener to respond to events
               // from the timer.  When an event is received, the
               // color of the display is changed.
               
            public void actionPerformed(ActionEvent evt) {
                colorIndex++;  // A number between 0 and 100.
                if (colorIndex > 100)
                   colorIndex = 0;
                float hue = colorIndex / 100.0F;  // Between 0.0F and 1.0F.
                display.setColor( Color.getHSBColor(hue,1,1)); 
            }
         };
		
	
		void startAnimation() {
          // Start the animation, unless it is already running.
             // We can check if it is running since the value of
             // timer is non-null when the animation is running.
   
          if (timer == null) {
             // Start the animation by creating a Timer that
                // will fire an event every 50 milliseconds, and 
                // will send those events to timerListener.
   
             timer = new Timer(50, timerListener);
             timer.start();  // Make the time start running.
             startStopButton.setText("Stop");
          }
      }
		
      void stopAnimation() {
          // Stop the animation by stopping the timer, unless the
            // animation is not running.
  
         if (timer != null) {
            timer.stop();   // Stop the timer.
            timer = null;   // Set timer variable to null, so that we
                            //   can tell that the animation isn't running.
            startStopButton.setText("Start");
         }
      }
      
	private class Display extends JPanel {
		
		public void setColor(Color color){
			
			setBackground(color);
		}	
	}
	
	public static void main(String [] args){
      	      	
      	ColorDisplay cd = new ColorDisplay();
  
      }
	
	
 }
