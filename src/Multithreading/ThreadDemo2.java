package Multithreading;

class DaemonThread_UserThreadTest {
	 public static void Main() throws InterruptedException {
		 Runnable r = new Runnable() {
			 public void run() {
				 for (int time = 10; time > 0; --time) {
					 System.out.println("Time #" + time);
					 try {
						 Thread.sleep(2);
					 } catch (InterruptedException e) {
						 e.printStackTrace();
					 }
				 }
			 }
		 };

	/* Daemon threads are typically used to perform services for user threads.			 
	Threads created by a user thread are user threads. 
	JVM doesn't terminate unless all the user threads terminate.
	*/
	 Thread t = new Thread(r);
	 t.setDaemon(false); // set this to "true" and see what happens  //--> Main thread-waiting... Time #10 Time #9 Time #8 Main thread exited.
	 t.start();
	 System.out.println("Main thread-waiting...");
	 Thread.sleep(5);
	 System.out.println("Main thread exited.");
	 }
}

public class ThreadDemo2 {
public static void main(String[] args) {
	
	try {
		DaemonThread_UserThreadTest.Main();
	}
	catch(InterruptedException ie) {}
			
}
}
/*
Main thread-waiting...
Time #10
Time #9
Main thread exited.
Time #8
Time #7
Time #6
Time #5
Time #4
Time #3
Time #2
Time #1




*/