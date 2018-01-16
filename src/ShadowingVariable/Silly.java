package ShadowingVariable;

public class Silly {
		private int x; // an instance variable named x 
		public void example (int x) { 
		        // x shadows instance variable 
				int a = x+1; 
				while (a > 3) { 
					/*int x = 1; // local variable shadows gives error at compile time
					a = a - x; 
					*/
					
					int x1 =1;
					a=a-x1;
				}
	} 

}
