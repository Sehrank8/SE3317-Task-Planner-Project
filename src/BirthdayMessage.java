import java.time.LocalDate;


public class BirthdayMessage extends MessageDecorator {
    private final String birthday;

    public BirthdayMessage(Message message, String birthday) {
        super(message);
        this.birthday = birthday;
    }

    @Override
    public String getMessage() {
        String baseMessage = message.getMessage();
        if (LocalDate.now().toString().equals(birthday)) {
            baseMessage += " - Happy Birthday!";
        }
        return baseMessage;
    }

    @Override
    public void addDay() {
        message.addDay();
    }
}
