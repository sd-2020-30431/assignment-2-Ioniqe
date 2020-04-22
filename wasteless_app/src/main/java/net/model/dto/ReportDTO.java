package net.model.dto;

import net.model.Item;

import java.util.List;

public class ReportDTO {
    private List<Item> eatenFood;
    private List<Item> expiredFood;
    private int eatenCalories;
    private int wastedCalories;

    public ReportDTO(List<Item> eatenFood, List<Item> expiredFood, int eatenCalories, int wastedCalories) {
        this.eatenFood = eatenFood;
        this.expiredFood = expiredFood;
        this.eatenCalories = eatenCalories;
        this.wastedCalories = wastedCalories;
    }

    public List<Item> getEatenFood() {
        return eatenFood;
    }

    public void setEatenFood(List<Item> eatenFood) {
        this.eatenFood = eatenFood;
    }

    public List<Item> getExpiredFood() {
        return expiredFood;
    }

    public void setExpiredFood(List<Item> expiredFood) {
        this.expiredFood = expiredFood;
    }

    public int getEatenCalories() {
        return eatenCalories;
    }

    public void setEatenCalories(int eatenCalories) {
        this.eatenCalories = eatenCalories;
    }

    public int getWastedCalories() {
        return wastedCalories;
    }

    public void setWastedCalories(int wastedCalories) {
        this.wastedCalories = wastedCalories;
    }
}
