package ExceptionDemo2;

public class ExceptionDemo2 {
   public static void transactions() throws Exception{
		
		BankAccount myAcct = new BankAccount("A1234");	
		
	    try{ 	 		
	    	myAcct.withdraw(500);
	    }
	    catch (BalanceTooLowException e) {
	    	System.out.println(e);	    		
	    }
	    finally{
	 
	    	System.out.println(myAcct.getBalance());	    		
	    }
	    myAcct.deposit(-1000.00);	    		
	}	

    public static void main(String [] args){ 
    
    	try{
    		transactions();    		
    	}
    	catch(Exception e){ System.out.println(e);}
    
    }    	
}
