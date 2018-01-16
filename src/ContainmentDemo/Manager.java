package ContainmentDemo;

class Manager {
	private String name;	
	// Containing references to instances of currentProject and Funds
	private ProjectWork currentProject;	
	private Funds budget;
	
	public Manager(){}
	
	public Manager(String name, String fundId, double allocation, 
			ProjectWork currentProject){
		this.name = name;
		// Creating the instance budget.
		budget = new Funds(fundId,allocation);		
		// Initializing the currentProject with the parameter
		this.currentProject = currentProject;
		currentProject.setFundId(fundId);
	}
	public double getExpenses(){
		return currentProject.getExpenses();
	}
	public String yearlyReport(){		
		String report = new String("Yearly Report: \n");
		report += "Manager: "+name;
		report += "\nBudget: "+budget;
		report += "\nCurrent Project: ";
		report += currentProject.getTitle();
		report += "\nExpenses: ";
		report += getExpenses();
		
		return report;
	}
}
