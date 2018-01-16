package MidtermQ3.Overriding;

public class Q3Demo {

public static void main(String [] args){
		
	    Store store1 = new Store();  // type parent store
        FastFoodStore sandwitchPlace = new FastFoodStore (); // type child fast food store
        Store store2 = new FastFoodStore();  // type parent store
        
        Payment p1 = new Payment();  // type parent
        CashPayment cp = new CashPayment(); // type child
        Payment p2 = new CashPayment();  //type parent
           
        store1.acceptPayment (p1);    /// Store::Payment
        store1.acceptPayment (cp);    /// Store::Payment
        store1.acceptPayment (p2);    /// Store::Payment
        	       
        sandwitchPlace.acceptPayment (p1);  ///FastFoodStore::Payment
        sandwitchPlace.acceptPayment (cp);  ///FastFoodStore::CashPayment
        sandwitchPlace.acceptPayment (p2);  ///FastFoodStore::Payment
        
        store2.acceptPayment (p1);   ///FastFoodStore::Payment
        store2.acceptPayment (cp);   ///FastFoodStore::Payment
        store2.acceptPayment (p2);   ///FastFoodStore::Payment 
        
	  //store2.giveChange();  // Not Ok  type parent store
	
	}	
}
