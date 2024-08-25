import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}

public class LibraryManagementSystem {
    static ArrayList<Book> library = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        
        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. View Books");
            System.out.println("3. Update a Book");
            System.out.println("4. Delete a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }

    public static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        library.add(new Book(title, author, year));
        System.out.println("Book added successfully!");
    }

    public static void viewBooks() {
        if (library.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("\nLibrary Books:");
            for (int i = 0; i < library.size(); i++) {
                Book book = library.get(i);
                System.out.println((i + 1) + ". Title: " + book.title + ", Author: " + book.author + ", Year: " + book.year);
            }
        }
    }

    public static void updateBook() {
        System.out.print("Enter the book number to update: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline

        if (index >= 0 && index < library.size()) {
            Book book = library.get(index);

            System.out.print("Enter new title (leave blank to keep the same): ");
            String newTitle = scanner.nextLine();
            System.out.print("Enter new author (leave blank to keep the same): ");
            String newAuthor = scanner.nextLine();
            System.out.print("Enter new year (enter 0 to keep the same): ");
            int newYear = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (!newTitle.isEmpty()) book.title = newTitle;
            if (!newAuthor.isEmpty()) book.author = newAuthor;
            if (newYear != 0) book.year = newYear;

            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Invalid book number!");
        }
    }

    public static void deleteBook() {
        System.out.print("Enter the book number to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline

        if (index >= 0 && index < library.size()) {
            library.remove(index);
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Invalid book number!");
        }
    }
}
