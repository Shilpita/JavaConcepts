package ComparisionDemo;

class Account {
    private String acctId;
    private int balance;

    public Account (String acctId, int balance){
 	   this.acctId = acctId;
 	   this.balance = balance;
    }
    public Account (){
 	   this(null,0);
    }
    @Override
    public int hashCode() {

           final int prime = 31;
           int result = 1;
           result = prime * result + ((acctId == null) ? 0 : acctId.hashCode());
           result = prime * result + balance;
           return result;
    }

    @Override

    public boolean equals(Object obj) {

           if (this == obj) return true;
           if (obj == null || this.getClass() != obj.getClass()){
                  return false;
           }
           Account other = (Account) obj;        
           return  

             (this.acctId != null && this.acctId.equals(other.acctId) &&
             this.balance == other.balance) ;
                     
    }
}
class CheckingAccount extends Account {
	private int overdraftAmt = 100;
	
	public CheckingAccount(String acctId, int balance, int overdraftAmt){
		super(acctId,balance);
		this.overdraftAmt = overdraftAmt;
	}
	
	 @Override
  public int hashCode() {
		 	int hash = super.hashCode();
         return hash+overdraftAmt;
  }
	@Override

 public boolean equals(Object obj) {

        if (super.equals(obj)){
        	System.out.println("super equal");
     	   CheckingAccount other = (CheckingAccount) obj;        
     	   return  this.overdraftAmt == other.overdraftAmt ;
        }
        else
     	   	return false;
 }

}
public class Equals_HashcodeDemo {

	public static void main(String[] args) {
		
		Account a1 = new Account ("A123",100);
		Account a2 = new Account ("A123",100);
		if (a1.equals(a2))
			System.out.println("Same");   //same
		else
			System.out.println("Not Same");
	
		System.out.println(a1.hashCode()); //61539316
		System.out.println(a2.hashCode()); //61539316
		
		CheckingAccount c1 = new CheckingAccount ("A123",100,50);
		CheckingAccount c2 = new CheckingAccount ("A123",100,50);
		
		if (a1.equals(c1))
			System.out.println("Same");
		else
			System.out.println("Not Same");  ///not same
		
		System.out.println(c1.hashCode());  ///61539366
		System.out.println(c2.hashCode()); //61539366
		
	
	}
}
/********output 
////Same
//61539316
//61539316
//Not Same
//61539366
//61539366

****/