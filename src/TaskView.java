import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Objects;

public class TaskView extends JFrame implements Observer {

    private JLabel dayLabel, dateLabel, birthdayLabel;
    private JTextArea notificationsArea, taskListArea;
    private JButton addTaskButton, deleteTaskButton, editTaskButton;

    private Message message;

    public TaskView() {
        setTitle("Task Planner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());


        message = new BasicMessage();
        message = new BirthdayMessage(message);
        message = new NotificationMessage(message);


        JPanel topPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        dayLabel = new JLabel();
        dateLabel = new JLabel();
        birthdayLabel = new JLabel();

        updateMessageLabels();

        topPanel.add(new JLabel("Day:"));
        topPanel.add(dayLabel);
        topPanel.add(new JLabel("Date:"));
        topPanel.add(dateLabel);
        topPanel.add(new JLabel("Birthday Celebration Message:"));
        topPanel.add(birthdayLabel);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 10, 10));


        JPanel notificationsPanel = new JPanel(new BorderLayout());
        notificationsPanel.setBorder(BorderFactory.createTitledBorder("Notifications"));
        notificationsArea = new JTextArea();
        notificationsArea.setEditable(false);
        notificationsPanel.add(new JScrollPane(notificationsArea), BorderLayout.CENTER);


        JPanel taskPanel = new JPanel(new BorderLayout());
        taskPanel.setBorder(BorderFactory.createTitledBorder("Task List"));
        taskListArea = new JTextArea();
        taskListArea.setEditable(false);
        taskPanel.add(new JScrollPane(taskListArea), BorderLayout.CENTER);


        JPanel taskButtonsPanel = new JPanel(new FlowLayout());
        addTaskButton = new JButton("+");
        deleteTaskButton = new JButton("-");
        editTaskButton = new JButton("✎");
        taskButtonsPanel.add(addTaskButton);
        taskButtonsPanel.add(deleteTaskButton);
        taskButtonsPanel.add(editTaskButton);

        taskPanel.add(taskButtonsPanel, BorderLayout.SOUTH);

        bottomPanel.add(notificationsPanel);
        bottomPanel.add(taskPanel);

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    private void updateMessageLabels() {
        // decorator chain
        String[] messages = message.getMessage().split(",");
        if (messages.length >= 2) {
            dayLabel.setText(messages[0].trim());
            dateLabel.setText(messages[1].trim());
        }
        if (messages.length >= 3) {
            birthdayLabel.setText(messages[2].trim());
        } else {
            birthdayLabel.setText(""); // Eğer doğum günü mesajı yoksa temizle
        }
    }
    public void updateDayAndDate() {
        message.addDay();
        updateMessageLabels();
    }

    public void displayBirthdayMessage(String message) {
        birthdayLabel.setText(message);
    }

    public void clearBirthdayMessage() {
        birthdayLabel.setText("");
    }

    public Task getTaskDetails() {
        String name = JOptionPane.showInputDialog("Enter Task Name:");
        String description = JOptionPane.showInputDialog("Enter Task Description:");
        String category = JOptionPane.showInputDialog("Enter Task Category:");
        String deadline = JOptionPane.showInputDialog("Enter Task Deadline (YYYY-MM-DD):");

        return new Task(name, description, category, deadline);
    }


    public String getSelectedTaskName() {
        return JOptionPane.showInputDialog("Enter the name of the task to delete or edit:");
    }



    @Override
    public void updateNotification(String message,String msg) {
//        notificationsArea.append(message + "\n");
        updateTaskList(message);
        if (!Objects.equals(msg, "\n")) {
            updateNotificationsList(this.message.getMessage() + msg);
        }
    }
    private void updateNotificationsList(String tasks) {
        notificationsArea.append(tasks);
    }



    private void updateTaskList(String tasks) {
        taskListArea.setText(tasks);
    }


    public void addAddTaskListener(ActionListener listener) {
        addTaskButton.addActionListener(listener);
    }

    public void addDeleteTaskListener(ActionListener listener) {
        deleteTaskButton.addActionListener(listener);
    }

    public void addEditTaskListener(ActionListener listener) {
        editTaskButton.addActionListener(listener);
}
}