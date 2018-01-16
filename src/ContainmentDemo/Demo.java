package ContainmentDemo;

public class Demo {
	  public static void main(String [] args) {	  
		  //ProjectWork project1 = new ProjectWork("Edu-Apps");
		 // project1.addExpenses(1500.00);
		  Manager manager1 = new Manager("Smith","A123",100000, new ProjectWork("Edu-Apps"));         //project1);	  
		  System.out.println(manager1.yearlyReport());  
	  }
}
