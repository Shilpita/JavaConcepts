package ClonesDemo;

//Objects of a class are cloneable only if the contained references are cloneable.
//Class Some is NOT Cloneable, therefore, an attempt to clone it results in an exception.

class Some{
	private int x;
	public Some(int x){
		this.x = x;
	}
	
	public String toString() { 
		return " Some.x = "+x;
	}
	
	////DECLARING CLONE() WILL NOT GIVE ERROR BUT THROWS EXCEPTION
	public Object clone() throws CloneNotSupportedException{	
	 	Some result = (Some) super.clone();
	 	return result;
	}
	
	public void change(int i){
		x = i;
	}
	
}


public class CloneDemo3 implements Cloneable{
	private int a;
	private int b;
	private Some someOb;
	
	public CloneDemo3(int a, int b,int x) { 
		this.a = a;
		this.b = b; 
		someOb = new Some(x);
	}	
	
	public Object clone() { //throws CloneNotSupportedException{
		//// do deep copy 
		 	CloneDemo3 result = null;
			try {
				result = (CloneDemo3) super.clone();
				result.someOb = (Some)someOb.clone();  	  //// SOME NOT CLONEABLE SO THROWS EXCEPTION 	
			 	
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("In finally");
			}
			return result;
	}
	
	public void print(){
		System.out.println("a = "+a +"  b = "+b +someOb);				
	}
	
	public void change(int a, int b){
		this.a = a;
		this.b = b;
		this.someOb.change(a+b);
	}

	public static void main(String [] args) throws CloneNotSupportedException{
	
	  CloneDemo3 one = new CloneDemo3 (1,2,3);	  
	one.print(); // a = 1  b = 2 Some.x = 3
  
	CloneDemo3 two = (CloneDemo3)one.clone();
	two.print(); /// EXCEPTION : java.lang.CloneNotSupportedException: ClonesDemo.Some
  
	one.change(5,7);
	one.print();
	System.out.println("clones object");
	two.print();	  
	  
}	
}
/*
java.lang.CloneNotSupportedException: Some
*/