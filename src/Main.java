import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static String gPlayerName;
    public static int gPlayerATK;
    public static int gPlayerDEF;
    public static int gPlayerHP;
    public static int gPlayerMana;
    public static void main(String[] args) throws IOException, ParseException {
        setup();
        Saves.pickSave();
        Scanner scanner = new Scanner(System.in);
        boolean lock = true;
        while (lock) {
            char response = menuOptions();
            if (response == 'P') {
                Character.loadData();
                Saves.checkSave();
                System.out.println("This is the character you will play as. Are you sure?");
                System.out.println("[Y] Yes, [N] No");
                response = yesNo();
                if (response == 'Y') {
                    lock = false;
                    battle();
                }
            }
            else if (response == 'S') {
                System.out.println("Here are your current stats!\n");
                Saves.checkSave();
                System.out.println("\n[W] Wipe Save");
                System.out.println("Press Anything Else to Continue...");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("W")) {
                    System.out.println("Do you want to wipe this save?");
                    System.out.println("[Y] Yes, [N] No");
                    response = yesNo();
                    if (response == 'Y') {
                        System.out.println("To delete your save, type in full caps \"DELETE\"");
                        System.out.println("Typing anything else will cancel this process");
                        String responseString = scanner.nextLine();
                        if (responseString.equals("DELETE")) {
                            Saves.wipeSave();
                            System.out.println("Save Successfully Wiped!");
                            System.out.println("Restart the program to play again.");
                            System.out.println("Press Enter to Continue...");
                            stall();
                            System.exit(0);
                        }
                        else {
                            System.out.println("Delete Process Terminated.");
                            System.out.println("Press Enter to Continue...");
                            stall();
                        }
                    }
                    else {
                        System.out.println("Delete Process Terminated.");
                        System.out.println("Press Enter to Continue...");
                        stall();
                    }
                }

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
    private static void battle(){
        Text.battleIntro();
        int currentStage = 1;
        int currentLevel = 1;
        int HP = Character.getPlayerHP();
        int mobDecider;
        String mobDeciderString;
        while (HP > 0) {
            if (currentLevel != 11) {
                if (currentStage == 1) {
                    Random rand = new Random();
                    mobDecider = rand.nextInt(11)+1;
                    mobDeciderString = String.valueOf(mobDecider);
                    Enemy.loadCurrentMob(mobDeciderString);

                    System.out.println("This mean's it's succeeded");
                    System.exit(0);
                }
            }
            else {
                System.out.println("Temp Boss");
            }
        }

    }
    /**Used for setting up all the things in the background*/
    private static void setup() throws IOException, ParseException {
        Enemy.createEnemies(readFile("./src/Enemy.json"));
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
    /**Only checks user inputs for yes or no and returns chars based on results.*/
    private static char yesNo() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        char choice = 'A'; // Default value

        while (!validInput) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("Y")) {
                choice = 'Y';
                validInput = true;
            } else if (input.equalsIgnoreCase("N")) {
                choice = 'N';
                validInput = true;
            } else {
                System.out.println("Please input either 'Y' or 'N'.");
            }
        }

        return choice;
    }
    /**Stall is used to create the effect of pressing return/enter for the next line :)*/
    private static void stall() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    /**General Purpose for Reading Files*/
    private static JSONArray readFile(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray data = (JSONArray) parser.parse(new FileReader(fileName));
        return data;
    }

}