import java.util.ArrayList;
import java.util.List;

public class BookLogic {
    private List<Book> books = new ArrayList<>();
    private int nextId = 1; // auto-increment ID

    // Add new book
    public void addBook(String title, String author) {
        Book book = new Book(nextId++, title, author);
        books.add(book);
        System.out.println("Book added successfully: " + book);
    }

    // View all books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No book available!");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Find book by ID
    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Update book details
    public void updateBook(int id, String title, String author) {
        Book book = findById(id);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            System.out.println("Book updated successfully: " + book);
        } else {
            System.out.println("Book not found!");
        }
    }

    // Delete book
    public void deleteBook(int id) {
        Book book = findById(id);
        if (book != null) {
            books.remove(book);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }
}
