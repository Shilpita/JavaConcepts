package Multithreading;


import java.util.concurrent.ArrayBlockingQueue; 
import java.util.concurrent.BlockingQueue; 


class Message {
    private String msg;   
    public Message(String str){
        this.msg=str;
    }
    public String getMsg() {
        return msg;
    }
}

class Producer implements Runnable {
    private BlockingQueue<Message> queue;   ////IMPORTANT 
    
    public Producer(BlockingQueue<Message> q){
        this.queue=q;
    }
    @Override
    public void run() {
        //produce messages
        for(int i=0; i<100; i++){
            Message msg = new Message(""+i);
            try {
                Thread.sleep(i);
                queue.put(msg);   ////IMPORTANT ...put on queue
                System.out.println("Produced: "+msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit message
        Message msg = new Message("exiting");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Consumer implements Runnable{

private BlockingQueue<Message> queue;  ////IMPORTANT 
    
    public Consumer(BlockingQueue<Message> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            Message msg;
            //consuming messages until exit message is received
            while((msg = queue.take()).getMsg() !="exiting"){   ////IMPORTANT  ...taking out of queue
            Thread.sleep(10);
            System.out.println("Consumed "+msg.getMsg()); 
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class BlockingQDemo2 {

	public static void main(String[] args) {
		 BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
	        Producer producer = new Producer(queue);
	        Consumer consumer = new Consumer(queue);
	        //starting producer to produce messages in queue
	        new Thread(producer).start();
	        //starting consumer to consume messages from queue
	        new Thread(consumer).start();
	        System.out.println("Producer and Consumer have been started");

	}

}
