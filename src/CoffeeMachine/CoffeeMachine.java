package CoffeeMachine;

import java.util.Objects;
import java.util.Scanner;

class InitialState {
    public static int waterAmount = 400;
    public static int milkAmount = 540;
    public static int beansAmount = 120;
    public static int cupsAmount = 9;
    public static int moneyAmount = 550;

    public static void overrideFields(int water, int milk, int beans, int cups) {
        waterAmount = waterAmount + water;
        milkAmount = milkAmount + milk;
        beansAmount = beansAmount + beans;
        cupsAmount = cupsAmount + cups;
    }
}

public class CoffeeMachine {
    private static void actionHandler(String type) {
        if (Objects.equals(type, "buy")) {
            buyAction();
        } else if (Objects.equals(type, "fill")) {
            fillAction();
        } else if (Objects.equals(type, "take")) {
            takeAction();
        }
    }

    private static void buyAction() {
        Scanner in = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String option = in.nextLine();
        int parsedOption = Integer.parseInt(option);

        if (parsedOption == 1) {
            InitialState.waterAmount = InitialState.waterAmount - 250;
            InitialState.beansAmount = InitialState.beansAmount - 16;
            InitialState.cupsAmount = InitialState.cupsAmount - 1;
            InitialState.moneyAmount = InitialState.moneyAmount + 4;
        } else if (parsedOption == 2) {
            InitialState.waterAmount = InitialState.waterAmount - 350;
            InitialState.milkAmount = InitialState.milkAmount - 75;
            InitialState.beansAmount = InitialState.beansAmount - 20;
            InitialState.cupsAmount = InitialState.cupsAmount - 1;
            InitialState.moneyAmount = InitialState.moneyAmount + 7;
        } else if (parsedOption == 3) {
            InitialState.waterAmount = InitialState.waterAmount - 200;
            InitialState.milkAmount = InitialState.milkAmount - 100;
            InitialState.beansAmount = InitialState.beansAmount - 12;
            InitialState.cupsAmount = InitialState.cupsAmount - 1;
            InitialState.moneyAmount = InitialState.moneyAmount + 6;
        }
    }

    private static void fillAction() {
        Scanner in = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add: ");
        String water = in.nextLine();
        int parsedWater = Integer.parseInt(water);

        System.out.println("Write how many ml of milk you want to add: ");
        String milk = in.nextLine();
        int parsedMilk = Integer.parseInt(milk);

        System.out.println("Write how many grams of coffee beans you want to add: ");
        String beans = in.nextLine();
        int parsedBeans = Integer.parseInt(beans);

        System.out.println("Write how many disposable coffee cups you want to add: ");
        String cups = in.nextLine();
        int parsedCups = Integer.parseInt(cups);

        InitialState.overrideFields(
                parsedWater,
                parsedMilk,
                parsedBeans,
                parsedCups
        );
    }

    private static void takeAction() {
        String takeOutput = String.format("I gave you %d\n", InitialState.moneyAmount);
        System.out.println(takeOutput);
        InitialState.moneyAmount = 0;
    }

    private static void printInfo() {
        String info = String.format(
                "%d of water\n%d of milk\n%d of coffee beans\n%d of disposable cups\n%d of money\n",
                InitialState.waterAmount,
                InitialState.milkAmount,
                InitialState.beansAmount,
                InitialState.cupsAmount,
                InitialState.moneyAmount
        );
        System.out.println("The coffee machine has: ");
        System.out.println(info);
    }

    private static void engine() {
        Scanner in = new Scanner(System.in);
        printInfo();
        System.out.println("Write action (buy, fill, take): ");
        String type = in.nextLine();
        actionHandler(type);
        printInfo();
    }

    public static void main(String[] args) {
        engine();
    }
}
