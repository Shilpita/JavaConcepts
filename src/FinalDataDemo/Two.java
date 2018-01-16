package FinalDataDemo;

class Two {
	private final One ob1; // once created, cannot be assigned
	
	public Two() {
			ob1 = new One(); 
		}
	
	public void change(String s){
		ob1.add(s);	// Can change the object that ob1 is referencing
	}
	
	public String toString() { 
			return ob1.toString();
	}
}
