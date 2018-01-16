package MVCDemo.SwingApp;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.*;


public class MVCDemo {
	public static void main(String[] args) {
		
			// Create a Model
			ItemModel model = new ItemModel(" Craft Vase",11.00);
			
			// Create View 1
			DisplayView display = new DisplayView();
			// Add the View as the Observer on the model
			model.addObserver(display);
			
			// Create View 2
			TextView textView = new TextView();
			// Add the View as the Observer on the model
			model.addObserver(textView);	
			
			// Create a Controller and connect it with the model
			ItemController controller = new ItemController(model);
			
			// Add the views to the controller so that it displays them
			// in a window
			controller.addAView(display);
			controller.addAView(textView);
			
			// Start the application now
			controller.startApp();
	}

}
