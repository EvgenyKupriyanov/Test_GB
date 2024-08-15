
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Controller cont = new Controller();
            cont.run();
        } catch (IOException e) {
            System.out.println("Ошибка ввода данных");
        }
    }
}