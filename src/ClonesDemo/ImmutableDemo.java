
package ClonesDemo;
//We want to make class Manager1 immutable... But the manager changes... OBJECTIVE NOT ACHIVED
class CurrentProject1 {
	private int projectId;
	private String title;
	private double budget = 0;
	
	public CurrentProject1(int projectId, String title){
		this.projectId = projectId;
		this.title = title;		
	}
	public void setBudget(double budget){
		this.budget = budget;
	}
	
	public String toString(){
		return (projectId + " "+title+ " "+budget);
	}
}


final class Manager1 {
	private final String name;
	private final CurrentProject1 managedProject;
	
	public Manager1(String name, CurrentProject1 project){
		this.name = name;
		this.managedProject = project;
	}
	
	public CurrentProject1 getProject(){
		return managedProject;
	}
	
	public String toString(){
		return (name + " "+managedProject);
	}
	
}


public class ImmutableDemo {

	public static void main(String[] args) {
		CurrentProject1 p1 = new CurrentProject1(100,"Research");
		Manager1 m1 = new Manager1("Smith: ",p1);
		
		System.out.println(m1); //Smith:  100 Research 0.0
		
		p1.setBudget(999);
		
		// Looks like the Manager1 instance m1 has changed
		System.out.println(m1); // Smith:  100 Research 999.0
	}

}


