package CollectionDemo;

import java.util.*;

/**
   This program sorts a set of item by comparing
   their descriptions.
*/
public class TreeSetTest
{  
   public static void main(String[] args)
   {  
      SortedSet<Item> parts = new TreeSet<Item>();  ////sorts by parts number using sorted set
      parts.add(new Item("Toaster", 1234));
      parts.add(new Item("Widget", 9912));
      parts.add(new Item("XModem", 4562));
      
      System.out.println("Sort by part number"+parts);
      System.out.println("=================================");

      SortedSet<Item> sortByDescription = new TreeSet<Item>(new
         Comparator<Item>()
         {  
            public int compare(Item a, Item b)
            {  
               String descrA = a.getDescription();
               String descrB = b.getDescription();
               return descrA.compareTo(descrB);
            }
         });

      sortByDescription.addAll(parts);
      System.out.println("Sort by Description"+sortByDescription);
      System.out.println("=================================");
   }
}

