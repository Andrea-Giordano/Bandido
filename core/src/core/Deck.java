package core;

import exceptions.EmptyDeckException;
import exceptions.HandFullException;
import java.util.List;
import java.util.Stack;

/**
 * Represent the Bandido deck.
 * It is composed of DECK_SIZE path cards.
 *
 * @Author: Andrea Giordano - andrea.giordano.inf@gmail.com
 */

public class Deck {

    private final static int DECK_SIZE = 69;

    private Stack<Card> deck = new Stack<Card>();

    public Deck(){}

    public static int getDeckSize(){ return DECK_SIZE; }
    public List<Card> getCards(){ return deck; }


    public Hand dropHand() throws EmptyDeckException {
        if (deck.isEmpty()){
            throw new EmptyDeckException();
        }

        Hand hand = new Hand();
        for(int i=0; i<Hand.getMaxHandSize(); ++i) {
            Card card = deck.pop();
            try {
                hand.addCard(card);
            } catch (HandFullException e) {
                deck.push(card);
                break;
            }
        }

        return hand;
    }


    public Card drawCard() throws EmptyDeckException{
        if(deck.isEmpty()){
            throw new EmptyDeckException();
        }

        return deck.pop();
    }
}
