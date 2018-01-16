package AbstractTest;

class Rectangle extends Shape{
    protected double width;
    protected double length;
     
	public Rectangle (String shapeName,double len, double wid){
       super (shapeName);
       length = len; 
       width = wid; 
    }
   
   public Rectangle (){}
   
   
   @Override
   public double area (){ return length * width;}
   
   @Override
   final public void print() {
       super.print();
       System.out.println("Area = "+area());}
}
