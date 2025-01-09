import java.util.ArrayList;
import java.util.List;


public class NotificationCenter implements Subject {
    private final List<TaskObserver> observers = new ArrayList<>();
    private String notification;

    public void setNotification(String notification) {
        this.notification = notification;
        notifyObservers();
    }

    @Override
    public void registerObserver(TaskObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(TaskObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (TaskObserver observer : observers) {
            observer.update(notification);
        }
    }
}
