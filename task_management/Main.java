import java.util.Scanner;

public class Main {

    static void displayMenu() {
        System.out.println("\n*** Book Manager ***");
        System.out.println("1. Add New Book");
        System.out.println("2. View Books");
        System.out.println("3. Update Book");
        System.out.println("4. Remove Book");
        System.out.println("5. Quit");
    }

    public static void main(String[] args) {
        BookLogic bookLogic = new BookLogic();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Choose an option above: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    bookLogic.addBook(title, author);
                }
                case 2 -> bookLogic.viewBooks();
                case 3 -> {
                    System.out.print("Enter book ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String author = scanner.nextLine();
                    bookLogic.updateBook(id, title, author);
                }

                case 4 -> {
                    System.out.print("Enter book ID to remove: ");
                    int id = scanner.nextInt();
                    bookLogic.deleteBook(id);
                }
                case 5 -> {
                    running = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
        scanner.close();
    }
}
