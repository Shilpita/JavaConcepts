package Multithreading;

import java.util.Date;
class RunnableJob implements Runnable {

	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println("RunnableJob is being run by " + thread.getName() + " at " + new Date());
		try {
			System.out.println("thread started");
			Thread.sleep(1000);
			System.out.println("thread sleep");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
public class ThreadJoinDemo {

	public static void main(String[] args) throws InterruptedException {

		RunnableJob runnableJob = new RunnableJob();

		Thread thread1 = new Thread(runnableJob, "T1");
		Thread thread2 = new Thread(runnableJob, "T2");
		Thread thread3 = new Thread(runnableJob, "T3");
		Thread thread4 = new Thread(runnableJob, "T4");

		thread1.start();
		thread1.join();
		thread2.start();
		thread2.join();
		thread3.start();
		thread3.join();
		thread4.start();
		thread4.join();

		Thread thread5 = new Thread(runnableJob, "T5");
		Thread thread6 = new Thread(runnableJob, "T6");
		Thread thread7 = new Thread(runnableJob, "T7");
		Thread thread8 = new Thread(runnableJob, "T8");

		thread5.start();
		//thread5.join();
		thread6.start();
		thread7.start();
		thread8.start();

	}

}
/*
RunnableJob is being run by T1 at Mon Nov 21 20:15:24 PST 2016
RunnableJob is being run by T2 at Mon Nov 21 20:15:25 PST 2016
RunnableJob is being run by T3 at Mon Nov 21 20:15:26 PST 2016
RunnableJob is being run by T4 at Mon Nov 21 20:15:27 PST 2016
RunnableJob is being run by T5 at Mon Nov 21 20:15:28 PST 2016
RunnableJob is being run by T8 at Mon Nov 21 20:15:28 PST 2016
RunnableJob is being run by T6 at Mon Nov 21 20:15:28 PST 2016
RunnableJob is being run by T7 at Mon Nov 21 20:15:28 PST 2016

New output 


RunnableJob is being run by T1 at Tue Dec 06 13:16:31 PST 2016
thread started
thread sleep
RunnableJob is being run by T2 at Tue Dec 06 13:16:32 PST 2016
thread started
thread sleep
RunnableJob is being run by T3 at Tue Dec 06 13:16:33 PST 2016
thread started
thread sleep
RunnableJob is being run by T4 at Tue Dec 06 13:16:34 PST 2016
thread started
thread sleep
RunnableJob is being run by T5 at Tue Dec 06 13:16:35 PST 2016
thread started
RunnableJob is being run by T6 at Tue Dec 06 13:16:35 PST 2016
thread started
RunnableJob is being run by T7 at Tue Dec 06 13:16:35 PST 2016
thread started
RunnableJob is being run by T8 at Tue Dec 06 13:16:35 PST 2016
thread started
thread sleep
thread sleep
thread sleep
thread sleep





*/