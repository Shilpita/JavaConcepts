
package ComparisionDemo;


import java.util.*; 

class PostalStamp1 implements Comparable{
	private int value;
	private String country;
	
	public PostalStamp1(int value, String country){
		this.value = value;
		this.country = country;
	}
	
	public int compareTo(Object second)
	{
		PostalStamp1 other = (PostalStamp1) second;
		if (value < other.value) return -1;
		else if (value == other.value) return 0;
		else	return 1;
			
	}
	public String toString()
	{
		return value+" "+country ;
	}
	
}

public class ComparisonDemo { 
	public static void main(String args[]) { 
		
		PostalStamp1 one = new PostalStamp1(35,"US");
		PostalStamp1 two = new PostalStamp1(30,"US");
		
		System.out.println(one.compareTo(two));
		
		PostalStamp1 [] stamps = new PostalStamp1[5];
		
		// fill it
		
		stamps[0] = new PostalStamp1(50,"US");
		stamps[1] = new PostalStamp1(25,"US");
		stamps[2] = new PostalStamp1(10,"US");
		stamps[3] = new PostalStamp1(20,"UK");
		stamps[4] = new PostalStamp1(5,"UK");
		
		Arrays.sort(stamps);
		
		for (int i = 0; i < stamps.length; ++i){
			System.out.println(stamps[i]);
		}
		
		
		
	}

}
