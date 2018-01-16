package Multithreading;

public class SynchCounter {
	private int count = 0;
	/*
	 *An atomic action is one that effectively happens all at once. 
	 *An atomic action cannot stop in the middle: 
	 *it either happens completely, or it doesn't happen at all.
	 * No side effects of an atomic action are visible until the action 
	 * is complete.

	* An increment expression, such as i++, does not describe an atomic action. Even very simple expressions can define complex actions that can decompose into other actions. 
	* However, there are actions you can specify that are atomic:
	*Reads and writes are atomic for reference variables and 
	*for most primitive variables (all types except long and double).
	*Atomic actions cannot be interleaved, so they can be used without fear of thread interference. 
	 */
	
	public synchronized void increment(){ count++;}   ///OUTPUT : Count: 20000  //Doesne't change as first t1 increments till 10000 then t2 add 10000
	
	//public void increment(){ count++;} // IMPORTANT ///OUTPUT : Count: 13110 OR 14023 (KEEPS CHANGING BECAUSE t1 and t2 are overwriting increments of count
	public void doWork(){
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				System.out.println("Count: "+count);
				for (int i = 0; i < 10000; ++i){
					increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				System.out.println("Count: "+count);
				for (int i = 0; i < 10000; ++i){
					//System.out.println("Count: "+count);
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
		}
		catch(InterruptedException e) {}
		System.out.println("Count: "+count);
	}
	public static void main(String[] args) {
		SynchCounter sc = new SynchCounter();
		sc.doWork();

	}

}
