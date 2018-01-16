package CollectionDemo;

public class TwoDimArray {
	
		private static final int ROWS = 5;
		private static final int COLUMNS = 10;
		//Two dimensional array with 
		
		private static int[][]table = new int[ROWS][COLUMNS];
		
		// A ragged or irregular array
		
		private static int[][] raggedArray = new int[3][];
		
		public static void fillTable(int startValue)
		{
			for (int row = 0; row < table.length; row++) {
	            for (int col = 0; col < table[row].length; col++) {
	                table[row][col] = startValue++;
	            }
	        }		
		}
		
		public static void displayTable()
		{
			for (int [] row : table) {
	            for (int val : row) {
	                System.out.print(val +" ");
	            }
	            System.out.println("\n");
	        }
		}
		
		public static void createAndFillRaggedArray(int startValue)
		{
			raggedArray[0]	= new int[4];
			raggedArray[1] = new int [2];
			raggedArray[2] = new int [3];
			
			for (int i = 0; i < raggedArray.length; ++i){
				
				for (int j = 0; j < raggedArray[i].length;++j){
					raggedArray[i][j] = startValue++;
				}
			}
		}
		
		public static void displayRaggedArray()
		{
			for (int [] row : raggedArray) {
	            for (int val : row) {
	                System.out.print(val +" ");
	            }
	            System.out.println("\n");
	        }
		}

}
