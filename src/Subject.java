import java.util.List;

public interface Subject {
    void addTask(Task task);

    void deleteTask(String taskName);

    void editTask(String oldName, Task updatedTask);

    List<Task> getTasks();

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(String string,String msg);
}

