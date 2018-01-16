package SerializableDemo;

import java.io.*;
import java.util.Date;
import java.util.Calendar;

/**
 *In this example, you will see the basics of implementing serialization.
 *Marking the objects as transient, when they cannot be or should not be serialized.
 *
 */
 
class Customer {    ////////implements Serializable{   ///TO MAKE CUSTOMER SERIALIZABLE 
	private String custId;
	
	public Customer(String custId){
		this.custId = custId;
	}
	public Customer(){
		this("Not Set");
	}
	
	public String getCustId() { return custId;}
	
}
class Transaction implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date time;
	private String transactionId;
	
	// Not to be serialized
	// Mark all non-serializable fields as transient
	
	transient private Customer customer = new Customer("Customer1"); /////IMPORTANT MARKED TRANSIENT TO NOT SERIALIZE
	
	/*<- IMPORTANT FOR THIS TO WORK CLASS CUSTOMER HAS TO IMPLEMENT SERIALIZABLE ELSE THROWS java.io.NotSerializableException EXCEPTION */
	///private Customer customer = new Customer("Cust1");   
	public Transaction(String id)
 	{
 	 time = Calendar.getInstance().getTime();
 	 transactionId = id;
 	}
	
 	public Transaction()
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

public class SerializableDemo1{
	
	public static void serialize(Transaction transactionOb, String filename){ //// IMPORTANT MAKED STATIC FOR USE IN MAIN
		 FileOutputStream fout = null;   ////OUTPUT STREAM TO WRITE OUT TO FILE
  		 ObjectOutputStream out = null;
 		try {
  			fout = new FileOutputStream(filename);
 			out = new ObjectOutputStream(fout);
 			out.writeObject(transactionOb);
			out.close();
  		}
 		catch(IOException ex){ ex.printStackTrace();}		
	}
	
	public static Transaction deSerialize(String filename){
		 Transaction transOb = null;
		 FileInputStream fis = null;   ////INPUT STREAM TO READ FROM FILE
  		 ObjectInputStream fin = null;
 		try {
  			fis = new FileInputStream(filename);
 			fin = new ObjectInputStream(fis);
 			transOb = (Transaction)fin.readObject(); 			
			fin.close();
  		}
 		catch(IOException ex){ ex.printStackTrace();}
 		catch(ClassNotFoundException e) {e.printStackTrace();}
 		return transOb;		
	}
	
	public static void main(String [] args)
	{
		// Create a Transaction object
				
		Transaction trs1 = new Transaction("T1");
		
		System.out.print("Before Serializing - ");
		System.out.println(trs1);
		
		serialize(trs1,"transFile.ser");  ////CALL SERIALIZE METHOD
		
		Transaction trs1Ret = deSerialize("transFile.Ser");   ////CALL DESERIALIZE METHOD
		
		System.out.print("After DeSerializing - "); 
		System.out.println(trs1Ret);
		
	}
}
///////////////////////OUTPUT////////////////////////////////////////////////////  
 /*
Before Serializing - Transaction Id: T1	Created at Time: Mon Dec 05 23:40:51 PST 2016	Customer Name: Customer1
After DeSerializing - Transaction Id: T1	Created at Time: Mon Dec 05 23:40:51 PST 2016
*/   
