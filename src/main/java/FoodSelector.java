import java.util.*;

/**
 * Selects the food you have selected at random
 */

public class FoodSelector {
    private static Food selectedFood;
    private static HashMap<String, List<Food>> foods = new HashMap<>();

    public FoodSelector() {

    }

    public void start() {
        System.out.println("Starting FoodSelector...");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().toLowerCase().trim();

        do {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("1. Add Food");
            System.out.println("2. Remove Food");
            System.out.println("3. Select Food");
            System.out.println("4. View Foods");
            System.out.println("5. Exit");

            choice = scanner.nextLine().toLowerCase().trim();

            switch (choice) {
                case "1", "one":
                    addFood();
                    break;
                case "2", "two":
                    removeFood();
                    break;
                case "3", "three":
                    selectFood();
                    break;
                case "4", "four":
                    viewFoods();


            }


        } while(!choice.equals("5") );
    }
    public void addFood() {
        System.out.println("Enter Food Type: ");
        Scanner scanner = new Scanner(System.in);
        String foodType = scanner.nextLine().trim().toLowerCase();
        System.out.println("Enter Food Name: ");
        String foodName = scanner.nextLine().trim().toLowerCase();
        Food food = new Food(foodType, foodName);

        if(foods.containsKey(foodType)) {
            foods.get(foodType).add(food);
        }
    }

    public void removeFood() {} {
        System.out.println("Enter Food Type: ");
        Scanner scanner = new Scanner(System.in);
        String foodType = scanner.nextLine().trim().toLowerCase();
        System.out.println("Enter Food Name: ");
        String foodName = scanner.nextLine().trim().toLowerCase();
        Food food = new Food(foodType, foodName);
        foods.get(foodType).remove(food);

    }

    public void selectFood() {
        Random rand = new Random();
        System.out.println("Select Food Type (1) or Meal (2)?");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().trim().toLowerCase();
        String[] foodTypes = foods.keySet().toArray(new String[0]);
        int randomIndex = rand.nextInt(foodTypes.length);

        if(choice.equals("1")) {
            String foodType = foodTypes[randomIndex];

            System.out.println("Selected Food Type: " + foodType);
            System.out.println("Do you want me to select the meal too? (Y/N)");

            choice = scanner.nextLine().trim().toLowerCase();
            if(choice.equals("Y")) {
                System.out.println("Meal: " + foods.get(foodType).get(randomIndex));
            }
        } else {
            System.out.println("Meal: " + foods.get(foodTypes[randomIndex]).get(randomIndex));
        }
    }

    public void viewFoods() {
        String choice = "";
        Scanner scanner = new Scanner(System.in);

        while(!choice.equals("3") || !choice.equals("three")) {
            System.out.println("1. To View All Foods");
            System.out.println("2. To View Specific Type of Food");
            System.out.println("3. To Exit");


            choice = scanner.nextLine().trim().toLowerCase();
            switch (choice) {
                case "1", "one":
                    for (List<Food> foods : foods.values()) {
                        System.out.println(foods.get(0).getFoodType() + ": ");
                        for (Food food : foods) {
                            System.out.println(food);
                        }
                    }
                    break;
                case "2", "two":
                    System.out.println("Enter Food Type: ");
                    String foodType = scanner.nextLine().trim().toLowerCase();
                    for (Food food : foods.get(foodType)) {
                        System.out.println(foodType + ": ");
                        System.out.println(food);
                    }
                    break;
                case "3", "three":
                    break;
            }
        }
    }
    public static Food getSelectedFood() {
        return selectedFood;
    }

    public static void setSelectedFood(Food selectedFood) {
        FoodSelector.selectedFood = selectedFood;
    }
}
