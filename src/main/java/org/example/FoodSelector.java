package org.example;

import java.util.*;

/**
 * Selects the food you have selected at random
 */

public class FoodSelector {
    private Food selectedFood;
    private static HashMap<String, List<Food>> foods = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    public FoodSelector() {

    }

    public void start() {
        System.out.println("Starting FoodSelector...");
        String choice = "zz";

        do {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("1. Add Food");
            System.out.println("2. Remove Food");
            System.out.println("3. Select Food");
            System.out.println("4. View Foods");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

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

    public HashMap<String, List<Food>> addFood() {
        System.out.println("Enter Food Type: ");
        String foodType = scanner.nextLine().trim().toLowerCase();
        System.out.println("Enter Food Name: ");
        String foodName = scanner.nextLine().trim().toLowerCase();
        Food food = new Food(foodType, foodName);

        if(foods.containsKey(foodType)) {
            foods.get(foodType).add(food);
        } else {
            List<Food> foodList = new ArrayList<>();
            foodList.add(food);
            foods.put(foodType, foodList);
        }
        return foods;
    }

    public HashMap<String, List<Food>> removeFood() {
        if(foods.isEmpty()) {
            System.out.println("List is empty, cannot remove foods.\n");
            return foods;
        }

        for(int i = 0; i < foods.size(); i++) {
            System.out.println((i+1) + ". " + foods.get(i));
        }
        return foods;
    }

    public Food selectFood() {
        if(foods.isEmpty()) {
            System.out.println("Food list is empty!\n");
            return null;
        }
        Random rand = new Random();
        System.out.println("Select Food Type (1) or Meal (2)?");
        String choice = scanner.nextLine().trim().toLowerCase();
        String[] foodTypes = foods.keySet().toArray(new String[0]);
        int randomIndex = rand.nextInt(foodTypes.length);

        if(choice.equals("1")) {
            String foodType = foodTypes[randomIndex];

            System.out.println("Selected Food Type: " + capitalize(foodType));
            System.out.println("Do you want me to select the meal too? (Y/N)");

            choice = scanner.nextLine().trim().toLowerCase();
            if(choice.equals("y")) {
                randomIndex = rand.nextInt(foods.get(foodType).size());
                System.out.println("Meal: " + foods.get(foodType).get(randomIndex));
            }
        } else {
            System.out.println("Meal: " + capitalize(foods.get(foodTypes[randomIndex]).get(randomIndex).toString()) + "\n");
        }
        selectedFood = foods.get(foodTypes[randomIndex]).get(randomIndex);
        return selectedFood;
    }

    public HashMap<String, List<Food>> viewFoods() {
        if(foods.isEmpty()) {
            System.out.println("Food list is empty! Nothing to view.\n");
            return foods;
        }
        String choice = "";

            do {
                System.out.println("1. To View All Foods");
                System.out.println("2. To View Specific Type of Food");
                System.out.println("3. To Exit");


                choice = scanner.nextLine().trim().toLowerCase();
                switch (choice) {
                    case "1", "one":
                        for (List<Food> foods : foods.values()) {
                            System.out.println(capitalize(capitalize(foods.get(0).getFoodType()) + ": ");
                            for (Food food : foods) {
                                System.out.println(capitalize(food.toString()));
                            }
                        }
                        break;
                    case "2", "two":
                        System.out.println("Enter Food Type: ");
                        String foodType = scanner.nextLine().trim().toLowerCase();
                        for (Food food : foods.get(foodType)) {
                            System.out.println(capitalize(foodType) + ": ");
                            System.out.println(capitalize(food.toString()));
                        }
                        break;
                    case "3", "three":
                        break;
                }
            } while (!choice.equals("3") || !choice.equals("three"));

        return foods;
    }

    public String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public  Food getSelectedFood() {
        return selectedFood;
    }

    public  void setSelectedFood(Food selectedFood) {
        this.selectedFood = selectedFood;
    }
}
