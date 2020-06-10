package core;

import exceptions.InvalidCardException;

import java.awt.*;

public class CardRepresentation {

    private char[][] matrix;

    public CardRepresentation(int largeSide, int shortSide, String representation, Card.ORIENTATION orientation) throws InvalidCardException {
        if (representation.length() != largeSide * shortSide){
            throw new InvalidCardException();
        }

        matrix = new char[largeSide][shortSide];
        int counter = 0;
        for(int i=0; i<largeSide; ++i){
            for(int j=0; j<shortSide; ++j){
                matrix[i][j] = representation.charAt(i+j+counter);
            }
            counter = counter + shortSide - 1;
        }


        if (orientation == Card.ORIENTATION._90){
            matrix = rotateClockWise90();

        } else if (orientation == Card.ORIENTATION._180){
            for(int i=0; i<2; ++i){
                matrix = rotateCounterClockWise90();
            }

        } else if (orientation == Card.ORIENTATION._270){
                matrix = rotateCounterClockWise90();
        }
    }


    private char[][] rotateCounterClockWise90(){

        char[][] rotatedMatrix = new char[matrix[0].length][matrix.length];
        for(int i=0; i<matrix.length; ++i){
            for(int j=0; j<matrix[0].length; ++j){
                rotatedMatrix[j][i] = matrix[i][matrix[0].length-1-j];
            }
        }
        matrix = rotatedMatrix;

        return matrix;
    }


    private char[][] rotateClockWise90() {
        char[][] rotatedMatrix = null;

        for(int i=0; i<3; ++i){ // 3 rotations 90° counter-clockwise are equals to 1 rotation 90° clockwise
            rotatedMatrix = rotateCounterClockWise90();
        }
        matrix = rotatedMatrix;

        return matrix;
    }

}
