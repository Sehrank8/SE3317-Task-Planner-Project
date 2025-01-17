import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskModel model = new TaskModel();
        TaskView view = new TaskView();
        TaskController controller = new TaskController(model, view);

        // Sample Tasks
//        model.addTask(new Task("Submit Report", "Submit project report", "Work", "2025-01-18"));
//        model.addTask(new Task("Grocery Shopping", "Buy groceries", "Personal", "2025-01-04"));

    }
}