package AnimalMammal;

class Child extends Parent{
	//overriding parent
	void seen(Cat c){
		System.out.println("In Child");
		c.show();
	}	
	/*
	public void seen(Mammal m){
			System.out.println("In Child overridden");
			m.show();
	}
	*/
	
}
