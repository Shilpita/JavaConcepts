package ComparisionDemo;

import java.util.Arrays;

class A {
	int a;
	public A(int a) { this.a = a; }
	public boolean equals(Object obj){
		if (obj instanceof A){
            A second = (A)obj;
            return (a == second.a);
        }
        return false;
 }
}	
class B extends A {
	int b;
	public B(int a,int b) 
{ super (a); this.b = b;}
public boolean equals (Object o){		
	if (o instanceof B) {
		if (super.equals(o) == true)
			//System.out.println("compared super");
			return ((B)o).b == this.b;		
	}	
    	return false;
}	
}



public  class Excercise { 
	public static void main(String args[]) { 
		
		A a1 = new A(1);
		B b1 = new B(1,2);
		B b2 = new B(2,2);
		B b3 = new B(2,2);
		A a2 = b1;
		
		System.out.println(a1.equals(b1)); ///true
		System.out.println(b1.equals(a1));//false
		System.out.println(b1.equals(b2));//false
		System.out.println(b2.equals(b1));//false
		System.out.println(a1.equals(a2));//true
		System.out.println(b2.equals(b3));///true

		
	}

}