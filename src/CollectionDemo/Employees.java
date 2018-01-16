package CollectionDemo;


/**
   A minimalist employee class for testing purposes.
*/
public class Employees{ 
	
	private String name;
	private double salary;
	
   /**
      Constructs an employee with $0 salary.
      @param n the employee name
   */
	
	
   public Employees(String n)
   {  
      name = n;
      salary = 0;
   }

   public String toString()
   {  
      return "[name=" + name + ", salary=" + salary + "]";
   }


}
