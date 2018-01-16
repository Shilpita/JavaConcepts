package Enum;

public class EnumDemo {

		public static void main(String[] args) {
			Tour tour1 = Tour.CHICAGO;
			System.out.println(tour1);
			System.out.println(" "+tour1.cost());
			Tour tour2 = Tour.NEWYORK;
			System.out.println(tour2);
			System.out.println(" "+tour2.cost());
			
			for (Tour t: Tour.values())
				System.out.println(t);
			
		}

	}
	/*
	CHICAGO 1000
	NEWYORK 2000
	NEWYORK
	CHICAGO
	MIAMI
	HOUSTON



	*/



