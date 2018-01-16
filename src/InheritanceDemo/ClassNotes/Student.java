package InheritanceDemo.ClassNotes;

class Student extends UniversityPerson  {
	private String major;

	public Student(String name,String ssn,String major){
		super (name,ssn);
		this.major = major;
	}
	public Student(){
		this("Not set","Not set","Not set");
	}
	
	
// Overrides and extends the method print () in the base class
@Override
public void print() {

		/*The following statement will not compile because, a private variable of
		the base class cannot be accessed in the derived class
		
		System.out.println("SSN: "+ssn); 
		
		}
		Call the print () of base class to print the base class members */

		super.print();
	    ////print();  <----- Complies but leads to infinite loop.
		System.out.println("Major: "+major);
	}
}

