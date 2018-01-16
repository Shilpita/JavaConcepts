package InnerClass;


public class House {
	int [] roomFootage;
	
	public House (){
		roomFootage = new int[4]; 
		roomFootage[0] = 30; 
		roomFootage[1] = 50;
		roomFootage[2] = 100;
		roomFootage[3] = 120;			
	}
	private class RoomConditioner implements RoomSelector {		
		public boolean isOkToAirCondition(int index){
			if (index < roomFootage.length){
				if (roomFootage[index] > 70)
					return true;
			}
			return false;	 
		}
	}
	
	public RoomSelector getRoomConditioner()
	{
		return new RoomConditioner();
	}

}

