import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    ArrayList<Task> TaskList = new ArrayList<>();


    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks";
        try (Connection connection =  DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)){
            while (rs.next()) {
                
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void addTask(String name,String description, String category, String deadline) {
        String query = "INSERT INTO TASKS" + "(task_name, description, category, deadline) values(" +
                name + description + category + deadline + ")";
    }

    public void removeTask() {

    }


}
