package net.model;

import net.model.Item;

import java.util.List;

public class WeeklyReport extends Report {
    public CreatedReport sendReport(List<Item> itemList){
        return createdReport(getItems(itemList, 7));
    }
}
