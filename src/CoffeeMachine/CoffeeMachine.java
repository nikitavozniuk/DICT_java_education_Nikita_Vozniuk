package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    private static final String START_STAGE = "Starting to make a coffee";
    private static final String GRINDING_BEANS_STAGE = "Grinding coffee beans";
    private static final String BOILING_WATER_STAGE = "Boiling water";
    private static final String MIXING_STAGE = "Mixing boiled water with crushed coffee beans";
    private static final String POURING_COFFEE_STAGE = "Pouring coffee into the cup";
    private static final String POURING_MILK_STAGE = "Pouring some milk into the cup";
    private static final String READY_STAGE = "Coffee is ready!";

    private static final int DEFAULT_WATER_FOR_CUP = 200;
    private static final int DEFAULT_MILK_FOR_CUP = 50;
    private static final int DEFAULT_BEANS_FOR_CUP = 15;

    private static void result(int cups) {
        int waterCount = DEFAULT_WATER_FOR_CUP * cups;
        int milkCount = DEFAULT_MILK_FOR_CUP * cups;
        int beansCount = DEFAULT_BEANS_FOR_CUP * cups;

        String output = String.format(
                "For %d cups of coffee you will need: \n%d ml of water\n%d ml of milk\n%d g of coffee beans",
                cups,
                waterCount,
                milkCount,
                beansCount
        );
        System.out.println(output);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need: ");
        String cups = in.nextLine();
        int parsedCups = Integer.parseInt(cups);
        result(parsedCups);
    }
}
