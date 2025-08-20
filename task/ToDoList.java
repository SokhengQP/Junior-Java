
import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Task> task;

    public ToDoList() {
        this.task = new ArrayList<>();
    }

    public void addTask(String description) {
        task.add(new Task(description));
        System.out.println("Task added successful!");
    }

    public void viewTask() {
        if (task.isEmpty()) {
            System.out.println("The to-do-list is empty!");
        }
        System.out.println("Your to-do-list: ");
        for (int i = 0; i < task.size(); i++) {
            System.out.println(i + 1 + " " + task.get(i));
        }
    }

    public void updateExistingTask(int index, String newDescription) {
        if (index >= 0 && index < task.size()) {
            Task taskToUpdate = task.get(index);
            taskToUpdate.setDescription(newDescription);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Invalid task number. Please try again!");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < task.size()) {
            task.remove(index);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
