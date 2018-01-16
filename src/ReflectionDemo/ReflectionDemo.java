package ReflectionDemo;

import java.lang.reflect.*; //contains Java Reflection Model API
import java.awt.*;
import javax.swing.*;
import java.io.*;



class Item implements Discountable{
	private String Itemname ="MyItem";
	Item(){}
	Item(String s){
		this.Itemname = s;
	}
	public void addDiscount(double d) {};
}

class SaleItem extends Item {
	SaleItem(){super();}
	SaleItem(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}}


//////////////////////////////////////////////////////////////////////

class SuperClassFinder {

	 public static void driver() {
	   Button b = new Button();
	   
	   System.out.println("Superclasses of Button:");
	   printSuperclasses(b);
	   
	   JButton b2 = new JButton();
	   System.out.println("Superclasses of JButton:");
	   printSuperclasses(b2);
	   
	   SaleItem s = new SaleItem("newItem");
	   System.out.println("Superclasses of SaleItem:");
	   printSuperclasses(s);  
	 }

	 static void printSuperclasses(Object o) {
	 	
	   Class subclass = o.getClass(); //return the Class object of o
	   
	   Class superclass = subclass.getSuperclass(); //return the superclass
	
		   while (superclass != null) {
			    String className = superclass.getName(); //getName returns the class
							   // full name. e.g. java.awt.Button
			      System.out.println(className);//"superclass: "+ superclass+"	className :"+className);
			      subclass = superclass;
			      superclass = subclass.getSuperclass(); // return superclass
		  }
	 }
}

///////////////////////////////////////////////////////////////////////
class InterfaceFinder {

  public static void driver() {
     
        Rectangle r = new Rectangle(100, 325);
        printInterfaceNames(r);
        
        Item i = new Item();
        printInterfaceNames(i);
     
   }

   static void printInterfaceNames(Object o) {
    Class c = o.getClass(); // returns the Class object that corresponds to o
      System.out.println("interfaces of "+ c);
    // the next statement returns the interfaces implemented by c which
    // represents the class o
      
    Class[] theInterfaces = c.getInterfaces(); 

    for (int i = 0; i < theInterfaces.length; i++) {
         String interfaceName = theInterfaces[i].getName(); // return the name
						// of the interface
         System.out.println(interfaceName);
      }
   }
}
//////////////////////////////////////////////////////////////////////////

class FieldFinder {
   public static void driver() {
      JButton g = new JButton("Testing");
      printFieldNames(g);
      Item i = new Item();
      printFieldNames(i);
   }
   static void printFieldNames(Object o) {
	   System.out.println("Finding Fields of object "+o);
      Class c = o.getClass();
      Field[] publicFields = c.getFields(); //returns all the accessible public fields of c
      if(publicFields.length == 0) publicFields = c.getDeclaredFields();
      for (int i = 0; i < publicFields.length; i++) {
         String fieldName = publicFields[i].getName(); //gets the field’s name
         Class typeClass = publicFields[i].getType(); //gets the field’s type
         String fieldType = typeClass.getName(); //gets the type’s name
         System.out.println("Name: " + fieldName + 
           ", Type: " + fieldType);
         }
      }
}

////////////////////////////////////////////////////////////////////////////
class ConstructorFinder {

   public static void driver() {
      Rectangle r = new Rectangle();
      showConstructors(r);
      showConstructors(new Item());
      showConstructors(new SaleItem());
      
   }

   static void showConstructors(Object o) {
	   System.out.println("Constructors of object "+o);
      Class c = o.getClass();
      Constructor[] theConstructors = c.getConstructors(); //get all public constructors
      if(theConstructors.length==0)theConstructors = c.getDeclaredConstructors();
      for (int i = 0; i < theConstructors.length; i++) {
         System.out.print("( ");
         Class[] parameterTypes = 
	      theConstructors[i].getParameterTypes(); //get the constructor
					      //parameters types
         for (int k = 0; k < parameterTypes.length; k ++) {
	  //get the name of each parameter
            String parameterString = parameterTypes[k].getName(); 
            System.out.print(parameterString + " ");
         }
         System.out.println(")");
     }
   }
}


////////////////////////////////////////////////////////////////////////////

