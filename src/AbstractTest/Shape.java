package AbstractTest;


/**
 * @Abstarct class demo
 */


public abstract class Shape{
    // Data Members
    private String shapeName = null;
    
    public Shape (String name){shapeName = name;} // constructor
    public Shape (){} //constructor with parameter
    
    // An abstract method with no method implementation (method body)
    public abstract  double area ();
    
    public void print ()
    { System.out.println ("ShapeName: "+shapeName);}
}
