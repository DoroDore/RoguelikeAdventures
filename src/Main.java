import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
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
    public static String gStageName;
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
    private static void battle() throws IOException, ParseException {
        Text.battleIntro();
        int currentStage = 1;
        int currentLevel = 1;
        gStageName = "Elysian Meadows";
        int mobDecider;
        String mobDeciderString;
        while (Character.getPlayerHP() > 0) {
            if (currentLevel != 11) {
                if (currentStage == 1) {
                    Random rand = new Random();
                    mobDecider = rand.nextInt(11)+1;
                    mobDeciderString = String.valueOf(mobDecider);
                    Enemy.loadCurrentMob(mobDeciderString);
                }
            }
            else {
                System.out.println("Temp Boss");
            }
            combatLoop();
            generateRewards();
            stall();
        }

    }
    /**Used for when you are currently engaged in combat*/
    private static void combatLoop() throws IOException, ParseException {
        Text.encounterEnemy();
        char combatChoice;
        while (Character.getPlayerHP() > 0) {
            combatChoice = 'Z';
            Character.displayPlayerStats();
            System.out.println("------------------------------------");
            Enemy.displayEnemyStats();
            System.out.println("------------------------------------");
            while (combatChoice != 'A' && combatChoice != 'S') {
                combatChoice = combatOptions();
                if (combatChoice == 'Z') {
                    System.out.println("Please select a valid option.");
                }
            }
            // Rest of your combat logic based on the selected choice
            if (combatChoice == 'A') {
                System.out.println("You swing your [WEAPON] to attack the " + Enemy.gCurrentEnemy.getEnemyName());
                Enemy.attackEnemyNormal(Character.getPlayerATK());
                stall();
            } else if (combatChoice == 'S') {
                System.out.println("Temp SPELL");
                stall();
            }
            if (Enemy.gCurrentEnemy.getEnemyHP() <= 0) {
                Enemy.gCurrentEnemy.resetHPToOriginal();
                return;
            }
            Enemy.enemyTurn();
        }
        Text.deathDialogue();
        Saves.updateRuns();
        System.exit(0);
    }
    /**A function used for generating the random buffs that you can get, whether it be a spell, a buff, or a weapon*/
    private static void generateRewards() {
        Scanner scanner = new Scanner(System.in);
        String[] rewards = new String[3];
        String[] rewardType = new String[3];
        String[] rewardName = new String[3];
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            int type = rand.nextInt(3)+1; //1 is Buffs, 2 is Spells, 3 is Weapons.
            if (type == 1) {
                rewards[i] = Buffs.getBuff();
                rewardType[i] = "Buff";
                rewardName[i] = Buffs.getBuffName(rewards[i]);
            }
            else if (type == 2) {
                rewards[i] = "Temporary Spell Result";
                rewardType[i] = "Spell";
            }
            else {
                rewards[i] = "Temporary Weapon Result";
                rewardType[i] = "Weapon";
            }
        }
        System.out.println("Choose a reward!");
        System.out.println("[1] " + rewardName[0] + "(" + rewardType[0] + ")" + "\t[2] " + rewardName[1] + "(" + rewardType[1] + ")" + "\t[3] " + rewardName[2] + "(" + rewardType[2] + ")");
        String choice = "Z";
        choice = scanner.nextLine();
        while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2") && !Objects.equals(choice, "3")) {
            System.out.println("Please input a valid integer!");
            choice = scanner.nextLine();
        }
        claimReward(rewardType[Integer.parseInt(choice)], "1");
    }
    private static void claimReward(String type, String ID) {
        if (type.equals("Buff")) {
            System.out.println("Temporary get buff");
        }
        else if (type.equals("Weapon")) {
            System.out.println("Temporary get weapon");
        }
        else {
            System.out.println("Temporary get spell");
        }
    }
    /**Used for setting up all the things in the background*/
    private static void setup() throws IOException, ParseException {
        Enemy.createEnemies(readFile("./src/Enemy.json"));
        Buffs.loadBuffs(readFile("./src/Buffs.json"));
    }
    private static char combatOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[A] Attack, [S] Spells");
        String input = scanner.next();
        if (input.equalsIgnoreCase("A")) {
            return 'A';
        }
        else if (input.equalsIgnoreCase("S")) {
            return 'S';
        }
        else {
            System.out.println("Please input a valid character.");
            return 'Z';
        }
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
    /**Used to get the name of the stage to be called into other classes*/
    public static String getStageName() {
        return gStageName;
    }

}