class MethodFinder {
   public static void driver() {
      Polygon p = new Polygon();
      showMethods(p);
   }
   static void showMethods(Object o) {
      Class c = o.getClass();
      Method[] theMethods = c.getMethods(); //get the class public methods
      System.out.println("NoOfmethods: "+theMethods.length);
      for (int i = 0; i < theMethods.length; i++) {
         String methodString = theMethods[i].getName(); //get the method name
         System.out.println("Name: " + methodString);
         //get the method return type 
         String returnString = theMethods[i].getReturnType().getName(); 
         System.out.println("   Return Type: " + returnString);
         //get the method parameters types
         Class[] parameterTypes = theMethods[i].getParameterTypes(); 
         System.out.print("   Parameter Types:");
         for (int k = 0; k < parameterTypes.length; k ++) {
	  			//get the name of each parameter
            String parameterString = parameterTypes[k].getName(); 
            System.out.print(" " + parameterString);
         }
         System.out.println();
      }
   }
}
////////////////////////////////////////////////////////////////////////////

class MethodInvoker {
   public static void driver() {
      String firstWord = "Java ";
      String secondWord = "Reflexion";
      String bothWords = append(firstWord, secondWord);
      System.out.println(bothWords);
   }
   public static String append(String firstWord, String secondWord) {
      String result = null;
      Class c = String.class; //get the Class object of the class String
      Class[] parameterTypes = new Class[] {String.class}; //create a list of parameters that consists of only one parameter of type String
      System.out.println(parameterTypes.toString());
      Method concatMethod; 
      
      Object[] arguments = new Object[] {secondWord};
      System.out.println(arguments.toString());
      try {
       //get an object that represents the concat method of the String class
        concatMethod = c.getMethod("concat", parameterTypes); 
        System.out.println(concatMethod);
       //call the concat method through the concatMethod object
        result = (String) concatMethod.invoke(firstWord, arguments); 
      } catch (Exception e) {}
      return result;
   }
}

///////////////////////////////////////////////////////////////////////////

class ObjectCreator {

   public static void driver() {
      Rectangle r = (Rectangle) createObject("java.awt.Rectangle");
      System.out.println(r.toString());
   }

   static Object createObject(String className) {
      Object object = null;
      try {
	//get the Class object that correponds to className (here
	//java.awt.Rectangle)
          Class classDefinition = Class.forName(className); 

	//Create an object of this class
	object = classDefinition.newInstance(); 
      } catch (Exception e) {}
      return object;
   }
}



///////////////////////////////////////////////////////////////////////////





public class ReflectionDemo {
	
