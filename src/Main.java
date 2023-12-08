import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Saves.pickSave();
        Text.intro();
    }
    private static char menuOptions() {
        return 'a';
    }

}