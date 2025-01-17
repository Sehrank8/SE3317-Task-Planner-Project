import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TaskController {
    private TaskModel model;
    private TaskView view;
    private Timer timer;

    public TaskController(TaskModel model, TaskView view) {
        this.model = model;
        this.view = view;

        this.view.addAddTaskListener(new AddTaskListener());
        this.view.addDeleteTaskListener(new DeleteTaskListener());
        this.view.addEditTaskListener(new EditTaskListener());

        model.registerObserver(view);
        startTimer();
    }

    private void startTimer() {
        timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                refreshView();
            }
        }, 0, 10000); // Updates every 10 seconds
    }


    private void refreshView() {
        view.updateDayAndDate();
        updateTaskList();
    }

    class AddTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Task task = view.getTaskDetails();
            if (task != null) {
                model.addTask(task);
                updateTaskList();
            }
        }
    }

    class DeleteTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String taskName = view.getSelectedTaskName();
            if (taskName != null) {
                model.deleteTask(taskName);
                updateTaskList();
            }
        }
    }

    class EditTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String oldTaskName = view.getSelectedTaskName();
            Task updatedTask = view.getTaskDetails();
            if (oldTaskName != null && updatedTask != null) {
                model.editTask(oldTaskName, updatedTask);
                updateTaskList();
            }
        }
    }

    private void updateTaskList() {
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
        view.updateNotification(taskList.toString());
    }

}
