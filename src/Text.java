import java.util.Scanner;

public class Text {
    public static void intro(){
        System.out.println("▄▄▄▄▄▄   ▄▄▄▄▄▄▄ ▄▄▄▄▄▄▄ ▄▄   ▄▄ ▄▄▄▄▄▄▄ ▄▄▄     ▄▄▄ ▄▄▄   ▄ ▄▄▄▄▄▄▄    ▄▄▄▄▄▄▄ ▄▄▄▄▄▄  ▄▄   ▄▄ ▄▄▄▄▄▄▄ ▄▄    ▄ ▄▄▄▄▄▄▄ ▄▄   ▄▄ ▄▄▄▄▄▄   ▄▄▄▄▄▄▄ ▄▄▄▄▄▄▄ ");
        System.out.println("█   ▄  █ █       █       █  █ █  █       █   █   █   █   █ █ █       █  █       █      ██  █ █  █       █  █  █ █       █  █ █  █   ▄  █ █       █       █");
        System.out.println("█  █ █ █ █   ▄   █   ▄▄▄▄█  █ █  █    ▄▄▄█   █   █   █   █▄█ █    ▄▄▄█  █   ▄   █  ▄    █  █▄█  █    ▄▄▄█   █▄█ █▄     ▄█  █ █  █  █ █ █ █    ▄▄▄█  ▄▄▄▄▄█");
        System.out.println("█   █▄▄█▄█  █ █  █  █  ▄▄█  █▄█  █   █▄▄▄█   █   █   █      ▄█   █▄▄▄   █  █▄█  █ █ █   █       █   █▄▄▄█       █ █   █ █  █▄█  █   █▄▄█▄█   █▄▄▄█ █▄▄▄▄▄");
        System.out.println("█    ▄▄  █  █▄█  █  █ █  █       █    ▄▄▄█   █▄▄▄█   █     █▄█    ▄▄▄█  █       █ █▄█   █       █    ▄▄▄█  ▄    █ █   █ █       █    ▄▄  █    ▄▄▄█▄▄▄▄▄  █");
        System.out.println("█   █  █ █       █  █▄▄█ █       █   █▄▄▄█       █   █    ▄  █   █▄▄▄   █   ▄   █       ██     ██   █▄▄▄█ █ █   █ █   █ █       █   █  █ █   █▄▄▄ ▄▄▄▄▄█ █");
        System.out.println("█▄▄▄█  █▄█▄▄▄▄▄▄▄█▄▄▄▄▄▄▄█▄▄▄▄▄▄▄█▄▄▄▄▄▄▄█▄▄▄▄▄▄▄█▄▄▄█▄▄▄█ █▄█▄▄▄▄▄▄▄█  █▄▄█ █▄▄█▄▄▄▄▄▄█  █▄▄▄█ █▄▄▄▄▄▄▄█▄█  █▄▄█ █▄▄▄█ █▄▄▄▄▄▄▄█▄▄▄█  █▄█▄▄▄▄▄▄▄█▄▄▄▄▄▄▄█");
        System.out.println("\n\nWelcome to Roguelike Adventures! What would you like to do?");
        System.out.println("[P] Start");
        System.out.println("[S] Stats");
        System.out.println("[I] Instructions");
        System.out.println("[E] End Game");
    }
    public static void instructions() {
        System.out.println("Roguelike Adventures is a roguelike game based off the original hit scratch game \"Roguelike Adventures\".");
        stall();
        System.out.println("In this game, the goal is to get through three different stages to defeat the final boss, each stage being separated into different battles.");
        stall();
        System.out.println("Similar to traditional Roguelike, buffs will also be obtainable at the end of each battle.");
        stall();
        System.out.println("These buffs may include weapons, spells, or stat buffs that last throughout the round.");
        stall();
        System.out.println("Spells have a more unique concept, and fit into certain spell slots, ranging from 1 to 4.");
        stall();
        System.out.println("Spell slots 1 and 2 are for spells obtainable after defeating enemies, which spell slot 3 is dedicated to specific weapons, and slot 4 being dedicated to powerful \"Soulspells\"");
        stall();
        System.out.println("Play the game to discover unique builds and synergies!");
        stall();
        System.out.println("However, if your HP reaches zero, all your progress will be reset back to square one.");
        stall();
        System.out.println("However, that doesn't mean all hope is lost. At the end of each round, permanent buffs will be added to your character, allowing for better runs in the future.");
        stall();
        System.out.println("Over multiple runs, you'll encounter all kinds of different enemies, each with their own mechanics, ensuring that each replay is different. Good luck!");
        stall();
    }
    public static void battleIntro() {
        System.out.println("When you open your eyes, you're standing in an expansive grass field.");
        stall();
        System.out.println("As you stand there, breeze blowing gently against your body, you try to recall your past.");
        stall();
        System.out.println("You can't recall anything.");
        stall();
        System.out.println("If there's one thing that's clear though, it's that you're currently in the Elysian Meadows.");
        stall();
        System.out.println("Almost instinctively, you reach for a scabbard you didn't know you had on your side and draw your sword.");
        System.out.println("With a smooth hiss, the silver blade catches on the first light.");
        stall();
        System.out.println("You aren't sure why, but there's something very important you have to do.");
        stall();
        System.out.println("Maybe in this life, or maybe in a future life, but you know you must complete it.");
        stall();
        System.out.println("Sword in hand, you set off to begin your journey.");
        System.out.println("Press Enter to Continue...");
        stall();
    }
    public static void encounterEnemy() {
        System.out.println("As you journey through the " + Main.getStageName() + " you eventually encounter a " + Enemy.gCurrentEnemy.getEnemyName() + "!");
        System.out.println("Drawing your [WEAPON NAME], you prepare to fight."); //The weapon thing is still under construction...
        stall();
    }
    public static void deathDialogue() {
        System.out.println("Though you fought well, the " + Enemy.gCurrentEnemy.getEnemyName() + " proves to be too powerful a foe.");
        stall();
        System.out.println("Clutching your [WEAPON] weakly, you feel your vision blur in and out of focus.");
        stall();
        System.out.println("As your conscious fades, you feel your body relax.");
        System.out.println("Maybe not in this life, but perhaps the next one.");
        stall();
        System.out.println("There is comfort in that thought.");
        stall();
        System.out.println("You died!");
    }
    private static void stall() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
