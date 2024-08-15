import java.text.SimpleDateFormat;
import java.util.*;


/// Создаем реестр для каждого вида животного, куда входит тип и само животное
public class Reestr {
    private String type;
    private List<Animal> animal_list;

    public Reestr(String type, List<Animal> animal_list) {
        this.type = type;
        this.animal_list = animal_list;
    }
    /// Получаем тип животного
    public String getType() {
        return type;
    }
    /// Получаем список всех живтных одного типа
    public List<Animal> getList() {
        return animal_list;
    }
    /// Получаем список команд животного
    public void list_command(String name) {
        for (int i = 0; i < animal_list.size(); i++) {
            if (animal_list.get(i).getName().equals(name)) {
                System.out.println("Список команд - " + animal_list.get(i).getCommand());
                ;
            }
        }
    }
    /// Обучаем животное новым командам
    public void add_command(String name) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < animal_list.size(); i++) {
            if (animal_list.get(i).getName().equals(name)) {
                System.out.println("Введите новую команду ");
                String new_cmd = in.nextLine().toUpperCase();
                animal_list.get(i).getCommand().add(new_cmd);
                System.out.println("Новый список команд - " + animal_list.get(i).getCommand());
            }
            if (!animal_list.get(i).getName().equals(name)) {
                count++;
            }
        }
        if (animal_list.size() == count) {
            System.out.println("Нет такого животного");
        }
    }
    /// Получаем список животных по году рождения.
    public void list_BD(int year) {
        for (int i = 0; i < animal_list.size(); i++) {
            int BD = animal_list.get(i).getBD() + 1900;
            if (BD == year) {
                System.out.println(animal_list.get(i).getName());
            }
        }
    }
    /// Ввел счечик для того, чтоб определить налчие животных нужного года
    public int list_BD_count(int year) {
        int count = 0;
        for (int i = 0; i < animal_list.size(); i++) {
            int BD = animal_list.get(i).getBD() + 1900;
            if (BD == year) {
                count++;
            }
        }
        return count;
    }

    public String toString() {
        SimpleDateFormat fr = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        return "Класс - " + type + "      " + animal_list;
    }
}

