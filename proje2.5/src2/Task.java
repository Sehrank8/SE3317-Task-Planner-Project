public class Task {
    private String name;
    private String description;
    private String category;
    private String deadline;

    public Task(String name, String description, String category, String deadline) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.deadline = deadline;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getDeadline() {
        return deadline;
    }
}
