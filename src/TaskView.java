import javax.swing.*;
import java.awt.*;

public class TaskView extends JFrame implements Observer{

    public TaskView() {

        setTitle("Birthday Task Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());


        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel dayLabel = new JLabel("Day:");
        JTextField dayField = new JTextField();

        JLabel dateLabel = new JLabel("Date:");
        JTextField dateField = new JTextField();

        JLabel birthdayLabel = new JLabel("Birthday Celebration Message:");
        JTextField birthdayField = new JTextField();

        topPanel.add(dayLabel);
        topPanel.add(dayField);
        topPanel.add(dateLabel);
        topPanel.add(dateField);
        topPanel.add(birthdayLabel);
        topPanel.add(birthdayField);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2, 10, 10));


        JPanel notificationsPanel = new JPanel();
        notificationsPanel.setLayout(new BorderLayout());

        JLabel notificationsLabel = new JLabel("Notifications");
        JTextArea notificationsArea = new JTextArea();
        notificationsArea.setEditable(false);

        notificationsPanel.add(notificationsLabel, BorderLayout.NORTH);
        notificationsPanel.add(new JScrollPane(notificationsArea), BorderLayout.CENTER);


        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BorderLayout());

        JLabel taskLabel = new JLabel("Task List");
        JPanel taskButtonsPanel = new JPanel();
        taskButtonsPanel.setLayout(new FlowLayout());

        JButton addTaskButton = new JButton("+");
        JButton deleteTaskButton = new JButton("-");
        JButton editTaskButton = new JButton("✎");

        taskButtonsPanel.add(addTaskButton);
        taskButtonsPanel.add(deleteTaskButton);
        taskButtonsPanel.add(editTaskButton);

        JTextArea taskListArea = new JTextArea();
        taskListArea.setEditable(false);

        taskPanel.add(taskLabel, BorderLayout.NORTH);
        taskPanel.add(taskButtonsPanel, BorderLayout.SOUTH);
        taskPanel.add(new JScrollPane(taskListArea), BorderLayout.CENTER);

        bottomPanel.add(notificationsPanel);
        bottomPanel.add(taskPanel);


        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.CENTER);


        setVisible(true);
    }

    @Override
    public void updateNotification() {

    }
}