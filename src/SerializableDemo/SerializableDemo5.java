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

class Customers1 {
	private String custId;
	
	public Customers1(String custId){this.custId = custId;}
	public Customers1(){this("Not Set");}
	public String getCustId() { return custId;}
	
}
class Transactions1 implements Serializable
{
	private Date time;
	private String transactionId;
	
	// Not to be serialized
	// Mark all non-serializable fields as transient
	
	transient private Customers1 customer = new Customers1();
	
	public Transactions1(String id)
 	{
 	 time = Calendar.getInstance().getTime();
 	 transactionId = id;
 	}
	
 	public Transactions1()
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

class CustomTransaction1 extends Transactions1 {
	
	private void writeObject(ObjectOutputStream out) throws IOException {
 		throw new NotSerializableException("Cannot serialize this one!");
 	}
 	private void readObject(ObjectInputStream in) throws IOException{
		throw new NotSerializableException("No serialization supported!");
	}
}

public class SerializableDemo5{
	
	public static void serialize(Transactions1 transactionOb, String filename){
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
	
	public static Transactions1 deSerialize(String filename){
		 Transactions1 transOb = null;
		 FileInputStream fis = null;
  		 ObjectInputStream fin = null;
 		try {
  			fis = new FileInputStream(filename);
 			fin = new ObjectInputStream(fis);
 			transOb = (Transactions1)fin.readObject();
 			
			fin.close();
  		}
 		catch(IOException ex){ ex.printStackTrace();}
 		catch(ClassNotFoundException e) {e.printStackTrace();}
 		return transOb;		
	}
	
	public static void main(String [] args)
	{
		// Create a Transaction object
		CustomTransaction1 ctr= new  CustomTransaction1(); ///// java.io.NotSerializableException
		
		Transactions1 ctr1= new  CustomTransaction1();  /// java.io.NotSerializableException
		Serializable ctr2 = new  CustomTransaction1();/// java.io.NotSerializableException
		serialize(ctr,"transFile2.ser");
		serialize(ctr1,"transFile2.ser");
		serialize((Transactions1) ctr2,"transFile2.ser");
		/* BELOW CODE TO FIX THE EXCEPTION BY CALLING SUPERCLASS */
//		serialize (new Transactions1("T1d"),"transFile2.ser");
//		Transactions1 newT = deSerialize("transFile2.ser");
//		System.out.println(newT);
		
	}
	
}

///////////////////////////////////////////////////////////////////////////  
    
