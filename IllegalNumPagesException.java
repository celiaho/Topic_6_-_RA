// Define IllegalNumPagesException
public class IllegalNumPagesException extends IllegalArgumentException {
    
    private int numPages;
    
    // Constructor for customized exception per Liang Listing 12.10
    public IllegalNumPagesException(int numPages) {
      super("Invalid number of pages: " + numPages);   // ***???Gemini code
      this.numPages = numPages;
    }
  
    // Return the radius
    public int getNumPages() {
      return numPages;
    }
  }