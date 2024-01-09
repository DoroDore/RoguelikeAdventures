import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Enemy {
    public static Enemy gCurrentEnemy;
    static HashMap<String, Enemy> gEnemyMap = new HashMap<>();
    private final int mID;
    private final String mName;
    private final int mATK;
    private final int mDEF;
    private final int mHP;
    private final String[] mMoves;

    public Enemy(int ID, String name, int attack, int defense, int hp, String[] moves) {
        mID = ID;
        mName = name;
        mATK = attack;
        mDEF = defense;
        mHP = hp;
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
    public static void enMoveLeap() {

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
}
