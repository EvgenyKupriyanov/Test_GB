import java.io.IOException;
import java.util.*;

public class Controller {

    public void run() throws IOException, NumberYearException, NumberMonthException, NumberDayException {
        List<Reestr> list = new ArrayList<>();
        Counter total = new Counter(0);


        boolean getNewIteration = true;
        while (getNewIteration) {
            Scanner in = new Scanner(System.in);
            System.out.println("Выберете команду:" + '\n' +
                    "Добавить животное - ADD" + '\n' +
                    "Показать команды - SHOW" + '\n' +
                    "Показать список животных - LIST" + '\n' +
                    "Обучить животное новой команде - TEACH" + '\n' +
                    "Показать количество животных - COUNT" + '\n' +
                    "Показать список животных по году рождения - BD" + '\n' +
                    "Выход - EXIT" + '\n' + '\n' +
                    "Введите команду:"
            );
            String command = in.nextLine().toUpperCase();

            if (command.equals("EXIT")) {
                getNewIteration = false;
                System.out.println("Выход из программы!");
                break;
            }
            if (command.equals("ADD")) {
                getNewIteration = true;
                Function_Animal animal = new Function_Animal();
                int count = 0;
                System.out.println("Введите тип животного ");
                String type = in.nextLine().toUpperCase();
                try {
                    if (list.isEmpty()) {
                        List<Animal> n = new ArrayList<>();
                        n.add(animal.add_animal());
                        Reestr reestr = new Reestr(type, n);
                        list.add(reestr);
                    }
                    else{
                        for (int i = 0; i < list.size(); i++) {

                            if (list.get(i).getType().equals(type)) {
                                list.get(i).getList().add(animal.add_animal());
                            } else {
                                count++;
                            }
                        }
                        if(count == list.size()){
                            List<Animal> n_1 = new ArrayList<>();
                            n_1.add(animal.add_animal());
                            Reestr reestr = new Reestr(type, n_1);
                            list.add(reestr);
                        }
                    }
                    System.out.println("В реестр добавлено животное");
                    total.add(1);
                }
                catch (NumberFormatException ignored) {
                }
            }
            if (command.equals("SHOW")) {
                getNewIteration = true;
                Scanner in1 = new Scanner(System.in);
                System.out.println("Введите имя животного ");
                String name = in1.nextLine().toUpperCase();
                for (Reestr reestr : list) {
                    reestr.list_command(name);
                }
            }
            if (command.equals("LIST")) {
                getNewIteration = true;
                if(list.isEmpty()){
                    System.out.println("Список пуст");
                }
                for(Reestr i : list) {
                    System.out.println("Класс - " + i.getType());
                    for (int j = 0; j < i.getList().size(); j++) {
                        System.out.println(i.getList().get(j).toString());
                    }
                }
            }
            if (command.equals("TEACH")) {
                getNewIteration = true;
                int count = 0;
                Scanner in1 = new Scanner(System.in);
                System.out.println("Введите тип животного ");
                String type = in1.nextLine().toUpperCase();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getType().equals(type)) {
                        Scanner in2 = new Scanner(System.in);
                        System.out.println("Введите имя животного ");
                        String name = in2.nextLine().toUpperCase();
                        list.get(i).add_command(name);
                    }
                    if (!list.get(i).getType().equals(type)) {
                        count++;
                    }
                }
                if (list.size() == count) {
                    System.out.println("Нет такого типа животного");
                }
            }
            if (command.equals("COUNT")) {
                getNewIteration = true;
                System.out.println("Общее количество животных - " + total);
            }
            if (command.equals("BD")) {
                getNewIteration = true;
                Scanner in1 = new Scanner(System.in);
                System.out.println("Введите год рождения животного ");
                int year = in1.nextInt();
                System.out.println("Список имен:");
                int count = 0;
                for (Reestr reestr : list) {
                    reestr.list_BD(year);
                    count = count + reestr.list_BD_count(year);
                }
                if(count == 0){
                    System.out.println("пусто");
                }
            }

        }
    }
}
