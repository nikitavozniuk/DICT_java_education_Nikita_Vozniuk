package Hangman;

import java.util.Objects;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String word = "java";
        System.out.println("HANGMAN");
        System.out.print("Guess the word: ");

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        if (Objects.equals(name, word)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