	public static void main(String [] args)
	{
		System.out.println("---------Superclass Finder------------");
		
		SuperClassFinder.driver();
		
		System.out.println("----------Interface Finder-------------");
		
		InterfaceFinder.driver();
		
		System.out.println("----------Field Finder -------------");
		FieldFinder.driver();
		
		System.out.println("----------Constructor Finder -------------");
		ConstructorFinder.driver();
		
		System.out.println("----------Method Finder -------------");
		MethodFinder.driver();
		
		System.out.println("----------Method Invoker -------------");
		MethodInvoker.driver();
		
		System.out.println("----------Object Creator -------------");
		ObjectCreator.driver();
		
		
	}
	
	
}
/*
 *---------Superclass Finder------------
Superclasses of Button:
java.awt.Component
java.lang.Object
Superclasses of JButton:
javax.swing.AbstractButton
javax.swing.JComponent
java.awt.Container
java.awt.Component
java.lang.Object
Superclasses of SaleItem:
Item
java.lang.Object
----------Interface Finder-------------
java.awt.Shape
java.io.Serializable
Discountable
----------Field Finder -------------
Name: MODEL_CHANGED_PROPERTY, Type: java.lang.String
Name: TEXT_CHANGED_PROPERTY, Type: java.lang.String
Name: MNEMONIC_CHANGED_PROPERTY, Type: java.lang.String
Name: MARGIN_CHANGED_PROPERTY, Type: java.lang.String
Name: VERTICAL_ALIGNMENT_CHANGED_PROPERTY, Type: java.lang.String
Name: HORIZONTAL_ALIGNMENT_CHANGED_PROPERTY, Type: java.lang.String
Name: VERTICAL_TEXT_POSITION_CHANGED_PROPERTY, Type: java.lang.String
Name: HORIZONTAL_TEXT_POSITION_CHANGED_PROPERTY, Type: java.lang.String
Name: BORDER_PAINTED_CHANGED_PROPERTY, Type: java.lang.String
Name: FOCUS_PAINTED_CHANGED_PROPERTY, Type: java.lang.String
Name: ROLLOVER_ENABLED_CHANGED_PROPERTY, Type: java.lang.String
Name: CONTENT_AREA_FILLED_CHANGED_PROPERTY, Type: java.lang.String
Name: ICON_CHANGED_PROPERTY, Type: java.lang.String
Name: PRESSED_ICON_CHANGED_PROPERTY, Type: java.lang.String
Name: SELECTED_ICON_CHANGED_PROPERTY, Type: java.lang.String
Name: ROLLOVER_ICON_CHANGED_PROPERTY, Type: java.lang.String
Name: ROLLOVER_SELECTED_ICON_CHANGED_PROPERTY, Type: java.lang.String
Name: DISABLED_ICON_CHANGED_PROPERTY, Type: java.lang.String
Name: DISABLED_SELECTED_ICON_CHANGED_PROPERTY, Type: java.lang.String
Name: CENTER, Type: int
Name: TOP, Type: int
Name: LEFT, Type: int
Name: BOTTOM, Type: int
Name: RIGHT, Type: int
Name: NORTH, Type: int
Name: NORTH_EAST, Type: int
Name: EAST, Type: int
Name: SOUTH_EAST, Type: int
Name: SOUTH, Type: int
Name: SOUTH_WEST, Type: int
Name: WEST, Type: int
Name: NORTH_WEST, Type: int
Name: HORIZONTAL, Type: int
Name: VERTICAL, Type: int
Name: LEADING, Type: int
Name: TRAILING, Type: int
Name: NEXT, Type: int
Name: PREVIOUS, Type: int
Name: WHEN_FOCUSED, Type: int
Name: WHEN_ANCESTOR_OF_FOCUSED_COMPONENT, Type: int
Name: WHEN_IN_FOCUSED_WINDOW, Type: int
Name: UNDEFINED_CONDITION, Type: int
Name: TOOL_TIP_TEXT_KEY, Type: java.lang.String
Name: TOP_ALIGNMENT, Type: float
Name: CENTER_ALIGNMENT, Type: float
Name: BOTTOM_ALIGNMENT, Type: float
Name: LEFT_ALIGNMENT, Type: float
Name: RIGHT_ALIGNMENT, Type: float
Name: WIDTH, Type: int
Name: HEIGHT, Type: int
Name: PROPERTIES, Type: int
Name: SOMEBITS, Type: int
Name: FRAMEBITS, Type: int
Name: ALLBITS, Type: int
Name: ERROR, Type: int
Name: ABORT, Type: int
----------Constructor Finder -------------
( )
( java.awt.Rectangle )
( int int int int )
( int int )
( java.awt.Point java.awt.Dimension )
( java.awt.Dimension )
( java.awt.Point )
----------Method Finder -------------
NoOfmethods: 27
Name: getBoundingBox
   Return Type: java.awt.Rectangle
   Parameter Types:
Name: contains
   Return Type: boolean
   Parameter Types: java.awt.geom.Point2D
Name: contains
   Return Type: boolean
   Parameter Types: double double
Name: contains
   Return Type: boolean
   Parameter Types: double double double double
Name: contains
   Return Type: boolean
   Parameter Types: java.awt.geom.Rectangle2D
Name: contains
   Return Type: boolean
   Parameter Types: java.awt.Point
Name: contains
   Return Type: boolean
   Parameter Types: int int
Name: reset
   Return Type: void
   Parameter Types:
Name: intersects
   Return Type: boolean
   Parameter Types: java.awt.geom.Rectangle2D
Name: intersects
   Return Type: boolean
   Parameter Types: double double double double
Name: getBounds
   Return Type: java.awt.Rectangle
   Parameter Types:
Name: inside
   Return Type: boolean
   Parameter Types: int int
Name: invalidate
   Return Type: void
   Parameter Types:
Name: translate
   Return Type: void
   Parameter Types: int int
Name: getPathIterator
   Return Type: java.awt.geom.PathIterator
   Parameter Types: java.awt.geom.AffineTransform double
Name: getPathIterator
   Return Type: java.awt.geom.PathIterator
   Parameter Types: java.awt.geom.AffineTransform
Name: addPoint
   Return Type: void
   Parameter Types: int int
Name: getBounds2D
   Return Type: java.awt.geom.Rectangle2D
   Parameter Types:
Name: hashCode
   Return Type: int
   Parameter Types:
Name: getClass
   Return Type: java.lang.Class
   Parameter Types:
Name: wait
   Return Type: void
   Parameter Types:
Name: wait
   Return Type: void
   Parameter Types: long int
Name: wait
   Return Type: void
   Parameter Types: long
Name: equals
   Return Type: boolean
   Parameter Types: java.lang.Object
Name: notify
   Return Type: void
   Parameter Types:
Name: notifyAll
   Return Type: void
   Parameter Types:
Name: toString
   Return Type: java.lang.String
   Parameter Types:
----------Method Invoker -------------
Java Reflexion
----------Object Creator -------------
java.awt.Rectangle[x=0,y=0,width=0,height=0]

 *
 */
 