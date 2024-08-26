
public class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String  title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
         if (!isBorrowed) {
             isBorrowed = true ;
             System.out.println("You've borrowed \" " + title + "\"");
         } else {
             System.out.println("Sorry, \"" + title + "\" is already borrowed.");
         }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("You've returned \"" + title + "\"");
        } else {
            System.put.println("\"" + title + "\"wasn't borrowed .");
        }
        

    @Override
    public String toString() {
        return title +  " by " + author + (isBorrowed ? " [Borrowed] "  :  " [Available] ");
        }
        

class Library{
    private List<Book>books;

    public Library(){
        books = new ArrayList<>();
    }
    public void  addBook(Book book){
        books.add(book);
        System.out.println("" + book.getTitle() + "has been added to the library.");
    }

    public void borrowBook(String title){
        for (Book book:books){
            if (book.getTitle().egualsIgnoreCase(title)){
                book.borrowBook();
                return;
            }
        }
        System.out.println("The book " + title + "is not available in the library.");
    }

    public void returnBook(String title){
        for (Book book:books){
            if (book.getTitle().equalsIgnoreCase(title)){

                book.returnBook();
                return;
            }
        }
        System.out.println("The book " + title + "was not borrowed from this library.");
    }

    public void showAvailableBooks(){
        System.out.println("Available Books:");
        for (Book book:books){
            if(!book.isBorrowed()){
                System.out.println(book);
            }
        }
    }
}    

public class Main {
    public void main (String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(newBook("To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("The Great Gatsby","F.Scott Fitzgerald"));

        while (running){
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Show Available Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Add New Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: 
                    library.showAvailableBooks();
                    break;
                case 2: 
                    System.out.print("Enter the title of the book to borrow:");
                    String returnTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;
                case 3: 
                    System.out.print("Enter the book to return:");
                    returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 4:
                    System.out.print("Enter the title of the new book:");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter the author of the new book:");
                    String newAuthor = scanner.nextLine();
                    library.addBook(new Book(newTitle, newAuthor));
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the library System.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }
}
}