package CoffeeMachine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class CoffeeMachine {
    private static final int DEFAULT_WATER_FOR_CUP = 200;
    private static final int DEFAULT_MILK_FOR_CUP = 50;
    private static final int DEFAULT_BEANS_FOR_CUP = 15;

    private static void start() {
        Scanner in = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has: ");
        String waterCount = in.nextLine();
        int parsedWaterCount = Integer.parseInt(waterCount);

        System.out.println("Write how many ml of milk the coffee machine has: ");
        String milkCount = in.nextLine();
        int parsedMilkCount = Integer.parseInt(milkCount);

        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        String beansCount = in.nextLine();
        int parsedBeansCount = Integer.parseInt(beansCount);

        System.out.println("Write how many cups of coffee you will need: ");
        String cupsCount = in.nextLine();
        int parsedCupsCount = Integer.parseInt(cupsCount);

        calc(parsedWaterCount, parsedMilkCount, parsedBeansCount, parsedCupsCount);
    }

    private static void calc(int water, int milk, int beans, int cups) {
        ArrayList<Integer> data = new ArrayList<Integer>();
        data.add(water / DEFAULT_WATER_FOR_CUP);
        data.add(milk / DEFAULT_MILK_FOR_CUP);
        data.add(beans / DEFAULT_BEANS_FOR_CUP);

        data.sort(Comparator.comparing(integer -> integer));
        int amountPossible = data.get(0);

        if (amountPossible == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (amountPossible > cups) {
            String output = String.format("Yes, I can make that amount of coffee (and even %d more than that)", amountPossible - cups);
            System.out.println(output);
        } else {
            String output = String.format("No, I can make only %d cups of coffee", amountPossible);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        start();
    }
}
