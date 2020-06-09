package exceptions;

public class EmptyDeckException extends Exception {

    private String message = "The deck is empty! No more cards can be drawn";

    public EmptyDeckException(){
        System.err.println(message);
    }

    public String getMessage(){
        return message;
    }
}
