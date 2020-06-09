package core;

import exceptions.InvalidCardException;
import settings.SetupLoader;

/**
 * Represent an occurrence of a Starter Bandido card.
 * Its representation is a matrix of char composed of the following chars: 0, 1
 *
 * 0 - No path
 * 1 - Existing path
 *
 * @Author: Andrea Giordano - andrea.giordano.inf@gmail.com
 */

public class StarterCard {

    public static Card getStarterCard(SetupLoader.Difficulty difficulty) {
        try {
            if (difficulty.equals(SetupLoader.Difficulty.EASY)) {
                return new Card("000111111000"); // it presents 4 exit paths
            }
            return new Card("010111111010"); // it presents 6 exit paths
        } catch (InvalidCardException e) {
            e.printStackTrace();
            return null;
        }
    }
}
