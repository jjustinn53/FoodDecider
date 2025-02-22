package org.example;

import java.util.Objects;

/**
 * A food object that is the type and name of food you want.
 */
public class Food {
    private String foodType;
    private String foodName;

    public Food(String foodType, String foodName) {
        this.foodType = foodType;
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Food food)) return false;
        return Objects.equals(foodType, food.foodType) && Objects.equals(foodName, food.foodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodType, foodName);
    }

    @Override
    public String toString() {
        return foodName;
    }
}
