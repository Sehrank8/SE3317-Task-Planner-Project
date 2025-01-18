import java.time.LocalDate;


public class BirthdayMessage extends MessageDecorator {
    private final String birthday = "2025-01-18";

    public BirthdayMessage(Message message) {
        super(message);

    }

    @Override
    public String getMessage() {
        String baseMessage = message.getMessage();
        if (LocalDate.now().toString().equals(birthday)) {
            baseMessage += ",Happy Birthday!";
        }
        return baseMessage;
    }

    @Override
    public void addDay() {
        message.addDay();
    }
}
