
import java.time.DayOfWeek;
import java.time.LocalDate;

public class BasicMessage extends Message {
    private LocalDate date;

    public BasicMessage() {
        this.date = LocalDate.now();
        DayOfWeek day = date.getDayOfWeek();
        message = day + ", " + date;
    }

    @Override
    public void addDay() {
        date = date.plusDays(1);
        DayOfWeek day = date.getDayOfWeek();
        message = day + ", " + date;
    }
}
