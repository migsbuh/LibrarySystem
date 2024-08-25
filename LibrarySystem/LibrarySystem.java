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
    ]

    @Override
    public String toString () {
        return title +  " by " + author + (isBorrowed ?: " [Borrowed] "  :  " [Available] ");
    }
}

    
