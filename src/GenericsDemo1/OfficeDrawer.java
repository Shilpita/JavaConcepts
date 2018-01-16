package GenericsDemo1;

import java.util.ArrayList;
import java.util.List;

/*A type variable may extend a public class or interface type, 
* meaning that its instantiation must be of that type or a subtype.
* The order of the & interface bounds is not significant, but only one public class type 
* can be specified and if there is one, it must come first. 
*/
public class OfficeDrawer<T extends OfficeItem & WritingTool> {	
 List <T> contents = new ArrayList<T>();
 WritingTool tool ; 
 		    		
 public void add(T aThing){
 	contents.add(aThing);
 	tool = aThing;
 }
 
 public void show(){
	 System.out.println(contents);
 }
}


