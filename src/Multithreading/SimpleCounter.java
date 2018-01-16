package Multithreading;

public class SimpleCounter extends Thread {
	   private int count;
	   private int increment;
	   private int delay;

	   public SimpleCounter(int startCount, int increment, int delay) {
	      count = startCount;
	      this.increment = increment;
	      this.delay = delay;
	   }

	   public void run(){
/*		
	The run() of Thread class is overridden here. The run() is invoked when execution starts.
	Execution of a thread ends when run() ends.
	To start a thread, create an instance of Thread class and invoke start() which indirectly invokes the run().
	In the code below, the run() executes an infinite loop, increments the counter inside the loop and sleeps for a 
	Duration given in milliseconds.
*/
	    try {
	      for (;;){

	        System.out.println(count +"   "+increment);

	        count += increment;

	        sleep (delay);
	      }
	    }
	    catch (InterruptedException e) {
	      System.out.println(e);
	    }
	   }
	

	   public static void main(String [] args){
	    new SimpleCounter(0,1,40).start();
	    new SimpleCounter (0,-1,40).start();

	   }
	}
