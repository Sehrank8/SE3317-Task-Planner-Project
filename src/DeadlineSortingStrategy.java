import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DeadlineSortingStrategy implements TaskSortingStrategy {
    @Override
    public List<Task> sort(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getDeadline));
        return tasks;
    }
}