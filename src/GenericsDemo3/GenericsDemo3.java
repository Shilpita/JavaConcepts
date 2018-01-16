package GenericsDemo3;

import java.util.ArrayList;
import java.util.List;

class A {public int getValue() { return 1;}}
class B extends A {public int getValue() { return 2;}}
class C extends B {public int getValue() { return 3;}}

class ListManager{	
	// Upperbound 
	public static void getElementsFromList(List <? extends B> aList){
		for(B b : aList){
		      System.out.println(b.getValue());
		   }		
	}
	
	public static void addElementsToList(List <? super B> aList){
		aList.add(new B());
		aList.add(new C());
	}	
}



public class GenericsDemo3 {
	public static void main(String[] args) {
		//-------------------------------------------------
		/*Wildcard instantiations of generic types can be retrieved/read 
		 * as their upper bound and assigned/written as their lower bound.
		 */
		 /* Upperbounded Wildcards */   
	   ArrayList<B>list1 = new ArrayList<B>();	     
	   list1.add(new B());
	   list1.add(new C());
	   
	   System.out.println(list1.get(0).getValue());
	   
	   
	   ArrayList<? extends B> masterList1 = list1;
	   
	   B b = masterList1.get(1);
	   // OK to get/read a value from the list
	   System.out.println(b.getValue());
	   
	   ArrayList<C>list2 = new ArrayList<C>();	     
	   list2.add(new C());
	   
	   masterList1 = list2;
	   b = masterList1.get(0);
	   System.out.println(b.getValue());
	   
	   
	   // Cannot add an element to the list
	   //masterList1.add(new B());
	   //list2.add(new B());
	   
	   //----------------------------------------------------
	   
	   /* Lowerbounded Wildcards */  
	   
	   ArrayList<B>list3 = new ArrayList<B>();	     
	   list3.add(new B());
	   
	   
	   ArrayList<? super C> masterList2 = list3;
	   
	   // Cannot read from masterList2
	  //  C c = masterList2.get(0);
	 /*
	  * 	 /*
	 Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	Type mismatch: cannot convert from capture#7-of ? super C to C

	at GenericsDemo3.GenericsDemo3.main(GenericsDemo3.java:68)
	 */
	  
	 //   System.out.println(c.getValue());
	   
	   masterList2.add(new C());
	   System.out.println(((B) masterList2.get(0)).getValue());
	   System.out.println(((C) masterList2.get(1)).getValue());
	   System.out.println(((B) masterList2.get(1)).getValue());
	}

}
