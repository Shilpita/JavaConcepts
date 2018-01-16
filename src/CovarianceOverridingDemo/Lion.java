package CovarianceOverridingDemo;

class Lion extends Animal {
	 public void eat(Meat food) {  
	   		System.out.println("Lion.eat - Meat");
	   		food.nutritionalProfile();
	 }
	 
	}
	