package CustomedException;

public class CustomExceptionsDemo{
    
	public static void main (String [] args){
	    FishTank tank = new FishTank();
	    		   
	    try {
	        tank.increaseTemp(-70);
	    }
	    // catch- block encloses the code that will handle
	    // the exception
	    catch (WaterTooHotException e){
	        System.out.println (e);
	    }
	   catch (Exception e)// 
        {
	        System.out.println (e);
	        e.printStackTrace();
	    }
	    // A finally block is always executed even when the program
	    // throws an exception and terminates

	    finally {
	        System.out.println ("Current WaterTemperature in FishTank = "+tank.getTemp());
	    }


	}
}