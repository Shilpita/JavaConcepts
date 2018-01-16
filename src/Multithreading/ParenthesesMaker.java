package Multithreading;
// No synchronized methods in this class
class Brackets {
	//synchronized void display(String s) { /////IMPORTANT : to synchronize OUTPUT :[Linda]\n[James]\n(London)\n(Paris)
	void display(String s) {
		   System.out.print ("[" + s);
		   
		   try {
		      Thread.sleep (1000);
		   } 
		   catch (InterruptedException e) {
		        System.out.println ("Brackets - Interrupted");
		   }
		   
		   System.out.println("]");
	}			
}

class Parentheses {
   synchronized void display(String s) {
   System.out.print ("(" + s);
   try {
      Thread.sleep (1000);
   } catch (InterruptedException e) {
        System.out.println ("Interrupted");
   }
   System.out.println(")");
  }
}

class MyThread implements Runnable {
   String s1;
   Parentheses p1;
   Thread t;
   public MyThread (Parentheses p2, String s2) {
      p1= p2;
      s1= s2;
      t = new Thread(this);
      t.start();
   }
   public void run() {
     p1.display(s1);
   }
}

class MyThread2 implements Runnable {
	   String s1;
	   Brackets p1;
	   Thread t;
	   public MyThread2 (Brackets p2, String s2) {
	      p1= p2;
	      s1= s2;
	      t = new Thread(this);
	      t.start();
	   }
	   public void run() {		   
	     	p1.display(s1);
		 
	   }
	   
	  /*/// IMPORTANT :Another method to synchronize a block of code
	   public void run() {
		   // synchronized on a block
		 synchronized(p1){
	     	p1.display(s1);
		 }
	   }*/ 
	   
	   
	   /*OUTPUT  
	   [Linda]
	   [James]
	   (London)
	    (Paris)

	    */
	   
	}

public class ParenthesesMaker{
   public static void main (String args[]) {
	  
   //////////////////////////////////////////////////////
   Brackets b1 = new Brackets();
   MyThread2 t3 = new MyThread2(b1, "Linda");
   MyThread2 t4 = new MyThread2(b1, "James");  
   try {
      t3.t.join();
      t4.t.join();
      
 	} catch (InterruptedException e ) {
      System.out.println( "Interrupted");
 	} 
 	
   ////////////////////////////////////////////////////////////
   Parentheses p3 = new Parentheses();
   MyThread t1 = new MyThread(p3, "London");
   MyThread t2 = new MyThread(p3, "Paris");
   try {
      t1.t.join();
      t2.t.join();
	} catch (InterruptedException e ) {
      System.out.println( "Interrupted");
	}
   
  }
}
/*
[James[Linda]
]
(London)
(Paris)



*/


