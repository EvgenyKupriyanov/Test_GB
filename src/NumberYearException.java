public class NumberYearException extends NumberFormatException {
    public NumberYearException (int date){
        super(String.format("Введен не правильно год [%d]", date));
    }
}
