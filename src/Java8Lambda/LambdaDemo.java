package Java8Lambda;

/*
A lambda expression is a block of code that you can pass around so it can be executed later, 
just once or multiple times.
You can supply a lambda expression whenever an object of an interface with a 
single abstract method is expected. Such an interface is called a functional interface.
Note: In Java 8, interfaces can declare non-abstract methods.
*/
interface Taxable{
	public double tax(double price, double tax);
}
interface Discountable{
	public double discount(double price, double discount);
}
class Item{
	private int itemId;
	private double price;
	
	public Item(int id, double price){
		itemId = id;
		this.price = price;	
	}
	// Using an anonymous class to implement 
	// the functional interface, Taxable
	public double getTax(){
		 Taxable taxOb = new Taxable(){
			 	public double tax(double pr, double tx){
			 		return (tx/100) * pr;
			 	}
		 };
		 return taxOb.tax(price,8);
	}	
	// Using a lambda expression to implement 
	// the functional interface, Discountable
	
	public double getDiscount(double percentOff){
		Discountable d = (originalPrice, discount) -> ((100-discount)/100)* originalPrice;
		return d.discount(price,percentOff);
	}	
}

/** Functional Interfaces with a single method
 */
interface Calculation {
	int calc(int a, int b);
}
interface MyComparator {
    public boolean compare(int a1, int a2);
}


public class LambdaDemo {
	
	private int op(int a, int b, Calculation operation){
		return operation.calc(a, b);
	}
	
	public static void main(String[] args) {
		LambdaDemo demo = new LambdaDemo();
		
		//A lambda expression is like a method, it provides a list of formal 
		// parameters and a body (which can be an expression 
		// or a block of code) expressed in terms of those parameters.
		
		Calculation add = (a,b) -> a+b;  ////<--------LAMBDA IMPORTANT
		
		//A Java lambda expression is an object. 
		// You can assign a lambda expression to a variable 
		// and pass it like a parameter.
		
		System.out.println(demo.op(5,9,add));
		
		Calculation multiply = (a,b) -> a*b;
		System.out.println(demo.op(5,9,multiply));
		
		// Running a thread using anonymous innerclass 
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world !");
			}
		}).start();
		 
		// Using lambda expression
		new Thread(() -> System.out.println("Hello world !!!!")).start();
		 
		
		MyComparator comparator = (a,b)-> {return a < b;};
		System.out.println(comparator.compare(12, 78));
		
		Item hammer = new Item(12,15.00);
		System.out.println(hammer.getDiscount(10));
		System.out.println(hammer.getTax());
		
	}

}
/*
 * 14
45
Hello world !
Hello world !!!!
true
13.5
1.2
*/
