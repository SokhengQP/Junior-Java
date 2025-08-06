import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
	private final List<Book> books = new ArrayList<>();
	private int nextId = 1;

	public void addBook(Scanner scanner) {
		System.out.print("Enter title: ");
		String title = scanner.nextLine();

		System.out.print("Enter author: ");
		String author = scanner.nextLine();

		System.out.print("Enter year: ");
		int year = scanner.nextInt();
		scanner.nextLine(); // consume newline

		Book book = new Book(nextId++, title, author, year);
		books.add(book);
		System.out.println("Book added successfully!");
	}

	public void viewBooks() {
		if (books.isEmpty()) {
			System.out.println("No books found.");
		} else {
			System.out.println("\nList of Books:");
			for (Book book : books) {
				System.out.println(book);
			}
		}
	}

	public void updateBook(Scanner scanner) {
		System.out.print("Enter the ID of the book to update: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // consume newline

		Book bookToUpdate = findBookById(id);
		if (bookToUpdate == null) {
			System.out.println("Book not found.");
			return;
		}

		System.out.print("Enter new title (leave empty to keep current): ");
		String title = scanner.nextLine();
		if (!title.isEmpty()) {
			bookToUpdate.title = title;
		}

		System.out.print("Enter new author (leave empty to keep current): ");
		String author = scanner.nextLine();
		if (!author.isEmpty()) {
			bookToUpdate.author = author;
		}

		System.out.print("Enter new year (0 to keep current): ");
		int year = scanner.nextInt();
		scanner.nextLine(); // consume newline
		if (year > 0) {
			bookToUpdate.year = year;
		}

		System.out.println("Book updated successfully!");
	}

	public void deleteBook(Scanner scanner) {
		System.out.print("Enter the ID of the book to delete: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // consume newline

		Book bookToDelete = findBookById(id);
		if (bookToDelete == null) {
			System.out.println("Book not found.");
			return;
		}

		books.remove(bookToDelete);
		System.out.println("Book deleted successfully!");
	}

	private Book findBookById(int id) {
		for (Book book : books) {
			if (book.id == id) {
				return book;
			}
		}
		return null;
	}
}
