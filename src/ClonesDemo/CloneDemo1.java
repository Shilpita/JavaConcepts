
package ClonesDemo;
/*****
 * The member Class Some is not cloneable and both the objects of MyClass point to the same object instance of Some
 * Therefore the value of data members of object Some changes for both objects of MyClass. This is Shallow Copy
 * @author saptarshi
 *
 */
class Some1{
	private int x;
	
	public Some1(int x){
		this.x = x;
	}
	public String toString() { 
		return " Some.x = "+x;
	}
	public void change(int i){
		x = i;
	}
	
}


class MyClass implements Cloneable{  ////IMPORTANT INTERFACE 
	private int a;
	private int b;
	private Some1 someOb; //<--- object of some
	
	public MyClass(int a, int b,int x) {
		this.a = a;
		this.b = b; 
		someOb = new Some1(x);
	}	
	
	// IMPORTANT make the clone() public 
	public Object clone() throws CloneNotSupportedException {
		// Shallow copy by default
    	MyClass result = (MyClass) super.clone();
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
}
////////////////////////////////////////////////////////// 
public class CloneDemo1 {
	
	public static void main(String [] args)throws CloneNotSupportedException{

	  MyClass one = new MyClass (1,2,3);	  
	  one.print();	// 	a = 1  b = 2 Some.x = 3
	  
	  MyClass two = (MyClass)one.clone();
	  two.print();	// a = 1  b = 2 Some.x = 3
	  
	  one.change(5,7);
	  
	  one.print();	// a = 5  b = 7 Some.x = 12
	  two.print();  // a = 1  b = 2 Some.x = 12  /// both one and two point at same object instance of Some someOB
	  two.change(30, 20); //The Some object changed by clone object due to shallow copy
	  one.print(); //a = 5  b = 7 Some.x = 50
	  two.print(); //a = 30  b = 20 Some.x = 50

	  
}
	
}

