package SerializableDemo;

import java.io.*;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;
import java.text.*;

/**
 *This example shows a subclass which is serializable but the superclass
 * is not.
 *
 */

class Student{
	protected String name;
	protected String major;	
	public Student(String name,String major){this.name = name;this.major = major;}
	public Student(){this("Not Set","Not set");}
	public String toString() { return "Name: "+name +" Major: "+major;}
	
}
class GradStudent extends Student implements Serializable
{
	private String startDateAsStr;
	
	public GradStudent(String name, String major)
 	{
 	 super(name,major);
 	 DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
 	 startDateAsStr  = df.format(new Date());
 	}
 	public GradStudent()
 	{
 	 this("0","Not Set");
 	}
	/**
     * Saves its own fields by calling defaultWriteObject and then explicitly
     * saves the fields of its supertype  
     */
    private void writeObject(ObjectOutputStream out)  throws IOException {
        
	// Take care of this class's field first by calling defaultWriteObject
	out.defaultWriteObject();
	
	/*
	 * Superclass does not implement the Serializable interface.
	 * we need to explicitly do the saving. The fields are protected
	 * so we can access them directly. 
	 */
	out.writeObject(super.name);
	out.writeObject(super.major);
    }
 
	/**
     * Restores its own fields by calling defaultReadObject and then explicitly
     * restores the fields of its supertype. 
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    
	    /*
	     * Take care of this class's fields first by calling 
	     * defaultReadObject
	     */
	    in.defaultReadObject();
    
	    /* 
	     * Superclass does not implement the Serializable 
	     * interface, we explicitly do the restoring. 
	     */
	    name = (String) in.readObject();
	    major = (String) in.readObject();
    }	
  	public String toString(){
  		String str = super.toString();
  		str += "	Started on: "+startDateAsStr;
  		return str;
  	}
 }

public class SerializableDemo4{
	
	public static void serialize(GradStudent student, String filename){
		 FileOutputStream fout = null;
  		 ObjectOutputStream out = null;
 		try {
  			fout = new FileOutputStream(filename);
 			out = new ObjectOutputStream(fout);
 			out.writeObject(student);
			out.close();
  		}
 		catch(IOException ex){ ex.printStackTrace();}		
	}
	
	public static GradStudent deSerialize(String filename){
		 GradStudent student = null;
		 FileInputStream fis = null;
  		 ObjectInputStream fin = null;
 		try {
  			fis = new FileInputStream(filename);
 			fin = new ObjectInputStream(fis);
 			student = (GradStudent)fin.readObject(); 			
			fin.close();
  		}
 		catch(IOException ex){ ex.printStackTrace();}
 		catch(ClassNotFoundException e) {e.printStackTrace();}
 		return student;		
	}
	
	public static void main(String [] args)
	{
		// Create a GradStudent instance
		
		GradStudent studentOrig = new GradStudent("Gabe Smith","CompSci");
		
		System.out.print("Before Serializing - ");
		
		System.out.println(studentOrig);	
			
		serialize(studentOrig,"studentFile.ser");
		
		GradStudent studentCopy = deSerialize("studentFile.Ser");
		
		System.out.print("After DeSerializing - ");
		System.out.println(studentCopy);
		
	}
	
}
///////////////////////////////////////////////////////////////////////////  
 /*
  * Before Serializing - Name: Gabe Smith Major: CompSci	Started on: 2016/12/06
After DeSerializing - Name: Gabe Smith Major: CompSci	Started on: 2016/12/06
*/   
