import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Enemy {
    public static Enemy gCurrentEnemy;
    static HashMap<String, Enemy> gEnemyMap = new HashMap<>();
    private int mID;
    private String mName;
    private int mATK;
    private int mDEF;
    private int mHP;
    private int mOriginalHP; // New variable to store original HP
    private String[] mMoves;

    public Enemy(int ID, String name, int attack, int defense, int hp, String[] moves) {
        mID = ID;
        mName = name;
        mATK = attack;
        mDEF = defense;
        mHP = hp;
        mOriginalHP = hp; // Store original HP when creating an instance
        mMoves = moves;
    }
    /**Reads the specific file "Enemy.json" and returns that data*/
    private static JSONArray readFile() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray data = (JSONArray) parser.parse(new FileReader("./src/Enemy.json"));
        return data;
    }
    /**Takes data from the readFile function and stores it into the gEnemyMap hashmap*/
    public static void createEnemies(JSONArray data) {
        for (Object o : data) {
            JSONObject obj = (JSONObject) o;
            int id = ((Long) obj.get("ID")).intValue();
            String name = (String) obj.get("Name");
            int attack = ((Long) obj.get("ATK")).intValue();
            int defense = ((Long) obj.get("DEF")).intValue();
            int hp = ((Long) obj.get("HP")).intValue();
            JSONArray movesArray = (JSONArray) obj.get("Moves");
            String[] moves = new String[movesArray.size()];
            for (int i = 0; i < movesArray.size(); i++) {
                moves[i] = (String) movesArray.get(i);
            }
            Enemy enemy = new Enemy(id, name, attack, defense, hp, moves);
            gEnemyMap.put(String.valueOf(id), enemy);
        }
    }
    /**Load mob data into the current slot*/
    public static void loadCurrentMob(String mobID) {
        gCurrentEnemy = gEnemyMap.get(mobID);
    }
    /**getMobData is used to check the data of individual mobs by identifying them by their ID code.*/
    public static void getMobData(String mobID) {
        gCurrentEnemy = gEnemyMap.get(mobID);
        System.out.println("Enemy ID: " + gCurrentEnemy.getEnemyID());
        System.out.println("Enemy Name: " + gCurrentEnemy.getEnemyName());
        System.out.println("Enemy Attack: " + gCurrentEnemy.getEnemyATK());
        System.out.println("Enemy Defense: " + gCurrentEnemy.getEnemyDEF());
        System.out.println("Enemy HP: " + gCurrentEnemy.getEnemyHP());
        String[] tempMoves = gCurrentEnemy.getEnemyMoves();
        System.out.println("Enemy Move 1: " + tempMoves[0]);
        System.out.println("Enemy Move 2: " + tempMoves[1]);
    }
    public static void main(String[] args) throws IOException, ParseException {
        createEnemies(readFile());
        getMobData("1");
    }
    public static void displayEnemyStats() {
        System.out.println("Enemy: " + gCurrentEnemy.mName + "\tEnemy HP: " + gCurrentEnemy.mHP);
        System.out.println("ATK: " + gCurrentEnemy.mATK + "\tDEF: " + gCurrentEnemy.mDEF);
    }
    public static void attackEnemyNormal(int damage) {
        if (gCurrentEnemy.mDEF >= damage) {
            System.out.println("The " + gCurrentEnemy.mName + " took no damage!");
        }
        else {
            System.out.println("The " + gCurrentEnemy.mName + " took " + (damage-gCurrentEnemy.mDEF) + " damage!");
            gCurrentEnemy.mHP -= damage-gCurrentEnemy.getEnemyDEF();
        }

    }
    public static void enemyTurn() {
        Random rand = new Random();
        int attackChoice = rand.nextInt(10)+1;
        if (attackChoice <=5) {
            System.out.println("The " + gCurrentEnemy.mName + " attacks!");
            if (gCurrentEnemy.mATK <= Character.getPlayerDEF()) {
                System.out.println("You took no damage!");
            }
            else {
                System.out.println("You took " + (gCurrentEnemy.mATK-Character.getPlayerDEF()) + " damage!");
                Character.playerDamage(gCurrentEnemy.mATK-Character.getPlayerDEF());
            }
            stall();
        }
        else if (attackChoice >= 6 && attackChoice <= 8) {
            callMove(0);
        }
        else {
            callMove(1);
        }
    }
    /**Used for calling on the method that executes code for a specific move*/
    private static void callMove(int num) {
        String firstMove = gCurrentEnemy.getEnemyMoves()[num];
        switch (firstMove) {
            case "Leap":
                enMoveLeap();
                break;
            case "Reformat":
                enMoveReformat();
                break;
            case "Heavy Slam":
                enMoveHeavySlam();
                break;
            case "Rage":
                enMoveRage();
                break;
            case "Bulldoze":
                enMoveBulldoze();
                break;
            case "Glitch":
                enMoveGlitch();
                break;
            case "Gust":
                enMoveGust();
                break;
            case "Shatter Shot":
                enMoveShatterShot();
                break;
            case "Natural Cure":
                enMoveNaturalCure();
                break;
            case "Control":
                enMoveControl();
                break;
            case "Wooden Strike":
                enMoveWoodenStrike();
                break;
            case "Banana Storm":
                enMoveBananaStorm();
                break;
            case "Banana Blast":
                enMoveBananaBlast();
                break;
            case "Thunderbolt":
                enMoveThunderbolt();
                break;
            case "Soak":
                enMoveSoak();
                break;
            default:
                // Handle the case when the move is not recognized
                System.out.println("Invalid move: " + firstMove);
                break;
        }
    }
    public int getEnemyID() {
        return mID;
    }
    public String getEnemyName() {
        return mName;
    }
    public int getEnemyATK() {
        return mATK;
    }
    public int getEnemyDEF() {
        return mDEF;
    }
    public int getEnemyHP() {
        return mHP;
    }
    public String[] getEnemyMoves() {
        return mMoves;
    }
    public void resetHPToOriginal() {
        mHP = mOriginalHP; // Reset HP to original value
    }
    private static String doesDamage(int incomingDamage, int damageMit) {
        if (incomingDamage <= damageMit) {
            return "no";
        }
        return String.valueOf(incomingDamage-damageMit);
    }
    private static int damageCalc(int incomingDamage, int damageMit) {
        return incomingDamage-damageMit;
    }
    public static void enMoveLeap() {
        System.out.println("The " + gCurrentEnemy.mName + " leaps into the air!");
        System.out.println("The enemy slams down on you, dealing " + doesDamage(gCurrentEnemy.getEnemyATK()*2, Character.getPlayerDEF()) + " damage!");
        Character.playerDamage(damageCalc(gCurrentEnemy.getEnemyATK()*2, Character.getPlayerDEF()));
    }
    public static void enMoveReformat() {

    }
    public static void enMoveHeavySlam() {

    }
    public static void enMoveRage() {

    }
    public static void enMoveBulldoze() {

    }
    public static void enMoveGlitch() {

    }
    public static void enMoveGust() {

    }
    public static void enMoveShatterShot() {

    }
    public static void enMoveNaturalCure() {

    }
    public static void enMoveControl() {

    }
    public static void enMoveWoodenStrike() {

    }
    public static void enMoveBananaStorm() {

    }
    public static void enMoveBananaBlast() {

    }
    public static void enMoveThunderbolt() {

    }
    public static void enMoveSoak() {

    }
    private static void stall() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
