import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskModel model = new TaskModel();
        TaskView view = new TaskView();
        TaskController controller = new TaskController(model, view);

        // Sample Tasks
      /*  model.addTask(new Task("Submit Report", "Submit project report", "Work", "2025-01-03"));
        model.addTask(new Task("Grocery Shopping", "Buy groceries", "Personal", "2025-01-04")); */

        // Initial Task List
        List<Task> tasks = model.getTasks();
        StringBuilder taskList = new StringBuilder();
        for (Task task : tasks) {
            taskList.append(task.getName())
                    .append(" - ")
                    .append(task.getDescription())
                    .append(" - ")
                    .append(task.getCategory())
                    .append(" - ")
                    .append(task.getDeadline())
                    .append("\n");
        }
        view.updateTaskList(taskList.toString());
    }
}