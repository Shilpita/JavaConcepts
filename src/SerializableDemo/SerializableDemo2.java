package SerializableDemo;
import java.io.*;
import java.util.Date;
import java.util.Calendar;

/**
 *In this example, you will see a superclass that supports serialization.
 *But the subclass should not support serialization.
 *Subclass must provide two private methods, readObject() and writeObject() 
 *which should throw an exception.
 */

class Customers {
	private String custId;
	
	public Customers(String custId){this.custId = custId;}
	public Customers(){this("Not Set");}
	public String getCustId() { return custId;}
	
}
class Transactions implements Serializable
{
	private Date time;
	private String transactionId;
	
	// Not to be serialized
	// Mark all non-serializable fields as transient
	
	transient private Customers customer = new Customers();
	
	public Transactions(String id)
 	{
 	 time = Calendar.getInstance().getTime();
 	 transactionId = id;
 	}
	
 	public Transactions()
 	{
 	 this("0");
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

class CustomTransaction extends Transactions {
	// this class does not want to support serialization
	// Provide two PRIVATE methods, writeObject() and readObject()
	// Throw NotSerializableException
	
	private void writeObject(ObjectOutputStream out) throws IOException {
 		throw new NotSerializableException("Cannot serialize this one!");
 	}
 	private void readObject(ObjectInputStream in) throws IOException{
		throw new NotSerializableException("No serialization supported!");
	}
}

public class SerializableDemo2{
	
	public static void serialize(Transactions transactionOb, String filename){
		 FileOutputStream fout = null;
  		 ObjectOutputStream out = null;
 		try {
  			fout = new FileOutputStream(filename);
 			out = new ObjectOutputStream(fout);
 			out.writeObject(transactionOb);
			out.close();
  		}
 		catch(IOException ex){ ex.printStackTrace();}		
	}
	
	public static Transactions deSerialize(String filename){
		 Transactions transOb = null;
		 FileInputStream fis = null;
  		 ObjectInputStream fin = null;
 		try {
  			fis = new FileInputStream(filename);
 			fin = new ObjectInputStream(fis);
 			transOb = (Transactions)fin.readObject();
 			
			fin.close();
  		}
 		catch(IOException ex){ ex.printStackTrace();}
 		catch(ClassNotFoundException e) {e.printStackTrace();}
 		return transOb;		
	}
	
	public static void main(String [] args)
	{
		// Create a Transaction object
		
		
		CustomTransaction ctr1= new CustomTransaction();
	
		
		serialize(ctr1,"transFile2.ser");
		/* BELOW CODE TO FIX THE EXCEPTION BY CALLING SUPERCLASS */
//		serialize (new Transactions("T1d"),"transFile2.ser");
//		Transactions newT = deSerialize("transFile2.ser");
//		System.out.println(newT);
		
	}
	
}

///////////////////////////////////////////////////////////////////////////  
    
