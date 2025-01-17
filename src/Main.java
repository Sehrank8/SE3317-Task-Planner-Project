public class Main {
    public static void main(String[] args) {
        //TaskView taskView = new TaskView();
        Message basicmessage = new BasicMessage();
        Message birthday = new BirthdayMessage(basicmessage);
        Message notification = new NotificationMessage(birthday);
        System.out.println(notification.getMessage());
        notification.addDay();
        System.out.println(notification.getMessage());
    }
}