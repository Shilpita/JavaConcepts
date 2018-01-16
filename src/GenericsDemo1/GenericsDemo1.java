package GenericsDemo1;

public class GenericsDemo1 {
	public static void main(String[] args) {
		// usage
	    ItemOrderA<Paper> order1 = new ItemOrderA<Paper>();
	    order1.setItem(new Paper(10));
	    
	    Paper p = order1.getItem();
	    System.out.println(p.getWeight()); //10
	    	    
	    order1.show(new Pen());  //pen
	    order1.show(new Paper(20)); //paper
	    
	    // Calling a static method
	    
	    ItemOrderA.show(new Pen()); //pen
	    
	    OfficeDrawer<Pen> drawer1 = new OfficeDrawer<Pen>();
	    // drawer1.add(order1.getItem()); ///error : ItemOrderA<Paper> not class oficeitem or writing tool
	    ItemOrderB<Pen>  order2= new ItemOrderB<Pen> ();
	    order2.setItem(new Pen());
	    drawer1.add(order2.getItem());
	    /** Below if pen is created of type interface Writing tool gives error in adding to drawer<Pen>*/
//	    WritingTool myPen = new Pen();
//	    drawer1.add(myPen);
	    Marker marker = new Marker();
	    OfficeDrawer<Marker> drawer2 = new OfficeDrawer<Marker>();
	    drawer2.add(marker);
	    drawer2.show();

	}

}
