import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.Year;

/// Класс по работе с животным
class Function_Animal implements iAnimal {

    /// Создаем животное
    @Override
    public Animal add_animal() throws NumberYearException, NumberMonthException, NumberDayException, NumberFormatException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя животного ");
        String name = in.nextLine().toUpperCase();
        System.out.println("Введите день рождения животного ");
        String day = in.nextLine();
        controlDay(day);
        System.out.println("Введите месяц рождения животного ");
        String month = in.nextLine();
        controlMonth(month);
        System.out.println("Введите год рождения животного ");
        String year = in.nextLine();
        controlYear(year);
        System.out.println("Введите навык животного ");
        String func = in.nextLine().toUpperCase();
        List<String> func_a = new ArrayList<>();
        func_a.add(func);

        String BD = day + "-" + month + "-" + year;
        SimpleDateFormat fr = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = fr.parse(BD);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Animal new_an = new Animal(name, date, func_a);
        System.out.println("animal 1 = " +
                "name - '" + name + '\'' +
                ", BD - " + fr.format(date) +
                ", command - " + func_a +
                '}');
        return new_an;

    }

    /// Классы для контроля ввода даты рождения
    public static void controlDay(String day) throws NumberDayException {
        try {
            Integer.parseInt(day);
            if (Integer.parseInt(day) > 31) {
                throw new NumberDayException(Integer.parseInt(day));
            }
        } catch (NumberFormatException e) {
            System.out.println("День ввели не верно");
            throw new NumberFormatException();
        }
    }

    public static void controlMonth(String month) throws NumberMonthException {
        try {
            Integer.parseInt(month);
            if (Integer.parseInt(month) > 12) {
                throw new NumberMonthException(Integer.parseInt(month));
            }
        } catch (NumberFormatException e) {
            System.out.println("Месяц ввели не верно");
            throw new NumberFormatException();
        }
    }

    public static void controlYear(String year) throws NumberYearException {
        int currentYear = Year.now().getValue();
        try {
            Integer.parseInt(year);
            if (Integer.parseInt(year) > currentYear) {
                throw new NumberYearException(Integer.parseInt(year));
            }
        } catch (NumberFormatException e) {
            System.out.println("Год ввели не верно");
            throw new NumberFormatException();
        }
    }
}