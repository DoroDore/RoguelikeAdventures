public class Character {
    public static String gPlayerName;
    public static int gPlayerATK;
    public static int gPlayerDEF;
    public static int gPlayerHP;
    public static int gPlayerMana;
    private static void loadData() {
        gPlayerName = Saves.getFileName();
        gPlayerATK = Saves.getATK();
        gPlayerDEF = Saves.getDEF();
        gPlayerHP = Saves.getHP();
        gPlayerMana = Saves.getMana();
    }
}
