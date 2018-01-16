package CovarianceOverridingDemo;

class Elephant extends Animal {
	 @Override
	  void eat(Food food) {
   		System.out.println("Elephant.eat - Food");
   		food.nutritionalProfile();
   	}			
   public void eat(Plant food) { 
   	System.out.println("Elephant.eat - Plant");
   	food.nutritionalProfile();
   }	
}
