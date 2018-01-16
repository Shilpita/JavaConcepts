package ShadowingVariable;

public class Demo {

	public static void main(String[] args) {
		Parent p = new Parent();
		System.out.println("parent x:"+ p.x);

		
		Child c = new Child();
		System.out.println("child x:"+ c.x);
		
		p= c;
		System.out.println("parent x:"+ p.x);
		
		/* Doesn't work due to substitutability
		Child c1 = new Parent();
		System.out.println("child x:"+ c1.x);
		*/
		Parent p1 = new Child();
		System.out.println("parent x:"+ p1.x);
		
	}

}
