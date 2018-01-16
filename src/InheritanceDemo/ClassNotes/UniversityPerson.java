package InheritanceDemo.ClassNotes;


/**
 * @(#)InheritanceDemo1.java
 */

public class UniversityPerson{
   protected String name;
   private String ssn;

   public UniversityPerson(String name,String ssn){
      this.name = name;
      this.ssn = ssn;
   }
   public UniversityPerson(){
   // Calling the constructor with two arguments
      this ("Not set","Not set");
   }
   public void print() { 
	   System.out.println("Name: "+name);
       System.out.println("SSN: "+ssn); }
}

