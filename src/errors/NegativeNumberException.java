package errors;

public class NegativeNumberException extends IllegalArgumentException{
    public NegativeNumberException(String s) {
        super(s);
    }
}
