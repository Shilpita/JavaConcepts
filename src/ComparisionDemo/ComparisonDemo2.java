package ComparisionDemo;


import java.util.*; 
// Parametrized Comparable interface

class PostalStamp2 implements Comparable<PostalStamp2>{
	private int value;
	private String country;
	
	public PostalStamp2(int value, String country){
		this.value = value;
		this.country = country;
	}
	
	public int compareTo(PostalStamp2 second)
	{
		if (value < second.value) return -1;
		else if (value == second.value) return 0;
		else	return 1;			
	}	
}

public class ComparisonDemo2 { 
	public static void main(String args[]) { 
		
		PostalStamp2 one = new PostalStamp2(35,"US");
		PostalStamp2 two = new PostalStamp2(30,"US");
		
		System.out.println(one.compareTo(two));
		
	}

}