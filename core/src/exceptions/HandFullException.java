package exceptions;

import core.Hand;

public class HandFullException extends Exception {

    private String message = "The hand is already full. It can be composed of max " + Hand.getMaxHandSize() + " cards.";

    public HandFullException(){
        System.err.println(message);
    }

    public String getMessage(){
        return message;
    }
}
