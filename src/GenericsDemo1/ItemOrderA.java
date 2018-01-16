package GenericsDemo1;

import java.util.ArrayList;
import java.util.List;

//A generic public class with a type parameter T
public class ItemOrderA<T>{
	private T item;
	// Cannot have a static type variable
 // static T aThing;
	
	/*
	 *Static method cannot make a non-static reference
	public static void show(T ob){
	  
 }
	*/
	// A static method with type parameter is ok
	
	public static <U>void show(U ob){
	  	  System.out.println(ob);
	}
	
	public void setItem( T item ) { this.item = item; }
	
	public T getItem() { return item; }
		
}
