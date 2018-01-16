package GenericsDemo4;


import java.util.ArrayList;
import java.util.List;

class One {
	public String toString() { return "One";}
}

class Two extends One {
	public String toString() { return "Two";}
}


public class GenericsDemo4 {

	public static void main(String[] args) {
		// Bounded wildcard. Can hold instantiations
		// of One or its subtypes 
		
		//IMPORTANT :CANNOT WRITE TO OBJECTS WITH TYPE WILDCARDS(?) UNKNOWN TYPE SO add() method does not work
		
		ArrayList<? extends One> list1;  ////bounded wildcard
		
		ArrayList<One> list2 = new ArrayList<One>();
		
		list2.add(new One());
		list2.add(new One());
		
		// Assignment ok
		list1 = list2;  ///OK
		
		// Reading from the list ok.
		// We get an object of type One or its subtypes
		for (One o: list1){
			System.out.println(o);
		}
		// Cannot add to the list
		// list1.add(new One()); //NOT OK CANNOT ADD TO LIST WITH UNKNOWN (?) TYPE/WILDCARD 
		//list1.add(new Two()); //NOT OK
		
		// Unbounded wild cards
		ArrayList<?> list3;
		
		// Assignment ok
		list3 = list2;  //OK
		//list3.add(new Two());  //NOT OK
		//list3.add(new One());  // NOT OK
		// Reading from the list ok.
		// We get an object of type Object or its subtypes
		for (Object o: list3){
			System.out.println(o);
		}
		
		// Lower Bounds
		
		List<? super Two> list4;
		
		list4 = new ArrayList<Two>();
		
		list4.add(new Two());	// OK
		//list4.add(new One()); // Not Ok
		
		Object ob = list4.get(0); // OK
		
	}

}
