package ContainmentDemo;

class ProjectWork {
	private String title;
	private String fundId;
	private double expenses;
	
	public ProjectWork(String title){
		this.title = title;
	}
	public void addExpenses(double expenses){
	
		this.expenses += expenses;
	}
	public void setFundId(String fundId){			
		this.fundId = fundId;
	}
	public String getTitle(){
		return title;
	}
	public String getFundId(){
		return fundId;
	}
	public double getExpenses(){
		return expenses;
	}

}
