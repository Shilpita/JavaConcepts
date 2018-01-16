package AbstractTest;

public class DriverDemo {
		   public static void main(String [] args){
		       Shape  shape;
		      
		       //shape = new Shape (); /* Will not compile because Shape is an abstract class and cannot be instantiated.*/
		       Rectangle  rectangle= new Rectangle ("Rectangle",2.0, 5.0);
		       Circle circle = new Circle ("Circle",10);
		       Square square = new Square ("Square",5);
		       rectangle.print();
		       circle.print();
		       square.print();
		/*OK to assign an instance of a derived class to a base class type
		       // This is called upward cast to the base and is always possible, 
		       // because an instance of a type Circle is also an instance of type shape*/
		       System.out.println("=======================================");
		       shape = rectangle;
		       shape.print();
		       System.out.println("=======================================");
			   shape = circle;
		       shape.print();// circle.print() is invoked since shape variable is actually referring to a circle object
		       System.out.println("=======================================");
		       // Another way of assigning a derived class instance to a reference of type
		       // super class
		       shape = new Rectangle("Rectangle",5.0,4.0);
		       shape.print(); // What print() is invoked? 
		       // An array of different Shape objects
		       Shape [] allShapes = new Shape[3];
		       allShapes[0] = new Rectangle ("Rectangle",2.0, 5.0);
		       allShapes[1] = new Circle ("Circle",10);
		       allShapes[2] = new Square ("Square",5); 
		       System.out.println("=======================================");
		       for (int i = 0; i < allShapes.length; ++i){
		           allShapes[i].print();
		       } 
		       System.out.println("=======================================");
		       // Casting
		       Rectangle two = new Rectangle("Rectangle",12,13);
		       Shape one = two; // upward cast to the base , always possible
		       
		       // two = one 
		       					/* this assignment will not work, because an instance of
		       					type Shape is not necessarily is an instance of type Circle.
		       					A downward cast is required */

		       Rectangle three = (Rectangle)one;
		       three. print();
		       
		       /**********************Slides question********************/
		      // Shape shape1 = new Shape(); // Not ok cannot create objects from abstract class.
		       Shape shape1 = new Circle();  // OK substituability
		       shape1 = new Rectangle();    // OK Substituability

		       Shape [] someShapes = new Shape[3]; // Ok
		       someShapes[0] = new Circle("circle", 5); // OK
		       someShapes[1] = new Rectangle("Rectangle", 5,10);//OK


		   }

}
