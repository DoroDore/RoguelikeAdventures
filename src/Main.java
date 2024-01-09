import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Saves.pickSave();
        boolean lock = true;
        while (lock) {
            char response = menuOptions();
            if (response == 'P') {
                System.out.println("Temporary Text");
            }
            else if (response == 'S') {
                System.out.println("Here are your current stats!\n");
                Saves.checkSave();
                System.out.println("W"); //Note to self, I need to add the wipe save function also
                System.out.println("\nPress Enter to Continue...");
                stall();
            }
            else if (response == 'I') {
                Text.instructions();
            }
            else if (response == 'E') {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
        }
    }
    /**This method contains the entire combat system, while calling on other helper methods*/
    private static void battle() {

    }
    /**A simple method for checking inputs and returning chars based on results.*/
    private static char menuOptions() {
        Scanner scanner = new Scanner(System.in);
        Text.intro();
        String input = scanner.next();
        if (input.equalsIgnoreCase("P")) {
            return 'P';
        }
        else if (input.equalsIgnoreCase("S")) {
            return 'S';
        }
        else if (input.equalsIgnoreCase("I")) {
            return 'I';
        }
        else if (input.equalsIgnoreCase("E")) {
            return 'E';
        }
        else {
            System.out.println("Please input a valid character.");
            return 'A';
        }
    }
    /**Stall is used to create the effect of pressing return/enter for the next line :)*/
    private static void stall() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}