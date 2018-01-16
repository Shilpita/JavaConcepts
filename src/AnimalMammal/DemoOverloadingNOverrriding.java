package AnimalMammal;

public class DemoOverloadingNOverrriding {

	public static void main(String[] args) {
		 Mammal m1 = new Mammal();
		 Cat c1 = new Cat();
		 Mammal m2 = new Cat();
		 Mammal m3;
		 m3 = c1;
		 
		 Parent p1 = new Parent();
		 Child ch1 = new Child();
		 Parent p2 = new Child();
		 
		 p1.seen(m1);
		 p1.seen(c1);
		 p1.seen(m2);
		 p1.seen(m3);
		 
		 System.out.println("============================");
		 
		 ch1.seen(m1);
		 ch1.seen(c1);
		 ch1.seen(m2);
		 ch1.seen(m3);
		 
		 System.out.println("============================");
		 
		 p2.seen(m1);
		 p2.seen(c1);
		 p2.seen(m2);
		 p2.seen(m3);

	}

}
