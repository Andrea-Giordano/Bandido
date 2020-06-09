package settings;

import core.Card;
import exceptions.InvalidCardException;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * A Parser for a text based input file.
 * The file is composed as a repetition of following pattern:
 *
 * Copies_number_of_the_following_card_string
 * Card_string
 *
 * Example:
 * 2
 * 010010010010
 * 3
 * 010110110010
 *
 * It means there are 2 cards with representational string 010010010010 and 3 cards with representational string 010110110010
 *
 * @Author: Andrea Giordano - andrea.giordano.inf@gmail.com
 */

public class LineCardParser implements CardParser {

    private Scanner scanner;


    public LineCardParser(Path filePath) {
        File file = new File(filePath.toString());
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("The file at :" + filePath.toString() + "does not exist.");
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    @Override
    public int getCopiesOfCard() {
        if (hasNextLine()){
            return Integer.parseInt(scanner.nextLine());
        }
        return 0;
    }

    @Override
    public Card getCard() {
        if (hasNextLine()){
            try {
                return new Card(scanner.nextLine());
            } catch (InvalidCardException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
                System.exit(-1);
            }
        }
        return null;
    }
}
