import java.util.ArrayList;
import java.util.List;


public class NotificationCenter implements Subject {
    private final List<TaskObserver> observers = new ArrayList<>();
    private String notification;

    public void setNotification(String notification) {
        this.notification = notification;
        notifyObservers("Task edited: " + oldName + " -> " + newName);
    }

    @Override
    public void registerObserver(TaskObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(TaskObserver o) {
        observers.remove(o);
    }

    public static void notifyObservers(String s) {
        for (TaskObserver observer : observers) {
            observer.update(notification);
        }
    }
}
