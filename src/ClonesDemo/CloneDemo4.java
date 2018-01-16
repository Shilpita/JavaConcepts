package ClonesDemo;

//Base1 and its Derived1 classes are cloneable .. Here the Non Primitive class has shallow copy
class Something{
	String s;
	public Something(String s){
		this.s = s;
	}
}

class Base1 implements Cloneable{
	protected int a;
	protected int b;
	
	public Base1(int a, int b) { 
		this.a = a;
		this.b = b;
	}	
	public Object clone() throws CloneNotSupportedException {	
		//Base1 result = (Base1) super.clone();   
		//return result;
		return (Base1) super.clone();  
	}
	
	public void print(){
		System.out.println("a = "+a +"  b = "+b );				
	}
	public void change(int a, int b){
		this.a = a;
		this.b = b;	
	}
}


class Derived1 extends Base1 implements Cloneable{
	int x;
	Something sth;
	public Derived1(int a, int b, int x ,String str ){
		super(a,b);
		this.x = x;		
		sth = new Something(str);
	}
	
	public Object clone() throws CloneNotSupportedException{
		return (Derived1)super.clone();
	}
	
	public void change(int a, int b, int c,String s){
		super.change(a,b);
		this.x = c;
		this.sth.s = s;
	} 
	
	public void print(){
		System.out.println("a = "+a +"  b = "+b +" X = "+x +" str="+ sth.s);				
	}		
}


public class CloneDemo4 {
	public static void main(String [] args)throws CloneNotSupportedException{	
	  Derived1 one = new Derived1 (1,2,3,"Hello");	  
	  one.print(); //// a = 1  b = 2 X = 3
	  
	  Derived1 two = (Derived1)one.clone();
	  System.out.println("printing cloned two");
	  two.print(); //// a = 1  b = 2 X = 3
	  Base1 three = (Base1)one.clone();  //// Casting as Parent to clone OK since Child cloneable
	  System.out.println("printing cloned three");
	  three.print(); ///a = 1  b = 2 X = 3
	   
	  one.change(5,7,8,"Bye");
	  System.out.println("After Change");
	  one.print(); ///a = 5  b = 7 X = 8
	  two.print();	////  a = 1  b = 2 X = 3
	  three.print(); //// a = 1  b = 2 X = 3
}	
}

/*
a = 1  b = 2 X = 3 str=Hello
printing cloned two
a = 1  b = 2 X = 3 str=Hello
printing cloned three
a = 1  b = 2 X = 3 str=Hello
After Change
a = 5  b = 7 X = 8 str=Bye
a = 1  b = 2 X = 3 str=Bye
a = 1  b = 2 X = 3 str=Bye
*
*/