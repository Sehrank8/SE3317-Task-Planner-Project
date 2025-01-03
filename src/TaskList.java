public class TaskList {



    public void getAllTasks() {
        String query = "F";
    }



    public void addTask(String name,String description, String category, String deadline) {
        String query = "INSERT INTO TASKS" + "(task_name, description, category, deadline) values(" +
                name + description + category + deadline + ")";
    }

    public void removeTask() {

    }


}
