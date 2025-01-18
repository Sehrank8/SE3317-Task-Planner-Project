import java.time.LocalDate;


public class BirthdayMessage extends MessageDecorator {

    public BirthdayMessage(Message message) {
        super(message);

    }
    @Override
    public String getMessage() {
        return message.getMessage();
    }

    @Override
    public void addDay() {
        message.addDay();
    }
}
