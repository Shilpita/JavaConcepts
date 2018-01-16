
 
public class TrafficLight {
	public TrafficLight(){lightColor = "RED";}	
	public TrafficLight(String color){
		lightColor = color.toUpperCase();}	
	String lightColor(){ return lightColor;}
	// next state of a TrafficLight object depends on its
	// current state and the message received

	TrafficLight change(){
	 if (lightColor.equals ("RED"))
	    lightColor = "GREEN";
	 else if (lightColor.equals ("GREEN"))
	    lightColor = "YELLOW";
	 else if (lightColor.equals ("YELLOW"))
	    lightColor = "RED";
	    return this;
	}
	private String lightColor;
	
	public static void main(String [] args){ 
	
		TrafficLight lightAtX = new TrafficLight();
					
		lightAtX.change();

		// Display the current state of the Traffic Light

		System.out.println(lightAtX.lightColor());
			
		// Chaining messages
		
		System.out.println(lightAtX.change().change().lightColor());
	
    }
}