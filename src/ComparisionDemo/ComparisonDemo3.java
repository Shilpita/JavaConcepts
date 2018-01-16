package ComparisionDemo;

import java.util.*; 
// a Comparator

class PostalStamp implements Comparable<PostalStamp>{
	private int value;
	private String country;
	
	public PostalStamp(int value, String country){
		this.value = value;
		this.country = country;
	}
	
	public int getValue() { 
		return value;
	}
	
	public String getCountry() { 
		return country;
	}
	
	public int compareTo(PostalStamp second)
	{
		if (value < second.value) return -1;
		else if (value == second.value) return 0;
		else	return 1;			
	}
	public String toString()
	{
		return value+" "+country ;
	}		
}

class PostalStampComparator implements Comparator<PostalStamp>{  ////IMPORTANT
	public int compare (PostalStamp first, PostalStamp second){
		return first.getCountry().compareTo(second.getCountry());
	}
}

public class ComparisonDemo3 { 
	public static void main(String args[]) { 
		
		PostalStamp [] stamps = new PostalStamp[5];
		
		// fill it
		
		stamps[0] = new PostalStamp(50,"US");
		stamps[1] = new PostalStamp(25,"US");
		stamps[2] = new PostalStamp(10,"US");
		stamps[3] = new PostalStamp(20,"UK");
		stamps[4] = new PostalStamp(5,"UK");
		

		System.out.println("Sorting by Stamp Country");
		// Sort by country
		Arrays.sort(stamps,new PostalStampComparator());
		
		for (int i = 0; i < stamps.length; ++i){
			System.out.println(stamps[i]);
		}
		
		// Sort by value
		System.out.println("Sorting by Stamp Value");
		Arrays.sort(stamps);  ////All ELEMENTS IN ARRAY MUST IMPLEMNET COMAPARABLE INTERFACE for SORT TO WORK
		
		for (int i = 0; i < stamps.length; ++i){
			System.out.println(stamps[i]);
		}
		
		System.out.println("Sorting by Stamp Country");
		// Sort by country
		Arrays.sort(stamps,new PostalStampComparator());
		
		for (int i = 0; i < stamps.length; ++i){
			System.out.println(stamps[i]);
		}
		
		
	}

}
/*
 *Sorting by Stamp Value
5 UK
10 US
20 UK
25 US
50 US
Sorting by Stamp Country
5 UK
20 UK
10 US
25 US
50 US
*/
