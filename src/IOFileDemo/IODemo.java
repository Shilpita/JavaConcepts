package IOFileDemo;

//File:  IODemo
//Description: Example to show text file reading and writing using 
//FileReaders (Writers), BufferedReaders (Writers) and Scanner objects.

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class IODemo {

 public static void main(String args[]) throws IOException {

     try {
    	 copyFile2(new File("testfile.txt"),new File("newtestfile1.txt"));

     } catch (IOException e) {
         System.err.println(e);
         System.exit(1);
     }      
     
 }

	//======================copyFile1()========================================
	 public static void copyFile1(String fromFile, String toFile) throws IOException{
	 	// Uses FileReader object to read a character at a time from a file
	 	// and uses FileWriter to write a character at a time to a file.	
     FileReader reader = null;
     FileWriter writer = null; new FileWriter(toFile);

		try{
			reader = new FileReader(fromFile);
			writer = new FileWriter(toFile);
			int c;
         while ((c = reader.read()) != -1) {
             writer.write(c);
         }
		}
		finally{
			if (reader != null) {
             reader.close();
         }
         if (writer != null) {
             writer.close();
         }

		}
     
 }
 //================= copyFile2=========================================
 // Uses BufferedReader to read a line at a time from a file and a 
 // BufferedWriter to write a line at a time to a file. 
 
 public static void copyFile2(File fromFile, File toFile) throws IOException {
     BufferedReader reader = new BufferedReader(new FileReader(fromFile));
     BufferedWriter writer = new BufferedWriter(new FileWriter(toFile));

     //... Loop as long as there are input lines.
     String line = null;
     while ((line=reader.readLine()) != null) {
         writer.write(line);
         writer.newLine();   // Write system dependent end of line.
     }

     //... Close reader and writer.
     reader.close();  // Close to unlock.
     writer.close();  // Close to unlock and flush to disk.
 }


 //=============================================================== copyFile2
 // Uses Scanner for file input.
 public static void copyFile3(File fromFile, File toFile) throws IOException {
     Scanner freader = new Scanner(fromFile);
     BufferedWriter writer = new BufferedWriter(new FileWriter(toFile));

     //... Loop as long as there are input lines.
     String line = null;
     while (freader.hasNextLine()) {
         line = freader.nextLine();
         writer.write(line);
         writer.newLine();   // Write system dependent end of line.
     }

     //... Close reader and writer.
     freader.close();  // Close to unlock.
     writer.close();  // Close to unlock and flush to disk.
 }

/////////////////////////////////////////////////////////////////////
	
 public static void scanAndShow(String fileName) throws IOException {
     Scanner s = null;
     try {
         s = new Scanner(new BufferedReader(new FileReader(fileName)));
			s.useDelimiter("[,\\s]+");

         while (s.hasNext()) {
             System.out.println(s.next());}
     } 
     finally {
         if (s != null) s.close();
     }
 }
}

