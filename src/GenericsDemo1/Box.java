package GenericsDemo1;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {	
   List <T> contents = new ArrayList<T>();     
   public void add(T aThing){contents.add(aThing);}      
}
