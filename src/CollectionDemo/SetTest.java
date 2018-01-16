package CollectionDemo;

import java.util.*;

/**
   This program uses a set to print all unique words in 
   System.in.
*/
public class SetTest
{ 
   public static void main(String[] args)
   {  
      Set<String> words = new HashSet<String>(); // HashSet implements Set
      long totalTime = 0;

      Scanner in = new Scanner("This is a test");
      while (in.hasNext()){  
         String word = in.next();
         long callTime = System.currentTimeMillis(); //currentTimeMillis();
        // System.out.println(callTime);
         words.add(word);
         callTime = System.currentTimeMillis() - callTime;
         totalTime += callTime;
      }

      Iterator<String> iter = words.iterator();
      
      while (iter.hasNext())
         System.out.println(iter.next());
      System.out.println(". . .");
      
      System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
      
   }
}
