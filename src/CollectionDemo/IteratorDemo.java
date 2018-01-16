package CollectionDemo;

import java.util.*;
public class IteratorDemo {
	public static void main(String[] args) {
		// Create an ArrayList of Strings		
		ArrayList <String> cityList = new ArrayList<String>();
		
		// Add strings to the list
		cityList.add("SFO");
		cityList.add("New York");
		cityList.add("Philadelphia");
		cityList.add("LosAngeles");
		cityList.add("Barcelona");
		cityList.add("London");
		
		// Get an iterator to navigate and display the contents of the list
		
		Iterator<String> iter = cityList.iterator(); //<------Iterator declaration
		while(iter.hasNext()) {
	         String city = iter.next();
	         System.out.print(city + " ");
	    }
		System.out.println();
		
		// Get a ListIterator to add to the list
		
		ListIterator<String> listIter = cityList.listIterator();///listiterator declaration
		while(listIter.hasNext()) {
	         String city = listIter.next();
	        listIter.set(city+"--->");
	    }
		System.out.println("\n modified using list iterator:\n \n");
		
		// Show the contents after modification
		iter = cityList.iterator();
		while(iter.hasNext()) {
	         String city = iter.next();
	         System.out.print(city+" ");
	    }
		System.out.println("\n Now printing backwards:\n \n");
		
		// Show the list from backwards
		while(listIter.hasPrevious()) {
	         String city = listIter.previous();
	         System.out.print(city + " ");
	    }
		System.out.println();
		
	}

}


//////output
/*
 *SFO New York Philadelphia LosAngeles Barcelona London 

 modified using list iterator:
 

SFO--->New York--->Philadelphia--->LosAngeles--->Barcelona--->London--->
 Now printing backwards:
 

London---> Barcelona---> LosAngeles---> Philadelphia---> New York---> SFO---> 
 
*/
