public class BirthdayMessage extends MessageDecorator{
    Message message;

    public BirthdayMessage(Message message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message.getMessage() + " Happy Birthday User!!";
    }

    @Override
    public void addDay() {
        message.addDay();
    }
}
