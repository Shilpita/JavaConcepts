package Enum;

public enum Tour {
	NEWYORK (4), CHICAGO(2),MIAMI (2),HOUSTON (1);
	private int days;
	private final int costPerDay = 500;
	
	private Tour(int days){
		this.days = days;
	}
	public int cost(){ return costPerDay * days;}
}

