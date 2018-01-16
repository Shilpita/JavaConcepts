package SubstutabilityDemo;

public class drive {

	public static void main(String[] args) {
		//test1 a0 = new test1();
		test1 a = new Pine();
		a.tester();
		((Pine) a).getter();
		
		Tree b = new Pine();
		b.getter();
		if(b instanceof Tree){
			System.out.println("Tree");
		}
		if(b instanceof Pine){
			System.out.println("Pine");
		}
		if(b instanceof Oak){
			System.out.println("Oak");
		}else{
			System.out.println("Oops");
		}
		
		Tree c = new Tree();
		c.getter();
		
		System.out.println("");
		
		
//		
//		// t2 d = new t1();  // subclass cannot be substituted by parent type.
//		
//		test1 [] arr = new test1[3];
//		arr[0] = new t2();
//		arr[2] = new t2();
//		arr[1] = new t3();
//		
//		for(int i =0 ; i<3; i++){
//			arr[i].tester();
//		}
//		
//		//test1 m = new t1(); // mismatch type
//		
//		

	}

	
}