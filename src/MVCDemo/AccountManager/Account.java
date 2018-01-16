package MVCDemo.AccountManager;
// Account.java
// Account is an Observable class that represents a bank
// account in which funds may be deposited or withdrawn.
import java.util.Observable;

public class Account extends Observable { ////IMPORTANT
   private double balance;
   private String name;

   // Account constructor
   public Account( String accountName, double openingDeposit ){
      name = accountName;
      setBalance( openingDeposit );
   }
   
   
   // set Account balance and notify observers of change
   private void setBalance( double accountBalance ){
      balance = accountBalance;
      
      //IMPORTANT NOTE :: must call setChanged before notifyObservers to
      // indicate model has changed

      setChanged();  /////IMPORTANT
      //IMPORTANT NOTE ::  notify Observers that model has changed .HERE AbstractAccountView is observer
      notifyObservers();
   }

   
   
   // get Account balance
   public double getBalance(){return balance;}

   // withdraw funds from Account
   public void withdraw( double amount )
      throws IllegalArgumentException
   {
      if ( amount < 0 )
         throw new IllegalArgumentException(
            "Cannot withdraw negative amount" );
      // update Account balance
      setBalance( getBalance() - amount );  ////notifies observer
   }

   // deposit funds in account
   public void deposit( double amount )
      throws IllegalArgumentException
   {
      if ( amount < 0 )
         throw new IllegalArgumentException(
            "Cannot deposit negative amount" );
      setBalance( getBalance() + amount );  /////notifies observer
   }
   
   public String getName(){
      return name;
   }
}

