package AbstractInterface;

public class OuterClass {
	private int a =7;
	private InnerClass ic = new InnerClass ();
	
	public void test (){
		System.out.println(ic.getM(this.a));
	}

}
