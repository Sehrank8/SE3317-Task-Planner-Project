public class NotificationMessage extends MessageDecorator {
    Message message;

    public NotificationMessage(Message message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message.getMessage() + " notification";
    }

    @Override
    public void addDay() {
        message.addDay();
    }
}
