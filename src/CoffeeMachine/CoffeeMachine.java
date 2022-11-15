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

class CoffeeMachineEngine {
    public static String machineState = "remaining";

    public static void runMachine(String action) {
        machineState = action;

        if (Objects.equals(action, "buy")) {
            buyAction();
        } else if (Objects.equals(action, "fill")) {
            fillAction();
        } else if (Objects.equals(action, "take")) {
            takeAction();
        } else if (Objects.equals(action, "remaining")) {
            printInfo();
        } else if (Objects.equals(action, "exit")) {
            return;
        }
    }

    private static void buyAction() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String option = in.nextLine();
        checkBuyPossible(option);
    }

    private static void fillAction() {
        Scanner in = new Scanner(System.in);

        System.out.println("\nWrite how many ml of water you want to add: ");
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
        System.out.println("\nThe coffee machine has: ");
        System.out.println(info);
    }

    private static void checkBuyPossible(String option) {
        if (Objects.equals(option, "1")) {
            int water = InitialState.waterAmount - 250;
            int beans = InitialState.beansAmount - 16;
            int cups = InitialState.cupsAmount - 1;

            if (water >= 0 && beans >= 0 && cups >= 0) {
                InitialState.waterAmount = water;
                InitialState.beansAmount = beans;
                InitialState.cupsAmount = cups;
                InitialState.moneyAmount = InitialState.moneyAmount + 4;
                System.out.println("I have enough resources, making you a coffee!\n");
            } else if (water < 0) {
                System.out.println("Sorry, not enough water!\n");
            } else if (beans < 0) {
                System.out.println("Sorry, not enough beans!\n");
            } else if (cups < 0) {
                System.out.println("Sorry, not enough cups!\n");
            }
        } else if (Objects.equals(option, "2")) {
            int water = InitialState.waterAmount - 350;
            int milk = InitialState.milkAmount - 75;
            int beans = InitialState.beansAmount - 20;
            int cups = InitialState.cupsAmount - 1;

            if (water >= 0 && beans >= 0 && cups >= 0 && milk >= 0) {
                InitialState.waterAmount = water;
                InitialState.milkAmount = milk;
                InitialState.beansAmount = beans;
                InitialState.cupsAmount = cups;
                InitialState.moneyAmount = InitialState.moneyAmount + 7;
                System.out.println("I have enough resources, making you a coffee!\n");
            } else if (water < 0) {
                System.out.println("Sorry, not enough water!\n");
            } else if (beans < 0) {
                System.out.println("Sorry, not enough beans!\n");
            } else if (cups < 0) {
                System.out.println("Sorry, not enough cups!\n");
            } else if (milk < 0) {
                System.out.println("Sorry, not enough milk!\n");
            }
        } else if (Objects.equals(option, "3")) {
            int water = InitialState.waterAmount - 200;
            int milk = InitialState.milkAmount - 100;
            int beans = InitialState.beansAmount - 12;
            int cups = InitialState.cupsAmount - 1;

            if (water >= 0 && beans >= 0 && cups >= 0 && milk >= 0) {
                InitialState.waterAmount = InitialState.waterAmount - 200;
                InitialState.milkAmount = InitialState.milkAmount - 100;
                InitialState.beansAmount = InitialState.beansAmount - 12;
                InitialState.cupsAmount = InitialState.cupsAmount - 1;
                InitialState.moneyAmount = InitialState.moneyAmount + 6;
                System.out.println("I have enough resources, making you a coffee!\n");
            } else if (water < 0) {
                System.out.println("Sorry, not enough water!\n");
            } else if (beans < 0) {
                System.out.println("Sorry, not enough beans!\n");
            } else if (cups < 0) {
                System.out.println("Sorry, not enough cups!\n");
            } else if (milk < 0) {
                System.out.println("Sorry, not enough milk!\n");
            }
        }
    }
}

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (!Objects.equals(CoffeeMachineEngine.machineState, "exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String type = in.nextLine();
            CoffeeMachineEngine.runMachine(type);
        }
    }
}
