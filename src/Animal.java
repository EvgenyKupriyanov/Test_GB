import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/// Класс для создания животных
public class Animal {

    private String name;
    private List<String> command;
    private Date date;

    public Animal(String name, Date date, List<String> command) {
        this.name = name;
        this.date = date;
        this.command = command;
    }

    public String getName() {
        return name;
    } /// Получаем имя животного

    public List<String> getCommand() {
        return command;
    } /// Получаем команды которое животное умеет

    public int getBD() { return date.getYear();} /// Получаем год рождения животного


    @Override
    public String toString() {
        SimpleDateFormat fr = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        return "Имя - " + name + ", дата рождения - " + fr.format(date) +
                ", комннады - " + command;
    }
}