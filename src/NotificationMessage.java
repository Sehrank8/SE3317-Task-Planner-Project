public class NotificationMessage extends MessageDecorator {
    public NotificationMessage(Message message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message.getMessage() + ",you have notification coming";
    }

    @Override
    public void addDay() {
        message.addDay();
    }
}
