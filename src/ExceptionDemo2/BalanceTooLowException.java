package ExceptionDemo2;

public class BalanceTooLowException extends Exception {
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private double howLow;
	public BalanceTooLowException(double amount, String message){ super(message);howLow = amount;}
	
	public String toString(){ return "Balance Too Low: " +howLow;}
	
}
