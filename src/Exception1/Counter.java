package Exception1;

public class Counter{
	private int count = 0;
	public Counter(int count) { this.count = count;};
	// The method increment () declares that it throws an exception
	public void increment(int amount)throws Exception {
              if ( amount < 0){
            	  throw new Exception("Negative amount not accepted");
              }
              // If no exception is thrown
              count += amount;
	}
	public void decrement(int amount){		
        count -= Math.abs(amount);
	}
	public int getCount(){ return count;}	
} 