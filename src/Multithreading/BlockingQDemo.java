
package Multithreading;

import java.util.concurrent.ArrayBlockingQueue; 
import java.util.concurrent.BlockingQueue; 
import java.util.Random; 

class Producer1 implements Runnable { 
 private BlockingQueue<Integer> bq = null;   /////IMPORTANT 
 
    public Producer1(BlockingQueue<Integer> queue) { 

        this.bq = queue; 
    }
    public void run() { 

        Random rand = new Random(); 
        int res = 0; 
        try { 
//            res = rand.nextInt(100); 
//
//            System.out.println("Produced: " + res); 
//
//            bq.put(res); 
//
//            Thread.sleep(1000); 
//            res = rand.nextInt(100); 
//            System.out.println("Produced: " + res); 
//            bq.put(res); 
//            Thread.sleep(1000); 
        	for(int i = 0 ; i<5 ;i++){
        		res = rand.nextInt(100); 
        		 System.out.println("Produced: " + res); 
        		 bq.put(res);
        		 System.out.println("Producer Thread sleeping");
        		 Thread.sleep(1000);
        		 System.out.println("Producer Thread woke up");
        	}
            
        } catch (InterruptedException e) { 

            e.printStackTrace(); 

        } 
    } 

} 

class Consumer1 implements Runnable { 
    protected BlockingQueue<Integer> queue = null; 
    public Consumer1(BlockingQueue<Integer> queue) { 
        this.queue = queue;  
    } 
    public void run() { 
        try { 
//            System.out.println("Consumed: " + queue.take()); 
//            System.out.println("Consumed: " + queue.take()); 
        	while(queue.isEmpty()){
        		//res = rand.nextInt(100); 
        		System.out.println("Consumed: " + queue.take());
        	}
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
    } 
} 
public class BlockingQDemo {
	public static void main(String[] args) {
		 BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(10); 

	        Producer1 Producer1 = new Producer1(bq); 
	        Consumer1 Consumer1 = new Consumer1(bq); 

	        new Thread(Producer1).start(); 
	        new Thread(Consumer1).start(); 
	        try{
	        	//System.out.println("trying to sleep in main thread");
	        	Thread.sleep(400);
	        }
	        catch (InterruptedException e){}

	}

}

/***
 * Produced: 45
Consumed: 45
Produced: 88
Consumed: 88
 */
