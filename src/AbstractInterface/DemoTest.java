package AbstractInterface;
/*
 * public class InnerClass {
	private int m;
	protected int getM(int b){
		m= b;
		return m;
	}
}

public class OuterClass {
	private int a =7;
	private InnerClass ic = new InnerClass ();
	
	public void test (){
		System.out.println(ic.getM(this.a));
	}

}



public interface PaymentChannel {
	public void paymentRead();
	public void paymentTake();
}


public abstract class PaymentType implements PaymentChannel {	
}

 */
public class DemoTest {

	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		oc.test();
		
		boolean locked = false;
		
		if(!locked)
			System.out.println(!locked +"!locked");
		else
			System.out.println(locked);
	}

}
