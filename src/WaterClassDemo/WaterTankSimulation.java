package WaterClassDemo;
import java.util.*;

import Multithreading.Counter;

/*
WaterTank holds water and allows water to flow out when shutoff is false. 
An Outpipe object runs on a separate thread and if the pipe is open on the watertank, allows 
the water to flow out.
A LevelMonitor object monitors the water level in the tank continuously and checks if the 
water level is above critical level. It shuts off the watertank if the level falls below critical level. 
Complete the code 
*/

class WaterTank extends Observable  {  /// <----change 1: add extends Observable
    int currentVolume;
    boolean shutOff = false;
    public WaterTank(int c){currentVolume = c;}
    public WaterTank(){}

    public void flowOut(){
    	if (!shutOff){
      		--currentVolume;
      		/*****IMPORTANT CHANGE ****/
      		//change2: set changed abd notify Observer and object to observe, here its water volumne
      		setChanged(); 
      		notifyObservers(new Integer(currentVolume)); //// IMPORTANT TO PASS OBSERVING OBJECT 
      		/******VERY IMPORTANT *******/
      	}
    }
    
    public int getCurrentVolume() { 
    	return currentVolume;
    }
    
    public void stop(){
    	shutOff = true;
    }
    
    public boolean isPipeOpen(){
    	return !shutOff;
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class LevelMonitor  implements Observer{    /// <----change 3: add implements Observer IMPORTANT
    int criticalVolume = 0;
    WaterTank tank;

    public LevelMonitor (int cvolume,WaterTank t){
        this.criticalVolume = cvolume;
        tank = t;
        tank.addObserver(this);
    }
    
    public LevelMonitor(){}
    public boolean isCriticalLevel(int volume){
    	return volume <= criticalVolume;
    }

    public void shutOffTank(){
        tank.stop();
    } 
    
    /****NOTE THE UPDATE METHOD OBject currentlevel passed from ovservable watertank at notifyObserver()*****/
    public void update(Observable o1, Object currentLevel){  
    	int level = (Integer)currentLevel;
    	if (isCriticalLevel(level)){
    		System.out.println("Monitor: Reached Critical Level - shutting off water");
    		shutOffTank();
    	}
    	else{
    		System.out.println("Monitor: WaterTank Volume Ok");
    	}
    }  
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


class OutPipe implements Runnable { /////change 4: ADD IMPLEMENTS Runnable for thread IMPORTANT
	WaterTank watertank = null;
	int id;
	public OutPipe(int id,WaterTank watertank){
		this.watertank = watertank;
		this.id = id;
	}
	public void run(){
		synchronized(watertank){  ////change 5: make water tank synchronized in a block
			while (watertank.isPipeOpen()){
				System.out.println("Thread "+id+" CurrentVolume: "+watertank.getCurrentVolume());
				watertank.flowOut();	
			}
		 }
			System.out.println("Thread "+id+" OutPipe Closed");
		 
    }
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class WaterTankSimulation {
	public static void main(String[] args) {
		 WaterTank tank = new WaterTank(100);

	     LevelMonitor monitor = new LevelMonitor(25,tank);
	     ////////change 6: Create Threads with outpipe object	    
	     Thread t1 = new Thread(new OutPipe(1,tank));  /// <---- Thread object created using object of type runnable as parameter to constructor
		 Thread t2 = new Thread(new OutPipe(2,tank));
	     t1.start();
	     t2.start();
	    
	     
	}
}
