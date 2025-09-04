package CH_3;

class Book {
    String title;
    String author;
    double price;

    // Constructor
    Book(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
    }

    void showDetails() {
        System.out.println("Book: " + title + " | Author: " + author + " | Price: " + price);
    }
}

public class BookStore {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "John", 500);
        Book b2 = new Book("OOP in Depth", "Sara", 750);

        b1.showDetails();
        b2.showDetails();
    }
}
