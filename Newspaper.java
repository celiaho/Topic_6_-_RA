/* *****************************************
 *  File : Topic 6 Reading Assignment - Newspaper.java
 *  Author : Celia Ho 
 *  Last Modified : Fri Apr 19 2024
 *  Description : Modify the Topic 4 Reading Assignment (ReadingMaterial, Newspaper, Book) so that the constructors call setNumPages, and setNumPages throws an exception that is a subclass of IllegalArgumentException called IllegalNumPagesException, with a member variable of numPages, modeled after the Exception subclass in the textbook for IllegalRadiusException. 
 *  ---
 *  Create the following classes
ReadingMaterial
- 	format:String 	print, digital, audio
+ 	ReadingMaterial() 	
+ 	ReadingMaterial(format:String) 	
+ 	getFormat():String 	
+ 	setFormat(String):void 	
+ 	toString():String 	
 
Newspaper  : ReadingMaterial
- 	numPages:int 	must be > 0
+ 	Newspaper() 	
+ 	Newspaper(format:String, numPages:int) 	
+ 	getNumPages():int 	
+ 	setNumPages(int):void 	must be > 0
+ 	toString():String 	must include ReadingMaterial toString
 
Book : ReadingMaterial
- 	numPages:int 	must be > 0
- 	binding:String 	hardcover,softcover,none
+ 	Book() 	
+ 	Book(format:String, numPages:int, binding:String) 	
+ 	getNumPages():int 	
+ 	setNumPages(int):void 	must be > 0
+ 	getBinding():String 	
+ 	setBinding(String):void 	
+ 	toString():String 	must include ReadingMaterial toString

Create a TestReadingMaterial class that instantiates an instance of ReadingMaterial, an instance of Newspaper, and an instance of Book. Create a method in TestReadingMaterial that demonstrates polymorphism with the signature: printReadingMaterial(ReadingMaterial rm) to print each instance and calls the object's toString method - do not use instanceOf in this method. 
 * ******************************************/

 public class Newspaper extends ReadingMaterial {
  
    private int numPages;     // must be > 0
  
    public Newspaper() {
    }
  
    public Newspaper(String format, int numPages) throws IllegalNumPagesException {
      super(format, numPages);
      if (numPages < 0)
        throw new IllegalNumPagesException(numPages);
      else
        this.numPages = numPages;
    }

    @Override
    public String toString() {
      return super.toString() + ": Newspaper";
    }
  
  }