////  Класс для подчета количества животных
public class Counter {
    private int num;

    public Counter (int num){
        this.num = num;
    }
    public void add(int n){
        num = n + num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
