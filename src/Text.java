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
        System.out.println("However, if your HP reaches zero, all your progress will be reset back to square one.");
        stall();
        System.out.println("However, that doesn't mean all hope is lost. At the end of each round, permanent buffs will be added to your character, allowing for better runs in the future.");
        stall();
        System.out.println("The")
    }
    private static void stall() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
