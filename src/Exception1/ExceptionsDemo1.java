package Exception1;

public class ExceptionsDemo1 {
	// Methods test1() and test2() do not declare any exceptions with a throws clause
	// since they are handling them in the methods.
	// test() declares an Exception with a throws() clause, since it does not have any 
	// exception handling code in the method
	
	public static void test1(int value) {
	    Counter oneCounter = new Counter(10);
	    // try block encloses the code that might potentially
	    // throw an exception
	    try {
	        oneCounter.increment (value);
	        System.out.println ("\ntest1:After incrementing, counter = "+oneCounter.getCount());   
	    }
	    // catch- block encloses the code that will handle
	    // the exception
	    catch (Exception e){
              System.out.println (e);//"test1:Catch Block: counter = "+oneCounter.getCount());             
	    }
	    // A finally block is always executed after the code in the try block, 
	    // even when the program throws an exception and terminates.
	    finally {
	        System.out.println ("\ntest1:Finally Block: Count = "+oneCounter.getCount());
	    }
	    
	    System.out.println ("\ntest1:After Finally Block: Done ------");
	}
	
	
	public static int test2(int value) {
	    Counter oneCounter = new Counter(10);	   
	    try {
	        oneCounter.increment (value);
	        System.out.println ("test2:After incrementing, counter = "+oneCounter.getCount());
	        return oneCounter.getCount();	        
	    }	    
	    catch (Exception e){
              System.out.println ("test2:Catch Block: counter = "+oneCounter.getCount());
	    }	    
	    finally {
	        System.out.println ("test2:In Finally Block: Count = "+oneCounter.getCount());
	        return 0;
	    }
	}
	
	public static void test3(int value) throws Exception 
	{
	    Counter oneCounter = new Counter(10);	   
	    oneCounter.increment (value);
	    System.out.println ("test3:After incrementing, counter = "+oneCounter.getCount());	    
	}
	
	public static void main(String[] args) throws Exception{
			
			test1(2);
			test1(-1);
			
			System.out.println("From test2: "+test2(2));
			System.out.println("From test2: "+test2(-1));	
			
			try {
				test3(4);				
			}			
			finally{
				System.out.println ("test3:In Finally Block");
			}
	}
}
/*
test1:After incrementing, counter = 12
test1:Finally Block: Count = 12
test1:After Finally Block: Done ------
test1:Catch Block: counter = 10
test1:Finally Block: Count = 10
test1:After Finally Block: Done ------
test2:After incrementing, counter = 12
test2:In Finally Block: Count = 12
From test2: 0
test2:Catch Block: counter = 10
test2:In Finally Block: Count = 10
From test2: 0
test3:After incrementing, counter = 20
test3:In Finally Block

*/