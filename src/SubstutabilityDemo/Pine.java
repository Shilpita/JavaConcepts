package SubstutabilityDemo;

public class Pine extends Tree implements test1{

	public void tester() {
		System.out.println("test1 implemented in t2");
	}
	public void getter(){
		System.out.println("t2 child");
	}
}
