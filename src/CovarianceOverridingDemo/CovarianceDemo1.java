package CovarianceOverridingDemo;

public class CovarianceDemo1 {
    
	public static void main(String[] args) {
		
		// Create instances of Food
		
		Food food1  = new Food();
		
		Plant plant = new Plant();
		
		Meat meat = new Meat();
		
		Food food2 = new Plant();  /// static type food , dynamic plant... call plant function
		
		Food food3 = plant;
		
		// Create instances of animals
		
	    Animal animal = new Animal();
	    
	    Elephant elephant = new Elephant();
	    
	    Lion lion = new Lion();
	    
	    //System.out.println(food2 instanceof Plant);
	    
	    // Set 1
	    animal.eat(food1); //Animal.eat - Food : food nutrition
	    System.out.println("------------------");  
	    animal.eat(plant); //Animal.eat - Food : plant nutrition
	    System.out.println("------------------");
	    animal.eat(meat); //Animal.eat - Food : meat nutrition
	    System.out.println("------------------");  
	    animal.eat(food2);//Animal.eat - Food : plant nutrition
	    System.out.println("===================="); 
	    animal.eat(food3);//Animal.eat - Food : plant nutrition
	    System.out.println("===================="); 

	    // Set 2
	    elephant.eat(food1);////Elephant.eat - Food : food nutrition
	    System.out.println("------------------"); 
	    elephant.eat(plant);////Elephant.eat - Plant : Plant nutrition
	    System.out.println("------------------"); 
	    elephant.eat(meat);////Elephant.eat - Food : Meat nutrition
	    System.out.println("------------------"); 
	    elephant.eat(food2);////Elephant.eat - Food : Plant nutrition
	    System.out.println("------------------");  
	    elephant.eat(food3);////Elephant.eat - Food : Plant nutrition
	    System.out.println("------------------");  
	    
	}
	}