import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private final NotificationCenter notificationCenter;

    public Model(NotificationCenter notificationCenter) {
        this.notificationCenter = notificationCenter;
    }

    public void addTask(Task task) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO tasks (task_name, description, category, deadline) VALUES (?, ?, ?, ?)")) {
            pstmt.setString(1, task.getName());
            pstmt.setString(2, task.getDescription());
            pstmt.setString(3, task.getCategory());
            pstmt.setString(4, task.getDeadline());
            pstmt.executeUpdate();
            notificationCenter.setNotification("Task added: " + task.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(String taskName) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM tasks WHERE task_name = ?")) {
            pstmt.setString(1, taskName);
            pstmt.executeUpdate();
            notificationCenter.setNotification("Task deleted: " + taskName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editTask(String oldName, String newName) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("UPDATE tasks SET name = ? WHERE name = ?")) {
            pstmt.setString(1, newName);
            pstmt.setString(2, oldName);
            pstmt.executeUpdate();
            notificationCenter.setNotification("Task edited: " + oldName + " -> " + newName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tasks")) {
            while (rs.next()) {
                tasks.add(new Task(
                        rs.getString("task_name"),
                        rs.getString("description"),
                        rs.getString("category"),
                        rs.getString("deadline")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}


