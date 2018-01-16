package CustomedException;

//Multiple catch blocks are allowed when a try block can give rise to more
//than one type of exception.
//When more than one catch block is used, the catch blcoks should be ordered
//with lowest subclass (the most specific exception) first and progressing to the
//highest (most generic) superclass.

class FishTank {
	
	double waterTemp = 70.00;
		
	public void increaseTemp(double temp)throws WaterTooHotException, Exception
	{
		if (temp <= 0){		
			throw new Exception (" temperature is not being increased");
		}
		else if (temp+waterTemp > 80.00){
	
			throw new WaterTooHotException(temp+waterTemp);
		}
		waterTemp += temp;
	}
	public double getTemp(){
		return waterTemp;
	}
	
}
