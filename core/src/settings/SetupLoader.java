package settings;

import core.Card;
import core.StarterCard;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * It is a tool to load the Bandido cards, their scanned pictures and other game settings.
 * It sets up a game.
 *
 * @Author: Andrea Giordano - andrea.giordano.inf@gmail.com
 */

public class SetupLoader {

    private static Path resourcesPath = Paths.get("..", "..", "resources");
    private static Path cardListPath = Paths.get(resourcesPath.toString(),"cards", "BandidoCardsList");

    private int players;
    private Difficulty difficulty;
    private Set<Card> cardSet = new HashSet<Card>();

    public SetupLoader(int players, Difficulty difficulty){
        this.players = players;
        this.difficulty = difficulty;
    }

    public Set<Card> loadAndGetCards(){

        CardParser parser = CardParser.getCardParser(cardListPath);
        while (!parser.hasNextLine()){
            for (int i=0; i<parser.getCopiesOfCard(); ++i){
                cardSet.add(parser.getCard());
            }
        }

        return new HashSet<>(cardSet);
    }

    public int getNumberOfPlayers(){ return players; }

    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    public Card getStarterCard(){
        return StarterCard.getStarterCard(difficulty);
    }

    public static enum Difficulty {
        EASY,
        DIFFICULT,
    }
}
