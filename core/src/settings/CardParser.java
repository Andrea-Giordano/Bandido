package settings;

import core.Card;

import java.nio.file.Path;

/**
 * A Parser to return the Bandido cards
 *
 * @Author: Andrea Giordano - andrea.giordano.inf@gmail.com
 */

public interface CardParser {

    static CardParser getCardParser(Path filePath){
        return new LineCardParser(filePath);
    }

    int getCopiesOfCard();
    Card getCard();
    boolean hasNextLine();
}
