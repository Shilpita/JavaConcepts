
package ClonesDemo;
/**
 * Both Some and MyClass are cloneable and DOING DEEP COPY
 * @author saptarshi
 *
 */

class Some2 implements Cloneable{  //// cantianed Class Some2 made cloneable 
		private int x;
		
		public Some2(int x){
			this.x = x;
		}
		
		public String toString() { 
			return " Some2.x = "+x;
		}
		
		public void change(int i){
			 x = i;
		}
		
		public Object clone() {
	  	try {
	    	Some2 result = (Some2) super.clone();
	    	return result;
	  	} catch (CloneNotSupportedException e) {
	    	return null;  
	    	}
		}
}


class MyClass1 implements Cloneable{
	private int a;
	private int b;
	private Some2 Some2Ob;
	
	public MyClass1(int a, int b,int x) {
		this.a = a;
		this.b = b; 
		Some2Ob = new Some2(x);
	}	
	
	public Object clone() {
		///// do deep copy
  	try {
    	MyClass1 result = (MyClass1) super.clone();
    	result.Some2Ob = (Some2)Some2Ob.clone(); ///IMPORTANT: Some2 clone method called for deep copy without calling this Some2.x will be = 12
    	
    	return result;
  	} catch (CloneNotSupportedException e) {
    	return null;  
    	}
	}
	
	public void print(){
		System.out.println("a = "+a +"  b = "+b +Some2Ob);				
	}
	
	public void change(int a, int b){
		this.a = a;
		this.b = b;
		this.Some2Ob.change(a+b);
	}
}
////////////////////////////////////////////////////////// 
public class CloneDemo2 {
	
	public static void main(String [] args){
	  MyClass1 one = new MyClass1 (1,2,3);	  
	  one.print();	// a = 1  b = 2 Some2.x = 3
	  
	  MyClass1 two = (MyClass1)one.clone();
	  two.print();	// a = 1  b = 2 Some2.x = 3
	  
	  one.change(5,7);
	  one.print();	// a = 5  b = 7 Some2.x = 12
	  two.print();	// a = 1  b = 2 Some2.x = 3
	  
}	
}
