package CoffeeMachine;

public class CoffeeMachine {
    private static final String START_STAGE = "Starting to make a coffee";
    private static final String GRINDING_BEANS_STAGE = "Grinding coffee beans";
    private static final String BOILING_WATER_STAGE = "Boiling water";
    private static final String MIXING_STAGE = "Mixing boiled water with crushed coffee beans";
    private static final String POURING_COFFEE_STAGE = "Pouring coffee into the cup";
    private static final String POURING_MILK_STAGE = "Pouring some milk into the cup";
    private static final String READY_STAGE = "Coffee is ready!";

    public static void main(String[] args) {
        System.out.println(START_STAGE);
        System.out.println(GRINDING_BEANS_STAGE);
        System.out.println(BOILING_WATER_STAGE);
        System.out.println(MIXING_STAGE);
        System.out.println(POURING_COFFEE_STAGE);
        System.out.println(POURING_MILK_STAGE);
        System.out.println(READY_STAGE);
    }
}
