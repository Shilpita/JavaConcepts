package CollectionDemo;

import java.util.*; 
public class ArrayDemo { 
	
	public static void display(int [] oneArray) { 
		for(int i = 0; i < oneArray.length; i++) 
			System.out.print(oneArray[i] + " "); 
		System.out.println(""); 
	}
	
	public static void showNames(String [] nameList) {
		
		// A for-each type of loop to access the values.
		// If you only need to reference the value of each of the elements, 
		// you can use this loop, which keeps track of the index and assigns 
		// successive values to a variable (name in this example). 
		
		for(String name: nameList) 
			System.out.print(name + " "); 
		System.out.println(""); 
	}
	
	public static void main(String args[]) { 
		// allocate and initialize array 
		int [] myArray = new int[10];
		String [] names = {"Smith","Jones","Clark","Green","Thomson"};
		
		for(int i = 0; i < 10; i++) 
			myArray[i] = 3 * i; 
		// display, sort, display 
		System.out.print("Original contents: "); 
		display(myArray); 
			// fill and display 
		
		// The Arrays class contains various methods for manipulating 
		// arrays (such as sorting and searching). 
		
		Arrays.fill(myArray, 2, 6, -1); 
		System.out.print("After Filling with -1 from locations 2 upto 6 : "); 
		display(myArray);
		// Sort and display 
		Arrays.sort(myArray); 
		System.out.print("Sorted: "); 
		display(myArray); 
		showNames(names);
		
		// binary search for 21 
		System.out.print("The value 21 is at location "); 
		int index = Arrays.binarySearch(myArray, 21); 
		System.out.println(index); 
	} 
	
	
}
/*
 Original contents: 0 3 6 9 12 15 18 21 24 27 
After Filling with -1 from locations 2 upto 6 : 0 3 -1 -1 -1 -1 18 21 24 27 
Sorted: -1 -1 -1 -1 0 3 18 21 24 27 
Smith Jones Clark Green Thomson 
The value 21 is at location 7

 * 
 */
