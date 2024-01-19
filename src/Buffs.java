import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class Buffs {
    public static Buffs gCurrentBuff;
    static HashMap<String, Buffs> gBuffMap = new HashMap<>();
    private final String mName;
    private final long mID;

    public Buffs(String name, long id) {
        mName = name;
        mID = id;
    }
    public String getBuffName() {
        return mName;
    }

    public long getBuffID() {
        return mID;
    }

    private static JSONArray readFile() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray data = (JSONArray) parser.parse(new FileReader("./src/Buffs.json"));
        return data;
    }

    public static void loadBuffs(JSONArray data) {
        for (Object o : data) {
            JSONObject obj = (JSONObject) o;
            String name = (String) obj.get("Name");
            long id = (long) obj.get("ID");
            String idString = String.valueOf(obj.get("ID"));
            Buffs buff = new Buffs(name, id);
            gBuffMap.put(idString, buff);
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        loadBuffs(readFile());
        gCurrentBuff = gBuffMap.get("13");
        System.out.println(gCurrentBuff.getBuffName());
        System.out.println(gCurrentBuff.getBuffID());
    }
    public static String getBuff() {
        Random rand = new Random();
        int picked = rand.nextInt(20)+1;
        System.out.println(picked);
        gCurrentBuff = gBuffMap.get(String.valueOf(picked));
        return gCurrentBuff.mName;
    }
    public static int getBuffID(String buffName) {
        gCurrentBuff = gBuffMap.get(buffName);
        return (int) gCurrentBuff.mID;
    }
}