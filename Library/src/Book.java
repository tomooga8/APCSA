/**
 * Create a new project in BlueJ, called Library. In your program, create a class called Book, that has two private
 * instance fields: numPages and currentPage.Then create a constructor that will initialize those instance fields.
 * In your main method, create two objects of the Book class, one with 245 pages, and a current page of 15, and another
 * object with 325 pages, and a current page of 75. Next, use dot.notation to print out the current pages of each of those books.
 *
 * *Make sure you have this program built out by our next class, so we can try creating some methods for our objects!
 */

public class Book {
    private int numPages;
    private int currentPage;

    public Book(int number, int page){
        numPages = numPages;
        currentPage = page;
    }

    public static void main(String[] args){
        Book one = new Book(245, 15);
        Book two = new Book(325, 75);

        System.out.println("Book 1 Page: " + one.currentPage);
        System.out.println("Book 2 Page: " + two.currentPage);


    }
}


