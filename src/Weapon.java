import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Weapon {
    public static Weapon gCurrentWeapon;
    public final String mName;
    public final int mID;
    public final int mATK;
    public final int mDEF;
    public final int mMana;
    public final String mSkill;

    static HashMap<String, Weapon> gWeaponMap = new HashMap<>();
    public Weapon(String name, int id, int atk, int def, int mana, String skill) {
        mName = name;
        mID = id;
        mATK = atk;
        mDEF = def;
        mMana = mana;
        mSkill = skill;
    }
    private static JSONArray readFile(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray data = (JSONArray) parser.parse(new FileReader(fileName));
        return data;
    }
    public static void main(String[] args) throws IOException, ParseException {
        loadWeapons(readFile("./src/Weapons.json"));
        gCurrentWeapon = gWeaponMap.get("6");
        gCurrentWeapon.displayStats();
    }
    public static void loadWeapons(JSONArray data) {
        for (Object o : data) {
            JSONObject obj = (JSONObject) o;
            String name = (String) obj.get("Name");
            int id = ((Long) obj.get("ID")).intValue(); // Change the type to Long
            String idString = String.valueOf(obj.get("ID"));
            int atk = ((Long) obj.get("ATK")).intValue(); // Cast to Long and then convert to int
            int def = ((Long) obj.get("DEF")).intValue(); // Cast to Long and then convert to int
            int mana = ((Long) obj.get("Mana")).intValue(); // Cast to Long and then convert to int
            String skill = (String) obj.get("Skill");
            Weapon weapon = new Weapon(name, id, atk, def, mana, skill);
            gWeaponMap.put(idString, weapon);
        }
    }
    /**Displays stats of an given weapon in the console*/
    public void displayStats() {
        System.out.println("Name: " + mName);
        System.out.println("ID: " + mID);
        System.out.println("ATK: " + mATK);
        System.out.println("DEF: " + mDEF);
        System.out.println("Mana: " + mMana);
        System.out.println("Skill: " + mSkill);
    }
    //Below are all my getter methods for weapon stats.
    private String getName() {
        return mName;
    }
    private int getID() {
        return mID;
    }
    private int getATK() {
        return mATK;
    }
    private int getDEF() {
        return mDEF;
    }
    private int getMana() {
        return mMana;
    }
    private String getSkill() {
        return mSkill;
    }
}
