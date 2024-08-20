/* *****************************************
 *  File : Topic 6 Reading Assignment - TestReadingMaterial.java
 *  Author : Celia Ho 
 *  Last Modified : Fri Apr 19 2024
 *  Description : Modify the Topic 4 Reading Assignment as instructed, then create a 
 *  TestReadingMaterial class that demonstrates a try/catch/finally block with the use of the 
 *  IllegalNumPagesException and prints the illegal number of pages. Use the toString() methods of 
 *  your classes to write your instances of ReadingMaterial, Newspaper, and Book to a textfile 
 *  named YourName.txt. Close the text file, then read it back to the console. 
 * ******************************************/

import java.io.IOException;
import java.util.Scanner;

public class TestReadingMaterial {
    public static void main(String[] args) throws IOException, IllegalNumPagesException, Exception {
                
        // ***Write to file section***

        // Create file object
        java.io.File file = new java.io.File("CeliaHo.txt");
        
        // Check if file exists
        if (file.exists()) {
            System.out.println("File " + file + " already exists.\n");
            // System.exit(1);
        }
        else 
            System.out.println("File " + file + " will be created.\n");
        
        // Create a PrintWriter & assign it to file object
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        

        // ***Instantiate objects***

        // Demonstrate invalid objects
        System.out.println("Demonstration of invalid objects with handled exceptions:");
        try {
            ReadingMaterial readingMaterial = new ReadingMaterial("print", 0);
            // Write formatted output to the file
            output.print(readingMaterial + "\n");
        }
        catch (IllegalNumPagesException ex) {
            System.out.println("\t" + "Reading Material: " + ex);
        }
        
        try {
            Newspaper newspaper = new Newspaper("digital", 0);
            output.print(newspaper + "\n");
        }
        catch (IllegalNumPagesException ex) {
            System.out.println("\t" + "Newspaper: " + ex);
        }

        try {
            Book book = new Book("audio", 0, "none");
            output.print(book + "\n");
        }
        catch (IllegalNumPagesException ex) {
            System.out.println("\t" + "Book: " + ex + "\n");
        }

        // Demonstrate valid objects

        try {
            ReadingMaterial readingMaterial = new ReadingMaterial("print", 8);
            // Write formatted output to the file
            output.print(readingMaterial + "\n");
        }
        catch (IllegalNumPagesException ex) {
            System.out.println("Reading Material: " + ex);
        }
        
        try {
            Newspaper newspaper = new Newspaper("digital", 90);
            output.print(newspaper + "\n");
        }
        catch (IllegalNumPagesException ex) {
            System.out.println("Newspaper: " + ex);
        }

        try {
            Book book = new Book("audio", 30, "none");
            output.print(book);
        }
        catch (IllegalNumPagesException ex) {
            System.out.println("Book: " + ex);
        }
        finally {   // ??? IS THIS WHAT THE ASSIGNMENT WANTS IN THE FINALLY CLAUSE?
            // Close the file
            System.out.println("Valid objects have been written to file " + file + ".\n");
            output.close();
        }
        
        // ***Read from file section***
        try {
            System.out.println("File " + file + " will be read:");

            // Create a scanner for the file
            try (Scanner input = new Scanner(file)) {
                while (input.hasNextLine()) {   // While file has another line of data to read...
                    String line = input.nextLine().trim(); //  ...trim leading/trailing whitespaces & save line read to variable "line"...
                    System.out.println("\t" + line);   // ...and print line to console.
                }
                System.out.println("Done reading file " + file + ".");

                // Close the file
                //input.close();  // Not necessary with try-with resources format used here (automatically closes the file) but good practice
            }
        } catch (IOException ex) {
            System.out.println("Error: I/O Exception occurred.\n");
        } 
        
    }
}