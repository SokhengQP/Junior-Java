
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToDoList iTask = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n****** To-Do List Application ******");
            System.out.println("1. Add a task");
            System.out.println("2. View all tasks");
            System.out.println("3. Update an existing task");
            System.out.println("4. Delete a task");
            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Input task description: ");
                    String description = scanner.nextLine();
                    iTask.addTask(description);
                    break;

                case "2":
                    iTask.viewTask();
                    break;

                case "3":
                    System.out.print("Enter the task number to remove: ");
                    try {
                        int updateTask = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter the new description: ");
                        String newDescription = scanner.nextLine();
                        iTask.updateExistingTask(updateTask - 1, newDescription);
                    } catch (NumberFormatException e) {
                        // TODO: handle exception
                        System.out.print("Invalid input. Please enter a number" + e);
                    }
                    break;

                case "4":
                    System.out.print("Enter the task number to delete: ");
                    try {
                        int taskNumber = Integer.parseInt(scanner.nextLine());
                        iTask.removeTask(taskNumber - 1);
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. Please enter a number!" + e);
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        }
    }
}
