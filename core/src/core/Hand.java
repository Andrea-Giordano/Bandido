package core;

import exceptions.HandFullException;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent an occurrence of the Hand of a user in a match.
 * An Hand is composed of a set of HAND_SIZE cards.
 *
 * @Author: Andrea Giordano - andrea.giordano.inf@gmail.com
 */

public class Hand {

    private final static int HAND_SIZE = 3;

    private List<Card> cards = new ArrayList<Card>();

    public Hand(){}

    public static int getMaxHandSize(){ return HAND_SIZE; }

    public List<Card> getCards(){ return cards; }


    public Hand addCard(Card card) throws HandFullException {
        if (cards.size() == HAND_SIZE){
            throw new HandFullException();
        }
        cards.add(card);

        return this;
    }

    public Card getCard(int index){
        return cards.get(index);
    }

}
