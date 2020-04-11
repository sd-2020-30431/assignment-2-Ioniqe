package net.model;

import java.util.List;

public class CreatedReport {
    private List<Item> eatenFood;
    private int eatenCalories; //total eaten calories (if quantity more than 1 => calories * quantity)
    private List<Item> expiredFood;
    private int wastedCalories;

    public CreatedReport() {
    }

    public CreatedReport(List<Item> eatenFood, int eatenCalories, List<Item> expiredFood, int wastedCalories) {
        this.eatenFood = eatenFood;
        this.eatenCalories = eatenCalories;
        this.expiredFood = expiredFood;
        this.wastedCalories = wastedCalories;
    }

    public List<Item> getEatenFood() {
        return eatenFood;
    }

    public void setEatenFood(List<Item> eatenFood) {
        this.eatenFood = eatenFood;
    }

    public int getEatenCalories() {
        return eatenCalories;
    }

    public void setEatenCalories(int eatenCalories) {
        this.eatenCalories = eatenCalories;
    }

    public List<Item> getExpiredFood() {
        return expiredFood;
    }

    public void setExpiredFood(List<Item> expiredFood) {
        this.expiredFood = expiredFood;
    }

    public int getWastedCalories() {
        return wastedCalories;
    }

    public void setWastedCalories(int wastedCalories) {
        this.wastedCalories = wastedCalories;
    }
}
