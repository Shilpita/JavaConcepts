package SerializableDemo;

import java.io.*;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;

/**
 * This example demonstrates the details of serializing an ArrayList of objects.
 *
 */
class Customer1 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String custId;
	
	public Customer1(String custId){this.custId = custId;}
	public Customer1(){this("Not Set");}
	public String getCustId() { return custId;}
	
}
class Transaction1 implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date time;
	private String transactionId;
	
	private Customer1 customer;
	
	public Transaction1(String id, String custId)
 	{
 	 time = Calendar.getInstance().getTime();
 	 transactionId = id;
 	 customer = new Customer1(custId);
 	}
	
 	public Transaction1()
 	{
 	 this("0","Not Set");
 	}
 	
 	public Date getTransactionTime(){
  		return time;
  	}
  	public String toString(){
  		String str = "Transaction Id: "+ transactionId;
  		str += "	Created at Time: "+time;
  		if (customer != null)
  			str += "	Customer Name: "+customer.getCustId();
  		return str;
  	}
 }

public class SerializableDemo3{
	
	public static void serialize(ArrayList<Transaction1> list1, String filename){
		 FileOutputStream fout = null;
  		 ObjectOutputStream out = null;
 		try {
  			fout = new FileOutputStream(filename);
 			out = new ObjectOutputStream(fout);
 			out.writeObject(list1);
			out.close();
  		}
 		catch(IOException ex){ ex.printStackTrace();}		
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Transaction1> deSerialize(String filename){
		 ArrayList<Transaction1> list = null;
		 FileInputStream fis = null;
  		 ObjectInputStream fin = null;
 		try {
  			fis = new FileInputStream(filename);
 			fin = new ObjectInputStream(fis);
 			list = (ArrayList)fin.readObject(); 			
			fin.close();
  		}
 		catch(IOException ex){ ex.printStackTrace();}
 		catch(ClassNotFoundException e) {e.printStackTrace();}
 		return list;		
	}
	
	public static void main(String [] args)
	{
		// Create a list of Transactions 
		
		ArrayList<Transaction1> list1 = new ArrayList<Transaction1>();
		
		list1.add( new Transaction1("T1","Cust1"));
		list1.add( new Transaction1("T2","Cust2"));
		list1.add( new Transaction1("T3","Cust3"));
		
	
		System.out.print("Before Serializing - ");
		for (Transaction1 t : list1){
			System.out.println(t);	
		}		
		serialize(list1,"transFile3.ser");
		
		ArrayList<Transaction1> list2 = deSerialize("transFile3.Ser");
		
		System.out.print("After DeSerializing - ");
		for (Transaction1 t : list2){
			System.out.println(t);	
		}

	}
	
}
///////////////////////////////////////////////////////////////////////////  
    
