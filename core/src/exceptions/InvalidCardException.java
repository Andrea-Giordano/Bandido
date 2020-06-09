package exceptions;

public class InvalidCardException extends Exception {

    private String message = "Fatal error! The passed Card representational string was invalid!";

    public InvalidCardException(){
        System.err.println(message);
    }

    public String getMessage(){
        return message;
    }
}
