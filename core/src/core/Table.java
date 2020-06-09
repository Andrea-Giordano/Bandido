package core;

/**
 * Represent the table of a Bandido match.
 * Its representation is a matrix of char.
 *
 * @Author: Andrea Giordano - andrea.giordano.inf@gmail.com
 */

public class Table {

    private final static int SIZE = Card.getCardMaxWidth() * Deck.getDeckSize();

    private char[][] table = new char[SIZE][SIZE];


    public boolean isPlaceable(Card card, int x1, int y1, int x2, int y2){
        //implement
        return false;
    }

    public Table dropOnTheTable(Card card, int x1, int y1, int x2, int y2){
        //implement
        return this;
    }
}
