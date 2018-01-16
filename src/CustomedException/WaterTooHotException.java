package CustomedException;

//User defined exceptions
class WaterTooHotException extends Exception {
 double low = 60.00;
 double high = 80.00;
 double current;
 public WaterTooHotException () {super ("WaterTooHotException");}
 public WaterTooHotException (double temp){
     current = temp;
 }
 public String toString(){
    return("WaterTooHotException- Water Temperature in FishTank must be between "+low +" and "+high +
    	"\n current temp after increase will be "+current);
 }
}
