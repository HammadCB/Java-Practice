package Projects;


abstract class LibraryItem{
    protected String Title;
    protected String Author;
    protected String ISBN;
    protected boolean isAvailable;


    public LibraryItem(String title, String author, String isbn) {
        this.Title = title;
        this.Author = author;
        this.ISBN = isbn;
        this.isAvailable = true;    
    }

    
    public abstract void showDetails();
    public abstract void borrow();
    public abstract void returnItem();

    //Checking up
    public boolean checkAvailability() {
        return isAvailable;
    }

    //Setting up
    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }
        
}

 class Book extends LibraryItem{

    public Book (String title,String author , String isbn){
    super(title,author,isbn);
    }



@Override
public void showDetails(){
    System.out.println("Book: "+Title+"| Author: "+Author+"| ISBN: "+ISBN);
    System.out.println("Availabe: "+(isAvailable ? "Yes":"No"));
}

@Override
public void borrow(){
    if (isAvailable){ 
    isAvailable=false;
    System.out.println(Title + "Has been Borrowed");
    }else{
        System.out.println(Title + "Is not available");
    }
        }

@Override
public void returnItem(){
    isAvailable=true;
    System.out.println(Title+ "Has been Returned ");
}

}




public class LibrarySystem {
    public static void main(String[] args) {
        System.out.println("Library System Initialized");
        LibraryItem B1 = new Book("Java Programming ","Sir Abdullah","532345");
        B1.showDetails();
        B1.borrow();
        B1.showDetails();
        B1.returnItem();
        B1.showDetails();
        

        
        
    }
    
}
