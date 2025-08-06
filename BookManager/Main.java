import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BookManager manager = new BookManager();

		while (true) {
			System.out.println("\n===== Book Manager =====");
			System.out.println("1. Add Book");
			System.out.println("2. View All Books");
			System.out.println("3. Update Book");
			System.out.println("4. Delete Book");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline
			System.out.println("\n");

			switch (choice) {
				case 1 -> manager.addBook(scanner);
				case 2 -> manager.viewBooks();
				case 3 -> manager.updateBook(scanner);
				case 4 -> manager.deleteBook(scanner);
				case 5 -> {
					System.out.println("Exiting...");
					return;
				}
				default -> System.out.println("Invalid choice!");
			}
		}
	}
}
