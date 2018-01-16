package ClonesDemo;

//Base is not cloneable, but provides a clone method to allow subclasses
//copy the base part correctly
class Base {
	protected int a;
	protected int b;
	protected String s;
	public Base(int a, int b , String t) { 
		this.a = a;
		this.b = b;
		this.s = t;
	}	
	
	public void print(){
		System.out.println("a = "+a +"  b = "+b + " s ="+ s);				
	}
	
	/**IF THIS METHOD IS COMMENTED THERE IS NO EFFECT ON THE OUTPUT FOR THIS PARTICULAR DEMO ***/
	public Object clone() throws CloneNotSupportedException {	////// IMPORTANT :a clone method to allow subclasses copy the base part correctly
	 	Base result = (Base) super.clone(); 
	 	return result;
	}
	
	public void change(int a, int b, String t){
		this.a = a;
		this.b = b;	
		this.s = t;
	}
}

class Derived extends Base implements Cloneable{
	int x;
	public Derived(int a, int b,String t, int x){
		super(a,b,t);
		this.x = x;		
	}
	
	public Object clone() throws CloneNotSupportedException {	
	 	Base result = (Base) super.clone();   
	 	return result;
	}
	public void change(int a, int b,String t, int c){
		super.change(a,b,t);
		this.x = c;		
	} 
	public void print(){
		System.out.println("a = "+a +"  b = "+b +" s="+ s +" X = "+x );				
	}		
}


public class CloneDemo5 {

	public static void main(String [] args)throws CloneNotSupportedException{
	
	  Derived one = new Derived (1,2,"Hello",3);	  
	  one.print();  ////a = 1  b = 2 s=Hello X = 3
	  
	  Derived two = (Derived)one.clone();
	  two.print();  ///a = 1  b = 2 s=Hello X = 3
	  
	  one.change(5,7,"World",8);
	  one.print(); //a = 5  b = 7 s=World X = 8
	  two.print();	//a = 1  b = 2 s=Hello X = 3
	  
}	
}

/*
*a = 1  b = 2X = 3
a = 1  b = 2X = 3
a = 5  b = 7X = 8
a = 1  b = 2X = 3

*
*/