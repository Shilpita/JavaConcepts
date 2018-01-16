package ClonesDemo;


class CurrentProject implements Cloneable {
	private int projectId;
	private String title;
	private double budget = 0;
	
	public CurrentProject(int projectId, String title){
		this.projectId = projectId;
		this.title = title;		
	}
	public void setBudget(double budget){this.budget = budget;}
	public String toString(){
		return (projectId + " "+title+ " "+budget);
	}
	// Provide a clone()
	public Object clone() throws CloneNotSupportedException {
		// Shallow copy by default
    	CurrentProject result = (CurrentProject) super.clone();
    	return result; 	
	}
}


final class Manager {
	private final String name;
	private final CurrentProject managedProject;
	
	public Manager(String name, CurrentProject project){
		this.name = name;
		CurrentProject temp;
		try{
			temp = (CurrentProject)project.clone();  //// Call clone and make shallow copy in temp
		}
		catch(CloneNotSupportedException e){temp = null;}
		managedProject = temp;
	}
	
	public String toString(){
		return (name + " "+managedProject);
	}
	
	//IMPORTANT IN GETTER METHOD RETURN CLONE OF OBJECT :::::::: Make sure that you return a copy of the object
	// so that it cannot be changed from outside of the method
	
	public CurrentProject getProject(){
		try {
	    	CurrentProject result = (CurrentProject)managedProject.clone();
	    	return result;
	  	} catch (CloneNotSupportedException e) {
	    	return null;  
	    	}
	}
}

public class ImmutableDemo2 {

	public static void main(String[] args) {
		CurrentProject p1 = new CurrentProject(100,"Research");
		
		Manager m1 = new Manager("Jones: ",p1); 
		System.out.println(m1);	//Jones:  100 Research 0.0
		
		p1.setBudget(999);
		System.out.println(m1); //Jones:  100 Research 0.0
		System.out.println(p1);  /// 100 Reserach 999.0
		
		CurrentProject m1Project = m1.getProject();
		m1Project.setBudget(200);
		System.out.println(m1Project);//// 100 Research 200.0
		
		System.out.println(m1);  //Jones:  100 Research 0.0 
	}

}
