package MVCDemo.SwingApp;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

//This class implements the Observer interface and 
//provides an empty implementation for the interface

class AView extends JPanel implements Observer{
	public void update(Observable o1, Object o2) {};
}

