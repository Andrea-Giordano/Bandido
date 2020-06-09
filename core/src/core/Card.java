package core;

import exceptions.InvalidCardException;

/**
 * Represent an occurrence of a Bandido card.
 * Its representation is a matrix of char composed of the following chars: 0, 1, X.
 *
 * 0 - No path
 * 1 - Existing path
 * X - Closed path
 *
 * @Author: Andrea Giordano - andrea.giordano.inf@gmail.com
 */

public class Card {

    private final static int ROWS = 4;
    private final static int COLUMNS = 3;

    private char[][] matrix = new char[ROWS][COLUMNS];

    public static int getCardMaxWidth(){ return Math.max(COLUMNS, ROWS); }

    public Card(String representation) throws InvalidCardException {
        if (representation.length() != ROWS * COLUMNS){
            throw new InvalidCardException();
        }

        int counter = 0;
        for(int i=0; i<ROWS; ++i){
            for(int j=0; j<COLUMNS; ++j){
                matrix[i][j] = representation.charAt(i+j+counter);
            }
            counter = counter + COLUMNS - 1;
        }
    }

    public char[][] getCardRepresentation(){ return matrix; }

    public char[][] rotateClockWise90(){
        return null;
    }

    public char[][] rotateCounterClockWise90() {
        return null;
    }
}
