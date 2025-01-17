import java.time.DayOfWeek;
import java.time.LocalDate;
class BasicMessage extends Message {
    LocalDate date = LocalDate.parse("2025-01-01");
    DayOfWeek dayOfWeek = date.getDayOfWeek();
    public BasicMessage() {
        message = dayOfWeek + "," + date;
    }

    public void addDay() {
        this.date = date.plusDays(1);
        this.dayOfWeek = date.getDayOfWeek();
        message = dayOfWeek + "," + date;
    }

}
