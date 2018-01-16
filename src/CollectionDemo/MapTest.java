package CollectionDemo;


import java.util.*;

/**
   This program demonstrates the use of a map with key type
   String and value type Employee.
*/
public class MapTest{  
	
   public static void main(String[] args)
   {  
      Map<String, Employees> staff = new HashMap<String, Employees>();
      staff.put("144-25-5464", new Employees("Amy Lee"));
      staff.put("567-24-2546", new Employees("Harry Hacker"));
      staff.put("157-62-7935", new Employees("Gary Cooper"));
      staff.put("456-62-5527", new Employees("Francesca Cruz"));

      // print all entries

      System.out.println(staff);

      // remove an entry

      staff.remove("567-24-2546");

      // replace an entry

      staff.put("456-62-5527", new Employees("Francesca Miller"));

      // look up a value

      System.out.println("getting values :"+staff.get("157-62-7935"));

      // iterate through all entries

      for (Map.Entry<String, Employees> entry : staff.entrySet())
      {  
         String key = entry.getKey();
         Employees value = entry.getValue();
         System.out.println("key=" + key + ", value=" + value);
      }
   }
}

/*
 *{144-25-5464=[name=Amy Lee, salary=0.0], 456-62-5527=[name=Francesca Cruz, salar
y=0.0], 567-24-2546=[name=Harry Hacker, salary=0.0], 157-62-7935=[name=Gary Coop
er, salary=0.0]}
[name=Gary Cooper, salary=0.0]
key=144-25-5464, value=[name=Amy Lee, salary=0.0]
key=456-62-5527, value=[name=Francesca Miller, salary=0.0]
key=157-62-7935, value=[name=Gary Cooper, salary=0.0]
*/