import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
public class Saves {
    static String fileName;
    static long runs;
    static long bestRun;
    static long ATK;
    static long DEF;
    static long HP;
    static long Mana;
    public static void pickSave() throws IOException, ParseException {
        System.out.println("Which save would you like to enter?");
        System.out.println("[1] File 1\t[2] File 2\t[3] File 3");
        Scanner scanner = new Scanner(System.in);
        boolean yesNo = false;
        int choice = 0;
        while (!(choice == 1 || choice == 2 || choice == 3)) {
            try {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2 || choice == 3) {
                    System.out.println("File Loading Success!");
                }
            }
            catch (InputMismatchException e) {

            }
            System.out.println("Invalid input. Please enter a valid integer");
            scanner.nextLine();
        }
        loadData(readFile(), choice);
    }
    private static JSONArray readFile() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray data = (JSONArray) parser.parse(new FileReader("./src/Save.json"));
        return data;

    }
    private static void loadData(JSONArray data, int fileNo) { //Note to self, I need to find a way for the player to start new saves in unused save slots
        JSONObject obj = (JSONObject) data.get(fileNo-1);
        fileName = (String) obj.get("Name");
        runs = (long) obj.get("Runs");
        bestRun = (long) obj.get("Best Run");
        ATK = (long) obj.get("ATK");
        DEF = (long) obj.get("DEF");
        HP = (long) obj.get("HP");
        Mana = (long) obj.get("Mana");
        System.out.println(fileName);
        System.out.println(runs);
        System.out.println(bestRun);
        System.out.println(ATK);
        System.out.println(DEF);
        System.out.println(HP);
        System.out.println(Mana);
    }
    public static void checkSave() {
        System.out.println("File Name: " + fileName);
        System.out.println("Runs: " + runs);
        System.out.println("Best Run: " + bestRun);
        System.out.println("Base ATK: " + ATK);
        System.out.println("Base DEF: " + DEF);
        System.out.println("Base HP: " + HP);
        System.out.println("Base Mana: " + Mana);
    }
    public static String getFileName() {
        return fileName;
    }
    public static int getRuns() {
        return (int) runs;
    }
    public static int getBestRun() {
        return (int) bestRun;
    }
    public static int getATK() {
        return (int) ATK;
    }
    public static int getDEF() {
        return (int) DEF;
    }
}
