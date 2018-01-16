package Multithreading;

//////////////////////////////////////////////////////
/*
This is another mechanism to make a thread – 
the class implements a Runnable interface. 
Note the way a thread is made using a Thread constructor
that takes a Runnable object as a parameter

*/
public class Counter implements Runnable {
	private int count;
	private int increment;
	private int delay;
	
	public Counter(int startCount, int increment, int delay) {
		count = startCount;
		this.increment = increment;
		this.delay = delay;
	}
	public void run(){
		try {
			for (;;){
				System.out.print(count +"   ");
				count += increment;
				Thread.sleep(300);
			}
		}catch (InterruptedException e) {
				System.out.println(e);
		}
	}


	public static void main(String [] args){
			Thread t1 = new Thread(new Counter(0,1,40));  /// <---- Thread object created using object of type runnable as parameter to constructor
			t1.start();
			Thread t2 = new Thread(new Counter(0,-1,100));
			t2.start();
	}
}
