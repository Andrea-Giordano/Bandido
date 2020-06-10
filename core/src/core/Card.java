package core;

import exceptions.InvalidCardException;

import java.util.EnumMap;

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

    private final static int LARGE_SIDE = 4;
    private final static int SHORT_SIDE = 3;

    public static enum ORIENTATION{
        _0, _90, _180, _270,
    }

    private char[][] matrix = new char[LARGE_SIDE][SHORT_SIDE];
    private EnumMap<ORIENTATION, CardRepresentation> cardRepresentations = new EnumMap<>(ORIENTATION.class);


    public static int getCardMaxWidth(){ return Math.max(SHORT_SIDE, LARGE_SIDE); }

    public Card(String representation) throws InvalidCardException {
        cardRepresentations.put(ORIENTATION._0, new CardRepresentation(LARGE_SIDE, SHORT_SIDE, representation, ORIENTATION._0));
        cardRepresentations.put(ORIENTATION._90, new CardRepresentation(SHORT_SIDE, LARGE_SIDE, representation, ORIENTATION._90));
        cardRepresentations.put(ORIENTATION._180, new CardRepresentation(LARGE_SIDE, SHORT_SIDE, representation, ORIENTATION._180));
        cardRepresentations.put(ORIENTATION._270, new CardRepresentation(SHORT_SIDE, LARGE_SIDE, representation, ORIENTATION._270));
    }

    public CardRepresentation getCardRepresentation(ORIENTATION orientation){ return cardRepresentations.get(orientation); }


}
