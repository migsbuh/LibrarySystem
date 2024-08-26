import javax.swing.*;
import java.awt.*;

public class LibraryTest extends JFrame{
    private LibraryInterface library;

    public LibraryTest() {
      library =  new Library();

      setTitle("Library System");
      setSize(400, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setLayout(new GridLayout(5, 1));


      JButton addButton = new JButton("Add Book");
      addButton.addActionListener(e -> {
        String title = JOptionPane.showInputDialog("Enter book title:");
        String author = JOptionPane.showInputDialog("Enter book author:");
        if (title != null && author != null && !title.isEmpty() && !author.isEmpty()) {
          library.addBook(title, author);
        }  
      });
      add(addButton);


      JButton deleteButton = new JButton("Delete Book");
      deleteButton.addActionListener(e -> {
       String title = JOptionPane.showInputDialog("Enter book title to delete:");
       if (title !=null && !title.isEmpty()) {
           library.deleteBook(title);
       }
      });
      add(borrowButton);

      JButton returnButton = new JButton("Return Book");
      returnButton.addActionListener(e -> {
          String title = JOptionPane.showInputDialog("Enter book title to return:");
          if (title != null && !title.isEmpty()) {
              library.returnBook(title);
          }
      });
      add(returnButton);

      JButton listButton = new JButton("List Books");
      listButton.addActionListener(e -> library.listAvailableBooks());
      add(listButton);

      JButton exitButton = new JButton("Exit");
      exitButton.addActionListener(e -> System.exit(0));
      add(exitButton);
  }

 public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      LibraryTest app = new LibraryTest();
      app.setVisible(true);
    });
  }

}