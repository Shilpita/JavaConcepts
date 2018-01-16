package AbstractTest;


class Circle extends Shape{
    private double radius;
    
	public Circle (String shapeName, double radius){ //constructor
        super(shapeName); // calls superclass constructor
        this.radius = radius;
        }
    
    public Circle (){}
    @Override
    public double area (){ return Math.PI * radius * radius;}
    
    @Override
    public void print() {
        super.print();
        System.out.println("Area = " +area());}
}

