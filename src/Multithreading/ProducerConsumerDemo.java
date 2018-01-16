package Multithreading;
//Java Threads: Synchronizing Two threads
// Using monitors to implement mutual exclusion with synchronized methods
/////////////////////////////////////////////////////////////////////
class Funds
// This is the shared resource.
// Each object and class has a monitor. Threads take temporary control
// of monitor and all the other threads are blocked from entry until the
// control is released from the first thread.
{
    private int value;
    boolean empty = true;
     
    public void put (int newValue){      
        value = newValue;
        empty = false;
    }
    public int get (){
        
        empty = true;
        return value;
    }
}

class Producers extends Thread {
  private Funds funds;
  public Producers(Funds funds){
    this.funds = funds;
  }
 
  public void run() {
      System.out.println ("Starting: Producer");
      for (int i = 1; i <= 10; ++i){
    	  try
          {
             produce(i);
          } catch (InterruptedException ex)
          {
             ex.printStackTrace();
          }         
      }
      System.out.println ("Producer is finished");       
}
  private void produce(int element) throws InterruptedException{
	// A method takes control of an object's monitor by entering a block of
	    // code or a method with the synchronized keyword.
	    // A synchronized keyword ensures that only one thread at a time will
	    // execute the class or object's code.
	    // An instance or class method can be synchronized.
	    // A block of code within a method can be synchronized
	    // For any given object, only one synchronized method can be executing 
	    // at any time.
	  synchronized(funds){  ////IMPORTANT
       	 while (!funds.empty){      	        
       	     funds.wait(); // ////IMPORTANT   waiting for the previous value 
       	                   // in funds to be consumed      	       
       	 }      
       	 System.out.println ("Produced: " +element);
       	 funds.put(element);
       	 funds.empty = false;
       	        
       	// notify() restarts the thread that has called the wait().
       	 funds.notify(); ////IMPORTANT
       }
  }
}
////////////////////////////////////////////////////
class Consumers extends Thread {
  private Funds funds;
  public Consumers(Funds funds){
    this.funds = funds;
  }
 
  public void run() {
      System.out.println ("Starting: Consumer");
      for (int i = 1; i <= 10; ++i){
    	  try
          {
             consume();
          } catch (InterruptedException ex)
          {
             ex.printStackTrace();
          }         
      }
      System.out.println ("Consumer is finished");       
 }
  
  
  private void consume() throws InterruptedException{
	  synchronized(funds){  ////IMPORTANT
       	 while (funds.empty){      	        
       	     funds.wait(); // ////IMPORTANT :waiting for the next value 
       	                   // in funds to be produced      	       
       	 }      
       	 int element = funds.get();
    	 System.out.println ("Consumed: " +element);
       	 funds.empty = true;
       	        
       	// notify() restarts the thread that has called the wait().
       	 funds.notify(); ////IMPORTANT
       }
  }
}

public class ProducerConsumerDemo {
	public static void main(String[] args) {
		Funds funds =   new Funds();
	    // funds object is shared by the producers and consumers
	    // Synchronization is essential to coordinate the producer
	    // and consumer sharing funds.     
	    Producers p = new Producers(funds);
	    Consumers c = new Consumers(funds);
	    p.start();
	    c.start();

	}
}
