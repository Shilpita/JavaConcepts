package MidtermQ3.Overriding;

class FastFoodStore extends Store {
    public void acceptPayment (CashPayment c)
    {System.out.println ("FastFoodStore::CashPayment");}
    
    public void acceptPayment (Payment p)
    {System.out.println ("FastFoodStore::Payment");}
    
    public void giveChange()  {System.out.println ("FastFoodStore::giveChange()");}
     
}